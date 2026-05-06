package reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ExtentReporter {
    public static ExtentReports extentReporter() throws IOException {
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("src/test/resources/testData.prop");
        prop.load(file);

        ExtentSparkReporter spark = new ExtentSparkReporter("report.html");
        spark.config().setTheme(Theme.DARK);
        spark.config().setReportName("Test Results");
        spark.config().setDocumentTitle("Automation result");
        spark.config().setTimeStampFormat("dd/MM/YYYY hh:mm:ss");

        ExtentReports report = new ExtentReports();
        report.attachReporter(spark);
        report.setSystemInfo("App URL", prop.getProperty("url"));
        report.setSystemInfo("Browser Name", prop.getProperty("browser"));
        report.setSystemInfo("Email", prop.getProperty("validEmail"));
        report.setSystemInfo("Password", prop.getProperty("validPassword"));
        report.setSystemInfo("Operating System", System.getProperty("os.name"));
        report.setSystemInfo("Username", System.getProperty("user.name"));
        report.setSystemInfo("Java version", System.getProperty("java.version"));

        return report;
    }
}
