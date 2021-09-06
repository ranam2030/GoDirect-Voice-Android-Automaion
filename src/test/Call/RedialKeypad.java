package AutomationTest.GoDirectVoiceAndroid.call;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;

import AutomationTest.GoDirectVoiceAndroid.Base;
import AutomationTest.GoDirectVoiceAndroid.SIPCall.OutgoingSIPCall;
import AutomationTest.GoDirectVoiceAndroid.onlineaccount.LoginAcc;
import PageObject.KeypadEl;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;



public class RedialKeypad extends Base {
	@Test
	public void RedialKeypadTest() throws InterruptedException, IOException {
		service = startServer();

		AndroidDriver<AndroidElement> driver = Capabilities("GoDirectVoiceApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(4000);
		
		new LoginAcc().KeypadNavigation();
		Thread.sleep(7000);
		
		RedialNumber();
		new OutgoingSIPCall().OutGoingcallEnd();
		service.stop();
		
	}

	public void RedialNumber() throws InterruptedException {
		// TODO Auto-generated method stub
		
		KeypadEl call = new KeypadEl (driver);
		call.KeypadCall.click();	
		
		Thread.sleep(2000);
		
		call.KeypadCall.click();	
	}

}
