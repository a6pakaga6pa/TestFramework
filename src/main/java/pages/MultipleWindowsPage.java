package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WindowManager;

public class MultipleWindowsPage {

    private WebDriver driver;
    private By clickHereLink = By.linkText("Click Here");

    public MultipleWindowsPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickHere(){
        driver.findElement(clickHereLink).click();
    }

    public void waitForNewWindow(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        var windows = driver.getWindowHandles();
        while(true) {
            if(windows.size() == 2) break;
        }
    }
}
