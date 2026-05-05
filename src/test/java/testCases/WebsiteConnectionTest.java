package testCases;

import base.BaseClass;
import org.testng.annotations.Test;
import pages.HomePage;

public class WebsiteConnectionTest extends BaseClass {
    public WebsiteConnectionTest() throws Exception {
        super();
    }

    @Test
    public void testCase() {
        hp.clickLoginOrSignupButton();
        System.out.println("Successfully connected to the website: " + driver.getCurrentUrl());
    }
}
