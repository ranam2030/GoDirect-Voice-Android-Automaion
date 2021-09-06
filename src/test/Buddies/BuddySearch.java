package AutomationTest.GoDirectVoiceAndroid.Buddies;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import PageObject.BuddiesEl;
import AutomationTest.GoDirectVoiceAndroid.Utilities;
import AutomationTest.GoDirectVoiceAndroid.onlineaccount.LoginAcc;
import AutomationTest.GoDirectVoiceAndroid.Base;
import AutomationTest.GoDirectVoiceAndroid.TestDataContact;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;



public class BuddySearch extends Base {
	public BuddiesEl buddy;
	@Test(dataProvider = "InputDataBuddy", dataProviderClass = TestDataContact.class)
	public void BuddySearchTest(String input) throws InterruptedException, IOException {
		service = startServer();

		AndroidDriver<AndroidElement> driver = Capabilities("GoDirectVoiceApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Buddy Search");
		Thread.sleep(4000);
		new LoginAcc().KeypadNavigation();
		Thread.sleep(4000);
		
		buddy = new BuddiesEl (driver);
		
		BuddySearchs();
		
		buddy.SearchBox.sendKeys(input);
		
		BuddyAccessDetails();
		
		
		service.stop();
	}
	
	public void BuddySearchs() {
		// TODO Auto-generated method stub
		BuddiesEl buddy = new BuddiesEl (driver);
		buddy.Contacts.click();
		
		buddy.BuddyTab.click();
		
		buddy.OfflineList.click();
		
		buddy.SearchBuddy.click();
		
	
	}
	
	private void BuddyAccessDetails() throws InterruptedException {
		// TODO Auto-generated method stub
		driver.hideKeyboard();
		
		Thread.sleep(4000);
		Utilities Buddyscroll = new Utilities(driver);
		Buddyscroll.ScrollText("Buddy");
		
		buddy.BuddyDetailsBuddy.click();
		
		buddy.BuddyBack.click();
		
		buddy.SearchClose.click();
		buddy.SearchClose.click();
		
	
	}

}
