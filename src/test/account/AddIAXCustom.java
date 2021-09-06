package AutomationTest.GoDirectVoiceAndroid.account;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import AutomationTest.GoDirectVoiceAndroid.Base;
import AutomationTest.GoDirectVoiceAndroid.TestDataAccount;
import AutomationTest.GoDirectVoiceAndroid.onlineaccount.LoginAcc;
import PageObject.AccountEl;
import PageObject.AppDrawerEl;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;



public class AddIAXCustom extends Base {
	@Test
	public void AddIAXCustomTest() throws InterruptedException, IOException {
		service = startServer();

		AndroidDriver<AndroidElement> driver = Capabilities("GoDirectVoiceApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(4000);
		new LoginAcc().KeypadNavigation();
		Thread.sleep(4000);
		
		AppDrawerEl dr = new AppDrawerEl (driver);
		dr.Drawer.click();
		dr.Account.click();
		
		AccountEl acc = new AccountEl (driver);
		acc.AddAccount.click();
		
		AddIAXAccount();

		service.stop();
	}

	public void AddIAXAccount() throws InterruptedException {
		// TODO Auto-generated method stub
		AccountEl account = new AccountEl (driver);
		
		
		account.AccDrop.click();
		
		account.GenAccList.click();
		
		account.ExtSelect.sendKeys(TestDataAccount.ext[0]);
		
		account.PassSelect.sendKeys(TestDataAccount.pass[0]);
		
		account.DomainSelect.sendKeys(TestDataAccount.dom[0]);
		
		account.ProtocolSelect.click();
		
		account.IAXProtocol.click();
		
		account.AccSave.click();
		
		//Thread.sleep(4000);
	}

}
