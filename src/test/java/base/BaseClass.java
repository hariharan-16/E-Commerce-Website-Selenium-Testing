package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    public WebDriver driver;
    public Properties prop;
    FileInputStream file;

    public BaseClass() throws IOException {
        prop = new Properties();
        file = new FileInputStream("src/test/resources/testData.prop");
        prop.load(file);
    }

    @BeforeMethod
    public void setUp() throws IOException {
        driver = initializeBrowser(prop.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT));
        driver.get(prop.getProperty("url"));
    }

    @AfterMethod
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

    public WebDriver initializeBrowser(String browser){
        //WebDriverManager.chromedriver().setup(); // Automatically manages the ChromeDriver version based on the installed Chrome browser
        WebDriverManager.chromedriver().browserVersion("147").setup(); // Forcing a specific version of ChromeDriver
        WebDriverManager.firefoxdriver().setup();

        if(browser.equals("chrome")){
            driver = WebDriverManager.chromedriver().create();
        } else if(browser.equals("firefox")){
            driver = WebDriverManager.firefoxdriver().create();
        }

        return driver;
    }

}
