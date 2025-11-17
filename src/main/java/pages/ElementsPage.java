package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import util.ConfigReader;

import java.io.IOException;

public class ElementsPage extends HomePage {

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    public By menulist = By.cssSelector("ul.menu-list");
    public By textBox = By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']");
    public By Title = By.xpath("//h1[text()='Text Box']");
    public By fullName = By.xpath("//input[@id='userName']");
    public By email = By.id("userEmail");
    public By currentAddress = By.id("currentAddress");
    public By permanentAddress = By.id("permanentAddress");
    public By submitButton = By.id("submit");
    public By outPut = By.id("output");

    public String full_name = "Automation" + Math.random();

    public void openElementsPage() throws InterruptedException {
        driver.findElement(elementsCard).click();
        Thread.sleep(2000);
    }

    public void openTextBoxPage() throws InterruptedException{
        openElementsPage();
        driver.findElement(textBox).click();
        Thread.sleep(1000);
    }

    public void fillTextBoxForm() throws IOException, InterruptedException {
       openTextBoxPage();
        driver.findElement(fullName).sendKeys(full_name);
        driver.findElement(email).sendKeys(ConfigReader.get("Email_id"));
        driver.findElement(currentAddress).sendKeys(ConfigReader.get("Current_Address"));
        driver.findElement(permanentAddress).sendKeys(ConfigReader.get("PermanentAddress"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight");
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
        return driver.findElement(By.id("currentAddress")).getText();
    }

    public String getOutputPermanentAddress() {
        return driver.findElement(By.id("permanentAddress")).getText();
    }

    public void ValidateTextBox() throws InterruptedException, IOException {

        String name = driver.findElement(By.xpath("//p[@id='name']")).getText();
        System.out.println(name);
        String email = driver.findElement(By.xpath("//p[@id='email']")).getText();
        System.out.println(email);
        String currentadd = driver.findElement(By.xpath("//p[@id='currentAddress']")).getText();
        System.out.println(currentadd);
        String permanentadd = driver.findElement(By.xpath("//p[@id='permanentAddress']")).getText();
        System.out.println(permanentadd);


//        Assert.assertEquals(name,"Name:"+Full_name);
//        Assert.assertEquals(email,"Email:"+ConfigReader.get("Email_id"));
//        Assert.assertEquals(currentadd,"Current Address :"+ConfigReader.get("Current_Address"));
//        Assert.assertEquals(permanentadd,"Permananet Address :"+ConfigReader.get("Permanent_address"));
    }
}
