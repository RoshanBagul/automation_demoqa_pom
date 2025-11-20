package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Forms {

    private final WebDriver driver;

    public Forms(WebDriver driver){
        this.driver = driver;
    }

    public By formList = By.xpath("//div[@class='element-group']//div[@class='element-list collapse show']//span[text()='Practice Form']");
    public void showFormList(){
        driver.findElement(formList).isDisplayed();
    }
}
