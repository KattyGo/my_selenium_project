package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage extends BaseTest{


   public Logger log = LogManager.getRootLogger() ;
    public WebDriverWait wait;
    Actions action;
   public WebDriver driver;
    JavascriptExecutor jsExecutor;


    public BasePage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),this);
        wait = new WebDriverWait(driver,10);
        action= new Actions(driver);
        jsExecutor = (JavascriptExecutor) driver;

    }

    protected void js_click(WebElement element){
        if (element==null) {
           log.info("element is Null");

        }
        for (int i=0; i < 2; i++){ // 2 tries to make click
            try {
                wait.until(ExpectedConditions.elementToBeClickable(element));
                jsExecutor.executeScript("arguments[0].click();", element);
                sleep(200);

            }catch (Exception e){
                log.warn("js_click FAILED" +e.getMessage());
            }
           log.error("js_Click RETRY "+ i+" ---------------------");
        }

    }


    /* ***click  by navigate with mouse  */
    protected  boolean a_click(WebElement element){
        log.info("click to element : "+ element);
        if (element==null) {
            log.info("element is Null");
        }
        for (int i=0; i < 2; i++){ // 2 tries to make click
            try {
                action.moveToElement(element).click().perform();
                sleep(200);

            }catch (Exception e){
                log.error("Actions click FAILED" +e.getMessage());
            }
            log.info("Actions Click RETRY "+ i+" ---------------------");
        }
        return false;
    }

    /* ***click  regular func and reclick twice   */
    protected boolean click(WebElement element){
        log.info("click to element : "+ element);
        if (element==null) {
            log.info("element is Null");
        }
        for (int i=0; i < 2; i++){ // 2 tries to make click
            try {
                wait.until(ExpectedConditions.visibilityOf(element));
                element.click();
                sleep(200);

            }catch (Exception e){
                log.warn("click FAILED" +e.getMessage());
            }
            log.error("Click RETRY "+ i+" ---------------------");
        }
        return false;
    }

    protected boolean type(WebElement el, String text) {
        if (el == null)
            return false;
        try {
            el.sendKeys(text);
            sleep(1000);
            return true;
        } catch (Exception e) {
            log.error("type(): FAILED\n" + e.getMessage());
        }
        return false;
    }

    protected String getText(WebElement element)  {
        if (element == null) {
            log.info("element is Null");
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
                log.info("Trying to recover from a stale element :" + e.getMessage());
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
          log.error("sleep: FAILED {}" + e.getMessage());
          Thread.currentThread().interrupt(); /* this line will keep Thread.interrupted() returns true */
          throw new IllegalStateException ("Invalid sleep!");
      }
  }

    /** Perform scroll to the elemnet */
    protected void scrollToElement(WebElement element){
        log.info("Scrolling to the element ");
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);

    }

    /** Perform scroll to the end page */
    protected void scrollEndPage(){
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }


}
