package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

   // Check Box Elements
    public By checkBox = By.xpath("//span[text()='Check Box']");
    public By checkboxTitle = By.xpath("//h1[text()='Check Box']");
    public By expand = By.xpath("//div[@class='rct-options']/button[@title='Expand all']");
    public By collapse = By.xpath("//div[@class='rct-options']/button[@title='Collapse all']");
    public By homeExpand = By.xpath("(//span[@class='rct-text']/button)[1]");
    public By homeCheckbox = By.xpath("//span[text()='Home']/ancestor::span//span[@class='rct-checkbox']");
    public By desktopCheckBox = By.xpath("//span[text()='Desktop']/ancestor::span//span[@class='rct-checkbox']");
    public By documentCheckBox = By.xpath("//span[text()='Documents']/ancestor::span//span[@class='rct-checkbox']");
    public By downloadCheckBox = By.xpath("//span[text()='Downloads']/ancestor::span//span[@class='rct-checkbox']");

   // Check Radio Button Elements
    public By radioButton = By.xpath("//ul[@class='menu-list']//span[text()='Radio Button']");
    public By radioButtonTitle = By.xpath("//h1[text()='Radio Button']");
    public By yesRadioButton = By.xpath("//label[@for='yesRadio']");
    public By impressiveRadioButton = By.xpath("//label[@for='impressiveRadio']");
    public By noRadioButton = By.id("noRadio");  //this is disabled radio button

   //Check Web Tables
    public By webTables = By.xpath("//ul[@class='menu-list']//span[text()='Web Tables']");
    public By webTableTitle = By.xpath("//h1[text()='Web Tables']");

    //Check Buttons
    public By buttons = By.xpath("//ul[@class='menu-list']//span[text()='Buttons']");
    public By buttonsTitle = By.xpath("//h1[text()='Buttons']");

    //Check Links
    public By links = By.xpath("//ul[@class='menu-list']//span[text()='Links']");

    //Check Broken Links-Images
    public By brokenLinks = By.xpath("//ul[@class='menu-list']//span[text()='Broken Links - Images']");

    //Check upload and download
    public By uploadAndDownload = By.xpath("//ul[@class='menu-list']//span[text()='Upload and Download']");

    //Check Dynamic Properties
    public By dynamicProperties = By.xpath("//ul[@class='menu-list']//span[text()='Dynamic Properties']");

//------------------------------------------------------------------------------------------------------------------------//

    public void collapseElementList(){
        driver.findElement(elementList).click();
    }
    public void openTextBoxPage() {
        driver.findElement(textBox).click();
    }
    public void openCheckBoxPage(){ driver.findElement(checkBox).click();}
    public void openRadioButtonPage(){driver.findElement(radioButton).click();}
    public void openWebTablesPage(){driver.findElement(webTables).click();}
    public void openButtonsPage(){driver.findElement(buttons).click();}
    public void openLinksPage(){driver.findElement(links).click();}
    public void openBrokenLinksPage(){driver.findElement(brokenLinks).click();}
    public void openUploadAndDownloadPage(){driver.findElement(uploadAndDownload).click();}
    public void openDynamicPropertiesPage(){driver.findElement(dynamicProperties).click();}

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
    public void validateCheckBox (){
        openCheckBoxPage();
        driver.findElement(checkboxTitle).isDisplayed();
        driver.findElement(expand).click();
        driver.findElement(collapse).click();

        driver.findElement(homeExpand).click();
        driver.findElement(homeCheckbox).click();
        driver.findElement(desktopCheckBox).isDisplayed();
        driver.findElement(documentCheckBox).isDisplayed();
        driver.findElement(downloadCheckBox).isDisplayed();
    }

    public void validateRadioButton (String outputYes , String outputImp) {
        openRadioButtonPage();
        WebElement element = driver.findElement(yesRadioButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(radioButtonTitle).isDisplayed();
        driver.findElement(yesRadioButton).isEnabled();
        driver.findElement(impressiveRadioButton).isEnabled();
        driver.findElement(noRadioButton).isDisplayed();

        driver.findElement(yesRadioButton).click();
        driver.findElement(By.className("mt-3"));
        driver.findElement(By.xpath("//span[text()='"+ outputYes +"']")).isDisplayed();
        driver.findElement(impressiveRadioButton).click();
        driver.findElement(By.xpath("//span[text()='"+ outputImp +"']")).isDisplayed();
    }

    public boolean isOutPutDisplayed(String outputYes){
        return !driver.findElements(
                By.xpath("//span[text()='"+ outputYes +"']")
        ).isEmpty();
    }
}
