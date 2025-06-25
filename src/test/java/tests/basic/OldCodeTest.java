package tests.basic;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import tests.supers.TestBase;
import util.GenUtils;

public class OldCodeTest extends TestBase {

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
	private String date;
	private String day;
	private String month;
	private String year;

	private final static String SITE_NAME ="https://www.automationexercise.com/";

	@Test
	public void test() {
		try {

			initParameter();

			WebDriver driver = app.getDriver();

			final String ACCOUNT_CREATED = "ACCOUNT CREATED!";

			log.info("Opening site '"+ SITE_NAME +"'...");
			driver.get(SITE_NAME);

			log.info("Verify that home page is displayed");
			driver.findElement(By.className("features_items"));

			log.info("Find Signup/Login link");
			driver.findElement(By.xpath("//a[@href='/login']")).click();


			driver.findElement(By.className("signup-form"));
			log.info("Signup form opened successfully");

			//fill name field
			log.info("Fill Name: " + fullName);
			driver.findElement(By.xpath("//form[@action='/signup']/input[@name='name']")).sendKeys(fullName);

			//fill email field
			log.info("find email field and fill: " + email);
			driver.findElement(By.xpath("//form[@action='/signup']/input[@type='email']")).sendKeys(email);

			//click signup button
			log.info("Click Signup button");
			driver.findElement(By.xpath("//form[@action='/signup']/button")).click();

			log.info("Verify that big signup form is displayed");
			driver.findElement(By.xpath("//button[@data-qa='create-account']"));

			log.info("Tick title: Mr.");
			driver.findElement(By.cssSelector("#id_gender1")).click();

			log.info("Fill password: " + password);
			driver.findElement(By.id("password")).sendKeys(password);

			log.info("Fill date of birth: " + date);
			log.info("Fill day: " + day);
			WebElement days =  driver.findElement(By.id("days"));
			Select dropdown = new Select(days);
			dropdown.selectByValue(day);

			log.info("Fill month: " + month);
			WebElement months =  driver.findElement(By.id("months"));
			dropdown = new Select(months);
			dropdown.selectByVisibleText(month);

			log.info("Fill year: " + year);
			WebElement years =  driver.findElement(By.id("years"));
			dropdown = new Select(years);
			dropdown.selectByValue(year);

			log.info("Tick Sign up for our newsletter!");
			driver.findElement(By.xpath("//label[@for='newsletter']")).click();

			log.info("Fill first name: " + firstName);
			driver.findElement(By.id("first_name")).sendKeys(firstName);

			log.info("Fill last name: " + lastName);
			driver.findElement(By.id("last_name")).sendKeys(lastName);

			log.info("Fill company: " + company);
			driver.findElement(By.id("company")).sendKeys(company);

			log.info("Fill address: " + address);
			driver.findElement(By.id("address1")).sendKeys(address);

			log.info("Select country: " + country);
			WebElement countryElement =  driver.findElement(By.id("country"));
			dropdown = new Select(countryElement);
			dropdown.selectByValue(country);

			log.info("Fill state: " + state);
			driver.findElement(By.id("state")).sendKeys(state);

			log.info("Fill city: " + city);
			driver.findElement(By.id("city")).sendKeys(city);

			log.info("Fill zip code: " + zipCode);
			driver.findElement(By.id("zipcode")).sendKeys(zipCode);

			log.info("Fill mobile number: " + mobileNumber);
			driver.findElement(By.id("mobile_number")).sendKeys(mobileNumber);

			log.info("Click Create Account button");
			driver.findElement(By.xpath("//form[@action='/signup']")).submit();

			log.info("Verify account created successfully");
			String retrievedText = driver.findElement(By.xpath("//h2[@data-qa='account-created']/b")).getText();
			Assert.assertEquals(retrievedText, ACCOUNT_CREATED, "Expected text: " + ACCOUNT_CREATED + " but found: " + retrievedText);

			log.info("Finish registration by clicking continue button");
			driver.findElement(By.cssSelector(".btn-primary")).click();

			log.info("Verify main page is displayed");
			driver.findElement(By.className("features_items"));

			log.info("Verify Logout button is displayed");
			driver.findElement(By.xpath("//a[@href='/logout']"));

			log.info("Verify Delete Account button is displayed");
			driver.findElement(By.xpath("//a[@href='/delete_account']"));


			endTestSuccess();
		} catch (Throwable t) {
			onTestFailure(t);
		}
	}

	private void initParameter() {
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
		date = "11/11/1995";
		day = "11";
		month = "November";
		year = "1995";
	}
}
