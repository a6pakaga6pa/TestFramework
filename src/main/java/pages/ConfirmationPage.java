package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {

    private WebDriver driver;
    private By confirmationText = By.id("content");

    public ConfirmationPage(WebDriver driver){
        this.driver = driver;
    }

    public String getConfirmationText(){
        return driver.findElement(confirmationText).getText();
    }
}
