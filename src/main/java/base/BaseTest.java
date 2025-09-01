package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import util.ConfigReader;
import util.ExtentManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
@Listeners()
public class BaseTest {

    public WebDriver driver;

//    public static ExtentReports extent = ExtentManager.getInstance();

    @BeforeMethod
    public void setUp() throws IOException {
        System.setProperty("webdriver.chrome.driver","/home/pavneesh/Automation2025/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.get("baseurl"));
        String url = driver.getCurrentUrl();
        System.out.println("Current URl" + url);
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
