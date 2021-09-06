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

public class AddAccHonCustomIAX extends Base{
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
		
		AccountEl account = new AccountEl (driver);
		account.AddAccount.click();
		AddHonCusAcc();
		
		service.stop();
	}
	public void AddHonCusAcc() throws InterruptedException{
		
		AccountEl account = new AccountEl (driver);
		
	
		account.AccDrop.click();
		
		account.HonAccList.click();
	
		account.AccRouter.click();
		
		Utilities u = new Utilities(driver);
		u.ScrollText("Custom");
		
		account.HonCustom.click();
		
		account.ProfileSelect.clear();
		account.ProfileSelect.sendKeys("HonCustomIAX");

		account.ExtSelect.click();
		//account.ExtSelect.sendKeys(TestDataAccount.Honext[10]);
		account.ExtSelect.sendKeys(TestDataAccount.Honext[13]);
		driver.hideKeyboard();
		
		account.PassSelect.click();
		account.PassSelect.sendKeys(TestDataAccount.Honpass[1]);
		driver.hideKeyboard();
	
		account.DomainSelect.click();
		//account.DomainSelect.sendKeys(TestDataAccount.Hondom[1]);
		account.DomainSelect.sendKeys(TestDataAccount.Hondom[2]);
		driver.hideKeyboard();
		
		account.Protocol.click();
		u.ScrollText("IAX");
		account.HonCustomIAX.click();
		
		account.AccSave.click();
		
	}

}
