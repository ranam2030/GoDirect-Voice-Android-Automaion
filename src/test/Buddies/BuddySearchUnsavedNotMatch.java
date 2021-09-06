package AutomationTest.GoDirectVoiceAndroid.Buddies;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.BuddiesEl;
import AutomationTest.GoDirectVoiceAndroid.Utilities;
import AutomationTest.GoDirectVoiceAndroid.onlineaccount.LoginAcc;
import AutomationTest.GoDirectVoiceAndroid.Base;
import AutomationTest.GoDirectVoiceAndroid.TestDataContact;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;



public class BuddySearchUnsavedNotMatch extends Base {
	public BuddiesEl buddy;
	
	public static final String NO_MESSAGE_ONLINE_TEXT = "No Buddies Online";
	public static final String NO_MESSAGE_OFFLINE_TEXT = "No Buddies Offline";
	
	@Test
	public void BuddySearchTest() throws InterruptedException, IOException {
		service = startServer();

		AndroidDriver<AndroidElement> driver = Capabilities("GoDirectVoiceApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Buddy Search Unsaved Match");
		Thread.sleep(4000);
		new LoginAcc().KeypadNavigation();
		Thread.sleep(4000);
		
		buddy = new BuddiesEl (driver);
		
		new BuddySearch().BuddySearchs();
	
		
		BuddyAccessDetails();
		
		NotMatch();
		
		
		service.stop();
	}
	
	
	private void BuddyAccessDetails() throws InterruptedException {
		// TODO Auto-generated method stub
		buddy.SearchBox.sendKeys(TestDataContact.BuddySearch[0]);
		driver.hideKeyboard();
		
		Thread.sleep(4000);
		Utilities Buddyscroll = new Utilities(driver);
		Buddyscroll.ScrollText("Tonmoy Basak");
		
		buddy.BuddyDetails.get(0).click();
		
		buddy.BuddyBack.click();
		
		buddy.SearchClose.click();
		buddy.SearchClose.click();
		
	
	}
	
	private void NotMatch() throws InterruptedException {
		// TODO Auto-generated method stub
		buddy.SearchBuddy.click();
		buddy.SearchBox.sendKeys(TestDataContact.BuddySearch[1]);
		driver.hideKeyboard();
		
		Thread.sleep(4000);
		Assert.assertEquals(buddy.OnlineNoMatch.getText(),NO_MESSAGE_ONLINE_TEXT);
		Assert.assertEquals(buddy.OfflineNoMatch.getText(),NO_MESSAGE_OFFLINE_TEXT);
		
		buddy.SearchClose.click();
		buddy.SearchClose.click();
		
	
	}

}
