package net.antury.seleniumdesign.test.strategy;

import net.antury.seleniumdesign.strategy.CreditCard;
import net.antury.seleniumdesign.strategy.NetBanking;
import net.antury.seleniumdesign.strategy.PaymentOption;
import net.antury.seleniumdesign.strategy.PaymentScreen;
import net.antury.seleniumdesign.test.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

import java.util.Map;

public class PaymentScreenTest extends BaseTest {
    private PaymentScreen paymentScreen;

    @BeforeTest
    public void setPaymentScreen(){
        this.paymentScreen = new PaymentScreen(this.driver);
    }

    @Test(dataProvider = "getData")
    public void paymentTest(PaymentOption paymentOption, Map<String, String> paymentDetails){
        this.paymentScreen.goTo();
        this.paymentScreen.getUserInformation().enterDetails("wilson", "antury", "wilantury@gmail.com");
        this.paymentScreen.setPaymentOption(paymentOption);
        this.paymentScreen.pay(paymentDetails);
        String orderNumber = this.paymentScreen.getOrder().placeOrder();
        System.out.println("Order number: " + orderNumber);
    }

    @DataProvider
    public Object[][] getData(){
        Map<String,String> cc = Maps.newHashMap();
        cc.put("cc","12345455345");
        cc.put("year", "25");
        cc.put("cvv", "107");

        Map<String,String> nb = Maps.newHashMap();
        nb.put("bank","BOFA");
        nb.put("account", "123988748743");
        nb.put("pin", "999");
        return new Object[][]{
                {new CreditCard(), cc},
                {new NetBanking(), nb}
        };
    }
}
