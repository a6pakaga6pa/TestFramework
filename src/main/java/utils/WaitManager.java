package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitManager {

    private WebDriver driver;
    private int timeout = 10;

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }



    public WaitManager(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForNumberOfWindowsToEqual(int numberOfWindows) {
        new WebDriverWait(driver, getTimeout()) {
        }.until((ExpectedCondition<Boolean>) driver -> (driver.getWindowHandles().size() == numberOfWindows));
    }

    public void waitUntilElementVisible(WebElement element){
        new WebDriverWait(driver, getTimeout()).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilElementInvisible(WebElement element){
        new WebDriverWait(driver, getTimeout()).until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitUntilElementClickable(WebElement element){
        new WebDriverWait(driver, getTimeout()).until(ExpectedConditions.elementToBeClickable(element));
    }
}
