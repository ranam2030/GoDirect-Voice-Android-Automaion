package AutomationTest.GoDirectVoiceAndroid.account;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.AboutEl;
import PageObject.AccountEl;
import PageObject.AccountListEl;
import PageObject.AppDrawerEl;
import PageObject.ContactsEl;
import PageObject.DiscoveryEl;
import PageObject.KeypadEl;
import PageObject.LoginEl;
import PageObject.PermissionEl;
import AutomationTest.GoDirectVoiceAndroid.AppConstant;
import AutomationTest.GoDirectVoiceAndroid.BaseFresh;
import AutomationTest.GoDirectVoiceAndroid.TestDataAccount;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class AppStartOffline extends BaseFresh {
	public static final String CONTACT_PERMISSION_TEXT = "Allow GoDirect Voice to access your contacts?";
	public static final String MIC_PERMISSION_TEXT = "Allow GoDirect Voice to record audio?";
	public static final String STORAGE_PERMISSION_TEXT = "Allow GoDirect Voice to access photos, media, and files on your device?";
	public static final String PHONE_PERMISSION_TEXT = "Allow GoDirect Voice to make and manage phone calls?";

	public static final String EULA_TEXT = "By using this application you agree to the\r\n" + "\r\n"
			+ "License Agreement & Privacy Policy.";
	public static final String OFFLINE_INSTRUCTION = "Offline Login mode is an advanced option which requires manual configuration for setting up Cabin PBX Accounts.";

	public static final String AXXESS_TEXT = "Axxess";
	public static final String CG710Legacy_TEXT = "CG-710 (Legacy)";
	public static final String CG710GD_TEXT = "CG-710 (GoDirect)";
	public static final String CNX900_TEXT = "CNX-900";
	public static final String GDR_TEXT = "GDR";
	public static final String SDR_TEXT = "SDR";
	
	public static final String GENERIC_NAME = "Generic";
	public static final String GENERIC_NUMBER = "+1 (321) 525-4377";

	@Test
	public void AppStartOfflineTest() throws InterruptedException, IOException {
		service = startServer();

		AndroidDriver<AndroidElement> driver = Capabilities("GoDirectVoiceApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		PermissionTest();
		Thread.sleep(30000);
		
		AgreePage();
		SkipDiscovery();
		
		Thread.sleep(4000);
		OfflineProceed();
		
		AddSipAcc();
		Thread.sleep(4000);
		
		AccountDetailsCheck();
		Thread.sleep(4000);
		
		AccountCheck();
		Thread.sleep(4000);
		
		ContactNumberCheck();
		Thread.sleep(4000);
		
		service.stop();
	}



	public void PermissionTest() throws InterruptedException {
		// TODO Auto-generated method stub
		PermissionEl permission = new PermissionEl(driver);

		Assert.assertEquals(permission.PermissionText.getText(), CONTACT_PERMISSION_TEXT);
		permission.Allow.click();
		Thread.sleep(4000);

		Assert.assertEquals(permission.PermissionText.getText(), MIC_PERMISSION_TEXT);
		permission.Allow.click();
		Thread.sleep(4000);

		Assert.assertEquals(permission.PermissionText.getText(), PHONE_PERMISSION_TEXT);
		permission.Allow.click();
		Thread.sleep(4000);

		Assert.assertEquals(permission.PermissionText.getText(), STORAGE_PERMISSION_TEXT);
		permission.Allow.click();
	}

	public void AgreePage() {
		// TODO Auto-generated method stub
		AboutEl Eula = new AboutEl(driver);
		// Assert.assertEquals(Eula.EulaText.getText(), EULA_TEXT);
		Eula.Agree.click();
	}

	public void SkipDiscovery() {
		// TODO Auto-generated method stub
		DiscoveryEl discovery = new DiscoveryEl(driver);
		Assert.assertEquals(discovery.Axxees.getText(), AXXESS_TEXT);
		Assert.assertEquals(discovery.CG710Legacy.getText(), CG710Legacy_TEXT);
		Assert.assertEquals(discovery.CG710GD.getText(), CG710GD_TEXT);
		Assert.assertEquals(discovery.CNX900.getText(), CNX900_TEXT);
		Assert.assertEquals(discovery.GDR.getText(), GDR_TEXT);
		Assert.assertEquals(discovery.SDR.getText(), SDR_TEXT);
		discovery.Skip.click();
	}

	public void OfflineProceed() {
		// TODO Auto-generated method stub
		LoginEl offline = new LoginEl(driver);
		offline.Offline.click();

		offline.Offline.click();

		Assert.assertEquals(offline.OfflineIns.getText(), OFFLINE_INSTRUCTION);

		offline.Proceed.click();

	}

	public void AddSipAcc() throws InterruptedException {

		AccountEl account = new AccountEl(driver);

		account.AccDrop.click();

		account.GenAccList.click();
		// account.ProfileSelect.sendKeys(TestDataAccount.getAccountData().get(0).get(AppConstant.PROFILE));

		account.ExtSelect.sendKeys(TestDataAccount.getAccountData().get(0).get(AppConstant.EXTENSION));

		account.PassSelect.sendKeys(TestDataAccount.getAccountData().get(0).get(AppConstant.ACCPASSWORD));

		account.DomainSelect.sendKeys(TestDataAccount.getAccountData().get(0).get(AppConstant.DOMAIN));

		account.AccSave.click();

		AccountListEl accreg = new AccountListEl(driver);
		String Status = accreg.AccStaus.getText();

		System.out.println(Status);

		

	}
	
	private void AccountDetailsCheck() {
		// TODO Auto-generated method stub
		
		AccountListEl accreg = new AccountListEl(driver);
		String Status = accreg.AccStaus.getText();

		System.out.println(Status);
		
		Assert.assertEquals(accreg.AutoProvisioned.getText(), "AUTO PROVISIONED ACCOUNTS");
		
		Assert.assertEquals(accreg.AutoProvisionedText.getText(), "Not Signed In");
		
		
		Assert.assertEquals(accreg.AutoDiscovered.getText(), "AUTO DISCOVERED ACCOUNTS");
		
		Assert.assertEquals(accreg.AutoDiscoveredText.getText(), "No Account Discovered");
		
		Assert.assertEquals(accreg.AccToggle.getText(), "ON");
		
		Assert.assertEquals(accreg.AccName.getText(), "Generic");
		
		Assert.assertEquals(accreg.AccExt.getText(), "13215254377 (SIP)");
		
		Assert.assertEquals(accreg.AccDomain.getText(), "202.191.126.148");
		accreg.AccBack.click();
	}
	
	private void AccountCheck() throws InterruptedException {
		// TODO Auto-generated method stub
		AccountDrawerCheck();
		AccountKeypadCheck();
		
	}



	private void AccountKeypadCheck() {
		// TODO Auto-generated method stub
		KeypadEl keypad = new KeypadEl(driver);
		Assert.assertEquals(keypad.AccNameOffline.getText(), GENERIC_NAME);
		Assert.assertEquals(keypad.AccStatus.getText(), "ONLINE");
	}



	private void AccountDrawerCheck() throws InterruptedException {
		// TODO Auto-generated method stub
		AppDrawerEl dr = new AppDrawerEl (driver);
		Assert.assertEquals(dr.AccName.getText(), GENERIC_NAME);
		Assert.assertEquals(dr.AccExt.getText(), GENERIC_NUMBER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}

	private void ContactNumberCheck() {
		// TODO Auto-generated method stub
		ContactsEl contact = new ContactsEl(driver);
		contact.Contacts.click();
		Assert.assertEquals(contact.MyNumber.getText(),GENERIC_NUMBER);
	}
	
}
