package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import util.ConfigReader;

import java.io.IOException;
import java.util.Properties;

import static java.awt.SystemColor.window;

public class elementsPage extends HomePage {

    public elementsPage(WebDriver driver) {
        super(driver);
    }
    public Properties prop;
    public By menulist = By.cssSelector("ul.menu-list");
    public By textBox = By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']");
    public By Title = By.xpath("//h1[text()='Text Box']");
    public By FullName = By.xpath("//input[@id='userName']");
    public By Email = By.id("userEmail");
    public By CurrentAddress = By.id("currentAddress");
    public By PermanentAddress = By.id("permanentAddress");
    public By SubmitButton = By.id("submit");
    public By OutPut = By.id("output");
    public String Full_name = "Automation" + Math.random();
    public void validateElementsPage () throws InterruptedException {
        driver.findElement(elementsCard).click();
        driver.findElement(menulist).isDisplayed();
    }

    public void ValidateTextBox() throws InterruptedException, IOException {
        driver.findElement(elementsCard).click();
        Thread.sleep(3000);
        driver.findElement(textBox).click();
        Thread.sleep(2000);
        driver.findElement(FullName).sendKeys(Full_name);
        driver.findElement(Email).sendKeys(ConfigReader.get("Email_id"));
        driver.findElement(CurrentAddress).sendKeys(ConfigReader.get("Current_Address"));
        driver.findElement(PermanentAddress).sendKeys(ConfigReader.get("Permanent_address"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        driver.findElement(SubmitButton).click();

        driver.findElement(OutPut).isDisplayed();
        String name = driver.findElement(By.xpath("//p[@id='name']")).getText();
        System.out.println(name);
        String email = driver.findElement(By.xpath("//p[@id='email']")).getText();
        System.out.println(email);
        String currentadd = driver.findElement(By.xpath("//p[@id='currentAddress']")).getText();
        System.out.println(currentadd);
        String permanentadd = driver.findElement(By.xpath("//p[@id='permanentAddress']")).getText();
        System.out.println(permanentadd);


        Assert.assertEquals(name,"Name:"+Full_name);
        Assert.assertEquals(email,"Email:"+ConfigReader.get("Email_id"));
        Assert.assertEquals(currentadd,"Current Address :"+ConfigReader.get("Current_Address"));
        Assert.assertEquals(permanentadd,"Permananet Address :"+ConfigReader.get("Permanent_address"));
    }
}
