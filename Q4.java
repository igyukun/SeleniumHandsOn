package Class10_HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

/*
Create a TestNG test using tests efficiency techniques:
1. Constants.
2. POM (Page Object Model).
 Enter https://dgotlieb.github.io/WebCalculator/
 Print “7” button dimensions (using Constant).
 Check if “6” button is displayed
 Prepare an int variable with any number
 Calculate a mathematical formula that will give the result you
choose in the int variable earlier (using POM)
 Use assert to check if you got the expected result
 Use a Singleton class to create and return your driver.
 */

public class Q4 {
    WebDriver driver;
    private static final int result = 14;
    private static CalculatorPage page;

    @BeforeClass
    //Initialize the ChromeDriver with a given URL
    //and create a new CalculatorPage instance
    public void initDriver(){
        driver = InitChromeSingletone.InitChrome();
        driver.get("https://dgotlieb.github.io/WebCalculator/");
        page = new CalculatorPage(driver);
    }

    @Test(priority = 0)
    //Print “7” button dimensions (using Constant)
    public void printBttn7Dimentions(){
        System.out.printf("Button 7 dimensions are %d,%d (X,Y)%n",page.getButtonWidth(Constants.BUTTON_7),
                                                                  page.getButtonHeight(Constants.BUTTON_7));
    }

    @Test(priority = 1)
    //Check if “6” button is displayed
    public void checkBttn6Displayed(){
        Assert.assertTrue(page.checkIfDisplayed(Constants.BUTTON_6));
    }

    @Test(priority = 2)
    //Calculating the sum by sending a sequence of buttons to press
    //and reading the screen for a result.
    //Asserting the result against the expected int value
    public void calculateAndAssertSum(){
        // Creating a list of buttons to press in the order of adding
        List<By> actions = new ArrayList<>();
        actions.add(Constants.BUTTON_6);
        actions.add(Constants.BUTTON_ADD);
        actions.add(Constants.BUTTON_8);
        actions.add(Constants.BUTTON_EQUAL);

        //Calling clickButtons method
        page.clickButtons(actions);

        //Asserting the result
        Assert.assertEquals(page.readScreenValue(),String.valueOf(result));
    }

    @AfterClass
    public void quit(){
        driver.quit();
    }

}
