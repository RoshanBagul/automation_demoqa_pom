package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import util.ConfigReader;
import util.ExtentManager;

import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.FileInputStream;
import java.io.InputStream;
import java.time.Duration;
import java.io.IOException;
import java.util.Properties;

public class BasePage {

    // declaring all variables
    public static Properties prop;
    public static InputStream fileInputStream;
    public static WebDriver driver;
    protected static ExtentReports extent;
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
  

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        // this method will run once before the suite starts
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws IOException {
        // this method will run Before each @test method we will have
        try {
            // reading config properties file
            String propFilePath = System.getProperty("user.dir") + "/src/main/resources/config/config.properties";
            System.out.println(propFilePath);
            fileInputStream = new FileInputStream(propFilePath);

            // load properties file in Properties
            prop = new Properties();
            prop.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

        // read which browser is requred for test from config file
        String browser = prop.getProperty("browser").toUpperCase();

        // use WEbDriverManager to automatically setup f=driver of the browser
        WebDriverManager.getInstance(DriverManagerType.valueOf(browser)).setup();

        // launch appropriate browser
        switch (browser) {
            case "CHROME":
                driver = new ChromeDriver();
                break;
            case "FIREFOX":
                driver = new FirefoxDriver();
                break;
            case "SAFARI":
                driver = new SafariDriver();
                break;
        }
        Reporter.log("===============Browser " + browser + " launched successfully==================", true);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.get(ConfigReader.get("baseurl"));
        String url = driver.getCurrentUrl();
        System.out.println("Current URl:  " + url);
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    public static WebDriver getDriver(){
        return driver;
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
       
        ExtentTest extentTest = getTest();

        if (result.getStatus() == ITestResult.FAILURE){
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS){
            extentTest.pass("Test Passed");
        } else if (result.getStatus() == ITestResult.SKIP){
            extentTest.skip(result.getThrowable());
        }

        // this method will run After each @test method we will have

        if (driver != null) {
            driver.quit();
            Reporter.log("===============Browser closed successfully==================", true);
        }   
    }

    @AfterSuite(alwaysRun = true)
    public void endReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
