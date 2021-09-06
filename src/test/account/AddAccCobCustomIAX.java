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

public class AddAccCobCustomIAX extends Base{
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
		
		Thread.sleep(4000);
		
		AddCustomIAXAcc();
	
		service.stop();
	}
	
	public void AddCustomIAXAcc() throws InterruptedException{
		Thread.sleep(500);
		AccountEl account = new AccountEl (driver);
		account.AddAccount.click();
		
		account.AccDrop.click();
		
		account.Cobham.click();
	
		account.AccRouter.click();
		
		Utilities u = new Utilities(driver);
		u.ScrollText("Custom");
		
		account.CobCustom.click();
		
		account.ExtSelect.click();
		account.ExtSelect.sendKeys(TestDataAccount.Cobext[2]);
		driver.hideKeyboard();
		
		account.PassSelect.click();
		account.PassSelect.sendKeys(TestDataAccount.Cobpass[1]);
		driver.hideKeyboard();
		
		account.DomainSelect.click();
		account.DomainSelect.sendKeys(TestDataAccount.Cobdom[1]);
		driver.hideKeyboard();
	
		account.Protocol.click();
		
		u.ScrollText("IAX");
		
		account.CobCustomIAX.click();
		
		
		account.AccSave.click();
	}
}
