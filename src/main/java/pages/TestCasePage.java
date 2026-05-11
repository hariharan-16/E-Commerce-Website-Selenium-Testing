package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCasePage {
    WebDriver driver;

    public TestCasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//b[text()='Test Cases']")
    private WebElement testCaseHeading;

    public boolean isTestCaseHeadingDisplayed() {
        return testCaseHeading.isDisplayed();
    }
}
