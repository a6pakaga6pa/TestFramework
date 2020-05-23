package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {

    private WebDriver driver;
    private By clickArea = By.cssSelector("div input");
    private By currentRange = By.id("range");


    public HorizontalSliderPage(WebDriver driver){
        this.driver = driver;

    }

    public void setArrowRight(String finalValue){
        while(!getResult().equals(finalValue)){
            driver.findElement(clickArea).sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public String getResult(){
        return driver.findElement(currentRange).getText();
    }


}
