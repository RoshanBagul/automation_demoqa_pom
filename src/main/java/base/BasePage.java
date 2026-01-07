package base;

import org.openqa.selenium.WebDriver;
import utils.Driver_manager;

public class BasePage {

    public WebDriver driver;

    public BasePage(){
        this.driver = Driver_manager.getDriver();
    }
}
