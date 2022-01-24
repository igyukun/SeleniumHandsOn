package Class10_HW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
/*
Class initializes the ChromeDriver with a URL, provided as an argument to the constructor
 */

public class InitChromeSingletone {
    private static WebDriver driver;

    public static WebDriver InitChrome() {
        if (driver == null) {
            System.setProperty(Constants.DRIVER_NAME, Constants.CHROME_DRIVER);
            ChromeOptions options = new ChromeOptions();
            options.setBinary(Constants.CHROME_EXEC);
            driver = new ChromeDriver(options);
        }

        return driver;
    }

//    public WebDriver getDriver() {
//        return driver;
//    }
}
