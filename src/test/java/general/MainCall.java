package general;


import com.relevantcodes.extentreports.ExtentReports;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.venturedive.base.database.connection.DbOperation;
import objects.Login;
import org.openqa.selenium.support.ui.WebDriverWait;
import preReq.TestBase;

import static config.ConfigProperties.Environment;

public class MainCall {

    static ExtentReports extent;
    public static String caseID;
    public static WebDriverFactory webDriverFactory = new WebDriverFactory();
    public static SeleniumFunctions seleniumFunctions = new SeleniumFunctions();
    public static Login loginPage = new Login();
    public static GeneralFunctions generalFunctions = new GeneralFunctions();
    public static DbOperation dbOp = new DbOperation();
    public final static TestBase preReq = new TestBase();
    public final static String reportPath = System.getProperty("user.dir") + "\\reports\\ExtentReport-"+ new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss").format(Calendar.getInstance().getTime())+".html";


    public static ExtentReports startReport() {
        extent = new ExtentReports(System.getProperty("user.dir") + "/reports/ExtentReport.html", true);
             extent.addSystemInfo("Environment", Environment);
        extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));
        return extent;
    }

    public static WebDriverWait waitCall() {
        return new WebDriverWait(WebDriverFactory.getDriver(), 15);

    }

    public static ExtentReports getExtentReport() {
        if (extent != null) {
            return extent;
        } else {
            throw new IllegalStateException("Extent Report object not initialized");
        }
    }


}

