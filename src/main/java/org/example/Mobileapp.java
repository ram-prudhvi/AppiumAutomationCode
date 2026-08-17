package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Mobileapp {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://127.0.0.1:4723/");

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("Pixel 6");
        options.setUdid("emulator-5554");
        AndroidDriver driver = new AndroidDriver(url, options);
        File app = new File("/Users/ramprudhvi/IdeaProjects/AppiumAutomationFresh/src/main/resources/ApiDemos.apk");
        driver.installApp(app.getAbsolutePath());

    }
}
