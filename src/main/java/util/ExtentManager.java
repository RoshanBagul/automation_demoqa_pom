package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class ExtentManager {
        public static ExtentReports extent;

        public static ExtentReports getInstance() {
            if (extent == null) {
                ExtentSparkReporter spark = new ExtentSparkReporter("./reports/extent.html");
                spark.config().setDocumentTitle("Automation Test Reports");
                spark.config().setTheme(Theme.STANDARD);

                extent = new ExtentReports();
                extent.attachReporter(spark);
                extent.setSystemInfo("Automation Tester", "Roshan Bagul");
                extent.setSystemInfo("Contact Info", "roshanbagul1904@gmail.com");
            }
            return extent;
        }
    }
