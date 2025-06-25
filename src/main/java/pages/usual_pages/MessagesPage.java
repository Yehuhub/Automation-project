package pages.usual_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages._pages_mngt.MainPageManager;
import pages.super_pages.MenusPage;

public class MessagesPage extends MenusPage {

    public enum MessagesList{
        ACCOUNT_CREATED{
            @Override
            public String toString() {
                return "ACCOUNT CREATED!";
            }
        },
        ACCOUNT_DELETED{
            @Override
            public String toString() {
                return "ACCOUNT DELETED!";
            }
        },
    }

    public MessagesPage(MainPageManager pages) {
        super(pages);
    }

    public MessagesPage ensurePageLoaded() {
        super.ensurePageLoaded();
        log.info("Ensure that messages page is displayed");
        waitBig.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-qa='continue-button']")));
        return this;
    }

    public MessagesPage verifyMessage(MessagesList message){
        log.info("Verify that " + message.toString() + " message is displayed");
        String retrievedMessage = driver.findElement(By.xpath("//h2[@class='title text-center']/b")).getText();
        Assert.assertEquals(retrievedMessage, message.toString(), "Message is not as expected");
        return this;
    }

    public HomePage clickContinueButton(){
        log.info("Click Continue button");
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
        return pages.homePage.ensurePageLoaded();
    }
}
