package AutomationTest.GoDirectVoiceAndroid.account;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import AutomationTest.GoDirectVoiceAndroid.Base;
import AutomationTest.GoDirectVoiceAndroid.onlineaccount.LoginAcc;
import PageObject.AccountListEl;
import PageObject.AppDrawerEl;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;



public class AccountEnableDisable extends Base {
	@Test
	public void GoDirectVoiceTest() throws InterruptedException, IOException {
		service = startServer();

		AndroidDriver<AndroidElement> driver = Capabilities("GoDirectVoiceApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(4000);
		new LoginAcc().KeypadNavigation();
		Thread.sleep(4000);
		
		AppDrawerEl dr = new AppDrawerEl (driver);
		dr.Drawer.click();
		dr.Account.click();
		
		AccountEnableDisable();

		service.stop();
	}

	private void AccountEnableDisable() throws InterruptedException {
		// TODO Auto-generated method stub
		
		AccountListEl accountToggle = new AccountListEl (driver);
		
			accountToggle.AccToggle.click();
			Thread.sleep(7000);
			accountToggle.AccToggle.click();
	}

}
