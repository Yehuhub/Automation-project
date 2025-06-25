package pages.usual_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pages._pages_mngt.MainPageManager;
import pages.super_pages.MenusPage;

public class SignupPage extends MenusPage {

    public enum Title {
        MR {
            @Override
            public String toString() {
                return "Mr.";
            }

            @Override
            public String toCssSelector() {
                return "#id_gender1";
            }
        },
        MRS {
            @Override
            public String toString() {
                return "Mrs.";
            }

            @Override
            public String toCssSelector() {
                return "#id_gender2";
            }

        };

        public abstract String toCssSelector();
    }

        public SignupPage(MainPageManager pages) {
        super(pages);
    }

    public SignupPage ensurePageLoaded() {
        super.ensurePageLoaded();
        log.info("Ensure that Signup page is displayed");
        waitBig.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-qa='create-account']")));
        return this;
    }

    public SignupPage tickTitle(Title title){
        log.info("Tick title: " + title.toString());
        driver.findElement(By.cssSelector(title.toCssSelector())).click();
        return this;
    }

    public SignupPage fillPassword(String password){
        log.info("Fill password: " + password);
        driver.findElement(By.id("password")).sendKeys(password);
        return this;
    }

    public SignupPage fillDay(String day){
        log.info("Fill day: " + day);
        WebElement days =  driver.findElement(By.id("days"));
        Select dropdown = new Select(days);
        dropdown.selectByVisibleText(day);
        return this;
    }

    public SignupPage fillMonth(String month){
        log.info("Fill month: " + month);
        WebElement months =  driver.findElement(By.id("months"));
        Select dropdown = new Select(months);
        dropdown.selectByVisibleText(month);
        return this;
    }

    public SignupPage fillYear(String year){
        log.info("Fill year: " + year);
        WebElement years =  driver.findElement(By.id("years"));
        Select dropdown = new Select(years);
        dropdown.selectByVisibleText(year);
        return this;
    }

    public SignupPage tickNewsletter(){
        log.info("Tick Sign up for our newsletter!");
        driver.findElement(By.xpath("//label[@for='newsletter']")).click();
        return this;
    }

    public SignupPage fillFirstName(String firstName){
        log.info("Fill first name: " + firstName);
        driver.findElement(By.id("first_name")).sendKeys(firstName);
        return this;
    }

    public SignupPage fillLastName(String lastName){
        log.info("Fill last name: " + lastName);
        driver.findElement(By.id("last_name")).sendKeys(lastName);
        return this;
    }

    public SignupPage fillCompany(String company){
        log.info("Fill company: " + company);
        driver.findElement(By.id("company")).sendKeys(company);
        return this;
    }

    public SignupPage fillAddress(String address){
        log.info("Fill address: " + address);
        driver.findElement(By.id("address1")).sendKeys(address);
        return this;
    }

    public SignupPage selectCountry(String country){
        log.info("Select country: " + country);
        WebElement countryElement =  driver.findElement(By.id("country"));
        Select dropdown = new Select(countryElement);
        dropdown.selectByValue(country);
        return this;
    }

    public SignupPage fillState(String state){
        log.info("Fill state: " + state);
        driver.findElement(By.id("state")).sendKeys(state);
        return this;
    }

    public SignupPage fillCity(String city){
        log.info("Fill city: " + city);
        driver.findElement(By.id("city")).sendKeys(city);
        return this;
    }

    public SignupPage fillZipcode(String zipcode){
        log.info("Fill zipcode: " + zipcode);
        driver.findElement(By.id("zipcode")).sendKeys(zipcode);
        return this;
    }

    public SignupPage fillMobileNumber(String mobileNumber){
        log.info("Fill mobile number: " + mobileNumber);
        driver.findElement(By.id("mobile_number")).sendKeys(mobileNumber);
        return this;
    }

    public MessagesPage clickCreateAccountButton(){
        log.info("Click Create Account button");
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
        return pages.messagesPage.ensurePageLoaded();
    }
}
