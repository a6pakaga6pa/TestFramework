package chapter4;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ConfirmationPage;
import pages.ForgotPasswordPage;
import static org.testng.Assert.*;
import static org.testng.Assert.assertTrue;

public class RestorePassword extends BaseTests {

    @Test
    public void testPasswordRestore(){
        ForgotPasswordPage restorePage = homePage.clickForgotPasswordPage();
        restorePage.enterEmail();
        ConfirmationPage confirmationPage = restorePage.pressRetrieveButton();
        assertTrue(confirmationPage.getConfirmationText()
                        .contains("Your e-mail's been sent!"),
                "Confirmation text is incorrect");

    }


}
