package AutomationTest.GoDirectVoiceAndroid.call;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import AutomationTest.GoDirectVoiceAndroid.Base;
import AutomationTest.GoDirectVoiceAndroid.onlineaccount.LoginAcc;
import PageObject.CallEl;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class OutgoingCall extends Base {
	public CallEl outcall;
	@Test
	public void OutgoingCallTest() throws InterruptedException, IOException {
	
		service = startServer();
		AndroidDriver<AndroidElement> driver = Capabilities("GoDirectVoiceApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(4000);
		new LoginAcc().KeypadNavigation();
		Thread.sleep(7000);
		
		//keypad functionality
		new RedialKeypad().RedialNumber();
		
		// outgoing call
		 outcall = new CallEl (driver);
		 Thread.sleep(9000);
		 OutGoingcallStatus();
		 OutGoingcallSpeaker();
		 OutGoingcallEnd();
		
		service.stop();
	}

	private void OutGoingcallStatus() throws InterruptedException {
		
		
		System.out.println (outcall.CallContact.getText());
		
		System.out.println (outcall.OutCallStatus.getText());
		
		
	}
	
	private void OutGoingcallSpeaker() throws InterruptedException {

		outcall.Speaker.click();
		Thread.sleep(7000);
		outcall.Speaker.click();
	}
	
	public void OutGoingcallEnd() throws InterruptedException {
		CallEl outcall = new CallEl (driver);
	
		Thread.sleep(7000);
		
		outcall.EndCall.click();
	}
	
}
