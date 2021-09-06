package AutomationTest.GoDirectVoiceAndroid.account;


import java.io.IOException;

import java.util.concurrent.TimeUnit;


import org.testng.annotations.Test;

import AutomationTest.GoDirectVoiceAndroid.Base;
import AutomationTest.GoDirectVoiceAndroid.onlineaccount.LoginAcc;
import PageObject.KeypadEl;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;



public class KeypadAccAdd extends Base {
	@Test
	public void KeypadAccAddTest() throws InterruptedException, IOException {
		service = startServer();

		AndroidDriver<AndroidElement> driver = Capabilities("GoDirectVoiceApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(4000);
		new LoginAcc().KeypadNavigation();
		Thread.sleep(4000);
		
		KeypadEl keypad = new KeypadEl (driver);
		keypad.KeypadProfile.click();
		Thread.sleep(4000);
		
		keypad.AccAdd.click();
		
		new AddSipCustom().AddSipAcc();
		
	}
}
