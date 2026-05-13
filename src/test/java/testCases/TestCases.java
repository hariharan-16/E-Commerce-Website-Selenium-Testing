package testCases;

import base.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Utilities;

import java.io.File;
import java.io.IOException;

public class TestCases extends BaseClass {

    public TestCases() throws Exception {
        super();
    }

    @Test
    public void testCase1() throws InterruptedException, IOException {
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
        Assert.assertTrue(driver.findElement(By.partialLinkText("Logged in as")).getText().contains(Utilities.getExcelData("Sheet1", 0, 0)), "Logged in as text does not contain the correct username");

//        Thread.sleep(5000);
//        sp.clickDeleteAccountButton();
//        WebElement accountDeletedText = driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
//        Assert.assertTrue(accountDeletedText.isDisplayed(), "Account Deleted text is not displayed");
//
//        Thread.sleep(5000);
//        sp.clickContinueButton();
    }

    @Test
    public void testCase2() throws InterruptedException, IOException {
        // Login with valid email and password
        hp.clickLoginOrSignupButton();
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Login to your account']")).isDisplayed(), "Login to your account text is not displayed");

        sp.enterLoginEmail(prop.getProperty("validEmail"));
        sp.enterLoginPassword(prop.getProperty("validPassword"));
        sp.clickLoginButton();
        Assert.assertTrue(driver.findElement(By.partialLinkText("Logged in as")).getText().contains(Utilities.getExcelData("Sheet1", 0, 0)), "Logged in as text does not contain the correct username");

//        sp.clickDeleteAccountButton();
//        WebElement accountDeletedText = driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
//        Assert.assertTrue(accountDeletedText.isDisplayed(), "Account Deleted text is not displayed");
//
//        Thread.sleep(5000);
//        sp.clickContinueButton();

    }

    @Test
    public void testCase3(){
        // Login with invalid email and password
        hp.clickLoginOrSignupButton();
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Login to your account']")).isDisplayed(), "Login to your account text is not displayed");

        sp.enterLoginEmail(Utilities.invalidEmail());
        sp.enterLoginPassword(Utilities.invalidPassword());
        sp.clickLoginButton();

        if(sp.invalidEmailOrPasswordTextIsDisplayed()){
            Assert.assertTrue(true);
        } else {
            Assert.fail("Invalid email or password text is not displayed");
        }
    }

    @Test
    public void testCase4() throws IOException {
        // Logout user
        hp.clickLoginOrSignupButton();
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Login to your account']")).isDisplayed(), "Login to your account text is not displayed");

        sp.enterLoginEmail(prop.getProperty("validEmail"));
        sp.enterLoginPassword(prop.getProperty("validPassword"));
        sp.clickLoginButton();
        Assert.assertTrue(driver.findElement(By.partialLinkText("Logged in as")).getText().contains(Utilities.getExcelData("Sheet1", 0, 0)), "Logged in as text does not contain the correct username");

        sp.clickLogoutButton();
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Login to your account']")).isDisplayed(), "Not navigated to Login to your account page after logout");
    }

    @Test
    public void testCase5() throws IOException {
        // Register with existing email
        hp.clickLoginOrSignupButton();
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Login to your account']")).isDisplayed(), "Login to your account text is not displayed");

        sp.enterName(Utilities.getExcelData("Sheet1", 0, 0));
        sp.enterSignupEmail(Utilities.getExcelData("Sheet1", 1, 0));
        sp.clickSignUpButton();

        if(sp.signupExistingEmailTextIsDisplayed()){
            Assert.assertTrue(true);
        }else {
            Assert.fail("Email Address already exist text is not displayed");
        }
    }

    @Test
    public void testCase6(){
        // Contact us form.
        hp.clickContactUsButton();
        if(cp.isGetInTouchHeadingDisplayed()){
            Assert.assertTrue(true);
        } else {
            Assert.fail("Get In Touch heading is not displayed. Not directed to contact us form");
        }

        cp.getNameField().sendKeys("test");
        cp.getEmailField().sendKeys("test@mail.com");
        cp.getSubjectField().sendKeys("test");
        cp.getMessageField().sendKeys("test");
        File file = new File("src/test/resources/dummyText.txt");
        cp.getInputFileField().sendKeys(file.getAbsolutePath());
        cp.getSubmitButton().click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        if(cp.isSuccessMessageDisplayed()){
            Assert.assertTrue(true);
        } else {
            Assert.fail("Success message is not displayed after submitting contact us form");
        }
        cp.getHomeButton().click();
    }

    @Test
    public void testCase7() {
        // Verify test case page
        hp.clickTestCaseButton();
        if(tp.isTestCaseHeadingDisplayed()){
            Assert.assertTrue(true);
        } else {
            Assert.fail("Test Cases heading is not displayed. Not navigated to Test Cases page");
        }
    }

    @Test
    public void testCase8(){
        // Verify all products page and product detail page
        hp.clickProductsButton();
        if(app.isAllProductsHeadingDisplayed()){
            Assert.assertTrue(true);
        } else {
            Assert.fail("All Products heading is not displayed. Not navigated to All Products page");
        }

        app.clickViewProduct("Blue Top");
        if (pdp.isProductInformationDisplayed()){
            Assert.assertTrue(true);
        } else {
            Assert.fail("Product Information is not displayed. Not navigated to product detail page");
        }
    }

    @Test
    public void testCase9(){
        // Search products
        hp.clickProductsButton();

        app.enterProductNameInSearchField("Men Tshirt");
        app.clickSearchButton();

        if(spp.isSearchedProductTextDisplayed()){
            Assert.assertTrue(true);
        } else {
            Assert.fail("Searched Products text is not displayed. Not navigated to searched products page");
        }

        if(spp.isSearchedProductNameDisplayed("Men Tshirt")){
            Assert.assertTrue(true);
        }else {
            Assert.fail("Searched product name is not displayed in searched products page");
        }
    }

    @Test
    public void testCase10(){
        // Verify subscription in home page
        Utilities.scrollToElement(driver, hp.getSubscriptionText());
        if (hp.getSubscriptionText().isDisplayed()){
            Assert.assertTrue(true);
        } else {
            Assert.fail("Subscription text is not displayed in home page");
        }

        hp.sendSubscriptionText("test@mail.com");
        hp.clickSubscribeButton();

        if(hp.isSubscriptionSuccessMessageDisplayed()){
            Assert.assertTrue(true);
        } else {
            Assert.fail("Subscription success message is not displayed after subscribing");
        }
    }

    @Test
    public void testCase11(){
        // Verify subscription in cart page
        hp.clickCartButton();
        if (cap.getSubscriptionText().isDisplayed()){
            Assert.assertTrue(true);
        } else {
            Assert.fail("Subscription text is not displayed in Cart page");
        }

        cap.sendSubscriptionText("test@mail.com");
        cap.clickSubscribeButton();

        if(cap.isSubscriptionSuccessMessageDisplayed()){
            Assert.assertTrue(true);
        } else {
            Assert.fail("Subscription success message is not displayed after subscribing");
        }
    }

}
