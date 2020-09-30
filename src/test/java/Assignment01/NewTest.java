package Assignment01;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class NewTest{
	  public AndroidDriver driver;
	   
@BeforeClass
  public void beforeClass() throws MalformedURLException, InterruptedException {
			DesiredCapabilities capability= new DesiredCapabilities();
		    capability.setCapability("deviceName", "Lucky");
		    //capability.setCapability(MobileCapabilityType.NO_RESET, true);
		    capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		    capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.khanacademy.android");
		    capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.khanacademy.android.ui.library.MainActivity");
		    driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
		    Thread.sleep(10000);
	         
	   }	
  @Test
  public void test() throws InterruptedException {
      driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Dismiss\")")).click();
      Thread.sleep(3000);
      driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in\")")).click();
      Thread.sleep(3000);
      driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Continue with Google\")")).click();
      Thread.sleep(5000);
      String actualText02=driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Choose an account\")")).getText();
      System.out.println(actualText02);
      String expectedText="Choose an account";
      Assert.assertEquals(actualText02, expectedText);

  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Khan Academy allows Google login");
	  driver.quit();
  }

}
