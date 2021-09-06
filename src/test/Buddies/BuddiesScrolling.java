package AutomationTest.GoDirectVoiceAndroid.Buddies;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import PageObject.BuddiesEl;
import AutomationTest.GoDirectVoiceAndroid.Base;
import AutomationTest.GoDirectVoiceAndroid.Utilities;
import AutomationTest.GoDirectVoiceAndroid.onlineaccount.LoginAcc;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;



public class BuddiesScrolling extends Base {
	public BuddiesEl buddy;
	@Test
	public void BuddiesScrollingTest() throws InterruptedException, IOException {
		service = startServer();

		AndroidDriver<AndroidElement> driver = Capabilities("GoDirectVoiceApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Buddies Scrolling");
		Thread.sleep(4000);
		new LoginAcc().KeypadNavigation();
		Thread.sleep(4000);
		
		buddy = new BuddiesEl (driver);
		ScrollBuddies();

		
		service.stop();
	}

	
	private void ScrollBuddies() throws InterruptedException {
		// TODO Auto-generated method stub
		buddy.Contacts.click();
		
		buddy.BuddyTab.click();
		
		buddy.OfflineList.click();
		Utilities Buddyscroll = new Utilities(driver);
		Buddyscroll.ScrollText("Tonmoy Basak");
	}
}