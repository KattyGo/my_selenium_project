package base;

import org.openqa.selenium.WebDriver;
import DriverFactory.BrowserFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class BaseTest {
    public static WebDriver driver;
    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();
    public static synchronized WebDriver getDriver() {
        return tdriver.get();
    }


    @BeforeMethod(alwaysRun = true)
    @Parameters({"browserName","brows_ver","url"})
    public void setUp(@Optional("chrome") String browserName,String brows_ver,String url){
        System.out.println("create browser: "+ browserName+" "+ brows_ver);
        BrowserFactory browserFactory = new BrowserFactory(browserName);
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
