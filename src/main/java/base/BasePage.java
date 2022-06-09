package base;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends BaseTest {

    WebDriverWait wait;

    public BasePage(WebDriver driver ) {
        this.driver = BaseTest.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,1),this);
        wait = new WebDriverWait(driver,10);
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
