package pages.usual_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages._pages_mngt.MainPageManager;
import pages.super_pages.MenusPage;

public class SignupLoginPage extends MenusPage {

    public SignupLoginPage(MainPageManager pages){
        super(pages);
    }

    public SignupLoginPage ensurePageLoaded() {
        super.ensurePageLoaded();
        log.info("Ensure that Signup/Login page is displayed");
        waitBig.until(ExpectedConditions.presenceOfElementLocated(By.className("signup-form")));
        return this;
    }

    public SignupLoginPage fillName(String name) {
        log.info("Fill Name: " + name);
        driver.findElement(By.xpath("//form[@action='/signup']/input[@name='name']")).sendKeys(name);
        return this;
    }

    public SignupLoginPage fillEmail(String email) {
        log.info("Fill Email: " + email);
        driver.findElement(By.xpath("//form[@action='/signup']/input[@name='email']")).sendKeys(email);
        return this;
    }

    public SignupPage clickSignupButton() {
        log.info("Click Signup button");
        driver.findElement(By.xpath("//form[@action='/signup']/button")).click();
        return pages.signupPage.ensurePageLoaded();
    }
}
