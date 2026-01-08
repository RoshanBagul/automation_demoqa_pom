package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import base.BasePage;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private By homepage = By.xpath("//div[@class='category-cards']");
    public By elementsCard = By.xpath("//h5[text()='Elements']");
    private By formsCard = By.xpath("//h5[text()='Forms']");
    private By alertCard = By.xpath("//h5[text()='Alerts, Frame & Windows']");
    private By widgetsCard = By.xpath("//h5[text()='Widgets']");
    private By interactionsCard = By.xpath("//h5[text()='Interactions']");
    private By bookCard = By.xpath("//h5[text()='Book Store Application']");

    public ElementsPage openElementsPage(){
        WebElement element = driver.findElement(elementsCard);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(elementsCard).click();
        return new ElementsPage(driver);
    }

    public void openFormsPage() {
        driver.findElement(formsCard).click();
    }

    public void openAlertsFrameWindowsPage() {
        driver.findElement(alertCard).click();
    }

    public void openWidgetsPage() {
        driver.findElement(widgetsCard).click();
    }

    public void openInteractionsPage() {
        driver.findElement(interactionsCard).click();
    }

    public void openBookCardPage() throws InterruptedException {
        Thread.sleep(2000);
        WebElement element = driver.findElement(bookCard);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(bookCard).click();
    }

    public void validateHomepage () throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(elementsCard).isDisplayed();
        driver.findElement(formsCard).isDisplayed();
        driver.findElement(alertCard).isDisplayed();
        driver.findElement(widgetsCard).isDisplayed();
        driver.findElement(interactionsCard).isDisplayed();
        driver.findElement(bookCard).isDisplayed();
    }
}
