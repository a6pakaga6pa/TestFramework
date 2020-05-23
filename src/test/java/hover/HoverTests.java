package hover;

import base.BaseTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.EventReporter;

import static org.testng.Assert.*;

public class HoverTests extends BaseTests {

    @Test
    public void testHoverUser2(){
        var hoversPage = homePage.clickHovers();
        var caption = hoversPage.hoverOverFigure(2);
        assertTrue(caption.isCaptionDisplayed(), "Caption not displayed!");
        assertEquals(caption.getTitle(), "name: user2", "Caption incorrect!");
        assertEquals(caption.getLinkText(),"View profile", "Caption link text incorrect!");
        assertTrue(caption.getLink().endsWith("/users/2"), "Link incorrect");
    }

   @Test
   public void testInOneMethod(){
       ChromeOptions options = new ChromeOptions();
       options.addArguments("disable-infobars");
       EventFiringWebDriver driver = new EventFiringWebDriver(new ChromeDriver(options));
       driver.get("https://the-internet.herokuapp.com/");
       var homePage = new HomePage(driver);
       var hoversPage = homePage.clickHovers();
       var caption = hoversPage.hoverOverFigure(2);
       assertTrue(caption.isCaptionDisplayed(), "Caption not displayed!");
       assertEquals(caption.getTitle(), "name: user2", "Caption incorrect!");
       assertEquals(caption.getLinkText(),"View profile", "Caption link text incorrect!");
       assertTrue(caption.getLink().endsWith("/users/2"), "Link incorrect");
       driver.quit();
   }


    private void True(boolean captionDisplayed, String s) {
    }
}
