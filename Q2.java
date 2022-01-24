package Class10_HW;

import com.paulhammant.ngwebdriver.ByAngular;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
Using ngWebDriver
(https://github.com/paul-hammant/ngWebDriver)
 Enter https://dgotlieb.github.io/AngularJS/main.html
 Clear first name.
 Enter your first name instead.
 Assert result.
 */
public class Q2 {
    WebDriver driver;

    @BeforeClass
    //Initialize the ChromeDriver with a given URL
    public void initDriver(){
        driver = InitChromeSingletone.InitChrome();
        driver.manage().window().maximize();
        driver.get("https://dgotlieb.github.io/AngularJS/main.html");
    }

    @Test (priority = 0)
    //Clear the First Name field
    public void replaceClearFirstName() {
        driver.findElement(ByAngular.model("firstName")).clear();
    }

    @Test (priority = 1)
    //Send a new First Name value
    public void setNewFirstName(){
        driver.findElement(ByAngular.model("firstName")).sendKeys("Igor");
    }

    @Test (priority = 2)
    //Check the First Name input correctness
    public void assertInput(){
        Assert.assertEquals(driver.findElement(ByAngular.model("firstName")).getAttribute("value"),
                "Igor");
    }
}
