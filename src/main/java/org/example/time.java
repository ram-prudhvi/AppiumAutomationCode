package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;

public class time {
    public static void main(String[] args) throws MalformedURLException {
        URL url =new URL("http://127.0.0.1:4723/");

        UiAutomator2Options options =new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("Pixel 6");
        options.setUdid("emulator-5554");

        AndroidDriver driver = new AndroidDriver(url, options);

        String time = driver.getDeviceTime();
        System.out.println("get the system time and date "+time);

        long density = driver.getDisplayDensity();
        System.out.println("Density Means Pixels of the Screen it gives Display and Images More Sharper  "+density);


    }
}
