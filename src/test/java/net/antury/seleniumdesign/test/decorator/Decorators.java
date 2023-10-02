package net.antury.seleniumdesign.test.decorator;

import net.antury.seleniumdesign.decorator.DashBoardPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.function.Consumer;

public class Decorators {

    private static void shouldDisplay(List<WebElement> elements) {
        elements.forEach(element -> Assert.assertTrue(element.isDisplayed()));
    }

    private static void shouldNotDisplay(List<WebElement> elements) {
        elements.forEach(element -> Assert.assertFalse(element.isDisplayed()));
    }

    //Ingredients
    private static final Consumer<DashBoardPage> adminComponentPresent = dashBoardPage -> shouldDisplay(dashBoardPage.getAdminComponents());
    private static final Consumer<DashBoardPage> adminComponentNotPresent = dashBoardPage -> shouldNotDisplay(dashBoardPage.getAdminComponents());
    private static final Consumer<DashBoardPage> guestComponentPresent = dashBoardPage -> shouldDisplay(dashBoardPage.getGuestComponents());
    private static final Consumer<DashBoardPage> guestComponentNotPresent = dashBoardPage -> shouldNotDisplay(dashBoardPage.getGuestComponents());
    private static final Consumer<DashBoardPage> suComponentPresent = dashBoardPage -> shouldDisplay(dashBoardPage.getSuperUserComponents());
    private static final Consumer<DashBoardPage> suComponentNotPresent = dashBoardPage -> shouldNotDisplay(dashBoardPage.getSuperUserComponents());

    private static final Consumer<DashBoardPage> adminSelection = dashBoardPage -> dashBoardPage.selectRole("admin");
    private static final Consumer<DashBoardPage> suSelection = dashBoardPage -> dashBoardPage.selectRole("superuser");
    private static final Consumer<DashBoardPage> guestSelection = dashBoardPage -> dashBoardPage.selectRole("guest");

    //user role pages
    public static final Consumer<DashBoardPage> guestPage = guestSelection.andThen(guestComponentPresent).andThen(suComponentNotPresent).andThen(adminComponentNotPresent);
    public static final Consumer<DashBoardPage> adminPage = adminSelection.andThen(adminComponentPresent).andThen(suComponentPresent).andThen(guestComponentPresent);
    public static final Consumer<DashBoardPage> suPage = suSelection.andThen(suComponentPresent).andThen(guestComponentPresent).andThen(adminComponentNotPresent);
}
