package com.Rahul.BrowsterstackIntegration;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	public WebDriver driver;
	public AppiumDriverLocalService service;

	@Test
	public void configureAppium(Method m)throws MalformedURLException {
	
	String userName = "rahulvakhariya_EPbeom";
	String key = "ggjfsVbuQXZx3yRQh3up";
	//String url = "https://" + userName + ":" + key + "@hub-cloud.browserstack.com/wd/hub";
	String url = "https://rahulvakhariya_EPbeom:ggjfsVbuQXZx3yRQh3up@hub-cloud.browserstack.com/wd/hub";
	

	DesiredCapabilities capabilities = new DesiredCapabilities();
	HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
	browserstackOptions.put("appiumVersion", "2.0.0");

	capabilities.setCapability("bstack:options", browserstackOptions);
	capabilities.setCapability("platformName", "android");
	capabilities.setCapability("platformVersion", "9.0");
	capabilities.setCapability("deviceName", "Google Pixel 3");
	capabilities.setCapability("app", "bs://a20c0135a8d54095c29ef3773612cdd48922fce1");
	capabilities.setCapability("project", "test java project");
	capabilities.setCapability("build", "Android-Demo");
	System.out.println(m.getName());
	capabilities.setCapability("name", m.getName());
	
	driver = new RemoteWebDriver(new URL(url), capabilities);

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
	
	driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rahul");
	
	driver.quit();

	}

}
