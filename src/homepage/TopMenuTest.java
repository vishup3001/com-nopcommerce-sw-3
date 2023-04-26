package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        // Open browser
        openBrowser(baseUrl);
    }

    @After
    public void tearDown() {
        // Close all windows
        closeBrowser();
    }

    /**
     * This method select menu on top menu
     * @param menu
     */
    public void selectMenu(String menu) {
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='" + menu + "']"));
    }

    @Test
    public void verifyPageNavigation() {
        String menuName = "Electronics";
        String expectedMessage = "Electronics";
        // this method select Electronics tab on top menu
        selectMenu(menuName);
        String actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Electronics']"));
        // verify Electronics page
        verifyTwoTextMessage(expectedMessage, actualMessage);

    }


}
