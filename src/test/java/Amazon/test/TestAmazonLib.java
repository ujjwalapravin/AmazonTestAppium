package Amazon.test;

import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;

public class TestAmazonLib {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		AmazonLib lb = new AmazonLib();
		AndroidDriver driver = lb.startApplication();
		lb.navigateToViews(driver);
	}}