package navigation;

import base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class NavigationTests extends BaseTests {


    @Test
    public void testNavigator(){
        homePage.clickDynamicLoading().clickExample1();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("https://www.google.com");
        assertEquals(getWindowManager().getWindowTitle(),"Google");
    }

    @Test
    public void testSwitchTab() {
        var multipleWindowsPage = homePage.clickMultipleWindows();
        multipleWindowsPage.clickHere();
        getWaitManager().waitForNumberOfWindowsToEqual(2);
        getWindowManager().switchToTab("New Window");
        assertEquals(getWindowManager().getWindowTitle(), "New Window");
        getWindowManager().closeAllExtraTabs();
    }

    @Test
    public void testDynamicLoadingNavigation(){
        var buttonPage = homePage.clickDynamicLoading().clickExample2NewTab();
        getWaitManager().waitForNumberOfWindowsToEqual(2);
        getWindowManager().switchToNewTab();
        assertTrue(buttonPage.isButtonDisplayed(), "Button is absent");
        getWindowManager().closeAllExtraTabs();
    }
}
