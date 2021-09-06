package AutomationTest.GoDirectVoiceAndroid.call;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import AutomationTest.GoDirectVoiceAndroid.Base;
import AutomationTest.GoDirectVoiceAndroid.Messages.MsgBuddyAccess;
import AutomationTest.GoDirectVoiceAndroid.onlineaccount.LoginAcc;
import PageObject.ContactsEl;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;



public class CallMsgThreadBuddy extends Base {

	@Test
	public void CallMessageTest() throws InterruptedException, IOException {
		service = startServer();

		AndroidDriver<AndroidElement> driver = Capabilities("GoDirectVoiceApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(4000);
		
		new LoginAcc().KeypadNavigation();
		Thread.sleep(4000);
		
		ContactsEl contact = new ContactsEl (driver);
		
		new MsgBuddyAccess().AccessMsgThread();
		new MsgBuddyAccess().AccessBuddy();
		
		contact.ContactCall.get(0).click();	
		
		new OutgoingCall().OutGoingcallEnd();
	
		
		service.stop();
	}




	

}
