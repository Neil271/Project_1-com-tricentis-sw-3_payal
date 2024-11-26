package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class TopMenuTest extends Utility {

    //Base url
    String baseUrl = "https://demowebshop.tricentis.com/";

    //Set up the browser
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //1.1 create a method with the name "selectMenu()" It has one parameter name "menu" of type string
    public void selectMenu(String menu) {
        //1.2 This method should click on the menu whatever name is passed as a parameter.
        WebElement menuElement = driver.findElement(By.xpath("//a[normalize-space()='" + menu + "']"));
        menuElement.click();
    }

    //1.3. create the @Test method name verifyPageNavigation(). Use the selectMenu() method to select the Menu and click on it and verify the page navigation.
    @Test
    public void verifyPageNavigation() {
        String menuName = "Computers";
        selectMenu(menuName);

        //verify the page navigation.

    }



    //Close the browser
    @After
    public void tearDown() {
        closeBrowser();
    }


}
