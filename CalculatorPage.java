package Class10_HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

/*
Class CalculatorPage receives initialized WebDriver instance
and provides methods allowing to get information and perform actions
on WebElements by their locators
 */

public class CalculatorPage {
    private WebDriver driver;

    //Constructor receives initialized webdriver
    public CalculatorPage(WebDriver driver){
        this.driver = driver;
    }

    //Returns the element width by locator
    public int getButtonWidth(By locator){
        return driver.findElement(locator).getRect().getWidth();
    }

    //Returns the element height by locator
    public int getButtonHeight(By locator){
        return driver.findElement(locator).getRect().getHeight();
    }

    //checks the element visibility by locator
    public boolean checkIfDisplayed(By locator){
        return driver.findElement(locator).isDisplayed();
    }

    //private method for clicking the element by locator
    private void clickButton(By locator){
        driver.findElement(locator).click();
    }

    //clicks elements passed as a list of locators
    public void clickButtons(List<By> locators){
        for (By locator: locators){
            clickButton(locator);
        }
    }

    //Reading the calculator screen contents
    public String readScreenValue(){
        return driver.findElement(Constants.SCREEN).getText();
    }
}
