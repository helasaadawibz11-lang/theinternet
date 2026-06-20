package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DragDropPage {

    WebDriver driver;
    WebDriverWait wait;
    @FindBy(id = "column-a")
    WebElement squareA;
    @FindBy(id = "column-b")
    WebElement squareB;


    public DragDropPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void clickSquareA() {
        squareA.click();
    }

    public void dragueAversB() {

        // . Créer l'instance Actions
        Actions builder = new Actions(driver);

        // . Exécuter l'action
        builder.dragAndDrop(squareA, squareB).perform();

        // sinon esseyer etape par etape
        //builder.clickAndHold(squareA).moveToElement(squareB).release(squareB).build().perform();
    }
    public  void dragueBversA(){
        // . Créer l'instance Actions
        Actions builder = new Actions(driver);

        // . Exécuter l'action
        builder.dragAndDrop( squareB, squareA).perform();
    }

    public String getTitleA(){
        String titlesquareA = squareA.getText();
        return titlesquareA;

    }
    public String getTitleB(){
        String titlesquareB = squareB.getText();
        return titlesquareB;

    }
    public void dragAInTheVoid() {
        // Créer l'instance Actions
        Actions builder = new Actions(driver);

        // Déplace le carré A de 0 pixel horizontalement et 300 pixels vers le bas (dans le vide), puis le lâche

        builder.dragAndDropBy(squareA, 0, 300).perform();
    }
    public  void dragueAversA(){
        // . Créer l'instance Actions
        Actions builder = new Actions(driver);

        // . Exécuter l'action
        builder.dragAndDrop( squareA, squareA).perform();
    }

}
