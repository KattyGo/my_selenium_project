import base.BaseTest;
import org.testng.annotations.Test;
import pages.logonPage.LoginPage;
import pages.mainPage.DashboardPage;

public class LoginTest extends BaseTest {


    @Test(testName = "login",description = "просто так")
    public void login_test() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());  //instace login page
        DashboardPage dashboardPage = new DashboardPage(getDriver()); //instace DashboardPage page
        loginPage.type_userName("Shoval.Ziman@comm-it.com");
        loginPage.type_password("123456");
        System.out.println(loginPage.get_logo_text());
        loginPage.click_loginButton();
        System.out.println( dashboardPage.is_displayTab());
        dashboardPage.scroll_sample();
        Thread.sleep(5000);


    }
}
