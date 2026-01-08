package tests.Forms;

import java.io.IOException;

import org.apache.groovy.json.internal.IO;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.Forms;
import pages.HomePage;

public class FormPageTest extends BaseTest {

    public HomePage homePage;
    public Forms formPage;


    @BeforeMethod(alwaysRun = true)
    public void initPages(){
        homePage = new HomePage(driver);
        formPage = new Forms(driver);
    }

    
    @Test (groups = {"smoke", "FormPage"})
    public void testFillPracticeForm() throws IOException, InterruptedException {
        homePage.openFormsPage();
        formPage.showFormList();
        formPage.fillPracticeForm();
    }

}
