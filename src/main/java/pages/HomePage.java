package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    public  HomePage(WebDriver driver){
        this.driver = driver;
    }
    public WebDriver driver;
    private By homepage = By.xpath("//div[@class='category-cards']");
    public By elementsCard = By.xpath("//h5[text()='Elements']");
    private By formsCard = By.xpath("//h5[text()='Forms']");
    private By alertCard = By.xpath("//h5[text()='Alerts, Frame & Windows']");
    private By widgetsCard = By.xpath("//h5[text()='Widgets']");
    private By interactionsCard = By.xpath("//h5[text()='Interactions']");
    private By bookCard = By.xpath("//h5[text()='Book Store Application']");


    public void validateHomepage (){
        driver.findElement(elementsCard).isDisplayed();
        driver.findElement(formsCard).isDisplayed();
        driver.findElement(alertCard).isDisplayed();
        driver.findElement(widgetsCard).isDisplayed();
        driver.findElement(interactionsCard).isDisplayed();
        driver.findElement(bookCard).isDisplayed();
    }
}
