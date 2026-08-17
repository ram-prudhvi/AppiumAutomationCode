import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.script.Target;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;
import java.net.URL;

public class draganddrop {
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
        WebElement view = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"));
        if (view.isDisplayed()) {
            System.out.println("View is Displayed");
            view.click();
            System.out.println("View is Clicked Successfully");
        } else {
            System.out.println("View is Displayed but unable to click");
        }

        WebElement dragdropbutton =driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]"));
        dragdropbutton.click();
        WebElement source =driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
        WebElement destination = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_2"));
        driver.executeScript("mobile: dragGesture", ImmutableMap.of
                ("elementId",((RemoteWebElement)source).getId(),
                        "endX", destination.getLocation().getX()+(destination.getSize().getWidth()/2),
                        "endY", destination.getLocation().getY()+(destination.getSize().getHeight()/2)));

        System.out.println("dragaanddrop is Excuted Succesfully");



    }
}
