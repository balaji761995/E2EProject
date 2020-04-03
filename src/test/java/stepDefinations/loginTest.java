package stepDefinations;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObjects.DriverUtility;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class loginTest extends DriverUtility {

    @Given("^Initiate the chrome browser$")
    public void initiate_the_chrome_browser() throws Throwable {
    	driver = initializeBrowser();
    }

    @When("^Enter the valid user name (.+) and password (.+)$")
    public void enter_the_valid_user_name_and_password(String username, String password) throws Throwable {
    	LoginPageObjects loginPage = new LoginPageObjects(driver);
		loginPage.enterUserName().sendKeys(username);
		loginPage.enterPassword().sendKeys(password);
		loginPage.signInButton().click();
    }

    @Then("^Successfully Navigated to the HomePage$")
    public void successfully_navigated_to_the_homepage() throws Throwable {
    	System.out.println("Successfully Navigated to the HomePage");
    }

    @And("^Navigate to the Rediff Welcome page$")
    public void navigate_to_the_rediff_welcome_page() throws Throwable {
    	driver.get("http://www.rediff.com/");
    }

    @And("^Click on loginPage link$")
    public void click_on_loginpage_link() throws Throwable {
    	HomePageObjects homePage = new HomePageObjects(driver);
		homePage.signInButton().click();
    }

}