package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.ElementsPage;
import pages.HomePage;


public class Helper {
    protected static WebDriver driver;

    public Helper(WebDriver driver){
        this.driver = driver;
    }

    public static void clickbutton(String buttonName){
        driver.findElement(By.xpath("//button[text()='"+buttonName+"']")).click();
    }

    public static void doubleClickButton(String doubleClick){
        WebElement element = driver.findElement(By.xpath("//button[text()='"+doubleClick+"']"));

        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    public static void rightclickButton(String rightClick){
        WebElement element = driver.findElement(By.xpath("//button[text()='"+rightClick+"']"));

        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }
}
