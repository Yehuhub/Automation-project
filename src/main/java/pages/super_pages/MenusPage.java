package pages.super_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages._pages_mngt.MainPageManager;
import pages.usual_pages.HomePage;
import pages.usual_pages.SignupLoginPage;

public class MenusPage extends AnyPage{

	public MenusPage(MainPageManager pages) {
		super(pages);
	}


	public MenusPage ensurePageLoaded() {
		super.ensurePageLoaded();
		waitBig.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body")));
		return this;
	}

	public SignupLoginPage clickSignupLogin() {
		log.info("Click Signup/Login link");
		driver.findElement(By.xpath("//a[@href='/login']")).click();
		return pages.signUpLogin.ensurePageLoaded();
	}

	public MenusPage verifyLogoutButton(){
		log.info("Verify Logout button is displayed");
		driver.findElement(By.xpath("//a[@href='/logout']"));
		return this;
	}
	public MenusPage verifyDeleteAccountButton(){
		log.info("Verify Delete Account Button button is displayed");
		driver.findElement(By.xpath("//a[@href='/delete_account']"));
		return this;
	}

}
