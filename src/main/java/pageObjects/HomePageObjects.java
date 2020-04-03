package pageObjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {
	
	public WebDriver driver;
	
	public HomePageObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".signin")
	WebElement signinButton;
	
	
	By Navbar = By.xpath("//ul[@class='navbarul']/li");
	
	public WebElement signInButton()
	{
		return signinButton;
	}
	
	public WebElement validateNavbarElements(String navbarLinkName)
	{
		int i;
		List<WebElement> navbar = driver.findElements(Navbar);
		for(i=0; i<navbar.size(); i++)
		{
			if(navbar.get(i).getText().equalsIgnoreCase(navbarLinkName))
			{
				break;
			}
		}
		return navbar.get(i);
		
		
	}
	

}

