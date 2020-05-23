package chapter3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestScenario {

    private WebDriver driver;

    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Shifting Content")).click();
        driver.findElement(By.linkText("Example 1: Menu Element")).click();

        List<WebElement> numberOfMenus = driver.findElements(By.cssSelector("#content > div > ul > li > a"));
        System.out.println(numberOfMenus.size());

        System.out.println(driver.getTitle());

    }

    public static void main(String[] args){
        TestScenario test = new TestScenario();
        test.setUp();
    }
}
