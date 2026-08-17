package org.example;

import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class Clocktest {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        // 1. Appium Server Endpoint
        URL url = new URL("http://127.0.0.1:4723/");

        // 2. Define Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("Pixel 6");
        options.setUdid("emulator-5554");

        // 🛑 CHANGE THIS TO FALSE: This forces Appium to close the app 
        // and launch it completely fresh so you see it open up!
        options.setNoReset(false);

        // Target Clock App (Verified from your mCurrentFocus log)
        options.setAppPackage("com.google.android.deskclock");
        options.setAppActivity("com.android.deskclock.DeskClock");

        System.out.println("Connecting to Appium server to start a fresh Clock session...");

        // 3. Initialize Session
        RemoteWebDriver driver = new RemoteWebDriver(url, options);
        System.out.println("Session built successfully!");

        // ⏳ Wait 3 seconds for the app to load visually
        Thread.sleep(3000);

        System.out.println("Attempting to click the Alarm tab to verify automation control...");

        // ⏳ Keep it open for 3 seconds so you can watch it
        Thread.sleep(3000);

        WebElement alaram = driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Alarm\"]/android.widget.FrameLayout[@resource-id=\"com.google.android.deskclock:id/navigation_bar_item_icon_container\"]/android.widget.ImageView[@resource-id=\"com.google.android.deskclock:id/navigation_bar_item_icon_view\"]"));
        Thread.sleep(5000);
        WebElement clock = driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Clock\"]/android.widget.FrameLayout[@resource-id=\"com.google.android.deskclock:id/navigation_bar_item_icon_container\"]/android.widget.ImageView[@resource-id=\"com.google.android.deskclock:id/navigation_bar_item_icon_view\"]"));
        Thread.sleep(5000);
        WebElement timer =driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Timer\"]/android.widget.FrameLayout[@resource-id=\"com.google.android.deskclock:id/navigation_bar_item_icon_container\"]"));
        Thread.sleep(5000);
        WebElement stopwatch =driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Stopwatch\"]/android.widget.FrameLayout[@resource-id=\"com.google.android.deskclock:id/navigation_bar_item_icon_container\"]/android.widget.ImageView[@resource-id=\"com.google.android.deskclock:id/navigation_bar_item_icon_view\"]"));
        Thread.sleep(5000);
        WebElement bedtime =driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Bedtime\"]/android.widget.FrameLayout[@resource-id=\"com.google.android.deskclock:id/navigation_bar_item_icon_container\"]/android.widget.ImageView[@resource-id=\"com.google.android.deskclock:id/navigation_bar_item_icon_view\"]"));

        alaram.click();
        clock.click();
        timer.click();
        stopwatch.click();
        bedtime.click();

         driver.quit();
        System.out.println("Execution complete.");
    }
}