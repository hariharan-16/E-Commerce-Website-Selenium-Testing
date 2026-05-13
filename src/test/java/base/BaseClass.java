package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import utilities.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    public WebDriver driver;
    public Properties prop;

    public WebDriver getDriver() {
        return driver;
    }

    public FileInputStream propFile, excelFile;
    public static XSSFWorkbook wb;

    public HomePage hp;
    public LoginOrSignUpPage sp;
    public ContactUsPage cp;
    public TestCasePage tp;
    public AllProductsPage app;
    public ProductsDetailPage pdp;
    public SearchedProductPage spp;
    public CartPage cap;

    public BaseClass() throws IOException {
        prop = new Properties();
        propFile = new FileInputStream("src/test/resources/testData.prop");
        prop.load(propFile);
    }

    @BeforeMethod
    public void setUp() throws IOException {
        driver = initializeBrowser(prop.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT));
        driver.get(prop.getProperty("url"));

        hp = new HomePage(driver);
        sp = new LoginOrSignUpPage(driver);
        cp = new ContactUsPage(driver);
        tp = new TestCasePage(driver);
        app = new AllProductsPage(driver);
        pdp = new ProductsDetailPage(driver);
        spp = new SearchedProductPage(driver);
        cap = new CartPage(driver);

        excelFile = new FileInputStream("src/test/resources/testData.xlsx");
        wb = new XSSFWorkbook(excelFile);
    }

    @AfterMethod
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

    public WebDriver initializeBrowser(String browser){
        //WebDriverManager.chromedriver().setup(); // Automatically manages the ChromeDriver version based on the installed Chrome browser
        //WebDriverManager.chromedriver().browserVersion("148").setup(); // Forcing a specific version of ChromeDriver

        if(browser.equalsIgnoreCase("chrome")){
            driver = WebDriverManager.chromedriver().browserVersion("147").create();
        } else if(browser.equalsIgnoreCase("firefox")){
            driver = WebDriverManager.firefoxdriver().create();
        }

        return driver;
    }

}
