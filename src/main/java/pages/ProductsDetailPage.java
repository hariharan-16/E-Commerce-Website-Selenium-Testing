package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsDetailPage {
    WebDriver  driver;

    public ProductsDetailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='product-information']")
    private WebElement productInformation;

    public boolean isProductInformationDisplayed() {
        return productInformation.isDisplayed();
    }

}
