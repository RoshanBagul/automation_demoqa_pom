package pages;
import base.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Helper;

public class AlertsFrameWindows extends Helper {

    private WebDriver driver;

    public AlertsFrameWindows(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public By AlertsFrameWindowsTitle = By.xpath("//h1[text()='Browser Windows']");
    public By SamplePage = By.id("sampleHeading");
    public By BrowserWindow = By.xpath("//span[text()='Browser Windows']");


    public void validateAlertsFrameWindowsPage () throws InterruptedException {
        driver.findElement(BrowserWindow).click();
        driver.findElement(AlertsFrameWindowsTitle).isDisplayed();
    }   

    public void validateNewWindowOpened(String switchWindowButton, String WindowId, String expectedText) throws InterruptedException {
        
        String originalWindow = driver.getWindowHandle();

        Helper.clickbutton(switchWindowButton);
        
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        String actualText = driver.findElement(By.id(WindowId)).getText();
        if (!actualText.equals(expectedText)) {
            throw new AssertionError("Text does not match! Expected: " + expectedText + ", but found: " + actualText);
        }

        driver.close();
        driver.switchTo().window(originalWindow);

    }
}
