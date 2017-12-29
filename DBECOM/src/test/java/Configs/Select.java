package Configs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class Select {

    public static WebDriver driver;
    public enum eql {Chrome, IE, fireFox}

    public static WebDriver Browser(eql eq){
        switch (eq){
            case Chrome:
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case IE:
                System.setProperty("webdriver.ie.driver", "src/main/resources/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                break;
            case fireFox:
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
                default:
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }



}
