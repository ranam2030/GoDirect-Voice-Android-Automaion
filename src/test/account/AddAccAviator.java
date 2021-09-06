package AutomationTest.GoDirectVoiceAndroid.account;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import AutomationTest.GoDirectVoiceAndroid.Base;
import AutomationTest.GoDirectVoiceAndroid.TestDataAccount;
import AutomationTest.GoDirectVoiceAndroid.Utilities;
import AutomationTest.GoDirectVoiceAndroid.onlineaccount.LoginAcc;
import PageObject.AccountEl;
import PageObject.AppDrawerEl;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AddAccAviator extends Base{
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
		
		Thread.sleep(1000);
		dr.Account.click();
		
		AddAviatorAcc();
	
		service.stop();
	}
	
	public void AddAviatorAcc() throws InterruptedException{
		Thread.sleep(500);
		AccountEl account = new AccountEl (driver);
		account.AddAccount.click();
		
		account.AccDrop.click();
		
		account.Cobham.click();
	
		account.AccRouter.click();
		
		Utilities u = new Utilities(driver);
		u.ScrollText("Custom");
		
		account.Aviator.click();
		
		account.ExtSelect.click();
		account.ExtSelect.clear();
		account.ExtSelect.sendKeys(TestDataAccount.Cobext[0]);
		driver.hideKeyboard();
		
		account.AccSave.click();
	}
}
