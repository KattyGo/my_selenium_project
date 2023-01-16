package base;

import org.openqa.selenium.WebDriver;
import DriverFactory.BrowserFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.Logger;


public class BaseTest {
    public static Logger log;
    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();
    public static synchronized WebDriver getDriver() {
        return tdriver.get();
    }


    @BeforeMethod(alwaysRun = true)
    @Parameters({"browserName","url"})
    public void setUp(@Optional("chrome") String browserName,String url){
        System.out.println("create browser: "+ browserName);
        BrowserFactory browserFactory = new BrowserFactory(browserName,log);
        tdriver.set(browserFactory.createDriver());
        getDriver().get(url);

    }


    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        try {
            System.out.println("close driver");
            getDriver().quit();
        } catch (Exception e){
            System.out.println("Error close driver");
        }
        }



}
