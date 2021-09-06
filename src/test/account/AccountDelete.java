package AutomationTest.GoDirectVoiceAndroid.account;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import AutomationTest.GoDirectVoiceAndroid.Base;
import AutomationTest.GoDirectVoiceAndroid.onlineaccount.LoginAcc;
import PageObject.AccountSelectEl;
import PageObject.AppDrawerEl;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;



public class AccountDelete extends Base {
	public static final String ACCOUNT_DELETE_TEXT = "Are you sure you want to delete this Profile now?";
	
	public static final String ACCOUNT_DELETE_HEADER = "Profile Delete";
	
	public AccountSelectEl account;
	@Test
	public void AccountDeleteTest() throws InterruptedException, IOException {
		service = startServer();

		AndroidDriver<AndroidElement> driver = Capabilities("GoDirectVoiceApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(4000);
		new LoginAcc().KeypadNavigation();
		Thread.sleep(4000);
		
		AppDrawerEl dr = new AppDrawerEl (driver);
		dr.Drawer.click();
		dr.Account.click();
		
		account = new AccountSelectEl (driver);
	
		SelectAccount();
		SelectRemove();
		SelectAccount();
		DeleteAccount();
		DeletePopUp();
		
		service.stop();
	}

	private void DeletePopUp() {
		// TODO Auto-generated method stub
		Assert.assertEquals(account.AccDelete.getText(), ACCOUNT_DELETE_TEXT);

		Assert.assertEquals(account.Header.getText(), ACCOUNT_DELETE_HEADER);
	
		account.Yes.click();
	}

	private void DeleteAccount() {
		// TODO Auto-generated method stub
		account.SelectionDelete.click();
	}

	private void SelectAccount() {
		// TODO Auto-generated method stub
		TouchAction t =new TouchAction(driver);
		t.longPress(longPressOptions().withElement(element(account.AccSelect))).release().perform();
	}

	private void SelectRemove() {
		// TODO Auto-generated method stub
		account.SelectionRemove.click();	
	}

	

}
