package Class10_HW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

public class Q5 {
    private WebDriver driver;
    private final String GOOGLE_URL         = "https://www.google.com";         //Google url
    private final String YOUTUBE_URL        = "https://www.youtube.com";        //Youtube url
    private final String GOOGLE_TRANS_URL   = "https://translate.google.com/";  //Translate url
    private ArrayList <String> handles;                                         //List of browser's tabs' handles

    @BeforeClass
    public void initChrome(){
        handles = new ArrayList<>();
        driver = InitChromeSingletone.InitChrome();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
    }

    @Test(priority = 0)
    //Open GOOGLE and get its window handle
    public void openGoogle(){
        driver.get(GOOGLE_URL);
        handles.add(driver.getWindowHandle());
    }

    @Test(priority = 1)
    //Open YouTube and get its tab handle
    public void openYoutube(){
        driver.switchTo().newWindow(WindowType.TAB); //Open new browser tab. Requires Selenium 4 and higher
        driver.get(YOUTUBE_URL);
        handles.add(driver.getWindowHandle());
    }

    @Test(priority =2)
    //Open Google Translate and get its tab handle
    public void openTranslate(){
        driver.switchTo().newWindow(WindowType.TAB); //Open new browser tab. Requires Selenium 4 and higher
        driver.get(GOOGLE_TRANS_URL);
        handles.add(driver.getWindowHandle());
    }

    @Test(priority = 3)
    //Switch to the tab containing Google
    public void navigateToGoogle() throws InterruptedException{
        Thread.sleep(1500);  //sleep for 1500ms to see the tab switch
        driver.switchTo().window(handles.get(0));
    }

    @Test(priority = 4)
    //Switch to the tab containing Youtube
    public void navigateToYoutube()throws InterruptedException{
        Thread.sleep(1500); //sleep for 1500ms to see the tab switch
        driver.switchTo().window(handles.get(1));
    }
}
