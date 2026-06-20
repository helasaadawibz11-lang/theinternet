package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Loginpage {

    WebDriver driver;
    WebDriverWait wait;

    //locators
    @FindBy(id ="username" )
    WebElement userinput ;
    @FindBy(id = "password")
    WebElement passwordinput ;
    @FindBy(xpath = "//*[@id=\"login\"]/button")
    WebElement loginbtn ;
    @FindBy(xpath ="//*[@id=\"flash\"]" )
    WebElement successloginmsg ;
    @FindBy(css ="#flash" )
    WebElement msgerreurlogin ;

    //constructeur
    public Loginpage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));

    }
    public void enterusername(String user){
        userinput.sendKeys(user);
    }
    public void enterpassword(String pass){
        passwordinput.sendKeys(pass);
    }
    public void clicklogin(){
        loginbtn.click();
    }

    public void successfullogin(){
        System.out.println("msg:" + successloginmsg.getText());
    }

    public String getmsgerreur() {
        // 1. On attend que l'élément soit présent dans le DOM
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#flash")));

        // 2. On attend spécifiquement que l'élément contienne du texte
        // Cette condition vérifie que le texte n'est pas vide ("")
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(By.cssSelector("#flash"), "")));

        String textecomplet = msgerreurlogin.getText();
        System.out.println("DEBUG - Texte capturé : [" + textecomplet + "]");
        return textecomplet;
    }
}
