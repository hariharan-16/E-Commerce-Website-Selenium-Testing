package testCases;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Utilities;

public class TestCases extends BaseClass {

    public TestCases() throws Exception {
        super();
    }

    @Test
    public void testCase1() throws InterruptedException {
        // Register User
        hp.clickLoginOrSignupButton();
        WebElement signUpText = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        Assert.assertTrue(signUpText.isDisplayed(), "Sign Up text is not displayed");

        sp.enterName(Utilities.getExcelData("Sheet1", 0, 0));
        sp.enterSignupEmail(Utilities.getExcelData("Sheet1", 1, 0));
        Thread.sleep(5000);
        sp.clickSignUpButton();
        WebElement accountInfoText = driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
        Assert.assertTrue(accountInfoText.isDisplayed(), "Account Information text is not displayed");

        sp.selectTitleMr();
        sp.enterPassword(Utilities.getExcelData("Sheet1", 2, 0));
        sp.chooseDOB();
        sp.enterFirstName(Utilities.getExcelData("Sheet1", 3, 0));
        sp.enterLastName(Utilities.getExcelData("Sheet1", 4, 0));
        sp.enterAddressOne(Utilities.getExcelData("Sheet1", 5, 0));
        sp.chooseCountry();
        sp.enterState(Utilities.getExcelData("Sheet1", 6, 0));
        sp.enterCity(Utilities.getExcelData("Sheet1", 7, 0));
        sp.enterZipCode(Utilities.getExcelData("Sheet1", 8, 0));
        sp.enterMobileNumber(Utilities.getExcelData("Sheet1", 9, 0));
        Thread.sleep(5000);
        sp.clickCreateAccountButton();
        WebElement accountCreatedText = driver.findElement(By.xpath("//b[text()='Account Created!']"));
        Assert.assertTrue(accountCreatedText.isDisplayed(), "Account Created text is not displayed");

        Thread.sleep(5000);
        sp.clickContinueButton();

        Thread.sleep(5000);
        sp.clickDeleteAccountButton();
        WebElement accountDeletedText = driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
        Assert.assertTrue(accountDeletedText.isDisplayed(), "Account Deleted text is not displayed");

        Thread.sleep(5000);
        sp.clickContinueButton();
    }

}
