package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import pages.*;
import base.BasePage;

public class Widgets extends BasePage{

    public Widgets(WebDriver driver){
        this.driver = driver;
    }
   
    public By ProgressBarTitle = By.xpath("//h1[text()='Progress Bar']");
    public By progress_bar = By.id("progressBar");
    public By ProgressBarCollaps = By.xpath("//div[@class='element-list collapse show']//li[@id='item-4']");
    public By startStopButton = By.id("startStopButton");
    public By fifty_Percent = By.xpath("//div[@id='progressBar']/div[text()='51%']");

    public void openProgressBar(){
        driver.findElement(ProgressBarCollaps).click();
    }

    public void clickStartStopButton(){
        driver.findElement(startStopButton).click();
    }


}
