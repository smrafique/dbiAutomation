package stepDefinition;

import Configs.Select;
import Utils.ElementMantainance;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Steps extends ElementMantainance {



    @Given("^User Open any browser$")
    public void user_Open_any_browser(){
        driver = Browser(eql.Chrome);
        driver.manage().window().maximize();
    }


    // Canadian Home page
    @Given("^User goes to canadian David's Bridal home page$")
    public void user_goes_to_canadian_David_s_Bridal_home_page(){
        driver.get("http://dbqa7.davidsbridal.ca");

    }

    @When("^User scroll down to bottom of the page and click on the \\*Contact Us\\* link on the Footer section$")
    public void user_scroll_down_to_bottom_of_the_page_and_click_on_the_Contact_Us_link_on_the_Footer_section() {

        if(driver.findElement(By.cssSelector("#dijit_Dialog_0 > div.dijitDialogPaneContent > a")).isDisplayed()){
            ElementNeedsToBeClicked(webElement("css", "#dijit_Dialog_0 > div.dijitDialogPaneContent > a"));
            ElementNeedsToBeClicked(webElement("link", "Contact Us"));

        }
        else {
            ElementNeedsToBeClicked(webElement("link", "Contact Us"));
        }
    }

    @Then("^User verify the page title is Contact Us$")
    public void user_verify_the_page_title_is_Contact_Us()  {
        String title = driver.getTitle();

        Assert.assertEquals("Contact Us",title);
    }
    @And("^user closes the browser$")
    public void user_closes_the_browser(){
        driver.quit();
    }


    // UK home page
    @Given("^User goes to UK David's Bridal home page$")
    public void user_goes_to_UK_David_s_Bridal_home_page()  {
        driver.get("http://dbqa7.davidsbridal.co.uk");
    }


}
