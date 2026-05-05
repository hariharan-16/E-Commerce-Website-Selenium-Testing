package testCases;

import base.BaseClass;
import org.testng.annotations.Test;

public class WebsiteConnectionTest extends BaseClass {
    public WebsiteConnectionTest() throws Exception {
        super();
    }

    @Test
    public void testCase() {
        System.out.println("Successfully connected to the website: " + driver.getCurrentUrl());
    }
}
