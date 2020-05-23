package frames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FrameTests extends BaseTests {

    @Test
    public void testWysiwyg(){
        var editorPage = homePage.clickWysiwygEditor();
        editorPage.clearTextArea();

        String text1 = "hello ";
        String text2 = "world";

        editorPage.setTextArea(text1);
        editorPage.decreaseIndention();
        editorPage.setTextArea(text2);

        assertEquals(editorPage.getTextFromEditor(), text1+text2, "Text from editor is incorrect");
    }

    @Test
    public void testFrames() {
        var framesPage = homePage.clickFrames();
        var nestedPage = framesPage.clickToNestedFramesPage();
        nestedPage.locateBigFrame();
        nestedPage.locateLeftIFrameArea();
        String text1 = nestedPage.getLeftText();
        assertEquals(text1, "LEFT", "Wrong LEFT text!");

        nestedPage.locateBottomIFrameArea();
        String text2 = nestedPage.getBottomText();
        assertEquals(text2, "BOTTOM", "Wrong BOTTOM text!");


    }
}