package net.antury.seleniumdesign.test.template;

import net.antury.seleniumdesign.template.AmazonShopping;
import net.antury.seleniumdesign.template.EbayShopping;
import net.antury.seleniumdesign.template.ShoppingTemplate;
import net.antury.seleniumdesign.test.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TemplateTest extends BaseTest {

    @Test(dataProvider = "getData")
    public void shoppingTest(ShoppingTemplate shoppingTemplate) {
        shoppingTemplate.shop();
    }

    @DataProvider
    public Object[] getData() {
        return new Object[]{
                new AmazonShopping(driver, "Samsung"),
                new EbayShopping(driver, "iPhone 14")
        };
    }
}
