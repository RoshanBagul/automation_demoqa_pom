package pages;

import java.io.IOException;
import java.io.ObjectInputFilter.Config;
import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import utils.ConfigReader;

public class Forms extends BasePage {

    private final WebDriver driver;

    public Forms(WebDriver driver){
        this.driver = driver;
    }
    
    public By FormTitle = By.xpath("//h1[text()='Practice Form']");
    public By FirstName = By.xpath("//input[@id='firstName']");
    public By LastName = By.xpath("//input[@id='lastName']");
    public By Email = By.xpath("//input[@id='userEmail']");
    public By Gender = By.xpath("//input[@value='Male']");
    public By Mobile = By.xpath("//input[@id='userNumber']");
    public By DateOfBirth = By.xpath("//input[@id='dateOfBirthInput']");
    public By Subjects = By.xpath("//input[@id='subjectsInput']");
    public By Hobbies = By.xpath("//label[text()='Hobbies']");
    public By SportsRadio = By.xpath("null");
    public By ReadingRadio = By.xpath("null");
    public By MusicRadio = By.xpath("null");
    public By Picture_file = By.xpath("//input[@id='uploadPicture']");
    public By CurrentAddress = By.xpath("//textarea[@id='currentAddress']");
    public By State = By.xpath("//div[@id='state']");
    public By City = By.xpath("//div[@id='city']");
    public By Submit = By.xpath("//button[@id='submit']");
    public By formList = By.xpath("//div[@class='element-group']//div[@class='element-list collapse show']//span[text()='Practice Form']");
   
   
    public void showFormList(){
        driver.findElement(formList).isDisplayed();
        driver.findElement(formList).click();
    }
   
    public void fillPracticeForm() throws IOException, InterruptedException {
        driver.findElement(FirstName).sendKeys(ConfigReader.get("First_Name"));
        driver.findElement(LastName).sendKeys(ConfigReader.get("Last_Name"));
        driver.findElement(Email).sendKeys(ConfigReader.get("Email_id"));
        driver.findElement(Mobile).sendKeys(ConfigReader.get("Mobile"));
        driver.findElement(Subjects).sendKeys(ConfigReader.get("Subjects"));
        driver.findElement(CurrentAddress).sendKeys(ConfigReader.get("Current_address")); 
        String filePath = System.getProperty("user.dir") + "/src/test/resources/upload/pomimage.png";

        System.out.println("Uploading file from: " + filePath);
        driver.findElement(Picture_file).sendKeys(filePath);

        driver.findElement(DateOfBirth).click();
        Select month = new Select(driver.findElement(By.className("react-datepicker__month-select")));
        month.selectByVisibleText("May");
        Select year = new Select(driver.findElement(By.className("react-datepicker__year-select")));
        year.selectByVisibleText("2000");
        driver.findElement(By.xpath("//div[text()='21']")).click();
    }
}
