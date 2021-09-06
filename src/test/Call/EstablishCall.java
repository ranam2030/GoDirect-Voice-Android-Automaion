package AutomationTest.GoDirectVoiceAndroid.call;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import AutomationTest.GoDirectVoiceAndroid.Base;
import AutomationTest.GoDirectVoiceAndroid.onlineaccount.LoginAcc;
import PageObject.AppDrawerEl;
import PageObject.CallEl;
import PageObject.CallStatEl;
import PageObject.KeypadEl;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class EstablishCall extends Base {
	public static final String SEND_CALL_TEXT = "Having a technical issue and want to send a diagnostic log to the support team? Follow up with the team will be required…";
	private CallEl incall;

	@Test
	public void InCallTest() throws InterruptedException, IOException {

		service = startServer();
		AndroidDriver<AndroidElement> driver = Capabilities("GoDirectVoiceApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(4000);
		new LoginAcc().KeypadNavigation();
		Thread.sleep(7000);

		// Redial Keypad functionality
		new RedialKeypad().RedialNumber();

		// In call
		incall = new CallEl(driver);
		Thread.sleep(12000);

		IncallStatus();

		IncallSpeaker();

		IncallMute();

		IncallHold();

		incall.CallStat.click();
		IncallStat();
		
		InactiveCallLog();

		SendCallLog();
		
		ReturnToCall();

		Thread.sleep(4000);
		DTMFKeypad();

		IncallEnd();

		service.stop();
	}

	private void IncallStatus() throws InterruptedException {

		System.out.println(incall.InCallCont.getText());

		System.out.println(incall.CallTimer.getText());

	}

	private void IncallSpeaker() throws InterruptedException {

		incall.Speaker.click();

		Thread.sleep(6000);

		incall.Speaker.click();

	}

	private void IncallMute() throws InterruptedException {
		incall.Mute.click();

		Thread.sleep(6000);

		incall.Mute.click();

	}

	private void IncallHold() throws InterruptedException {
		incall.Hold.click();

		Thread.sleep(6000);

		incall.Hold.click();

	}

	public void IncallStat() throws InterruptedException {

		CallStatEl callstat = new CallStatEl(driver);
		Thread.sleep(3000);
		callstat.ActiveCallSat.click();

		Assert.assertEquals(callstat.CallSatNumber.getText(), "16027530172");

		Assert.assertEquals(callstat.CallSatDomain.getText(), "89.255.223.174");

		Assert.assertEquals(callstat.CallSatSecurity.getText(), "Secured");

		Assert.assertEquals(callstat.CallSatCodec.getText(), "iSVC 8kHz");

		callstat.CallSatBarReceivedLost.isDisplayed();

		callstat.CallSatBarReceivedLost.isDisplayed();

		callstat.CallSatBarSentLost.isDisplayed();

		System.out.println(callstat.CallSatDuration.getText());

		System.out.println(callstat.CallSatLatency.getText());

	}

	public void InactiveCallLog() throws InterruptedException {

		CallStatEl callstat = new CallStatEl(driver);
		Thread.sleep(3000);
		callstat.InactiveCallSat.click();
		
		Assert.assertEquals(callstat.InactiveCallSatus.getText(), "No Call");
		
		callstat.ActiveCallSat.click();


	}
	
	public void SendCallLog() throws InterruptedException {

		CallStatEl callstat = new CallStatEl(driver);
		Thread.sleep(3000);
		callstat.CallSatSend.click();
		
		Assert.assertEquals(callstat.CallSatSendTitle.getText(), "Send Log");
		Assert.assertEquals(callstat.CallSatSendText.getText(), SEND_CALL_TEXT);
		callstat.CallSatSendYes.click();
		
		MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.ImageView");
		el1.click();
		
		Thread.sleep(2000);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(6000);
		
		MobileElement el2 = (MobileElement) driver.findElementById("com.google.android.gm:id/to");
		
		if (el2.getText().contains("suppoprt@stitelnetworks.com"))
		{		el2.click();
		
		}
		MobileElement el3 = (MobileElement) driver.findElementById("com.google.android.gm:id/subject");
		if (el3.getText().contains("GoDirect Voice Android Edition"))
		{		el3.click();
		
		}
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		Thread.sleep(2000);
		callstat.CallStatBack.click();
		
		

	}
	
	public void ReturnToCall() throws InterruptedException {
		
		AppDrawerEl dr = new AppDrawerEl (driver);
		dr.Drawer.click();
		Thread.sleep(1000);
		
		dr.CallStat.click();
		Thread.sleep(4000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

		Thread.sleep(2000);
		KeypadEl keypad = new KeypadEl (driver);
		keypad.Keypad8.click();


	}
	

	private void DTMFKeypad() throws InterruptedException {
		incall.DTMFKeypad.click();

		Thread.sleep(2000);
		incall.DTMFKeypad1.click();

		Thread.sleep(2000);
		incall.DTMFKeypad2.click();

		Thread.sleep(2000);
		incall.DTMFKeypad3.click();

		Thread.sleep(2000);
		incall.DTMFKeypad4.click();

		Thread.sleep(2000);
		incall.DTMFKeypad5.click();

		Thread.sleep(2000);
		incall.DTMFKeypad6.click();

		Thread.sleep(2000);
		incall.DTMFKeypad7.click();

		Thread.sleep(2000);
		incall.DTMFKeypad8.click();

		Thread.sleep(2000);
		incall.DTMFKeypad9.click();

		Thread.sleep(2000);
		incall.DTMFKeypad0.click();

		Thread.sleep(2000);
		incall.DTMFKeypadStar.click();

		Thread.sleep(2000);
		incall.DTMFKeypadHash.click();

		Thread.sleep(2000);
		incall.HideDTMFKeypad.click();

	}

	private void IncallEnd() throws InterruptedException {

		Thread.sleep(2000);
		incall.DTMFKeypad.click();

		Thread.sleep(2000);
		incall.EndDTMFKeypad.click();
	}

}
