package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    public static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {

            String reportPath = System.getProperty("user.dir") + "/reports/extent.html";

            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.config().setDocumentTitle("Automation Test Reports");
            spark.config().setReportName("ToolsQA Automation Test Report");
            spark.config().setTheme(Theme.STANDARD);

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Automation Tester", "Roshan Bagul");
            extent.setSystemInfo("Contact Info", "roshanbagul1904@gmail.com");
            extent.setSystemInfo("Browser", "Chrome");
        }
        return extent;
    }
}
