package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {
	
	public WebDriver driver;
	
	@FindBy(css="[name='login']")
	WebElement login;
	
	@FindBy(css="[name='passwd']")
	WebElement password;
	
	@FindBy(css=".signinbtn")
	WebElement signInButton;
	
	@FindBy(xpath="//div[@id='div_login_error']/b")
	WebElement loginError;
	
	public LoginPageObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement enterUserName()
	{
		return login;
	}
	
	public WebElement enterPassword()
	{
		return password;
	}
	
	public WebElement signInButton()
	{
		return signInButton;
	}
	public WebElement loginErrorMsg()
	{
		return loginError;
	}

}
