package net.antury.seleniumdesign.test.command;

import net.antury.seleniumdesign.command.HomePage;
import net.antury.seleniumdesign.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CommandTest extends BaseTest {

    private HomePage homePage;

    @BeforeTest
    public void setHomePage() {
        this.homePage = new HomePage(driver);
    }

    @Test
    public void homePageTest() {
        this.homePage.goTo();
        this.homePage.getElementValidators()
                .stream()
                .parallel()
                .map(elementValidator -> elementValidator.validate())
                .forEach(result -> Assert.assertTrue(result));
    }
}
