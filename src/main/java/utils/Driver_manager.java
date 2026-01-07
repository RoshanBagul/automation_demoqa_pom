package utils;
import org.openqa.selenium.WebDriver;

public class Driver_manager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(WebDriver driverInstance){
        driver.set(driverInstance);
    }

    public static WebDriver getDriver(){
        return driver.get();
    }
    
    public static void unload(){
        driver.remove();
    }
}
