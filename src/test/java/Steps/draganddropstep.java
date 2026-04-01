package Steps;

import Pages.viewpage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;



public class draganddropstep {

    WebDriver driver;
    viewpage viewpage;
    @Given("je suis sur la page de l application")
    public void jeSuisSurLaPageDeLApplication() {
        this.driver=Hook.driver;
        viewpage=new viewpage(driver);
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
    }

    @When("je click sur square A")
    public void jeClickSurSquareA() {
        viewpage.clickSquareA();
    }

    @And("je drag A vers B")
    public void jeDragAVersB() {
        viewpage.dragueAversB();
    }
    @Then("B et A switch de places")
    public void bEtASwitchDePlaces() {
        viewpage.verifswitchAversB();

    }
}
