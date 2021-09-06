package AutomationTest.GoDirectVoiceAndroid.account;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import AutomationTest.GoDirectVoiceAndroid.AppConstant;
import AutomationTest.GoDirectVoiceAndroid.Base;
import AutomationTest.GoDirectVoiceAndroid.TestDataAccount;
import AutomationTest.GoDirectVoiceAndroid.onlineaccount.LoginAcc;
import PageObject.AccountEl;
import PageObject.AccountValidEl;
import PageObject.AppDrawerEl;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;



public class AccountValidation extends Base {
	private static final String ACCOUNT_EMPTY = "account_empty";
	private static final String EXTENSION_EMPTY = "extension_empty";
	private static final String DOMAIN_EMPTY = "domain_empty";
	private static final String PROFILE_EMPTY = "profile_empty";
	private static final String EXTENSION_INVALID = "extension_invalid";
	
	private static final String KEY_TYPE = "type";
	private static final String KEY_EXTENSION = "extension";
	private static final String KEY_DOMAIN = "domain";
	private static final String KEY_PROFILE = "profile";
	private static final String KEY_PASSWORD = "password";
	private static final String KEY_MSG = "msg";
	
	List<Map<String, String>> validationList;
	public AccountValidEl account;
	
	@Test
	public void AccValidationTest() throws InterruptedException, IOException {
		validationList = new ArrayList<Map<String,String>>();
		service = startServer();

		AndroidDriver<AndroidElement> driver = Capabilities("GoDirectVoiceApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(4000);
		
		new LoginAcc().KeypadNavigation();
		Thread.sleep(4000);
		
		AppDrawerEl dr = new AppDrawerEl (driver);
		dr.Drawer.click();
		dr.Account.click();
		
		account = new AccountValidEl (driver);
		
		AccountEl acc = new AccountEl (driver);
		acc.AddAccount.click();
		acc.AccDrop.click();
		acc.GenAccList.click();
		
		validationList.add(getTestCaseMapData(ACCOUNT_EMPTY, 
				TestDataAccount.getAccountData().get(2).get(AppConstant.PROFILE), 
				TestDataAccount.getAccountData().get(2).get(AppConstant.EXTENSION), 
				TestDataAccount.getAccountData().get(2).get(AppConstant.PASSWORD),
				TestDataAccount.getAccountData().get(2).get(AppConstant.DOMAIN), 
				AppConstant.ACCOUNT_EMPTY_TEXT));
		
		validationList.add(getTestCaseMapData(EXTENSION_EMPTY, 
				TestDataAccount.getAccountData().get(3).get(AppConstant.PROFILE), 
				TestDataAccount.getAccountData().get(3).get(AppConstant.EXTENSION), 
				TestDataAccount.getAccountData().get(3).get(AppConstant.PASSWORD),
				TestDataAccount.getAccountData().get(3).get(AppConstant.DOMAIN), 
				AppConstant.EXTENSION_EMPTY_TEXT));
		
		validationList.add(getTestCaseMapData(DOMAIN_EMPTY, 
				TestDataAccount.getAccountData().get(4).get(AppConstant.PROFILE), 
				TestDataAccount.getAccountData().get(4).get(AppConstant.EXTENSION), 
				TestDataAccount.getAccountData().get(4).get(AppConstant.PASSWORD),
				TestDataAccount.getAccountData().get(4).get(AppConstant.DOMAIN), 
				AppConstant.DOMAIN_EMPTY_TEXT));
		
		validationList.add(getTestCaseMapData(PROFILE_EMPTY, 
				TestDataAccount.getAccountData().get(5).get(AppConstant.PROFILE), 
				TestDataAccount.getAccountData().get(5).get(AppConstant.EXTENSION), 
				TestDataAccount.getAccountData().get(5).get(AppConstant.PASSWORD),
				TestDataAccount.getAccountData().get(5).get(AppConstant.DOMAIN), 
				AppConstant.PROFILE_EMPTY_TEXT));
		
		validationList.add(getTestCaseMapData(EXTENSION_INVALID, 
				TestDataAccount.getAccountData().get(6).get(AppConstant.PROFILE), 
				TestDataAccount.getAccountData().get(6).get(AppConstant.EXTENSION),
				TestDataAccount.getAccountData().get(6).get(AppConstant.PASSWORD),
				TestDataAccount.getAccountData().get(6).get(AppConstant.DOMAIN), 
				AppConstant.EXTENSION_INVALID_TEXT));
		
	
		
		if(validationList != null && validationList.size() > 0) {
			for(Map<String, String> map: validationList) {
				
				account.ProfileSelect.clear();
				account.ProfileSelect.sendKeys(map.get(KEY_PROFILE));
				account.ExtSelect.clear();
				account.ExtSelect.sendKeys(map.get(KEY_EXTENSION));
				account.PassSelect.clear();
				account.PassSelect.sendKeys(map.get(KEY_PASSWORD));
				account.DomainSelect.clear();
				account.DomainSelect.sendKeys(map.get(KEY_DOMAIN));
				
				account.AccSave.click();
				
				Assert.assertEquals(getMsg(map.get(KEY_TYPE), account), map.get(KEY_MSG));
						
				
			}
		}
		
	
		service.stop();
	}
	private String getMsg(String type, AccountValidEl account) {
		
		String msg= "";
		switch (type) {
		case ACCOUNT_EMPTY:
			msg =  account.EDToast.getAttribute("name");

			break;
		case EXTENSION_EMPTY:
			msg =  account.EDToast.getAttribute("name");

			break;
		case DOMAIN_EMPTY:
			msg = account.EDToast.getAttribute("name");
			break;
			
		case PROFILE_EMPTY:
			msg =  account.ProfileToast.getAttribute("name");
			break;
			
		case EXTENSION_INVALID:
			msg =  account.InvalidExtToast.getAttribute("name");
			break;
			
		default:
			System.out.println("no match");

		}
		
		return msg;
	}

	private Map<String, String> getTestCaseMapData(String type,String profile, String extension, 
			String password,String domain, String checkMsg) {
		Map<String, String> map = new HashMap<String, String>();
		map.put(KEY_TYPE, type);
		map.put(KEY_PROFILE, profile);
		map.put(KEY_EXTENSION, extension);
		map.put(KEY_DOMAIN, domain);
		map.put(KEY_PASSWORD, password);
		map.put(KEY_MSG, checkMsg);
		return map;
		
	}
	

}
