package Steps;

import Pages.Loginpage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

public class loginsteps {

    WebDriver driver;
    WebDriverWait wait;
    Loginpage loginpage ;

    @Given("je suis sur la page de login")
    public void jeSuisSurLaPageDeLogin() {
        this.driver = Hook.driver;
        loginpage = new Loginpage(driver);
        driver.get("https://the-internet.herokuapp.com/login");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    @When("je saisi username {string}")
    public void jeSaisiUsername(String user) {
        loginpage.enterusername(user);
    }

    @And("je saisi password {string}")
    public void jeSaisiPassword(String pass) {
        loginpage.enterpassword(pass);
    }

    @And("je click sur login button")
    public void jeClickSurLoginButton() {
        loginpage.clicklogin();
    }

    @Then("redirection vers successful login page")
    public void redirectionVersSuccessfulLoginPage() {
        wait.until(ExpectedConditions.urlToBe("https://the-internet.herokuapp.com/secure"));
        Assert.assertEquals("Redirection échouée", "https://the-internet.herokuapp.com/secure", driver.getCurrentUrl());
        loginpage.successfullogin();
    }

    @Then("loginfailed et msg erreur saffiche {string}")
    public void loginfailedEtMsgErreurSaffiche(String msgExpected) {
        String Actualmsg = loginpage.getmsgerreur();
        Assert.assertTrue("msgincorrect", Actualmsg.contains(msgExpected));
    }
}
