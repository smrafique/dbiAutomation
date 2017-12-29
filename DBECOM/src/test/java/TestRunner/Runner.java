package TestRunner;

import Configs.Select;
import com.cucumber.listener.Reporter;
import com.sun.jmx.snmp.Timestamp;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)

@CucumberOptions(
        monochrome=true,
        features = "src/Features",
        glue = "stepDefinition",
        tags = {"@Smoke"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/Reports/report.html"},
        format={"json:target/Reports/cucumber.json"}
        )
public class Runner extends Select {



        @BeforeClass
        public static void setUp(){
//                driver = Browser(Select.eql.Chrome);
//                driver.manage().window().maximize();

        }

        @AfterClass
        public static void tearDown(){
                Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
                Reporter.setSystemInfo("user", System.getProperty("user.name"));
                Reporter.setSystemInfo("os", "Mac OSX");
                Reporter.setTestRunnerOutput("Sample test runner output message");
                //driver.quit();
        }


}