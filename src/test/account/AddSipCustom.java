package AutomationTest.GoDirectVoiceAndroid.account;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import AutomationTest.GoDirectVoiceAndroid.AppConstant;
import AutomationTest.GoDirectVoiceAndroid.Base;
import AutomationTest.GoDirectVoiceAndroid.TestDataAccount;
import AutomationTest.GoDirectVoiceAndroid.onlineaccount.LoginAcc;
import PageObject.AccountEl;
import PageObject.AccountListEl;
import PageObject.AppDrawerEl;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;



public class AddSipCustom extends Base {

	@Test
	public void AddSipCustomTest() throws InterruptedException, IOException {
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
		
		AddSipAcc();
	
		
		service.stop();
	}
	

	public void AddSipAcc() throws InterruptedException {
		
		
		AccountEl account = new AccountEl (driver);
		
		
		account.AccDrop.click();
		
		account.GenAccList.click();
		
		account.ProfileSelect.clear();
		
		account.ProfileSelect.sendKeys(TestDataAccount.getAccountData().get(0).get(AppConstant.PROFILE));
		
		account.ExtSelect.sendKeys(TestDataAccount.getAccountData().get(0).get(AppConstant.EXTENSION));
		
		account.PassSelect.sendKeys(TestDataAccount.getAccountData().get(0).get(AppConstant.ACCPASSWORD));
		
		//account.DomainSelect.sendKeys(TestDataAccount.getAccountData().get(0).get(AppConstant.DOMAIN));
		account.DomainSelect.sendKeys("192.168.1.1");
		
		account.AccSave.click();
		
		Thread.sleep(4000);
		
		/*AccountListEl accreg = new AccountListEl (driver);
		String Status = accreg.AccStaus.getText();
		
		System.out.println (Status);
		
		Assert.assertEquals(Status, "Registered");*/
		
		//account.AccBack.click();
		
		
	}

}
