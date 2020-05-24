package horizontalSlider;

import base.BaseTests;
import org.testng.annotations.Test;
public class HorizontalSliderTests extends BaseTests {

    @Test
    public void testHorizontalSlider(){
        var horizontalSliderPage = homePage.clickHorizontalSlider();
        horizontalSliderPage.setArrowRight("4");
    }


}
