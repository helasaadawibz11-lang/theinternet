package Steps;

import Pages.loginpage;
import Pages.viewpage;
import io.cucumber.java.PendingException;
import net.bytebuddy.asm.Advice;
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
    loginpage loginpage ;

    @Given("je suis sur la page de login")
    public void jeSuisSurLaPageDeLogin() {
        this.driver=Hook.driver;
        loginpage=new loginpage(driver);
        driver.get("https://the-internet.herokuapp.com/login");
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));

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
        loginpage.veriflogin();
    }
    //login invalide
    @When("je saisi user {string}")
    public void jeSaisiUser(String user) {
        loginpage.saisiruser(user);
    }

    @And("je saisi pass {string}")
    public void jeSaisiPass(String pass) {
        loginpage.saisirpassword(pass);
    }

    @Then("loginfailed et msg erreur saffiche {string}")
    public void loginfailedEtMsgErreurSaffiche(String msgExpected) {
        String Actualmsg=loginpage.getmsgerreur();
        Assert.assertTrue("msgincorrect",Actualmsg.contains(msgExpected));
    }
}
