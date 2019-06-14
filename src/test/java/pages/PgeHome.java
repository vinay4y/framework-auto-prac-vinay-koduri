package pages;

import common.BrowserDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PgeHome {
    WebDriver objPgeHomeDriver = BrowserDriver.getCurrentDriver();


    public PgeHome(WebDriver objPgeHomeDriver){
        this.objPgeHomeDriver = objPgeHomeDriver;
        //This initElements method will create all WebElements
        PageFactory.initElements(objPgeHomeDriver, this);
    }

    @FindBy(xpath="//a[@class='login']")
    public WebElement Signin;


}
