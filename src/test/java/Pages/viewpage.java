package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class viewpage {

    WebDriver driver ;
    WebDriverWait wait;
    By squareA=By.id("column-a");
    By squareB=By.id("column-b");


    public viewpage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    public void clickSquareA(){
        driver.findElement(squareA).click();
    }
    public void dragueAversB(){

        WebElement elementA = driver.findElement(squareA);
        WebElement elementB = driver.findElement(squareB);
        // 2. Créer l'instance Actions
        Actions builder = new Actions(driver);

        // 3. Exécuter l'action
        builder.dragAndDrop(elementA,elementB).perform();

        //3.2 sinon esseyer etape par etape
        //builder.clickAndHold(elementA).moveToElement(elementB).release(elementB).build().perform();
    }
    public String verifswitchAversB(){
        String titlesquareA= driver.findElement(squareA).getText();
        Assert.assertEquals("switchfailed","B",titlesquareA);
        System.out.println("squareA contient" +titlesquareA);
        return titlesquareA ;
    }

}
