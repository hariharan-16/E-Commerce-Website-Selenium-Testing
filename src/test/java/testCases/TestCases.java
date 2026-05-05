package testCases;

import base.BaseClass;
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
        sp.enterName(Utilities.getExcelData("Sheet1", 0, 0));


        Thread.sleep(5000);
    }

}
