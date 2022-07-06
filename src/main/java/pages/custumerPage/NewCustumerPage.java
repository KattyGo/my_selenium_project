package pages.custumerPage;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NewCustumerPage extends BasePage {

    public NewCustumerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[formcontrolname='customerStatus'][value='newCustomer']")
    private WebElement new_Customer;
    @FindBy(css = "[placeholder='dd/mm/yyyy']")
    private WebElement date;
    @FindBy(css = ".datepicker-header .datepick-container")
    private WebElement c_date;


    public NewCustumerPage click_new_Customer(){
        System.out.println("click new customer ");
        click(new_Customer);
        return this;
    }
    public NewCustumerPage type_today_date(){
        click(c_date);
        String timeStamp = new SimpleDateFormat("ddMMyyyy").format(Calendar.getInstance().getTime());
        System.out.println("type_date: "+ timeStamp);
        type(date,timeStamp);
        return this;
    }
   public NewCustumerPage type_today_date(String f_date){
        click(c_date);
        System.out.println("type_date: "+ f_date);
        type(date,f_date);
        return this;
    }


}
