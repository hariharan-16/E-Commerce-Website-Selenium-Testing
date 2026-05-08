package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
    WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[text()='Get In Touch']")
    private WebElement getInTouchHeading;

    public boolean isGetInTouchHeadingDisplayed() {
        return getInTouchHeading.isDisplayed();
    }

    @FindBy(xpath = "//input[@name='name']")
    private WebElement nameField;

    public WebElement getNameField() {
        return nameField;
    }

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;

    public WebElement getEmailField() {
        return emailField;
    }

    @FindBy(xpath = "//input[@name='subject']")
    private WebElement subjectField;

    public WebElement getSubjectField() {
        return subjectField;
    }

    @FindBy(xpath = "//textarea[@id='message']")
    private WebElement messageField;

    public WebElement getMessageField() {
        return messageField;
    }

    @FindBy(xpath = "//input[@type='file']")
    private WebElement inputFileField;

    public WebElement getInputFileField() {
        return inputFileField;
    }

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;

    public WebElement getSubmitButton() {
        return submitButton;
    }

    // After submit

    @FindBy(xpath = "//div[@class='status alert alert-success']")
    private WebElement successMessage;

    public Boolean isSuccessMessageDisplayed() {
        return successMessage.isDisplayed();
    }

    @FindBy(xpath = "//span[text()=' Home']")
    private WebElement homeButton;

    public WebElement getHomeButton() {
        return homeButton;
    }
}
