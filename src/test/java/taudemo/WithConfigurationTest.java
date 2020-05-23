package taudemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WithConfigurationTest {
    private WebDriver driver;

    @BeforeClass
    public void beforeAll(){
        //noinspection SpellCheckingInspection,SpellCheckingInspection
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass
    public void afterAll(){
        driver.quit();
    }

    @Test
    public void justATest(){
        driver.get("https://www.example.com");
        assertEquals(driver.getTitle(), "Example Domain");


    }
}
