package Steps;

import Pages.DragDropPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class Draganddropstep {

    WebDriver driver;
    DragDropPage dragdrop;

    @Given("je suis sur la page de l application")
    public void jeSuisSurLaPageDeLApplication() {
        this.driver = Hook.driver;
        dragdrop = new DragDropPage(driver);
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
    }

    @When("je click sur square A")
    public void jeClickSurSquareA() {
        dragdrop.clickSquareA();
    }

    @And("je drag A vers B")
    public void jeDragAVersB() {
        dragdrop.dragueAversB();
    }

    @Then("B et A switch de places")
    public void bEtASwitchDePlaces() {

        String titlesquareA = dragdrop.getTitleA();
        Assert.assertEquals("switchfailed", "B", titlesquareA);
        System.out.println("squareA contient" + titlesquareA);

    }

    @When("je drag le carre B vers le carre A")
    public void jeDragLeCarreBVersLeCarreA() {
        dragdrop.dragueBversA();

    }

    @Then("le carre A doit afficher le texte {string}")
    public void leCarreADoitAfficherLeTexte(String title) {
        String titlesquareA = dragdrop.getTitleA();
        Assert.assertEquals("drag failed", title, titlesquareA);
        System.out.println("squareA contient" + titlesquareA);

    }

    @And("le carre B doit afficher le texte {string}")
    public void leCarreBDoitAfficherLeTexte(String title) {
        String titlesquareB = dragdrop.getTitleB();
        Assert.assertEquals("drag failed ", title, titlesquareB);
        System.out.println("squareB contient" + titlesquareB);


    }

    @When("je drag le carre A et je le lâche dans le vide")
    public void jeDragLeCarreAEtJeLeLâcheDansLeVide() {
        dragdrop.dragAInTheVoid();

    }

    @When("je drag le carre A et je le lâche sur le carre A")
    public void jeDragLeCarreAEtJeLeLâcheSurLeCarreA() {
        dragdrop.dragueAversA();

    }

}
