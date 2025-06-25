package tests.basic;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.usual_pages.MessagesPage;
import pages.usual_pages.SignupPage;
import tests.supers.TestBase;
import util.GenUtils;


public class PageObjectCode extends TestBase {

	private final static String SITE_NAME ="https://www.automationexercise.com/";
	private String fullName;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String company;
	private String address;
	private String country;
	private String state;
	private String city;
	private String zipCode;
	private String mobileNumber;
	private String day;
	private String month;
	private String year;
	private SignupPage.Title title;
	private MessagesPage.MessagesList message;



	@Test
	public void test() {
		try {

			initParameters();

			WebDriver driver = app.getDriver();

			log.info("Opening site '"+ SITE_NAME +"'...");
			driver.get(SITE_NAME);

			app.pages().homePage.ensurePageLoaded()
					.clickSignupLogin()
					.fillName(fullName)
					.fillEmail(email)
					.clickSignupButton()
					.tickTitle(title)
					.fillPassword(password)
					.fillDay(day)
					.fillMonth(month)
					.fillYear(year)
					.tickNewsletter()
					.fillFirstName(firstName)
					.fillLastName(lastName)
					.fillCompany(company)
					.fillAddress(address)
					.selectCountry(country)
					.fillState(state)
					.fillCity(city)
					.fillZipcode(zipCode)
					.fillMobileNumber(mobileNumber)
					.clickCreateAccountButton()
					.verifyMessage(message)
					.clickContinueButton()
					.verifyLogoutButton()
					.verifyDeleteAccountButton();

			endTestSuccess();
		} catch (Throwable t) {
			onTestFailure(t);
		}
	}

	private void initParameters() {
		String timestamp = GenUtils.getCurrentTimestamp(GenUtils.TIME_FORMAT_ddMMyyHHmmSSS);
		fullName = "John Doe" ;
		email = "John" + timestamp + "@Doe.com";
		password = "123456";
		firstName = "John";
		lastName = "Doe";
		company = "John Concrete Ltd.";
		address = "25 Sydney Rd.";
		country = "Australia";
		state = "Victoria";
		city = "Melbourne";
		zipCode = "3672";
		mobileNumber = "0431337288";
		day = "11";
		month = "November";
		year = "1995";
		title = SignupPage.Title.MR;
		message = MessagesPage.MessagesList.ACCOUNT_CREATED;
	}
}
