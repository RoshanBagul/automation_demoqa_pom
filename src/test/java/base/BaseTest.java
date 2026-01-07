
package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Driver;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;

import groovyjarjarantlr4.v4.parse.ANTLRParser.ruleEntry_return;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import utils.ConfigReader.*;
import utils.ConfigReader;
import utils.ExtentManager;
import utils.Driver_manager;

public class BaseTest {

    protected static WebDriver driver;
    protected static Properties prop;
    protected static ExtentReports extent;
    public static InputStream fileInputStream;
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
      extent = ExtentManager.getInstance();
    }

    @BeforeMethod(alwaysRun = true)
    public void setup()throws IOException {
        loadConfig();
        initDriver();
        driver.get(ConfigReader.get("baseurl"));
        String url = driver.getCurrentUrl();
        System.out.println("Current URl:  " + url);
    }

    // private void loadConfig(){
    //     try (InputStream fis = new FileInputStream(
    //         System.getProperty("user.dir") + "/src/main/resources/config/config.properties")) {
                
    //             prop = new Properties();
    //             prop.load(fis);
    //     } catch (Exception e) {
    //         throw new RuntimeException("Failed to load config file", e);
    //     }
    // }
    
    private void loadConfig(){
        // this method will run Before each @test method we will have
        try {
            // reading config properties file
            String propFilePath = System.getProperty("user.dir") + "/src/main/resources/config/config.properties";
            System.out.println(propFilePath);
            fileInputStream = new FileInputStream(propFilePath);

            // load properties file in Properties
            prop = new Properties();
            prop.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }    

    private void initDriver(){
        String browser = prop.getProperty("browser").toUpperCase();
        WebDriverManager.getInstance(DriverManagerType.valueOf(browser)).setup();

        switch (browser) {
            case "CHROME":
                ChromeOptions options = new ChromeOptions();
                options.setPageLoadStrategy(PageLoadStrategy.EAGER);
                options.addArguments("--window-size=1920,1080");

                if (System.getenv("GITHUB_ACTIONS")!= null){
                    options.addArguments("--headless=new");
                    options.addArguments("--disable-gpu");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                }
                driver = new ChromeDriver(options);
                Driver_manager.setDriver(driver);
                break;

            case "FIREFOX":
                driver = new FirefoxDriver();
                break;

            case "SAFARI":
                driver = new SafariDriver();
                break;

            // default:
            //     throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        if (System.getenv("GITHUB_ACTIONS") == null) {
            driver.manage().window().maximize();
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        ExtentTest extentTest = getTest();

        if (extentTest != null){
            if (result.getStatus() == ITestResult.FAILURE) {
                extentTest.fail(result.getThrowable());
            }else if (result.getStatus() == ITestResult.SUCCESS){
                extentTest.pass("Test Passed");
            }else {
                extentTest.skip(result.getThrowable());
            }
        }

        if (driver != null) {
            driver.quit();
            Reporter.log("Browser Closed successfully", true);
        }
    }

    @AfterSuite(alwaysRun = true)
    public void endReport(){
        if (extent != null){
            extent.flush();
        }
    }   
}