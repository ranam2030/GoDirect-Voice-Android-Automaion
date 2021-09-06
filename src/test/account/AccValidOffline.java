package AutomationTest.GoDirectVoiceAndroid.account;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import AutomationTest.GoDirectVoiceAndroid.Base;
import AutomationTest.GoDirectVoiceAndroid.TestDataAccount;
import AutomationTest.GoDirectVoiceAndroid.Utilities;
import AutomationTest.GoDirectVoiceAndroid.onlineaccount.LoginAcc;
//import AutomationTest.GoDirectVoiceAndroid.onlineaccount.LoginAcc;
import PageObject.AccountEl;
import PageObject.AccountSelectEl;
import PageObject.AppDrawerEl;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AccValidOffline extends Base{
	
	//Empty Cabin Router
	public static final String ROUTER_EMPTY = "Please select cabin router.";
	//Honeywell manufacturer
	public static final String EXTENSION_RANGE_EXCEED_CNX900 = "Try extensions ranging 301-354";
	public static final String EXTENSION_RANGE_EXCEED_CNX800 = "Try extensions ranging 1-99";
	public static final String EXTENSION_RANGE_EXCEED_CNX250 = "Try extensions ranging 10-90";
	public static final String EXTENSION_RANGE_EXCEED_CG710GD = "Try extensions ranging 301-354";
	public static final String EXTENSION_RANGE_EXCEED_CG710L = "Try extensions ranging 600-654";
	public static final String EXTENSION_RANGE_EXCEED_CCU200 = "Try extensions ranging 600-690";
	public static final String EXTENSION_RANGE_EXCEED_CCU100 = "Try extensions ranging 600-690";
	public static final String EXTENSION_RANGE_EXCEED_ASPIRE100 = "Try extensions ranging 201-210";
	public static final String EXTENSION_RANGE_EXCEED_GDR = "Try extensions ranging 301-354";
	//Iridium Manufacturer
	public static final String EXTENSION_RANGE_EXCEED_IRIDIUMGO = "Invalid Extension";	
	//gogo manufacturer
	public static final String EXTENSION_RANGE_EXCEED_ST4300 = "Try extensions ranging 81-88";
	public static final String EXTENSION_RANGE_EXCEED_AXXESS = "Try extensions ranging 81-85";
	//Cobham manufacturer
	public static final String EXTENSION_RANGE_EXCEED_AVIATOR = "Try extensions ranging 2100-2115";
	//Satcom Direct Manufacturer
	public static final String EXTENSION_RANGE_EXCEED_SDR = "Try extensions ranging 10-58";                     
	//TrueNorth Manufacturer
	public static final String EXTENSION_RANGE_EXCEED_OPTELITY = "Try extensions ranging 0-99";
	public static final String EXTENSION_RANGE_EXCEED_SIMPHONE = "Try extensions ranging 0-99";
	
	
	
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
		
		Empty_Router_Check();
		//HONEYWELL
		RangValidation_CNX900();
		RangValidation_CNX800();
		RangValidation_CNX250();
		RangValidation_CG710GD();
		RangValidation_CG710L();
		RangValidation_CCU200();
		RangValidation_CCU100();
		RangValidation_ASPIRE100();
		RangValidation_GDR();
		//GOGO
		RangValidation_ST4300();
		RangValidation_Axxess();
		//IRIDIUM
		RangValidation_IridiumGo();
		//AVIATOR
		RangValidation_Aviator();
		//SDR
		RangValidation_SDR();
		//TRUENORTH
		RangValidation_Optelity();
		RangValidation_Simphone();
		
	service.stop();
		
	}
	
private void Empty_Router_Check() throws InterruptedException {	
		
		Thread.sleep(1000);
		
		AccountEl account= new AccountEl (driver);
		
		account.AddAccount.click();							// click to open new account setup page
		
	
		account.AccDrop.click();                              //click to open manufacturer list
		
		account.HonAccList.click();								// Click to select manufacturer
		
		account.AccSave.click();
		
		Assert.assertEquals(account.Extension_range.getText(),ROUTER_EMPTY );
		System.out.println();
		
		account.BackButton.click();
		
	}
	
//HOEYWELL
	
private void RangValidation_CNX900() throws InterruptedException {	
		
		Thread.sleep(1000);
		
		AccountEl account= new AccountEl (driver);
		
	//	account.AddAccount.click();							// click to open new account setup page
		
	
		account.AccDrop.click();                              //click to open manufacturer list
		
		account.HonAccList.click();								// Click to select manufacturer
		
		account.AccRouter.click();  						// Click to open router list
		
		Utilities u = new Utilities (driver);
		u.ScrollText("Custom");
		
		account.CNX900.click();   
		
		account.ExtSelect.click();
		account.ExtSelect.clear();
		account.ExtSelect.sendKeys(TestDataAccount.Honext[0]);
		driver.hideKeyboard();
		
		account.AccSave.click();
		
		Assert.assertEquals(account.Extension_range.getText(), EXTENSION_RANGE_EXCEED_CNX900);
		System.out.println();
		
		account.BackButton.click();
		
	}


private void RangValidation_CNX800() throws InterruptedException {	
	
	Thread.sleep(1000);
							
	AccountEl account= new AccountEl (driver);
	account.AccRouter.click();  						// Click to open router list
	
	Utilities u = new Utilities (driver);
	u.ScrollText("Custom");
	
	account.CNX800.click();   
	
	account.ExtSelect.click();
	account.ExtSelect.clear();
	account.ExtSelect.sendKeys(TestDataAccount.Honext[0]);
	driver.hideKeyboard();
	
	account.AccSave.click();
	
	Assert.assertEquals(account.Extension_range.getText(), EXTENSION_RANGE_EXCEED_CNX800);
	//System.out.println();
	
	account.BackButton.click();
	//account.BackButton.click();
}


private void RangValidation_CNX250() throws InterruptedException {	
	
	Thread.sleep(1000);
	
	AccountEl account= new AccountEl (driver);
	
	//account.AccDrop.click();                              //click to open manufacturer list
	
	//account.HonAccList.click();								// Click to select manufacturer
	
	account.AccRouter.click();  						// Click to open router list
	
	Utilities u = new Utilities (driver);
	u.ScrollText("Custom");
	
	account.CNX250.click();   
	
	account.ExtSelect.click();
	account.ExtSelect.clear();
	account.ExtSelect.sendKeys(TestDataAccount.Honext[0]);
	driver.hideKeyboard();
	
	account.AccSave.click();
	
	Assert.assertEquals(account.Extension_range.getText(), EXTENSION_RANGE_EXCEED_CNX250);
	System.out.println();
	
	account.BackButton.click();
//	account.BackButton.click();
} 


private void RangValidation_CG710GD() {	
	
	//Thread.sleep(1000);
	
	AccountEl account= new AccountEl (driver);
	
	//account.AccDrop.click();                              //click to open manufacturer list
	
	//account.HonAccList.click();								// Click to select manufacturer
	
	account.AccRouter.click();  						// Click to open router list
	
	Utilities u = new Utilities (driver);
	u.ScrollText("Custom");
	
	account.CG710G.click();   
	
	account.ExtSelect.click();
	account.ExtSelect.clear();
	account.ExtSelect.sendKeys(TestDataAccount.Honext[0]);
	driver.hideKeyboard();
	
	account.AccSave.click();
	
	Assert.assertEquals(account.Extension_range.getText(), EXTENSION_RANGE_EXCEED_CG710GD);
	System.out.println();
	
	account.BackButton.click();
//	account.BackButton.click();
}

private void RangValidation_CG710L() {	
	
	//Thread.sleep(1000);
	
	AccountEl account= new AccountEl (driver);
	
	//account.AccDrop.click();                              //click to open manufacturer list
	
	//account.HonAccList.click();								// Click to select manufacturer
	
	account.AccRouter.click();  						// Click to open router list
	
	Utilities u = new Utilities (driver);
	u.ScrollText("Custom");
	
	account.CG710L.click();   
	
	account.ExtSelect.click();
	account.ExtSelect.clear();
	account.ExtSelect.sendKeys(TestDataAccount.Honext[0]);
	driver.hideKeyboard();
	
	account.AccSave.click();
	
	Assert.assertEquals(account.Extension_range.getText(), EXTENSION_RANGE_EXCEED_CG710L);
	System.out.println();
	
	account.BackButton.click();
	//account.BackButton.click();
}
private void RangValidation_CCU200() {	
	
	//Thread.sleep(1000);
	
	AccountEl account= new AccountEl (driver);
	
	//account.AccDrop.click();                              //click to open manufacturer list
	
	//account.HonAccList.click();								// Click to select manufacturer
	
	account.AccRouter.click();  						// Click to open router list
	
	Utilities u = new Utilities (driver);
	u.ScrollText("Custom");
	
	account.CCU200.click();   
	
	account.ExtSelect.click();
	account.ExtSelect.clear();
	account.ExtSelect.sendKeys(TestDataAccount.Honext[0]);
	driver.hideKeyboard();
	
	account.AccSave.click();
	
	Assert.assertEquals(account.Extension_range.getText(), EXTENSION_RANGE_EXCEED_CCU200);
	System.out.println();
	
	account.BackButton.click();
	//account.BackButton.click();
}

private void RangValidation_CCU100() {	
	
	//Thread.sleep(1000);
	
	AccountEl account= new AccountEl (driver);
	
	//account.AccDrop.click();                              //click to open manufacturer list
	
	//account.HonAccList.click();								// Click to select manufacturer
	
	account.AccRouter.click();  						// Click to open router list
	
	Utilities u = new Utilities (driver);
	u.ScrollText("Custom");
	
	account.CCU100.click();   
	
	account.ExtSelect.click();
	account.ExtSelect.clear();
	account.ExtSelect.sendKeys(TestDataAccount.Honext[0]);
	driver.hideKeyboard();
	
	account.AccSave.click();
	
	Assert.assertEquals(account.Extension_range.getText(), EXTENSION_RANGE_EXCEED_CCU100);
	System.out.println();
	
	account.BackButton.click();
	//account.BackButton.click();
}

private void RangValidation_ASPIRE100() {	
	
	//Thread.sleep(1000);
	
	AccountEl account= new AccountEl (driver);
	
	//account.AccDrop.click();                              //click to open manufacturer list
	
	//account.HonAccList.click();								// Click to select manufacturer
	
	account.AccRouter.click();  						// Click to open router list
	
	Utilities u = new Utilities (driver);
	u.ScrollText("Custom");
	
	account.Aspire.click();   
	
	account.ExtSelect.click();
	account.ExtSelect.clear();
	account.ExtSelect.sendKeys(TestDataAccount.Honext[0]);
	driver.hideKeyboard();
	
	account.AccSave.click();
	
	Assert.assertEquals(account.Extension_range.getText(), EXTENSION_RANGE_EXCEED_ASPIRE100);
	System.out.println();
	
	account.BackButton.click();
	
}
private void RangValidation_GDR() {	
	
	//Thread.sleep(1000);
	
	AccountEl account= new AccountEl (driver);
	
	//account.AccDrop.click();                              //click to open manufacturer list
	
	//account.HonAccList.click();								// Click to select manufacturer
	
	account.AccRouter.click();  						// Click to open router list
	
	Utilities u = new Utilities (driver);
	u.ScrollText("Custom");
	
	account.GDR.click();   
	
	account.ExtSelect.click();
	account.ExtSelect.clear();
	account.ExtSelect.sendKeys(TestDataAccount.Honext[0]);
	driver.hideKeyboard();
	
	account.AccSave.click();
	
	Assert.assertEquals(account.Extension_range.getText(), EXTENSION_RANGE_EXCEED_GDR);
	System.out.println();
	
	account.BackButton.click();
	account.BackButton.click();
}


//GOGO


private void RangValidation_ST4300() {	
	
	//Thread.sleep(1000);
	
	AccountEl account= new AccountEl (driver);
	//account.AddAccount.click();							// click to open new account setup page
	
	account.AccDrop.click();                              //click to open manufacturer list
	
	account.Gogo.click();								// Click to select manufacturer
	
	account.AccRouter.click();  						// Click to open router list
	
	Utilities u = new Utilities (driver);
	u.ScrollText("Custom");
	
	account.ST4300.click();   
	
	account.ExtSelect.click();
	account.ExtSelect.clear();
	account.ExtSelect.sendKeys(TestDataAccount.gogoext[0]);
	driver.hideKeyboard();
	
	account.AccSave.click();
	
	Assert.assertEquals(account.Extension_range.getText(), EXTENSION_RANGE_EXCEED_ST4300);
	System.out.println();
	
	account.BackButton.click();
}

private void RangValidation_Axxess() {	
	
	//Thread.sleep(1000);
	
	AccountEl account= new AccountEl (driver);
	
	account.AccRouter.click();  						// Click to open router list
	
	Utilities u = new Utilities (driver);
	u.ScrollText("Custom");
	
	account.Axxess.click();   
	
	account.ExtSelect.click();
	account.ExtSelect.clear();
	account.ExtSelect.sendKeys(TestDataAccount.gogoext[0]);
	driver.hideKeyboard();
	
	account.AccSave.click();
	
	Assert.assertEquals(account.Extension_range.getText(), EXTENSION_RANGE_EXCEED_AXXESS);
	System.out.println();
	
	account.BackButton.click();
	account.BackButton.click();
}
 
private void RangValidation_IridiumGo() {	
	
	//Thread.sleep(1000);
	
	AccountEl account= new AccountEl (driver);
	//account.AddAccount.click();							// click to open new account setup page
	
	account.AccDrop.click();                              //click to open manufacturer list
	
	account.Iridium.click();								// Click to select manufacturer
	
	account.AccRouter.click();  						// Click to open router list
	
	Utilities u = new Utilities (driver);
	u.ScrollText("Custom");
	
	account.IridiumGo.click();   
	
	//account.ExtSelect.click();
	//account.ExtSelect.clear();
	//account.ExtSelect.sendKeys(TestDataAccount.Iriext[]);
	driver.hideKeyboard();
	
	account.AccSave.click();
	
	Assert.assertEquals(account.Extension_range.getText(), EXTENSION_RANGE_EXCEED_IRIDIUMGO);
	System.out.println();
	
	account.BackButton.click();
	account.BackButton.click();
}

private void RangValidation_Aviator() {	
	
	//Thread.sleep(1000);
	
	AccountEl account= new AccountEl (driver);
	//account.AddAccount.click();							// click to open new account setup page
	
	account.AccDrop.click();                              //click to open manufacturer list
	
	account.Cobham.click();								// Click to select manufacturer
	
	account.AccRouter.click();  						// Click to open router list
	
	Utilities u = new Utilities (driver);
	u.ScrollText("Custom");
	
	account.Aviator.click();   
	
	account.ExtSelect.click();
	account.ExtSelect.clear();
	account.ExtSelect.sendKeys(TestDataAccount.Cobext[3]);
	driver.hideKeyboard();
	
	account.AccSave.click();
	
	Assert.assertEquals(account.Extension_range.getText(), EXTENSION_RANGE_EXCEED_AVIATOR);
	System.out.println();
	
	account.BackButton.click();
	account.BackButton.click();
}
private void RangValidation_SDR() {	
	
	//Thread.sleep(1000);
	
	AccountEl account= new AccountEl (driver);
	//account.AddAccount.click();							// click to open new account setup page
	
	account.AccDrop.click();                              //click to open manufacturer list
	
	account.SatcomDirect.click();								// Click to select manufacturer
	
	account.AccRouter.click();  						// Click to open router list
	
	Utilities u = new Utilities (driver);
	u.ScrollText("Custom");
	
	account.SDR.click();   
	
	account.ExtSelect.click();
	account.ExtSelect.clear();
	account.ExtSelect.sendKeys(TestDataAccount.sdrext[3]);
	driver.hideKeyboard();
	
	account.AccSave.click();
	
	Assert.assertEquals(account.Extension_range.getText(), EXTENSION_RANGE_EXCEED_SDR);
	System.out.println();
	
	account.BackButton.click();
	account.BackButton.click();
}
private void RangValidation_Optelity() {	
	
	//Thread.sleep(1000);
	
	AccountEl account= new AccountEl (driver);
	//account.AddAccount.click();							// click to open new account setup page
	
	account.AccDrop.click();                              //click to open manufacturer list
	
	account.TrueNorth.click();								// Click to select manufacturer
	
	account.AccRouter.click();  						// Click to open router list
	
	Utilities u = new Utilities (driver);
	u.ScrollText("Custom");
	
	account.Optelity.click();   
	
	account.ExtSelect.click();
	account.ExtSelect.clear();
	account.ExtSelect.sendKeys(TestDataAccount.TNext[4]);
	driver.hideKeyboard();
	
	account.AccSave.click();
	
	Assert.assertEquals(account.Extension_range.getText(), EXTENSION_RANGE_EXCEED_OPTELITY);
	System.out.println();
	
	account.BackButton.click();
}

private void RangValidation_Simphone() {	
	
	//Thread.sleep(1000);
	
	AccountEl account= new AccountEl (driver);
	
	
	account.AccRouter.click();  						// Click to open router list
	
	Utilities u = new Utilities (driver);
	u.ScrollText("Custom");
	
	account.Simphone.click();   
	
	account.ExtSelect.click();
	account.ExtSelect.clear();
	account.ExtSelect.sendKeys(TestDataAccount.TNext[4]);
	driver.hideKeyboard();
	
	account.AccSave.click();
	
	Assert.assertEquals(account.Extension_range.getText(), EXTENSION_RANGE_EXCEED_SIMPHONE);
	System.out.println();
	
	account.BackButton.click();
	account.BackButton.click();
}

}

