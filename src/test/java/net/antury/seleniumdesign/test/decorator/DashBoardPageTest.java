package net.antury.seleniumdesign.test.decorator;

import net.antury.seleniumdesign.decorator.DashBoardPage;
import net.antury.seleniumdesign.test.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.function.Consumer;

public class DashBoardPageTest extends BaseTest {

    private DashBoardPage dashBoardPage;

    @BeforeTest
    public void setUp() {
        this.dashBoardPage = new DashBoardPage(driver);
    }

    @Test(dataProvider = "getData")
    public void roleTest(Consumer<DashBoardPage> rolePage) {
        this.dashBoardPage.goTo();
        rolePage.accept(this.dashBoardPage);
    }

    @DataProvider
    public Object[] getData() {
        return new Object[]{
                Decorators.guestPage,
                Decorators.adminPage,
                Decorators.suPage
        };
    }
}
