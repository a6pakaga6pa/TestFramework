package cookies;

import base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertFalse;

public class CookieTests extends BaseTests {

    @Test
    public void deleteCookieTest(){

        var cookieManager = getCookieManager();
        var cookie = cookieManager.buildCookie("optimizelyBuckets1", "%7B%7D");
        cookieManager.deleteCookie(cookie);
        assertFalse(cookieManager.isCookiePresent(cookie), "Cookie is not deleted!");
    }


}
