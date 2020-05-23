package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {

    private WebDriver driver;
    private String bigFrameArea = "frame-top";
    private String leftFrameArea = "frame-left";
    private String bottomFrameArea = "frame-bottom";

    private By leftTextArea = By.cssSelector("body");
    private By bottomTextArea = By.cssSelector("body");

    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void locateBigFrame() {
        driver.switchTo().frame(bigFrameArea);
    }

    public void locateLeftIFrameArea() {
        driver.switchTo().frame(leftFrameArea);
    }

    public void locateBottomIFrameArea() {
        driver.switchTo().frame(bottomFrameArea);
    }

    public String getLeftText() {
        String text = driver.findElement(leftTextArea).getText();
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        return text;

    }

    public String getBottomText() {
        String text = driver.findElement(bottomTextArea).getText();
        driver.switchTo().parentFrame();
        return text;
    }

    public void switchToMain(){
        driver.switchTo().parentFrame();
    }


}
