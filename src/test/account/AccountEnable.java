package AutomationTest.GoDirectVoiceAndroid.account;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import AutomationTest.GoDirectVoiceAndroid.Base;
import AutomationTest.GoDirectVoiceAndroid.onlineaccount.LoginAcc;
import PageObject.AccountListEl;
import PageObject.AppDrawerEl;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;



public class AccountEnable extends Base {
	@Test
	public void AccountEnableTest() throws InterruptedException, IOException {
		service = startServer();

		AndroidDriver<AndroidElement> driver = Capabilities("GoDirectVoiceApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(4000);
		new LoginAcc().KeypadNavigation();
		Thread.sleep(4000);
		
		AppDrawerEl dr = new AppDrawerEl (driver);
		dr.Drawer.click();
		dr.Account.click();
		
		AccountEnableDisable();

		service.stop();
	}

	private void AccountEnableDisable() {
		
		TouchAction t =new TouchAction(driver);
		AccountListEl accountToggle = new AccountListEl (driver);
		if (accountToggle.AccToggle.getText().equalsIgnoreCase("ON")) {
			t.longPress(longPressOptions().withElement(element(accountToggle.AccEnable))).release().perform();
		}
		else {
			t.longPress(longPressOptions().withElement(element(accountToggle.AccDisable))).release().perform();
		}

	}

}
