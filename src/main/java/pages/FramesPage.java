package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage {

    private WebDriver driver;
    private By nestedFramesLink = By.cssSelector("#content > div > ul > li:nth-child(1) > a");

    public FramesPage(WebDriver driver){
        this.driver = driver;
    }

    public NestedFramesPage clickToNestedFramesPage() {
        driver.findElement(nestedFramesLink).click();
        return new NestedFramesPage(driver);
    }

}
