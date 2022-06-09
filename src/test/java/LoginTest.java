import org.testng.annotations.Test;
import base.BaseTest;
import pages.mainPage.DashboardPage;
import pages.logonPage.LoginPage;

public class LoginTest extends BaseTest {


    @Test(testName = "login",description = "просто так")
    public void login_test() {
        LoginPage loginPage = new LoginPage(getDriver());  //instace login page
        DashboardPage dashboardPage = new DashboardPage(getDriver()); //instace DashboardPage page
        loginPage.type_userName("Shoval.Ziman@comm-it.com");
        loginPage.type_password("123456");
        System.out.println(loginPage.get_logo_text());
        loginPage.click_loginButton();
        dashboardPage.is_displayTab();


    }
}
