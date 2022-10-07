package general;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import static config.ConfigProperties.*;

public class WebDriverFactory {
    static WebDriver driver;
    static String device = Device; // Change to windows or mac accordingly

    static Boolean headless = Boolean.valueOf(isHeadless);

    // static String chromeDriverPath = device.equals("Windows") ? "driver/chromedriver.exe" : "driver/chromedriver";
    // static String geckoDriverPath = device.equals("Windows") ? "driver/geckodriver.exe" : "driver/geckodriver";

    public static final String USERNAME = "alvinakamran1";
    public static final String AUTOMATE_KEY = "J26gKTS1gDw9WVEEcsYx";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver getInstance() throws MalformedURLException {
        finishDriver();
        WebDriverManager.chromedriver().setup();
        ChromeOptions op = new ChromeOptions();

        if(headless)
            op.addArguments("--headless");

        switch (Browser)
        {
            case "Chrome":
                // System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                op.addArguments("--start-maximized");
                driver = new ChromeDriver(op);
                break;

            case "IE":
                driver = new InternetExplorerDriver();
                break;

            case "Firefox":
                // System.setProperty("webdriver.gecko.driver", geckoDriverPath);
                op.addArguments("--start-maximized");
                File filef = new File("driver/geckodriver");
                System.setProperty("webdriver.gecko.driver", filef.getAbsolutePath());
                driver = new FirefoxDriver();
                break;

            case "Edge":
                File file = new File("driver/msedgedriver");
                System.setProperty("webdriver.edge.driver", file.getAbsolutePath());
                driver = new EdgeDriver();
                break;


            case "Remote":
                DesiredCapabilities caps = DesiredCapabilities.chrome();
                caps.setCapability("browser", "Chrome");
                caps.setCapability("browser_version", "78.0 beta");
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("resolution", "1024x768");
                driver = new RemoteWebDriver(new URL(URL), caps);

        }


        driver.get(webAssignmentUrl);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return driver;
    }





    public static void startDriver()  {
        ChromeOptions op = new ChromeOptions();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        if(device .equals("linux"))
        {
            // chromeDriverPath = "driver/chromedriver_linux";
        }

        if (driver == null) {
            // System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            if (device.equals("Windows")) {
                op.addArguments("--start-maximized");
            }
            else
                op.addArguments("start-fullscreen");
            if(headless)
                op.addArguments("--headless");

            driver = new ChromeDriver(op);

        } else

        {
            throw new IllegalStateException("Driver has already been initialized. Quit it before using this method");
        }}


    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        }
        else
        {
            throw new IllegalStateException("Driver has not been initialized");
        }
    }


    public static void finishDriver()
    {
        if (driver != null)
        {
            driver.quit();
//            driver = null;
        }
    }

}
