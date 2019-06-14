package step_definitions;

import common.BrowserDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.PgeAuthentication;
import pages.PgeHome;
import pages.PgeMyAccount;

public class RegistrationStepDef {
    WebDriver objDriver = BrowserDriver.getCurrentDriver();

    PgeHome objHome = new PgeHome(objDriver);
    PgeAuthentication objAuthentication = new PgeAuthentication(objDriver);
    PgeMyAccount objMyAccount = new PgeMyAccount(objDriver);

    @Given("Automation practice page is opened")
    public void automationPracticePageIsOpened() {
        BrowserDriver.loadPage("http://automationpractice.com");
    }

    @When("I click on Sign in link")
    public void iClickOnSignInLink()  throws Throwable  {
        objHome.Signin.click();
    }

    @And("I provide with email address {string}")
    public void iProvideWithEmailAddress(String emailAddress) {
        objAuthentication.txtbox_emailAddress.sendKeys(emailAddress);
    }

    @Then("I click on {string} button")
    public void iOnButton(String arg0) {
        objAuthentication.button_createAnAccount.click();
    }

    @And("provide all the required information of {string}")
    public void provideAllTheRequiredInformationOf(String email) {
        objAuthentication.provideAlltheMandatoryInfo(email);
    }

    @And("I click on Register button")
    public void iClickOnRegisterButton() {
        objAuthentication.button_Register.click();
    }


    @Then("user should see the following error message {string}")
    public void userShouldSeeTheFollowingErrorMessage(String errMsg) {
        String invalidEmailErrMsg = objAuthentication.txt_invalidEmailAddress.getText();
        Assert.assertEquals(invalidEmailErrMsg,errMsg.toString());
    }

    @Then("I should be able to register successfully and receive the following message {string}")
    public void iShouldBeAbleToRegisterSuccessfullyAndReceiveTheFollowingMessage(String accountInfoMsg) {
        String accountInfo= objMyAccount.p_info_account.getText();
        Assert.assertEquals(accountInfo,accountInfoMsg.toString());
        System.out.println(accountInfo);

    }
}
