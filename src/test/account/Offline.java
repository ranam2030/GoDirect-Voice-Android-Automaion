package AutomationTest.GoDirectVoiceAndroid.account;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.testng.Assert;
import org.testng.annotations.Test;

import AutomationTest.GoDirectVoiceAndroid.Base;
import AutomationTest.GoDirectVoiceAndroid.onlineaccount.LogInOut;
import AutomationTest.GoDirectVoiceAndroid.onlineaccount.LogOut;
import AutomationTest.GoDirectVoiceAndroid.onlineaccount.LoginAcc;
import PageObject.AppDrawerEl;
import PageObject.LoginEl;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;



public class Offline extends Base {
	
	public static final String OFFLINE_INSTRUCTION = "Offline Login mode is an advanced option which requires manual configuration for setting up Cabin PBX Accounts.";
	
	@Test
	public void OfflineTest() throws InterruptedException, IOException {
		service = startServer();

		AndroidDriver<AndroidElement> driver = Capabilities("GoDirectVoiceApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Thread.sleep(4000);
		new LoginAcc().KeypadNavigation();
		Thread.sleep(4000);
		
		AppDrawerEl dr = new AppDrawerEl (driver);
		dr.Drawer.click();
		
		boolean SignedStatus=new LogInOut().SignInCheck();
		if (!SignedStatus) {
			
			new LogOut().LogOut();
			
			Thread.sleep(9000);
			dr.Drawer.click();
		
		}
		
		Thread.sleep(3000);
		dr.SignIn.click();
		
		OfflineProceed();
		
		service.stop();
	}

	public void OfflineProceed() {
		// TODO Auto-generated method stub
		LoginEl offline = new LoginEl (driver);
		offline.Offline.click();
	
		Assert.assertEquals(offline.OfflineIns.getText(), OFFLINE_INSTRUCTION);
		
		offline.Proceed.click();
		
	}


}
