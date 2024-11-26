package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    /**
     * This method will send text on element
     */
    public void sendTextOnElement(By by, String text) {
        WebElement element = driver.findElement(by);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * This method will get the text from element
     */
    public String getTextFromElem(By by) {
        return driver.findElement(by).getText();
    }

    /**
     * This method will click on the element
     */
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    /**
     * This method will return webelement
     */
    public WebElement findWebElement(By by) {
        return driver.findElement(by);
    }


    /**
     * This method will mouse hoover and click on  webelement
     */
    public void mouseHooverAndClickOnElement(WebElement webElement) {
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).click().build().perform();
    }

    /**
     * This method will do mouse hoover on the element
     */
    public void mouseHooverOnElement(WebElement webElement) {
        Actions actions = new Actions(driver);   // obj creation of Action class
        actions.moveToElement(webElement).build().perform();
    }

    /**
     * This Method will select the option in the Select tag.
     */
    public void selectOptionInSelectElement(WebElement selectElement, String option) {
        //Create the object of select class
        Select select = new Select(selectElement);
        //Select by visible text
        select.selectByVisibleText(option);
    }
}

