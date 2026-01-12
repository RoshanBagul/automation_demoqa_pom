package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ElementsPage;
import pages.HomePage;
import java.time.Duration;


public class Helper {
    protected static WebDriver driver;

    public Helper(WebDriver driver){
        this.driver = driver;
    }

    public static void clickbutton(String buttonName){
        driver.findElement(By.xpath("//button[text()='"+buttonName+"']")).click();
    }

    public static void doubleClickButton(String doubleClick) throws InterruptedException {
        Thread.sleep(500);
        WebElement element = driver.findElement(By.xpath("//button[text()='"+doubleClick+"']"));

        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    public static void rightclickButton(String rightClick){

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement element = wait.until(
//                ExpectedConditions.elementToBeClickable(
//                        By.xpath("//button[text()='"+rightClick+"']")
//                )
//        );
//
//        Actions actions = new Actions(driver);
//        actions
//                .moveToElement(element)
//                .contextClick()
//                .pause(Duration.ofMillis(300))
//                .sendKeys(Keys.ESCAPE)  // Always close menu
//                .perform();


        WebElement element = driver.findElement(
                By.xpath("//button[text()='" + rightClick + "']")
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Simulate right-click via JS (no native menu)
        js.executeScript(
                "arguments[0].dispatchEvent(new MouseEvent('contextmenu', {bubbles: true}));",
                element
        );
    }

    public static void clickLinks(String links) {
        driver.findElement(By.xpath("//a[text()='" + links + "']")).click();
    }

    public static void allowSingleTabOnly(String switchTabButton, String WindowId) {
        String parent = driver.getWindowHandle();
        clickbutton(switchTabButton);
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());       
        driver.findElement(By.id(WindowId)).isDisplayed();
        driver.close();
        driver.switchTo().window(parent);
    }
}
