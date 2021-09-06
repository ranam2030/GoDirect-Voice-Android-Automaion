package AutomationTest.GoDirectVoiceAndroid.account;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import AutomationTest.GoDirectVoiceAndroid.AppConstant;
//import AutomationTest.GoDirectVoiceAndroid.AppConstant;
import AutomationTest.GoDirectVoiceAndroid.Base;
import AutomationTest.GoDirectVoiceAndroid.TestDataAccount;
import AutomationTest.GoDirectVoiceAndroid.Utilities;
import AutomationTest.GoDirectVoiceAndroid.onlineaccount.LoginAcc;
import PageObject.AccountEl;
import PageObject.AppDrawerEl;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AddAccIridiumGo extends Base{

	@Test
	
	public void GoDirectVoiceTest() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		service = startServer();

		AndroidDriver<AndroidElement> driver = Capabilities("GoDirectVoiceApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		
		Thread.sleep(4000);
		new LoginAcc().KeypadNavigation();
		Thread.sleep(4000);
		
		AppDrawerEl dr = new AppDrawerEl (driver);	
		dr.Drawer.click();									//click to open App navigation drawer
		
		Thread.sleep(1000);
		dr.Account.click();									// click to open account settings page
		
		AddIridiumGoAcc();
		
		service.stop();
	}
		
		public void AddIridiumGoAcc() throws InterruptedException{
			
			Thread.sleep(1000);
			
		AccountEl account= new AccountEl (driver);
		account.AddAccount.click();							// click to open new account setup page
		
		account.AccDrop.click();                              //click to open manufacturer list
		
		account.Iridium.click();								// Click to select manufacturer
		
		account.AccRouter.click();  						// Click to open router list
		
		Utilities u = new Utilities (driver);
		u.ScrollText("Custom");
		
		account.IridiumGo.click(); 							// Click to select Iridium router
		account.ExtSelect.click();
		account.ExtSelect.clear();
		account.ExtSelect.sendKeys(TestDataAccount.Iriext[1]);
		//account.ExtSelect.sendKeys(TestDataAccount.getAccountData().get(0).get(AppConstant.EXTENSION));
		//account.ExtSelect.sendKeys(TestDataAccount.getAccountData().get(0).get(AppConstant.PASSWORD));
		//account.ExtSelect.sendKeys(TestDataAccount.getAccountData().get(0).get(AppConstant.DOMAIN));
		driver.hideKeyboard();
		
		account.AccSave.click();
		
		
		
	}

}
