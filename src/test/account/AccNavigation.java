package AutomationTest.GoDirectVoiceAndroid.account;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import AutomationTest.GoDirectVoiceAndroid.Base;
import AutomationTest.GoDirectVoiceAndroid.onlineaccount.LoginAcc;
import PageObject.AccountEl;
import PageObject.AppDrawerEl;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AccNavigation extends Base {
	
	@Test

	public void NaviagtionCheck() throws InterruptedException, IOException {
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
		dr.Account.click();	
		
		Naviagtion_Hon();
		Naviagtion_Iridium();
		Naviagtion_Cobham();
		Naviagtion_GoGo();
		Naviagtion_SDR();
		Naviagtion_TN();
		Naviagtion_Generic();
		
		service.stop();
	}
	
private void Naviagtion_Hon() throws InterruptedException {	
		
		Thread.sleep(1000);
		
		AccountEl account= new AccountEl (driver);
		
		account.AddAccount.click();							// click to open new account setup page
		
	
		account.AccDrop.click();                              //click to open manufacturer list
		
		account.HonAccList.click();								// Click to select manufacturer
		
		
		account.BackButton.click();
		
	}
private void Naviagtion_Iridium() throws InterruptedException {	
	
	Thread.sleep(1000);
	
	AccountEl account= new AccountEl (driver);
	
	//account.AddAccount.click();							// click to open new account setup page
	

	account.AccDrop.click();                              //click to open manufacturer list
	
	account.Iridium.click();								// Click to select manufacturer
	
	
	account.BackButton.click();
	
}

private void Naviagtion_Cobham() throws InterruptedException {	
	
	Thread.sleep(1000);
	
	AccountEl account= new AccountEl (driver);
	
	//account.AddAccount.click();							// click to open new account setup page
	

	account.AccDrop.click();                              //click to open manufacturer list
	
	account.Cobham.click();								// Click to select manufacturer
	
	
	account.BackButton.click();
	
}
private void Naviagtion_GoGo() throws InterruptedException {	
	
	Thread.sleep(1000);
	
	AccountEl account= new AccountEl (driver);
	
	//account.AddAccount.click();							// click to open new account setup page
	

	account.AccDrop.click();                              //click to open manufacturer list
	
	account.Gogo.click();								// Click to select manufacturer
	
	
	account.BackButton.click();
	
}
private void Naviagtion_SDR() throws InterruptedException {	
	
	Thread.sleep(1000);
	
	AccountEl account= new AccountEl (driver);
	
	//account.AddAccount.click();							// click to open new account setup page
	

	account.AccDrop.click();                              //click to open manufacturer list
	
	account.SatcomDirect.click();								// Click to select manufacturer
	
	
	account.BackButton.click();
	
}
private void Naviagtion_TN() throws InterruptedException {	
	
	Thread.sleep(1000);
	
	AccountEl account= new AccountEl (driver);
	
	//account.AddAccount.click();							// click to open new account setup page
	

	account.AccDrop.click();                              //click to open manufacturer list
	
	account.TrueNorth.click();								// Click to select manufacturer
	
	
	account.BackButton.click();
	
}
private void Naviagtion_Generic() throws InterruptedException {	
	
	Thread.sleep(1000);
	
	AccountEl account= new AccountEl (driver);
	
	//account.AddAccount.click();							// click to open new account setup page
	

	account.AccDrop.click();                              //click to open manufacturer list
	
	account.GenAccList.click();								// Click to select manufacturer
	
	
	account.BackButton.click();
	
}

}
