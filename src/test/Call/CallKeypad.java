package AutomationTest.GoDirectVoiceAndroid.call;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import AutomationTest.GoDirectVoiceAndroid.Base;
import AutomationTest.GoDirectVoiceAndroid.Keypad.KeypadNumberType;
import AutomationTest.GoDirectVoiceAndroid.onlineaccount.LoginAcc;
import PageObject.KeypadEl;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;



public class CallKeypad extends Base {
	@Test
	public void CallKeypadTest() throws InterruptedException, IOException {
		service = startServer();

		AndroidDriver<AndroidElement> driver = Capabilities("GoDirectVoiceApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(4000);
		
		new LoginAcc().KeypadNavigation();
		Thread.sleep(4000);
		
		KeypadEl keypad = new KeypadEl (driver);
		Thread.sleep(4000);
		new KeypadNumberType().NumberTypeKeypad();
		Thread.sleep(4000);
		keypad.KeypadCall.click();	
		new OutgoingCall().OutGoingcallEnd();

		service.stop();
	}
	
	

}
