package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class HoversPage {

    private WebDriver driver;
    private By figureBox = By.xpath("//div[@class = 'figure']");
    private By boxCaption = By.className("figcaption");
    private By header = By.tagName("h5");
    private By link = By.tagName("a");


    public HoversPage(WebDriver driver){
        this.driver = driver;
    }

    public FigureCaption hoverOverFigure(int index){
        System.out.println("driver=" + driver);
        driver.findElement(By.className("no-js"));
        System.out.println("driver=" + driver);
        driver.findElement(header);
        System.out.println("driver=" + driver);
        driver.findElements(By.cssSelector("meta"));
        System.out.println("driver=" + driver);
        driver.findElements(By.cssSelector(".row"));
        List<WebElement> a = driver.findElements(By.xpath("//div[@class = 'example']"));
        System.out.println(a);

        List<WebElement> figures = driver.findElements(figureBox);
        WebElement figure = driver.findElements(figureBox).get(index-1);
        Actions actions = new Actions(driver);
        actions.moveToElement(figure).perform();
        return new FigureCaption(figure.findElement(boxCaption));

    }

    public class FigureCaption {

        private WebElement caption;

        public FigureCaption(WebElement caption){
            this.caption = caption;

        }

        public boolean isCaptionDisplayed(){
            return caption.isDisplayed();
        }

        public String getTitle(){
            return caption.findElement(header).getText();
        }

        public String getLink(){
            return caption.findElement(link).getAttribute("href");
        }

        public String getLinkText(){
            return caption.findElement(link).getText();
        }

    }
}
