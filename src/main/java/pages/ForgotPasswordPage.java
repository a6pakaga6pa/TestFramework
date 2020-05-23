package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private WebDriver driver;

    private String myEmail = "someemail@asd.com";
    private By emailField = By.id("email");
    private By retrieveButton = By.id("form_submit");

    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterEmail(){
        driver.findElement(emailField).sendKeys(myEmail);
    }

    public ConfirmationPage pressRetrieveButton(){
        driver.findElement(retrieveButton).click();
        return new ConfirmationPage(driver);
    }
}
