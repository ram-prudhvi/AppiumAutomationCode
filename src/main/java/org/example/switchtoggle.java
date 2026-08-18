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

public class switchtoggle {
    public static void main(String[] args) throws MalformedURLException {
        URL url =new URL("http://127.0.0.1:4723/");
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("Pixel 6");
        options.setUdid("emulator-5554");

        options.setAppPackage("io.appium.android.apis");  //target App  Unique Identifier/ID. like Aadhaar Number
        options.setAppActivity("io.appium.android.apis.ApiDemos"); // After the App open displayed Home Screen path
        AndroidDriver driver = new AndroidDriver(url, options);

        WebElement view = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"));
        if (view.isDisplayed()) {
            System.out.println("View is Displayed");
            view.click();
            System.out.println("View is Clicked Successfully");
        } else {
            System.out.println("View is Displayed but unable to click");
        }

        WebElement switches =driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
        +".scrollIntoView(new UiSelector().description(\"Switches\"))"));
        switches.click();
        System.out.println("Switch Button is Clicked Successfully");

        WebElement standardswitch = driver.findElement(By.xpath("//android.widget.Switch[@content-desc=\"Standard switch\"]"));
        standardswitch.click();
        System.out.println("standard switch toggle is Enabled Successfully");

        WebElement Defaultis = driver.findElement(By.xpath("//android.widget.Switch[@content-desc=\"Default is on\"]"));
        Defaultis.click();
        System.out.println("Default Switch On switch is off Successfully");


        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
    }
}
