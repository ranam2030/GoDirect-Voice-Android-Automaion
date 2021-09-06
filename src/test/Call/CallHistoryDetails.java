package AutomationTest.GoDirectVoiceAndroid.call;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.testng.annotations.Test;

import AutomationTest.GoDirectVoiceAndroid.Base;
import AutomationTest.GoDirectVoiceAndroid.Utilities;
import AutomationTest.GoDirectVoiceAndroid.onlineaccount.LoginAcc;
import PageObject.HistoryEl;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;



public class CallHistoryDetails extends Base {
	public HistoryEl history;
	@Test
	public void CallHistoryDetailsTest() throws InterruptedException, IOException {
		service = startServer();

		AndroidDriver<AndroidElement> driver = Capabilities("GoDirectVoiceApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(4000);
		new LoginAcc().KeypadNavigation();
		Thread.sleep(4000);
		
		history = new HistoryEl (driver);
		
	    HistoryDetails();
	
		history.HistoryCall.click();	
	
		new OutgoingCall().OutGoingcallEnd();
	
		
		
		service.stop();
	}

	public void HistoryDetails() throws InterruptedException {
		// TODO Auto-generated method stub
		HistoryEl history = new HistoryEl (driver);
		history.HistoryTab.click();
		history.AllTab.click();
		Thread.sleep(9000);
		Utilities contactscroll = new Utilities(driver);
		contactscroll.ScrollText("Buddy");
		
		history.HistoryBuddy.click();
	}

}
