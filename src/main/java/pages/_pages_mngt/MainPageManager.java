package pages._pages_mngt;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import applogic.ApplicationManager1;
import pages._pages_mngt.page_factory.DisplayedElementLocatorFactory;
import pages.super_pages.MenusPage;
import pages.super_pages.Page;
import pages.usual_pages.*;
import util.ParamsUtils;
import util.SelUtils;

public class MainPageManager {

	private WebDriver driver;
	public SelUtils su;
	private Logger log;
	private ParamsUtils sessionParams;


public MenusPage menusPage;
public HomePage homePage;
public SignupLoginPage signUpLogin;
public SignupPage signupPage;
public MessagesPage messagesPage;

	public MainPageManager(ApplicationManager1 app) {
		driver = app.getDriver();
		su = app.su;
		log = app.getLogger();
		sessionParams = app.getParamsUtils();
		
		menusPage=initElements(new MenusPage(this));
		homePage =initElements(new HomePage(this));
		signUpLogin =initElements(new SignupLoginPage(this));
		signupPage =initElements(new SignupPage(this));
		messagesPage =initElements(new MessagesPage(this));
	}

	public <T extends Page> T initElements(T page) {
		PageFactory.initElements(new DisplayedElementLocatorFactory(driver, 10), page);
		return page;
	}

	public WebDriver getWebDriver() {
		return driver;
	}

	public Logger getLogger() {
		return log;
	}

	public ParamsUtils getSessionParams() {
		return sessionParams;
	}
}
