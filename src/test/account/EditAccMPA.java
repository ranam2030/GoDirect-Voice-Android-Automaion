package AutomationTest.GoDirectVoiceAndroid.account;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import AutomationTest.GoDirectVoiceAndroid.Base;
import PageObject.AccountEl;
import PageObject.AccountListEl;
import PageObject.AppDrawerEl;
import PageObject.ProfileDetailsMPAEl;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class EditAccMPA extends Base{
	@Test
	public void GoDirectVoiceTest() throws InterruptedException, IOException {
		service = startServer();

		AndroidDriver<AndroidElement> driver = Capabilities("GoDirectVoiceApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.startActivity(new Activity("com.honeywell.aero.godirectvoice","com.sb.app.settings.EULAPrivacyActivity"));
		
		Thread.sleep(2000);
		AppDrawerEl dr = new AppDrawerEl (driver);
		dr.Drawer.click();
		
		Thread.sleep(2000);
		AppDrawerEl acc = new AppDrawerEl (driver);
		acc.Account.click();
		
		Thread.sleep(1000);
		AccountListEl accselect = new AccountListEl (driver);
		accselect.Accselect.click();
		
		ProfileDetailsMPAEl editprofile = new ProfileDetailsMPAEl (driver);
		editprofile.ProfileName.click();
		editprofile.ProfileName.clear();
		editprofile.ProfileName.sendKeys("Aspire");
		driver.hideKeyboard();
		
		ProfileDetailsMPAEl editext= new ProfileDetailsMPAEl (driver);
		editext.Extension.click();
		editext.Extension.clear();
		editext.Extension.sendKeys("202");
		driver.hideKeyboard();
		
		ProfileDetailsMPAEl editpass= new ProfileDetailsMPAEl (driver);
		editpass.Password.click();
		editpass.Password.clear();
		editpass.Password.sendKeys("1234");
		driver.hideKeyboard();
		
		ProfileDetailsMPAEl editdomain= new ProfileDetailsMPAEl (driver);
		editdomain.Domain.click();
		editdomain.Domain.clear();
		editdomain.Domain.sendKeys("192.168.30.180");
		driver.hideKeyboard();
		
		ProfileDetailsMPAEl pressdone= new ProfileDetailsMPAEl (driver);
		pressdone.Done.click();
		
		
		service.stop();
		}
}
