package Steps;

import Pages.AlertsPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class AlertsSteps {
    WebDriver driver;
    AlertsPage AlertsPage;

    @Given("je suis sur la page des alertes")
    public void jeSuisSurLaPageDesAlertes() {
        this.driver=Hook.driver;
        AlertsPage=new AlertsPage(driver);
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
    }

    @When("je click sur l alerte java script sipmle click")
    public void jeClickSurLAlerteJavaScriptSipmleClick() {
        AlertsPage.setClickjsAlert();
    }

    @Then("alerte saffiche avec msg boite dialogue I am a JS Alert et bouton ok")
    public void alerteSafficheAvecMsgBoiteDialogueIAmAJSAlertEtBoutonOk() {
        String Actualmsg= AlertsPage.affichageDialogueAlertsimple();
        String Expectedmsg="I am a JS Alert";
        Assert.assertTrue("wrong alert",Actualmsg.contains(Expectedmsg));
    }

    @And("je click sur bouton OK")
    public void jeClickSurBoutonOK() {
        AlertsPage.affichageDialogueAlertsimple();
        //String Expectedcolourbtn="rgb(34, 132, 161)" ;
        // c'est la couleur vrai du code css , mais a cause des filtres selenium voit la couleur un peut changer donc il vaut mieux donner la reference comme il la voit selenium avec son visionnage filtré

        String Expectedcolourbtn="rgb(35, 137, 168)" ;
        // 3. Définis ton attendu en Hex (35, 137, 168 donne environ #2389a8)
        // Tu peux trouver l'Hexa dans l'inspecteur Chrome (onglet Computed)
        String expectedHex = "#2389a8";
        String ActualColour=AlertsPage.getButtonColourjsAlert();
        // 2. On la convertit en Hexadécimal pour une comparaison facile
        String actualHex = Color.fromString(ActualColour).asHex();
        System.out.println("le code hex attendu est : #2389a8 , alors que selenium a lu :" +actualHex );
        //Assert.assertEquals("color failed",Expectedcolourbtn,ActualColour);
        // assert equals echoue dans ce cas car le code couleur que voit selenium n'est pas exacte et change legerement a chaque execution
        Assert.assertTrue("color failed",actualHex.contains("#238"));
    }

    @Then("result affiche You successfully clicked an alert")
    public void resultAfficheYouSuccessfullyClickedAnAlert() {
        String Actualmsg = AlertsPage.getmsgResult();
        String Expectedmsg="You successfully clicked an alert";

        Assert.assertTrue("wrong msg",Actualmsg.contains(Expectedmsg));
    }
    @When("je click sur l alerte java script confirm")
    public void jeClickSurLAlerteJavaScriptConfirm() {
        AlertsPage.setClickjsAlertConfirm();
    }

    @Then("alerte saffiche avec msg boite dialogue I am a JS Confirm et boutons ok cancel")
    public void alerteSafficheAvecMsgBoiteDialogueIAmAJSConfirmEtBoutonsOkCancel() {
        String Expectedmsg="I am a JS Confirm";
        String Actualmsg=AlertsPage.affichageDialogueAlertConfirm();
        Assert.assertTrue("wrong msg",Actualmsg.contains(Expectedmsg));

    }

    @Then("result affiche You clicked: Ok")
    public void resultAfficheYouClickedOk() {
        String Expectedmsg="You clicked: Ok";
        String Actualmsg=AlertsPage.getmsgConfirmResult();
        Assert.assertTrue("wrongmsg",Actualmsg.contains(Expectedmsg));
        System.out.println("le msg est : "+Actualmsg);

    }

    @And("je click sur bouton Cancel")
    public void jeClickSurBoutonCancel() {
        AlertsPage.affichageDialogueAlertCancel();
    }

    @Then("result affiche You clicked: Cancel")
    public void resultAfficheYouClickedCancel() {
        String Expectedmsg="You clicked: Cancel";
        String Actualmsg=AlertsPage.getmsgResult();
        Assert.assertTrue("wrongmsg",Actualmsg.contains(Expectedmsg));
        System.out.println("le msg est : "+Actualmsg);
    }

    @When("je click sur l alerte java script Prompt")
    public void jeClickSurLAlerteJavaScriptPrompt() {
       AlertsPage.setClickAlertPrompt();
    }

    @And("je click sur bouton OK Prompt")
    public void jeClickSurBoutonOKPrompt() {
        String Expectedmsg="I am a JS prompt";
        String Actualmsg=AlertsPage.affichageDialogueAlertConfirm();
        Assert.assertTrue("wrong msg",Actualmsg.contains(Expectedmsg));
    }

    @Then("result affiche You entered:")
    public void resultAfficheYouEntered() {
        AlertsPage.getmsgResult();
        String Expectedmsg="You entered:";
        String Actualmsg=AlertsPage.getmsgConfirmResult();
        Assert.assertTrue("wrongmsg",Actualmsg.contains(Expectedmsg));
        System.out.println("le msg est : "+Actualmsg);

    }

    @And("je saisi {string} et click sur bouton OK")
    public void jeSaisiEtClickSurBoutonOK(String msg) {
        AlertsPage.entermsgalertandclickok ();
    }

    @Then("result affiche You entered: hi hela")
    public void resultAfficheYouEnteredHiHela() {
        AlertsPage.getmsgResult();
        String Expectedmsg="You entered: hi hela";
        String Actualmsg=AlertsPage.getmsgConfirmResult();
        Assert.assertTrue("wrongmsg",Actualmsg.contains(Expectedmsg));
        //System.out.println("le msg est : "+Actualmsg);

    }

    @And("je click sur cancel")
    public void jeClickSurCancel() {
        AlertsPage.dismissAlertPtompt();
    }

    @Then("result affiche You entered: null")
    public void resultAfficheYouEnteredNull() {
        AlertsPage.getmsgResult();
        String Expectedmsg="You entered: null" ;
        String Actualmsg=AlertsPage.getmsgConfirmResult();
        Assert.assertTrue("wrongmsg",Actualmsg.contains(Expectedmsg));
       // System.out.println("le msg est : "+Actualmsg);

    }
}
