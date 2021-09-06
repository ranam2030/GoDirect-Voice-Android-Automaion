package AutomationTest.GoDirectVoiceAndroid.call;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import AutomationTest.GoDirectVoiceAndroid.Base;
import AutomationTest.GoDirectVoiceAndroid.onlineaccount.LoginAcc;
import PageObject.AppDrawerEl;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class CallStatistics extends Base {
	
	@Test
	public void InCallTest() throws InterruptedException, IOException {

		service = startServer();
		AndroidDriver<AndroidElement> driver = Capabilities("GoDirectVoiceApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(4000);
		new LoginAcc().KeypadNavigation();
		Thread.sleep(4000);
		
		AppDrawerEl dr = new AppDrawerEl (driver);
		dr.Drawer.click();
		Thread.sleep(1000);
		
		dr.CallStat.click();
		
		new EstablishCall().IncallStat();;
		
		new EstablishCall().InactiveCallLog();

		new EstablishCall().SendCallLog();
		
	

		service.stop();
	}


}
