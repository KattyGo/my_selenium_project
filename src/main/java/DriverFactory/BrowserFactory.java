package DriverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {



    protected String browserName;
    public static WebDriver driver;

    public  BrowserFactory(String browserName){
        this.browserName =browserName;

    }

    public WebDriver  createDriver(){

        ChromeOptions chromeOptions=new ChromeOptions();
        FirefoxOptions firefoxOptions=new FirefoxOptions();

        switch (browserName) {

            case "chrome":
            WebDriverManager.chromedriver().setup();
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("--disable-notifications");
            driver=new ChromeDriver(chromeOptions);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            break;


            case "firefox":
            WebDriverManager.firefoxdriver().setup();
            firefoxOptions.addPreference ("dom.webnotifications.enabled", false);
            driver=new FirefoxDriver(firefoxOptions);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            break;

            case "edge":
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            break;
            default:
                //Do something

        }
       return driver;
    }



}
