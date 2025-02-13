package Testpkg;

import org.testng.annotations.Test;

import BASEPKG.baseclass;
import pagepkg.pageclass;

public class testclass extends baseclass{
	
	@Test
	public void test() {
		pageclass ob=new pageclass(driver);
		ob.appointment();
		ob.copy_paste_username();
		ob.copy_paste_password();
		ob.dropdown();
		ob.check();
		ob.date();
		ob.comment();
		ob.logout();
	}

}
