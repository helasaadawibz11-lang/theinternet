package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsPage {

    WebDriver driver;
    WebDriverWait wait;

    By ClickjsAlert=By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button");
    By ClickjsAlertConfirm=By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button");
    By ClickjsAlertPrompt=By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button");
    By Result=By.xpath("//*[@id=\"result\"]");

    public AlertsPage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void setClickjsAlert(){
        driver.findElement(ClickjsAlert).click();
    }
    public String affichageDialogueAlertsimple(){

        wait.until(ExpectedConditions.alertIsPresent());
        // 1. Basculer le focus de Selenium sur l'alerte
        Alert alert=driver.switchTo().alert();
        // 2. Récupérer le texte (pour ton assertion)
        String TextAlert= alert.getText();
        // 3. Cliquer sur le bouton OK
        alert.accept();
        return TextAlert;
    }
    public String getmsgResult(){
        String msgResult=driver.findElement(Result).getText();
        System.out.println("msg est"+msgResult);
        return msgResult;

    }
    public void setClickjsAlertConfirm(){
        driver.findElement(ClickjsAlertConfirm).click();
    }
    public String affichageDialogueAlertConfirm(){

        wait.until(ExpectedConditions.alertIsPresent());
        // 1. Basculer le focus de Selenium sur l'alerte
        Alert alert=driver.switchTo().alert();
        // 2. Récupérer le texte (pour ton assertion)
        String TextAlert= alert.getText();
        // 3. Cliquer sur le bouton OK
        alert.accept();
        System.out.println("le msg de la boite dialogue est "+TextAlert );
        return TextAlert;
    }
    public String getmsgConfirmResult(){
        String msgConfirmResult=driver.findElement(Result).getText();
        System.out.println("msg est"+msgConfirmResult);
        return msgConfirmResult;
    }

    public String affichageDialogueAlertCancel(){

        wait.until(ExpectedConditions.alertIsPresent());
        // 1. Basculer le focus de Selenium sur l'alerte
        Alert alert=driver.switchTo().alert();
        // 2. Récupérer le texte (pour ton assertion)
        String TextAlert= alert.getText();
        // 3. Cliquer sur le bouton OK
        alert.dismiss();
        System.out.println("le msg de la boite dialogue est "+TextAlert );
        return TextAlert;
    }

    public String getButtonColourjsAlert (){

        //verifier le changement de couleur du bouton au passage souris sur le bouton

        WebElement ColourBtnjsAlert =driver.findElement(ClickjsAlert);
        Actions action = new Actions(driver);
        action.moveToElement(ColourBtnjsAlert).perform(); // On survole le souris sur le bouton
        String buttonColourjsAlert = ColourBtnjsAlert.getCssValue("background-color");
        //System.out.println("la couleur desiré rgb(35, 137, 168) , la couleur identifiée est :" +buttonColourjsAlert);
        return buttonColourjsAlert ;
    }

    public void setClickAlertPrompt() {
        driver.findElement(ClickjsAlertPrompt).click();
    }

    public String entermsgalertandclickok(){

        wait.until(ExpectedConditions.alertIsPresent());
        // 1. Basculer le focus de Selenium sur l'alerte
        Alert alert=driver.switchTo().alert();
        // 2. Récupérer le texte (pour ton assertion)
        String TextAlert= alert.getText();
        alert.sendKeys("hi hela");
        // 3. Cliquer sur le bouton OK
        alert.accept();
        System.out.println("le msg de la boite dialogue est "+TextAlert );
        return TextAlert;
    }

    public String dismissAlertPtompt(){

        wait.until(ExpectedConditions.alertIsPresent());
        // 1. Basculer le focus de Selenium sur l'alerte
        Alert alert=driver.switchTo().alert();
        // 2. Récupérer le texte (pour ton assertion)
        String TextAlert= alert.getText();
        // 3. Cliquer sur le bouton OK
        alert.dismiss();
        System.out.println("le msg de la boite dialogue est "+TextAlert );
        return TextAlert;
    }
}
