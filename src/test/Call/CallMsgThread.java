package AutomationTest.GoDirectVoiceAndroid.call;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import AutomationTest.GoDirectVoiceAndroid.Base;
import AutomationTest.GoDirectVoiceAndroid.onlineaccount.LoginAcc;
import PageObject.MessageEl;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;



public class CallMsgThread extends Base {

	@Test
	public void CallMessageTest() throws InterruptedException, IOException {
		service = startServer();

		AndroidDriver<AndroidElement> driver = Capabilities("GoDirectVoiceApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(4000);
		new LoginAcc().KeypadNavigation();
		Thread.sleep(4000);
		
		MessageEl message = new MessageEl (driver);
		
		AccessMsgThread();
		
		message.MsgThreadCall.click();
	
		new OutgoingCall().OutGoingcallEnd();
		
		service.stop();
	}



	public void AccessMsgThread() throws InterruptedException {
		// TODO Auto-generated method stub
		MessageEl message = new MessageEl (driver);
		message.MessagesTab.click();
		Thread.sleep(7000);
		message.MessagesDetails.get(0).click();
	
	}
	
	

}
