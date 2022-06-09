package DriverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {



    protected String browserName;
    public static WebDriver driver;

    public  BrowserFactory(String browserName){
        this.browserName =browserName;

    }

    public WebDriver  createDriver(){

        switch (browserName) {

            case "chrome":
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            break;


            case "firefox":
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
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
