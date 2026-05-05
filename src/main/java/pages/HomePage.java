package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Home")
    private WebElement homeButton;

    @FindBy(linkText = "Products")
    private WebElement productsButton;

    @FindBy(linkText = "Cart")
    private WebElement cartButton;

    @FindBy(linkText = "Signup / Login")
    private WebElement loginOrSignupButton;

    @FindBy(linkText = "Contact us")
    private WebElement contactUsButton;

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
}
