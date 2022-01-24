package Class10_HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class CalculatorPage {
    private WebDriver driver;

    public CalculatorPage(WebDriver driver){
        this.driver = driver;
    }

    public int getButtonWidth(By locator){
        return driver.findElement(locator).getRect().getWidth();
    }

    public int getButtonHeight(By locator){
        return driver.findElement(locator).getRect().getHeight();
    }

    public boolean checkIfDisplayed(By locator){
        return driver.findElement(locator).isDisplayed();
    }

    private void clickButton(By locator){
        driver.findElement(locator).click();
    }

    public void clickButtons(List<By> locators){
        for (By locator: locators){
            clickButton(locator);
        }
    }
    public String readScreenValue(){
        return driver.findElement(Constants.SCREEN).getText();
    }
}
