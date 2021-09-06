package AutomationTest.GoDirectVoiceAndroid.call;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.testng.annotations.Test;

import AutomationTest.GoDirectVoiceAndroid.Base;
import AutomationTest.GoDirectVoiceAndroid.Utilities;
import AutomationTest.GoDirectVoiceAndroid.onlineaccount.LoginAcc;
import PageObject.ContactsEl;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;



public class CallContact extends Base {
	public ContactsEl contact;
	
	@Test
	public void CallContactTest() throws InterruptedException, IOException {
		service = startServer();

		AndroidDriver<AndroidElement> driver = Capabilities("GoDirectVoiceApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		contact = new ContactsEl (driver);
		
		ContactSeacrh();
		
		contact.ContactCall.get(0).click();	
		
		new OutgoingCall().OutGoingcallEnd();
		
	
		service.stop();
	}


	public void ContactSeacrh() throws InterruptedException {
		
		ContactsEl contact = new ContactsEl (driver);
		Thread.sleep(4000);
		
		new LoginAcc().KeypadNavigation();
		Thread.sleep(4000);
		
		contact.Contacts.click();
		
		contact.ContactTab.click();
				
		contact.SearchContact.click();
		
		contact.SearchBox.sendKeys("Buddy");
		
		Thread.sleep(3000);
		driver.hideKeyboard();
		
		Utilities contactscroll = new Utilities(driver);
		contactscroll.ScrollText("Buddy");
		
		contact.ContactBuddy.click();
	}

}
