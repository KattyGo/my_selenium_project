package pages.mainPage;

import base.BasePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.custumerPage.NewCustumerPage;

public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".main-menu-btn-label")
    private WebElement next_tab;
    @FindBy(xpath = "//span[contains(text(),'Beresheet hotel')]")
    private WebElement scroll_sample;
    @FindBy(css = "[type='add_white'] .icon.add_white.pointer")
    private WebElement plus_bt;
    @FindBy(css = ".icon.contract_full_service")
    private WebElement full_service_icon;




    public NewCustumerPage click_plus_bt(){
        wait.until(ExpectedConditions.visibilityOf(full_service_icon));
        System.out.println("click plus button");
        click(plus_bt);
        return new NewCustumerPage(driver);
    }





    public WebElement getScroll_sample() {
        return scroll_sample;
    }

    public String is_displayTab()  {
        return getText(next_tab);
    }

    public void scroll_sample(){
        scrollToElement(scroll_sample);
    }



}
