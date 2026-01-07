package utils;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class AdHandler {
    
    public static void handleAds(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            ((JavascriptExecutor) driver).executeScript(
                "document.querySelectorAll('iframe').forEach(i=> i.remove());");

            By closeButtons = By.xpath("//button[text()='Close' or text()='✕' or text()='X' or contains(@class,'close')]");
            
            
            wait.until(ExpectedConditions.presenceOfElementLocated(closeButtons));
            driver.findElement(closeButtons).click();
            System.out.println("Ad closed.");

            // var iframes = driver.findElements(By.tagName("iframe"));
            // for (var iframe : iframes) {
            //     driver.switchTo().frame(iframe);
            //     var adCloseButtons = driver.findElements(By.className("ad-close-button"));
            //     if (!adCloseButtons.isEmpty()) {
            //         adCloseButtons.get(0).click();
            //         System.out.println("Ad closed.");
            //     }
            //     driver.switchTo().defaultContent();
            // }
        } catch (Exception e) {
            System.out.println("No ads found or error handling ads: " + e.getMessage());
        }
    }
}
