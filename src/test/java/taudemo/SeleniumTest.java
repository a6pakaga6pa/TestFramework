package taudemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class SeleniumTest {

    private WebDriver driver;

    @BeforeClass
    public void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass
    public void afterAll() {
        driver.quit();
    }

    /**
     *
     */
    @Test
    public void openTheComPageAndCheckTheTitle() {
        String expectedComTitle = "Example Domain";
        driver.get("https://www.example.com");
        assertEquals(driver.getTitle(), expectedComTitle, "Wrong title");
    }
    
    @Test
    public void openTheOrgPageAndCheckTheTitle() {
        String expectedOrgTitle = "Example Domain";
        driver.get("https://www.example.org");
        assertEquals(driver.getTitle(), expectedOrgTitle, "Wrong title");
    }

}
