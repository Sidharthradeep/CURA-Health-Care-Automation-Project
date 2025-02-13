package pagepkg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class pageclass {
	WebDriver driver;
	@FindBy(id="btn-make-appointment")
	WebElement appointment;
	
	@FindBy(xpath="/html/body/section/div/div/div[2]/form/div[1]/div[1]/div/div/input")
	WebElement username;
	@FindBy(id="txt-username")
	WebElement loc_user;
	
	@FindBy(xpath="/html/body/section/div/div/div[2]/form/div[1]/div[2]/div/div/input")
	WebElement pass;
	@FindBy(id="txt-password")
	WebElement loc_pass;
	
	@FindBy(id="btn-login")
	WebElement login;
	
	@FindBy(id="combo_facility")
	WebElement dropdown;
	
	@FindBy(id="chk_hospotal_readmission")
	WebElement check;
	
	@FindBy(id="radio_program_none")
	WebElement radio;
	
	@FindBy(id="txt_visit_date")
	WebElement datepicker;
	@FindBy(xpath="/html/body/div/div[1]/table/thead/tr[2]/th[3]")
	WebElement next;
	
	@FindBy(id="txt_comment")
	WebElement comment;
	@FindBy(id="btn-book-appointment")
	WebElement book;
	
	@FindBy(xpath="/html/body/section/div/div/div[7]/p/a")
	WebElement goback;
	@FindBy(xpath="/html/body/a/i")
	WebElement tag;
	@FindBy(xpath="/html/body/nav/ul/li[5]/a")
	WebElement logout;
	
	public pageclass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void appointment() {
		appointment.click();
	}
	public void copy_paste_username() {
		Actions act=new Actions(driver);
		act.keyDown(username,Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		act.keyDown(username,Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		act.keyDown(loc_user,Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
	}
	public void copy_paste_password() {
		Actions act=new Actions(driver);
		act.keyDown(pass,Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		act.keyDown(pass,Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		act.keyDown(loc_pass,Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
		login.click();
	}
	public void dropdown() {
		Select drop=new Select(dropdown);
		drop.selectByVisibleText("Seoul CURA Healthcare Center");
	}
	public void check() {
		check.click();
		radio.click();
	}
	public void date() {
		datepicker.click();
		while(true)
		{
			String months=driver.findElement(By.xpath("/html/body/div/div[1]/table/thead/tr[2]/th[2]")).getText();
			if(months.equals("June 2025")) {
				break;
			}
			else {
				next.click();
			}
		}
		List<WebElement> datelist=driver.findElements(By.xpath("/html/body/div/div[1]/table/tbody/tr/td"));
		for(WebElement pick:datelist)
		{
			String date=pick.getText();
			if(date.equals("10")) {
				pick.click();
				break;
			}
		}
	}
	public void comment() {
		comment.sendKeys("Hello my name will displayed in the comments");
		book.click();
	}
	public void logout() {
		tag.click();
		logout.click();
	}
}
