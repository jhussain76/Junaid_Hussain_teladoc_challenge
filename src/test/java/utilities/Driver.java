package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    /*
    Creating the private constructor so this class' object
    is not reachable from outside
     */
    private Driver(){}

    /*
    Making our 'driver' instance private so that it is not reachable from outside of the class.
    We make it static, because we want it to run before everything else, and also we will use it in a static method
     */
    private static WebDriver driver;

    /*
    Creating re-usable utility method that will return same 'driver' instance everytime we call it.
     */
    public static WebDriver getDriver(){

        if (driver == null){

            /*
            We read our browser type from configuration.properties file using
            .getProperty method we creating in ConfigurationReader class.
             */
            String browserType = utilities.ConfigurationReader.getProperty("browser");

            /*
            Depending on the browser type our switch statement will determine
            to open specific type of browser/driver
             */
            switch (browserType){
                case "chrome-remote":
                    try{
                        URL url = new URL("http://35.153.50.112:4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        driver = new RemoteWebDriver(url,desiredCapabilities);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }
        }

        /*
        Same driver instance will be returned every time we call Driver.getDriver(); method
         */
        return driver;


    }

    /*
    This method makes sure we have some form of driver sesion or driver id has.
    Either null or not null it must exist.
     */
    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }


}
