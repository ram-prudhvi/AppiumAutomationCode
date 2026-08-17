package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;

public class checkbox {
    public static void main(String[] args) throws MalformedURLException {
        URL url =new URL("http://127.0.0.1:4723/");

        UiAutomator2Options options =new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("Pixel 6");
        options.setUdid("emulator-5554");


        options.setAppPackage("io.appium.android.apis");  //target App  Unique Identifier/ID. like Aadhaar Number
        options.setAppActivity("io.appium.android.apis.ApiDemos"); // After the App open displayed Home Screen path
        AndroidDriver driver = new AndroidDriver(url, options); //Starting New Test Session in Appium Server

        System.out.println("Session Is Started");

        WebElement view = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"));
        if (view.isDisplayed()) {
            System.out.println("View is Displayed");
            view.click();
            System.out.println("View is Clicked Successfully");
        } else {
            System.out.println("View is Displayed but unable to click");
        }

        WebElement SystemUiVisibility = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
        +".scrollIntoView(new UiSelector().description(\"System UI Visibility\"))"));
        SystemUiVisibility.click();
        System.out.println("SystemUiVisibility is Clicked Successfully");

        WebElement SystemUimodels =driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"System UI Modes\"]"));
        SystemUimodels.click();
        System.out.println("SystemUiModels is Clicked Successfully");


        WebElement lowprofile = driver.findElement(By.id("io.appium.android.apis:id/modeLowProfile"));
        lowprofile.click();
        System.out.println("lowprofile checkbox  is checked Successfully");

        WebElement Fullscreen =driver.findElement(By.id("io.appium.android.apis:id/layoutFullscreen"));
        Fullscreen.click();

        System.out.println("Fullscreen Checkbox is Checked Successfully");

        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));

        System.out.println("Successfully Back To Home");



    }

}
