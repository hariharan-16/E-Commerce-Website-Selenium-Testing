package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchedProductPage {
    WebDriver driver;

    public SearchedProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[text()='Searched Products']")
    private WebElement searchedProductText;

    public boolean isSearchedProductTextDisplayed(){
        return searchedProductText.isDisplayed();
    }

    private By searchProductName(String productName){
        String xpath = "//div[@class='single-products']//p[text()='"+productName+"']";
        return By.xpath(xpath);
    }

    public boolean isSearchedProductNameDisplayed(String productName){
        WebElement element = driver.findElement(searchProductName(productName));
        return element.isDisplayed();
    }
}
