package com.google.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Driver {

    /**
     * InheritableThreadLocal class used to
     * manage the WebDriver instance across different threads,
     * such as in multi-threaded test execution or parallel test execution (Selenium Grid)
     */

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    /*
   We make the WebDriver private, because we want to close access from outside the class.
   We are making it static, because we will use it in a static method.
    */
    private static WebDriver driver; // default value = null

    /*
   Create a re-usable utility method which will return the same driver instance once we call it.
   - If an instance doesn't exist, it will create first, and then it will always return same instance.
    */
    public static WebDriver getDriver(){

        if(driverPool.get() == null){
            // read browser from conf.read. utility class
            String browserType = ConfigurationReader.getProperty("browser");


            /*
            Depending on the browserType returned from the configuration.properties
            switch statement will determine the "case", and open the matching browser.
             */
            switch (browserType){
                case "chrome":
                     WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                     WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }

        }
        return driverPool.get();
    }


    public static void closeDriver(){
        if(driverPool.get() != null){
            driverPool.get().quit(); // kill the driver - driver will not exist anymore
            driverPool.remove(); // assign null back so "singleton" design can create new one if needed

        }
    }


}
