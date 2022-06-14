package pages.mainPage;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".main-menu-btn-label")
    private WebElement next_tab;
    @FindBy(xpath = "//span[contains(text(),'Beresheet hotel')]")
    private WebElement scroll_sample;

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
