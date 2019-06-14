package common;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.UnreachableBrowserException;

import java.util.concurrent.TimeUnit;


public class BrowserDriver {

    private static WebDriver mDriver;

    /**********     ***************/
    @Before
    public  static WebDriver getCurrentDriver(){
        if (mDriver==null) {
            try {
                mDriver = BrowserFactory.getBrowser();
                mDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            } catch (UnreachableBrowserException e) {
                mDriver = BrowserFactory.getBrowser();
            } catch (WebDriverException e) {
                mDriver = BrowserFactory.getBrowser();
            }
        }
        return mDriver;
    }


    @After
    public static void close() {
        try {
            getCurrentDriver().close();
            mDriver = null;
        } catch (UnreachableBrowserException e) {
        }
    }

    public static void loadPage(String url){
        getCurrentDriver().get(url);
    }
}
