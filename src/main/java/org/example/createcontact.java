package org.example;

import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class createcontact {
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
        options.setAppPackage("com.google.android.contacts");
        options.setAppActivity("com.android.contacts.activities.PeopleActivity");

        System.out.println("Connecting to Appium server to start a fresh Contact session...");
        options.setCapability("appium:autoGrantPermissions", true);
        // 3. Initialize Session
        RemoteWebDriver driver = new RemoteWebDriver(url, options);
        System.out.println("Session built successfully!");

        // ⏳ Wait 3 seconds for the app to load visually
        Thread.sleep(8000);
        Actions ac =new Actions(driver);
        System.out.println("Attempting to click the Contact tab to verify automation control...");


       // WebElement allow = driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button"));
       // Thread.sleep(8000);
        WebElement contactbutton =driver.findElement(By.id("com.google.android.contacts:id/floating_action_button"));
        contactbutton.click();
        Thread.sleep(4000);
        WebElement firstname =driver.findElement(By.xpath("//android.widget.EditText[@text=\"First name\"]"));
        firstname.sendKeys("test2");
        WebElement lastname= driver.findElement(By.xpath("//android.widget.EditText[@text=\"Last name\"]"));
        lastname.sendKeys("test2");
        WebElement comapny=driver.findElement(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[4]/android.widget.EditText"));
        comapny.sendKeys("testcompany");
        WebElement  phone= driver.findElement(By.xpath("//android.widget.EditText[@text=\"+1\"]"));
        phone.sendKeys("1234567890");
        Thread.sleep(3000);
        WebElement save =driver.findElement(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.widget.Button"));
        save.click();
        Thread.sleep(3000);
        WebElement back = driver.findElement(By.id("com.google.android.contacts:id/nav_back_icon"));
        back.click();
        Thread.sleep(3000);
        WebElement serach = driver.findElement(By.id("com.google.android.contacts:id/open_search_bar"));

        serach.click();
        serach.sendKeys("1234567890");

        // ⏳ Keep it open for 3 seconds so you can watch it
        Thread.sleep(3000);
        driver.quit();
    }
    }
