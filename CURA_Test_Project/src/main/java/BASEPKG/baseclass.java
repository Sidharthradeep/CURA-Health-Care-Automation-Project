package BASEPKG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class baseclass {
	public static WebDriver driver;
	@BeforeTest
	public void open() {
		driver=new ChromeDriver();
		driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
		driver.manage().window().maximize();
	}
}
