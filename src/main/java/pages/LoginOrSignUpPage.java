package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginOrSignUpPage {
    WebDriver driver;

    public LoginOrSignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Signup field

    @FindBy(name = "name")
    private WebElement nameField;

    public void enterName(String name){
        nameField.sendKeys(name);
    }

    @FindBy(xpath = "//div[@class='signup-form']//input[@name='email']")
    private WebElement signupMailField;

    public void enterSignupEmail(String email){
        signupMailField.sendKeys(email);
    }

    @FindBy(xpath = "//div[@class='signup-form']//button[@type='submit']")
    private WebElement signUpButton;

    public void clickSignUpButton(){
        signUpButton.click();
    }

    // Login field

    @FindBy(xpath = "//div[@class='login-form']//input[@type='email']")
    private WebElement loginEmailField;

    public void enterLoginEmail(String email){
        loginEmailField.sendKeys(email);
    }

    @FindBy(xpath = "//div[@class='login-form']//input[@type='password']")
    private WebElement loginPasswordField;

    public void enterLoginPassword(String password){
        loginPasswordField.sendKeys(password);
    }

    @FindBy(xpath = "//div[@class='login-form']//button[@type='submit']")
    private WebElement loginButton;

    public void clickLoginButton(){
        loginButton.click();
    }

    // Signup Form Page

    @FindBy(id = "id_gender1")
    private WebElement titleMrRadioButton;

    public void selectTitleMr(){
        titleMrRadioButton.click();
    }

    @FindBy(id = "id_gender2")
    private WebElement titleMrsRadioButton;

    public void selectTitleMrs(){
        titleMrsRadioButton.click();
    }

    @FindBy(id = "password")
    private WebElement signupPasswordField;

    public void enterPassword(String password){
        signupPasswordField.sendKeys(password);
    }

    @FindBy(xpath = "//select[@name='days']")
    private WebElement daysDropdown;

    @FindBy(xpath = "//select[@name='months']")
    private WebElement monthsDropdown;

    @FindBy(xpath = "//select[@name='years']")
    private WebElement yearsDropdown;

    public void chooseDOB(){
        Select date = new Select(daysDropdown);
        date.selectByValue("24");
        Select month = new Select(monthsDropdown);
        month.selectByValue("2");
        Select year = new Select(yearsDropdown);
        year.selectByValue("2002");
    }

    @FindBy(id = "first_name")
    private WebElement firstNameField;

    public void enterFirstName(String firstName){
        firstNameField.sendKeys(firstName);
    }

    @FindBy(id = "last_name")
    private WebElement lastNameField;

    public void enterLastName(String lastName){
        lastNameField.sendKeys(lastName);
    }

    @FindBy(id = "address1")
    private WebElement addressOneField;

    public void enterAddressOne(String addressOne){
        addressOneField.sendKeys(addressOne);
    }

    @FindBy(id = "country")
    private WebElement countryDropdown;

    public void chooseCountry(){
        Select country = new Select(countryDropdown);
        country.selectByVisibleText("India");
    }

    @FindBy(id = "state")
    private WebElement stateField;

    public void enterState(String state){
        stateField.sendKeys(state);
    }

    @FindBy(id = "city")
    private WebElement cityField;

    public void enterCity(String city){
        cityField.sendKeys(city);
    }

    @FindBy(id = "zipcode")
    private WebElement zipCodeField;

    public void enterZipCode(String zipCode){
        zipCodeField.sendKeys(zipCode);
    }

    @FindBy(id = "mobile_number")
    private WebElement mobileNumberField;

    public void enterMobileNumber(String mobileNumber){
        mobileNumberField.sendKeys(mobileNumber);
    }

    @FindBy(xpath = "//button[text() = 'Create Account']")
    private WebElement createAccountButton;

    public void clickCreateAccountButton(){
        createAccountButton.click();
    }

    // Account Created/Deleted Page

    @FindBy(xpath = "//a[text()='Continue']")
    private WebElement continueButton;

    public void clickContinueButton(){
        continueButton.click();
    }

    // After login or register Delete Account & Logout Button appears

    @FindBy(linkText = "Delete Account")
    private WebElement deleteAccountButton;

    public void clickDeleteAccountButton(){
        deleteAccountButton.click();
    }

    @FindBy(xpath = "//a[text()=' Logout']")
    private WebElement logoutButton;

    public void clickLogoutButton(){
        logoutButton.click();
    }

    // Login Failure

    @FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
    private WebElement invalidEmailOrPasswordText;

    public boolean invalidEmailOrPasswordTextIsDisplayed(){
        return invalidEmailOrPasswordText.isDisplayed();
    }

}
