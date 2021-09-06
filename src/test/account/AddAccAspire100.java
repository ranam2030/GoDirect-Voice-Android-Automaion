package AutomationTest.GoDirectVoiceAndroid.account;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import AutomationTest.GoDirectVoiceAndroid.AppConstant;
import AutomationTest.GoDirectVoiceAndroid.Base;
import AutomationTest.GoDirectVoiceAndroid.TestDataAccount;
import AutomationTest.GoDirectVoiceAndroid.Utilities;
import AutomationTest.GoDirectVoiceAndroid.onlineaccount.LoginAcc;
import PageObject.AccountEl;
import PageObject.AppDrawerEl;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AddAccAspire100 extends Base {
	
	//public static final String EXTENSION_RANGE_EXCEED = "Try extensions ranging 201-210";
	
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
		
		
		//RangValidation();
		AddAspire100Acc();
		
		service.stop();
	}
		
/*private void RangValidation() {	
		
		//Thread.sleep(1000);
		
		AccountEl account= new AccountEl (driver);
		account.AddAccount.click();
		
		account.AccDrop.click();
		
		account.HonAccList.click();
	
		account.AccRouter.click();
		
		Utilities u = new Utilities(driver);
		u.ScrollText("Custom");
		
		account.Aspire.click(); 
		
		account.ExtSelect.click();
		account.ExtSelect.clear();
		account.ExtSelect.sendKeys(TestDataAccount.Honext[0]);
		driver.hideKeyboard();
		
		account.AccSave.click();
		
	   Assert.assertEquals(account.Extension_range.getText(), EXTENSION_RANGE_EXCEED);
	
	} */
		
	public void AddAspire100Acc() throws InterruptedException{
		
		Thread.sleep(1000);
		AccountEl account = new AccountEl (driver);
		account.AddAccount.click();
		
		account.AccDrop.click();
		
		account.HonAccList.click();
	
		account.AccRouter.click();
		
		Utilities u = new Utilities(driver);
		u.ScrollText("Custom");
		
		account.Aspire.click(); 
		
		account.ExtSelect.click();
		account.ExtSelect.clear();
		account.ExtSelect.sendKeys(TestDataAccount.Honext[8]);
		driver.hideKeyboard();
		
		account.PassSelect.click();
		account.PassSelect.clear();
		account.PassSelect.sendKeys(TestDataAccount.Honpass);
		driver.hideKeyboard();
		
		account.DomainSelect.click();
		account.DomainSelect.clear();
		account.DomainSelect.sendKeys(TestDataAccount.Hondom[0]);
		driver.hideKeyboard();

		
		account.AccSave.click();
		
		
		
	}
}

