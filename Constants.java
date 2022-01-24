package Class10_HW;

import org.openqa.selenium.By;

public class Constants {
    
    public static final String DRIVER_NAME      = "webdriver.chrome.driver";
    public static final String CHROME_DRIVER    = "C:\\Users\\IGOR\\Documents\\Studies\\QA Experts\\WebDrivers\\chromedriver_win32\\chromedriver.exe";
    public static final String CHROME_EXEC      = "C:\\Program Files (x86)\\Google\\Chrome Beta\\Application\\chrome.exe";
    public static final String CALC_URL         = "https://dgotlieb.github.io/WebCalculator/";

    //Calculator buttons locators
    public static final By BUTTON_1     = By.id("one");
    public static final By BUTTON_2     = By.id("two");
    public static final By BUTTON_3     = By.id("three");
    public static final By BUTTON_4     = By.id("four");
    public static final By BUTTON_5     = By.id("five");
    public static final By BUTTON_6     = By.id("six");
    public static final By BUTTON_7     = By.id("seven");
    public static final By BUTTON_8     = By.id("eight");
    public static final By BUTTON_9     = By.id("nine");
    public static final By BUTTON_0     = By.id("zero");
    public static final By BUTTON_DOT   = By.id("dot");
    public static final By BUTTON_ADD   = By.id("add");
    public static final By BUTTON_SUB   = By.id("minus");
    public static final By BUTTON_MULT  = By.id("multiply");
    public static final By BUTTON_DIV   = By.id("divide");
    public static final By BUTTON_EQUAL = By.id("equal");
    public static final By BUTTON_CLEAR = By.id("clear");

    //Calculator screen locator
    public static final By SCREEN       = By.id("screen");

}
