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

    public boolean is_displayTab(){
        return next_tab.isDisplayed();
    }
}
