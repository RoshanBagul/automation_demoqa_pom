package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import util.ConfigReader;

import java.io.IOException;

public class ElementsPage {
    private final WebDriver driver;
    public ElementsPage(WebDriver driver) {
        this.driver = driver;
    }
    public By menulist = By.cssSelector("ul.menu-list");
    public By textBox = By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']");
    public By Title = By.xpath("//h1[text()='Text Box']");
    public By fullName = By.xpath("//input[@id='userName']");
    public By email = By.id("userEmail");
    public By currentAddress = By.xpath("//textarea[@id='currentAddress']");
    public By permanentAddress = By.id("permanentAddress");
    public By submitButton = By.id("submit");
    public By outPut = By.id("output");
    public String full_name = "Automation" + Math.random();
    public  By elementList = By.xpath("//div[@class='element-group']//div[@class='element-list collapse show']");


    public void collapseElementList(){
        driver.findElement(elementList).click();
    }
    public void openTextBoxPage() {
        driver.findElement(textBox).click();
    }

    public void fillTextBoxForm() throws IOException, InterruptedException {
       openTextBoxPage();
        driver.findElement(fullName).sendKeys(full_name);
        driver.findElement(email).sendKeys(ConfigReader.get("Email_id"));
        driver.findElement(currentAddress).sendKeys(ConfigReader.get("Current_address"));
        driver.findElement(permanentAddress).sendKeys(ConfigReader.get("Permanent_address"));

        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        driver.findElement(submitButton).click();
    }

    public boolean isOutputDisplayed() {
      return driver.findElement(outPut).isDisplayed();
    }

    public String getOutputName(){
      return driver.findElement(By.id("name")).getText();
    }

    public String getOutputEmail(){
      return driver.findElement(By.id("email")).getText();
    }

    public String getOutputCurrentAddress() {
        return driver.findElement(By.xpath("//p[@id='currentAddress']")).getText();
    }

    public String getOutputPermanentAddress() {
        return driver.findElement(By.xpath("//p[@id='permanentAddress']")).getText();
    }
}
