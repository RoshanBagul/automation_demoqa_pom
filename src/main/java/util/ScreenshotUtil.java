package util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class ScreenshotUtil {

    public static String takeScreenshot(WebDriver driver, String testName) {
        if (driver == null) {
            return null;
        }

        // Timestamp for unique name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotName = testName + "_" + timeStamp + ".png";

        // Folder: /screenshots under project root
        String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + screenshotName;

        try{
            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            File dest =  new File(screenshotPath);

            // Create Folder if not exists
            dest.getParentFile().mkdirs();

            FileUtils.copyFile(src,dest);
            return screenshotPath;
        }   catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
