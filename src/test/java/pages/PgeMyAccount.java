package pages;

import common.BrowserDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PgeMyAccount {
    WebDriver objPgeMyAccount = BrowserDriver.getCurrentDriver();

    //Constructor
    public PgeMyAccount(WebDriver objPgeMyAccount){
        this.objPgeMyAccount = objPgeMyAccount;
        //This initElements method will create all WebElements
        PageFactory.initElements(objPgeMyAccount, this);
    }

    @FindBy(xpath="//p[@class='info-account']")
    public WebElement p_info_account;
}
