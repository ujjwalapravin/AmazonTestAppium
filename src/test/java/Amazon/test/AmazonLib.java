package Amazon.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class AmazonLib {
	public AndroidDriver startApplication() throws MalformedURLException {
		URL URL = new URL ("http://localhost:4723/wd/hub");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","11");
		capabilities.setCapability("appPackage","com.touchboarder.android.api.demos");
		capabilities.setCapability("appActivity","com.touchboarder.androidapidemos.MainActivity");
		
		AndroidDriver driver = new AndroidDriver(URL, capabilities);
		System.out.println("Session ID is " + driver.getSessionId());
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//WebDriverWait wc = new WebDriverWait(driver, Duration.ofSeconds(20));
	  //  wc.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.amazon.mShop.android.shopping:id/btn_cancel")));
		//driver.findElement(By.id("com.android.permissioncontroller:id/cancel_button")).click();
				
		return driver;
	}
	public void navigateToViews(AndroidDriver driver) {
		driver.findElement(By.id("com.android.permissioncontroller:id/cancel_button")).click();
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Select English\"]")).click();
		driver.findElement(By.id("in.amazon.mShop.android.shopping:id/continue_button")).click();
		driver.findElement(By.id("in.amazon.mShop.android.shopping:id/chrome_search_hint_view")).click();
		driver.findElement(By.id("in.amazon.mShop.android.shopping:id/rs_search_src_text")).sendKeys("Airpods");
        //Display all the element in the console
		List<WebElement> lstviews = driver.findElements(By.xpath("//android.widget.Button[@index='1']"));
		for (WebElement view : lstviews) {
			System.out.println("result are :" + view.getAttribute("content-desc"));
		//click on airpods on 2nd generation airpods
		driver.findElement(By.xpath("//android.widget.Button[@text='airpods pro 2']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//Display all the elements in 2nd generation airpods
		List<WebElement> lstpods = driver.findElements(By.xpath("//android.view.view[@resource-id='search']"));
		for (WebElement views : lstpods) {
			System.out.println("result are :" + views.getAttribute("content-desc"));
		}

	}
	}}
