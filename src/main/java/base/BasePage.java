package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    WebDriverWait wait;
    Actions action;
    WebDriver driver;
    JavascriptExecutor jsExecutor;


    public BasePage(WebDriver driver ) {
        this.driver = BaseTest.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,1),this);
        wait = new WebDriverWait(driver,10);
        action= new Actions(driver);
        jsExecutor = (JavascriptExecutor) driver;
    }

    protected void js_click(WebElement element){
        if (element==null) {
            System.out.println("element is Null");
        }
        for (int i=0; i < 2; i++){ // 2 tries to make click
            try {
                wait.until(ExpectedConditions.elementToBeClickable(element));
                jsExecutor.executeScript("arguments[0].click();", element);
                sleep(200);

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
                sleep(200);

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
                sleep(200);

            }catch (Exception e){
                System.out.println("click FAILED" +e.getMessage());
            }
            System.out.println("Click RETRY "+ i+" ---------------------");
        }
    }

    protected void  type(WebElement element,String text) {
        if (element == null) {
            System.out.println("element is Null");
        }
            try {
                wait.until(ExpectedConditions.visibilityOf(element));
                element.clear();
                element.sendKeys(text);
               sleep(200);
            } catch (Exception e) {
                System.out.println("click FAILED" + e.getMessage());

        }
    }

    protected String getText(WebElement element)  {
        if (element == null) {
            System.out.println("element is Null");
        }
        String text= null;
        int count = 0;
        boolean succesed = false;
        while (count < 2 && !succesed)
            try {
                text=element.getText();
                succesed= true;
            } catch (StaleElementReferenceException e) {
                e.toString();
                System.out.println("Trying to recover from a stale element :" + e.getMessage());
                sleep(200);
                count = count + 1;
            }
        return text;
    }

  //*** sleep for 'x' millis  ***//
    protected void sleep(long millis) {
        try {
            Thread.sleep(millis);
        }  catch (InterruptedException e) {
            System.out.println("sleep: FAILED {}" + e.getMessage());
            Thread.currentThread().interrupt(); /* this line will keep Thread.interrupted() returns true */
            throw new IllegalStateException ("Invalid sleep!");
        }
    }

    /** Perform scroll to the elemnet */
    protected void scrollToElement(WebElement element){
        System.out.println("Scrolling to the element ");
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);

    }

    /** Perform scroll to the end page */
    protected void scrollEndPage(){
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }


}
