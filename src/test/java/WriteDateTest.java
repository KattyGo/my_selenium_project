import base.BaseTest;
import org.testng.annotations.Test;
import pages.logonPage.LoginPage;

public class WriteDateTest extends BaseTest {


    @Test(testName = "write date",description = "написать дату")
    public void login_test()  {
        LoginPage loginPage = new LoginPage(getDriver());  //instace login page
        loginPage.type_userName("Shoval.Ziman@comm-it.com")
                 .type_password("123456")
                    .click_loginButton()
                        .click_plus_bt()
                            .click_new_Customer()
                .type_today_date("20092023");






    }
}

