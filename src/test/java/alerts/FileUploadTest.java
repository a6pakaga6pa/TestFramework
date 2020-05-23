package alerts;

import base.BaseTests;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTest extends BaseTests {

    @Test
    public void testFileUpload() {
        var uploadPage = homePage.clickFileUpload();
        getWaitManager().waitUntilElementClickable(uploadPage.findUploadInput());
        uploadPage.uploadFile("D:\\testautomationu\\webdriver_java\\resources\\chromedriver.exe");
        assertEquals(uploadPage.getUploadedFiles(), "chromedriver.exe", "Uploaded files");
    }


}
