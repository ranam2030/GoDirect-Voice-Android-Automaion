package AutomationTest.GoDirectVoiceAndroid.call;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import AutomationTest.GoDirectVoiceAndroid.Base;
import AutomationTest.GoDirectVoiceAndroid.history.HistoryDelete;
import AutomationTest.GoDirectVoiceAndroid.onlineaccount.LoginAcc;
import PageObject.HistoryEl;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;



public class CallHistory extends Base {

	@Test
	public void CallHistoryTest() throws InterruptedException, IOException {
		service = startServer();

		AndroidDriver<AndroidElement> driver = Capabilities("GoDirectVoiceApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		HistoryEl history = new HistoryEl(driver);
		Thread.sleep(4000);
		
		new LoginAcc().KeypadNavigation();
		Thread.sleep(4000);
		
		history.HistoryTab.click();
		history.AllTab.click();
		
		new HistoryDelete().SelectHistory();
		
		history.HistoryCall.click();
	
		new OutgoingCall().OutGoingcallEnd();
		
		service.stop();
	}




	

}
