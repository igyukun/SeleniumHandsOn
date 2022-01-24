package Class10_HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

/*
 Enter https://dgotlieb.github.io/Selenium/synchronization.html
 Press on “remove checkbox” button and find the new element
that will show up under the CheckBox - use Implicit Wait.
 Press on “Show hidden” button and find the new element that
will replace the “Show hidden” button - use Thread.sleep().
 Press on “render” button and find the new element that will
show under “render” button – use Explicit Wait.
 */

public class Q1 {

    WebDriver driver;

    @BeforeClass
    //Initialize the ChromeDriver with a given URL
    public void initDriver(){
        driver = InitChromeSingletone.InitChrome();
        driver.manage().window().maximize();
        driver.get("https://dgotlieb.github.io/Selenium/synchronization.html");
    }

    @Test (priority = 0)
    //Pressing on “remove checkbox” button and checking the new element
    //that will show up under the CheckBox using the Implicit Wait.
    public void testImplicitSync(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("btn")).click();
        driver.findElement(By.cssSelector("p[id=message]"));
    }

    @Test (priority = 1)
    //Pressing on “Show hidden” button and finding the new element that
    //will replace the “Show hidden” button, using the Thread.sleep() method
    public void testSleepSync() throws InterruptedException{
        driver.findElement(By.id("hidden")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("div#finish1 h4"));
    }

    @Test (priority = 2)
    //Pressing on “render” button and finding the new element that will
    //show under “render” button, using the Explicit Wait.
    public void testExplicitSync(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.id("rendered")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish2 h4")));
    }
}
