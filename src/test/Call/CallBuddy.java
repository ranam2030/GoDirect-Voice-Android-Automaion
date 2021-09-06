package AutomationTest.GoDirectVoiceAndroid.call;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.testng.annotations.Test;

import AutomationTest.GoDirectVoiceAndroid.Base;
import AutomationTest.GoDirectVoiceAndroid.Utilities;
import PageObject.BuddiesEl;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;



public class CallBuddy extends Base {
	
	public BuddiesEl buddy;
	@Test
	public void CallBuddyTest() throws InterruptedException, IOException {
		service = startServer();

		AndroidDriver<AndroidElement> driver = Capabilities("GoDirectVoiceApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		buddy = new BuddiesEl (driver);
		
		BuddyAccess();
		
		CallBuddy();
		
		service.stop();
	}
	public void BuddyAccess() throws InterruptedException {
		// TODO Auto-generated method stub
		BuddiesEl buddy = new BuddiesEl (driver);
		buddy.Contacts.click();
		
		buddy.BuddyTab.click();
		
		buddy.OfflineList.click();
		
		buddy.SearchBuddy.click();
		
		buddy.SearchBox.sendKeys("Buddy");
		Thread.sleep(3000);
		driver.hideKeyboard();
		
		Utilities Buddyscroll = new Utilities(driver);
		
		Buddyscroll.ScrollText("Buddy");
		
		buddy.BuddyDetailsBuddy.click();
		
	}
	private void CallBuddy() throws InterruptedException {
		// TODO Auto-generated method stub
		buddy.BuddyCall.get(0).click();	
		
		new OutgoingCall().OutGoingcallEnd();
	

}
}
