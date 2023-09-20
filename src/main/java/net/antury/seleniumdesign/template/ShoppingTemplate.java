package net.antury.seleniumdesign.template;

public abstract class ShoppingTemplate {
    public abstract void launchSite();
    public abstract void searchForProducts();
    public abstract void selectProduct();
    public abstract void buy();

    public void shop(){
        launchSite();
        searchForProducts();
        selectProduct();
        buy();
    }
}
