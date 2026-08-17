package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.touch.LongPressOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;
import java.net.URL;

public class actions {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        URL url = new URL("http://127.0.0.1:4723/");

        //Desired Capabilities For UiAutomator2Options
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android"); // Checking Mobile target Operating System (OS) which has Android or IOS
        options.setAutomationName("UiAutomator2"); // Appium backend  Driver For Android
        options.setDeviceName("Pixel 6"); // Test Run Device
        options.setUdid("emulator-5554"); //Emulator unique Hardware ID

        options.setAppPackage("io.appium.android.apis");  //target App  Unique Identifier/ID. like Aadhaar Number
        options.setAppActivity("io.appium.android.apis.ApiDemos"); // After the App open displayed Home Screen path
        AndroidDriver driver = new AndroidDriver(url, options); //Starting New Test Session in Appium Server


        System.out.println("Session is Started");

        //For Tap we need just using click
        WebElement view =driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"));
        if(view.isDisplayed()) {
            System.out.println("View is Displayed");
            view.click();
            System.out.println("View is Clicked Successfully");
        }
        else {
            System.out.println("View is Displayed but unable to click");
        }


        //For Tap we need just using click with appiumby
        //WebElement view =driver.findElement(AppiumBy.accessibilityId("Views"));
        //view.click();


        WebElement expandablelist =driver.findElement(AppiumBy.accessibilityId("Expandable Lists"));
        if(expandablelist.isDisplayed()) {
            System.out.println("expandablelist is Displayed");
            expandablelist.click();
            System.out.println("expandablelist is Clicked Successfully");
        }
        else {
            System.out.println("expandablelist Displayed but unable to click");
        }


        WebElement CustomAdapter =driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]\n"));
        if(CustomAdapter.isDisplayed()) {
            System.out.println("CustomAdapter is Displayed");
            CustomAdapter.click();
            System.out.println("CustomAdapter is Clicked Successfully");
        }
        else {
            System.out.println("CustomAdapter Displayed but unable to click");
        }


        WebElement dognames =driver.findElement(By.xpath("//android.widget.TextView[@text=\"Dog Names\"]"));
        if(dognames.isDisplayed()) {
            System.out.println("dognames is Displayed");
            dognames.click();
            System.out.println("dognames is Clicked Successfully");
        }
        else {
            System.out.println("dognames Displayed but unable to click");
        }

        // longpress using longclickGesture with map
        //map work with key and value pair
        //elementID and Duration are Keys
        WebElement bandit =driver.findElement(By.xpath("//android.widget.TextView[@text=\"Bandit\"]"));
        if(bandit.isDisplayed()) {
            System.out.println("Bandit is Displayed Successfully");
            driver.executeScript("mobile:longClickGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) bandit).getId(),
                    "duration", 2000));
            System.out.println("Bandit is Clicked Successfully");
        }



        Thread.sleep(1000);

        WebElement sampleaction = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sample action\")"));
        if(sampleaction.isDisplayed()) {
            sampleaction.click();
            System.out.println("sampleaction is clicked");
            Thread.sleep(2000);
        }


        System.out.println("Session is Completed  Successfully");

    }
}
