package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h2[text()='Subscription']")
    private WebElement subscriptionText;

    @FindBy(id = "susbscribe_email")
    private WebElement subscribeEmailField;

    @FindBy(id = "subscribe")
    private WebElement subscribeButton;

    @FindBy(xpath = "//div[text()='You have been successfully subscribed!']")
    private WebElement subscriptionSuccessMessage;

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
