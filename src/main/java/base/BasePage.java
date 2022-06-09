package base;

import base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends BaseTest {

    WebDriverWait wait;
    Actions action;

    public BasePage(WebDriver driver ) {
        this.driver = BaseTest.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,1),this);
        wait = new WebDriverWait(driver,10);
        action= new Actions(driver);
    }

    protected void js_click(WebElement element){
        if (element==null) {
            System.out.println("element is Null");
        }
        for (int i=0; i < 2; i++){ // 2 tries to make click
            try {
                wait.until(ExpectedConditions.elementToBeClickable(element));
                JavascriptExecutor executor = (JavascriptExecutor)driver;
                executor.executeScript("arguments[0].click();", element);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }catch (Exception e){
                System.out.println("js_click FAILED" +e.getMessage());
            }
            System.out.println("js_Click RETRY "+ i+" ---------------------");
        }

    }


    protected  void a_click(WebElement element){
        System.out.println("click to element : "+ element);
        if (element==null) {
            System.out.println("element is Null");
        }
        for (int i=0; i < 2; i++){ // 2 tries to make click
            try {
                action.moveToElement(element).click().perform();
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }catch (Exception e){
                System.out.println("Actions click FAILED" +e.getMessage());
            }
            System.out.println("Actions Click RETRY "+ i+" ---------------------");
        }
    }

    protected void click(WebElement element){
        System.out.println("click to element : "+ element);
        if (element==null) {
            System.out.println("element is Null");
        }
        for (int i=0; i < 2; i++){ // 2 tries to make click
            try {
                wait.until(ExpectedConditions.visibilityOf(element));
                element.click();
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }catch (Exception e){
                System.out.println("click FAILED" +e.getMessage());
            }
            System.out.println("Click RETRY "+ i+" ---------------------");

        }

    }

}
