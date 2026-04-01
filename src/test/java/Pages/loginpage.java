package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginpage {

    WebDriver driver;
    WebDriverWait wait;
    By userinput=By.id("username");
    By passwordinput =By.id("password");
    By loginbtn=By.xpath("//*[@id=\"login\"]/button");
    By successloginmsg=By.xpath("//*[@id=\"flash\"]");
    //By msgerreurlogin=By.xpath("//*[@id=\"flash\"]");
    By msgerreurlogin = By.cssSelector("#flash");


    public loginpage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    public void enterusername(String user){
        driver.findElement(userinput).sendKeys(user);
    }
    public void enterpassword(String pass){
        driver.findElement(passwordinput).sendKeys(pass);
    }
    public void clicklogin(){
        driver.findElement(loginbtn).click();
    }
    public void veriflogin(){

        Assert.assertEquals("loginfailed","https://the-internet.herokuapp.com/secure",driver.getCurrentUrl());
        System.out.println("msg:" + driver.findElement(successloginmsg).getText());

    }
    public void saisiruser(String user){
        driver.findElement(userinput).sendKeys(user);
    }
    public void saisirpassword(String pass){
        driver.findElement(passwordinput).sendKeys(pass);
    }


    // public String getmsgerreur(){
      //  return wait.until(ExpectedConditions.visibilityOfElementLocated(msgerreurlogin)).getText();


    //}

    // 2 eme essai a cause d'un retard de recuperation du msg on a changé la methode getmsgerreur
    /*

    public String getmsgerreur(){
        try {
            WebElement msg = wait.until(ExpectedConditions.presenceOfElementLocated(msgerreurlogin));
            System.out.println("DEBUG - Texte trouvé : [" + msg.getText() + "]");
            return msg.getText();
        } catch (Exception e) {
            System.out.println("L'élément flash n'est pas apparu à temps !");
            throw e;
        }
    }*/

    // 3eme essai de la fonction getmsgerreur qui semble plus robuste avec le site TheInternet

    public String getmsgerreur() {
        // 1. On attend que l'élément soit présent dans le DOM
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(msgerreurlogin));

        // 2. On attend spécifiquement que l'élément contienne du texte
        // Cette condition vérifie que le texte n'est pas vide ("")
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(msgerreurlogin, "")));

        String textecomplet = element.getText();
        System.out.println("DEBUG - Texte capturé : [" + textecomplet + "]");

        return textecomplet;
    }
}
