package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Home")
    private WebElement homeButton;

    @FindBy(xpath = "//a[text()=' Products']")
    private WebElement productsButton;

    @FindBy(linkText = "Cart")
    private WebElement cartButton;

    @FindBy(linkText = "Signup / Login")
    private WebElement loginOrSignupButton;

    @FindBy(linkText = "Contact us")
    private WebElement contactUsButton;

    @FindBy(xpath = "//div[@class='item active']//button[text()='Test Cases']")
    private WebElement testCaseButton;

    @FindBy(xpath = "//h2[text()='Subscription']")
    private WebElement subscriptionText;

    @FindBy(id = "susbscribe_email")
    private WebElement subscribeEmailField;

    @FindBy(id = "subscribe")
    private WebElement subscribeButton;

    @FindBy(xpath = "//div[text()='You have been successfully subscribed!']")
    private WebElement subscriptionSuccessMessage;

    public void clickHomeButton() {
        homeButton.click();
    }

    public void clickProductsButton() {
        productsButton.click();
    }

    public void clickCartButton() {
        cartButton.click();
    }

    public void clickLoginOrSignupButton() {
        loginOrSignupButton.click();
    }

    public void clickContactUsButton() {
        contactUsButton.click();
    }

    public void clickTestCaseButton() {
        testCaseButton.click();
    }

    public WebElement getSubscriptionText(){
        return subscriptionText;
    }

    public void sendSubscriptionText(String text){
        subscribeEmailField.sendKeys(text);
    }

    public void clickSubscribeButton() {
        subscribeButton.click();
    }

    public boolean isSubscriptionSuccessMessageDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(subscriptionSuccessMessage));
        return subscriptionSuccessMessage.isDisplayed();
    }

}
