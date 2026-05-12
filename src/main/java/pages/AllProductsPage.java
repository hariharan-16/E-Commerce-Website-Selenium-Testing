package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Utilities;

import java.time.Duration;

public class AllProductsPage {
    WebDriver driver;
    WebDriverWait wait;

    public AllProductsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[text()='All Products']")
    private WebElement allProductsHeading;

    public boolean isAllProductsHeadingDisplayed() {
        return allProductsHeading.isDisplayed();
    }

    // Due to multiple product have same view product so according to product name we are clicking on view product button
    private By viewProduct(String productName){
        String xpath = "//p[text()='"+productName+"']//..//..//..//a[text()='View Product']";
        return By.xpath(xpath);
    }

    public void clickViewProduct(String productName){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(viewProduct(productName)));
        Utilities.scrollToElement(driver, element);
        Utilities.jsClick(driver, element);
    }

    @FindBy(id = "search_product")
    private WebElement searchTextField;

    public void enterProductNameInSearchField(String productName){
        searchTextField.sendKeys(productName);
    }

    @FindBy(id = "submit_search")
    private WebElement searchButton;

    public void clickSearchButton(){
        searchButton.click();
    }
}
