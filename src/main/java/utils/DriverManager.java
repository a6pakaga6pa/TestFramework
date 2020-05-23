package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    private static WebDriver driver;
    private EventFiringWebDriver eventFiringWebDriver;
    private static BrowserName useThisDriver = null;
    public static String browserPropertyName = "browser";
    public enum BrowserName {CHROME, FIREFOX, EDGE, BROWSERSTACK}

    public static WebDriver getDriver(){
        String defaultBrowser = System.getProperty(browserPropertyName, "CHROME");
        switch(defaultBrowser){
            case "CHROME": {
                System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
                driver = new ChromeDriver();
                return driver;
            }
            case "FIREFOX": {
                System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
                driver = new FirefoxDriver();
                return driver;
            }
            case "EDGE": {
                System.setProperty("webdriver.edge.driver", "resources/msedgedriver.exe");
                driver = new EdgeDriver();
                return driver;
            }
            case "BROWSERSTACK": {
                String USERNAME = "******";
                String AUTOMATE_KEY = "********";
                String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("browser", "Chrome");
                caps.setCapability("browser_version", "81.0");
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("resolution", "1024x768");
                caps.setCapability("name", "Bstack-[Java] Sample Test");

                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                    return driver;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
            default: {
                throw new RuntimeException("Unknown Browser in" + browserPropertyName + ": " + defaultBrowser);
            }
        }
    }

    public static WebDriver getDriver(BrowserName browser){
        switch(browser){
            case CHROME: {
                System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
                driver = new ChromeDriver();
                return driver;
            }
            case FIREFOX: {
                System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
                driver = new FirefoxDriver();
                return driver;
            }
            case EDGE: {
                System.setProperty("webdriver.edge.driver", "resources/msedgedriver.exe");
                driver = new EdgeDriver();
                return driver;
            }
            case BROWSERSTACK: {
                //USERNAME and AUTOMATE_KEY are hidden for purpose
                String USERNAME = "******";
                String AUTOMATE_KEY = "********";
                String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("browser", "Chrome");
                caps.setCapability("browser_version", "81.0");
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("resolution", "1024x768");
                caps.setCapability("name", "Bstack-[Java] Sample Test");
                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                    return driver;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
            default: {
                System.out.println("Unsupported driver: " + useThisDriver.toString() + " is chosen");
                driver = getDriver();
                return driver;
            }
        }
    }

    private static ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        // options.setHeadless(true);
        return options;
    }

    public static void quit(){
        if(driver!=null){
            try{
                driver.quit();
                driver=null;
            }catch(Exception e){
            }

        }
    }


}
