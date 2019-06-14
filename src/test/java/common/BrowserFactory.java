package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;


public  class BrowserFactory    {

    private static final String BROWSER_PROP_KEY = "browser";
    private static final String RUNLOCATION_PROP_KEY = "runLocation";
    private static final String ENVIRONEMNT_PROP_KEY = "envType";

    /**
     * creates the browser driver specified in the system property "browser"
     * if no property is set then a firefox browser driver is created.
     * The allow properties are firefox, safari and chrome
     * e.g to run with chrome, pass in the option -Dbrowser=chrome at runtime
     * @return WebDriver
     */


    public static WebDriver getBrowser() {
                WebDriver driver;
                String browser = System.getProperty(BROWSER_PROP_KEY);
                switch (browser) {
                    case "chrome":
                        driver = createChromeDriver();
                        break;
                    case "ie":
                        driver = createIEDriver();
                        break;
                    case "Firefox":
                        driver = createFirefoxDriver();
                        break;
                    default:
                        driver = createFirefoxDriver();
                         break;
                }
                    addAllBrowserSetup(driver);
                return driver;

    }

    private static WebDriver createChromeDriver() {

        String runLocation = System.getProperty(RUNLOCATION_PROP_KEY);
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        switch (runLocation) {
            case "local":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");
                cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
                cap.setJavascriptEnabled(true);
                cap.setBrowserName("chrome");
                return new ChromeDriver(cap);
            case "remote":
                // pending: code to execute the scripts remotly
                // Either from SauceLabs / Seetest /Browserstack / selenium grid etc..
            default:
                return null;
        }

    }

//
    private static WebDriver createIEDriver() {

        return new InternetExplorerDriver();
    }

    private static WebDriver createFirefoxDriver() {
        return  new FirefoxDriver();
    }



    private static void addAllBrowserSetup(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
}
