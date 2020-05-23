package context;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextMenuTests extends BaseTests {

    @Test
    public void testContextMenu() {
        var contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.rightClickContextArea();
        String text = contextMenuPage.alert_getText();
        assertEquals(text, "You selected a context menu", "Wrong text!");
        contextMenuPage.alert_clickToAccept();
    }
}
