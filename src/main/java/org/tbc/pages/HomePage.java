package org.tbc.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage {
    public Locator hamburgerMenu, forMyBusinessBtn, locationsBtn;

    public HomePage (Page page) {
        this.hamburgerMenu = page.locator("button.tbcx-pw-hamburger-menu__button");
        this.forMyBusinessBtn = page.locator(".tbcx-pw-mega-menu-navigation")
                .locator("button")
                .filter(new Locator.FilterOptions().setHasText("ჩემი ბიზნესისთვის"));
        this.locationsBtn = page.locator(".tbcx-pw-mega-menu-quick-acitons-item__title")
                .filter(new Locator.FilterOptions().setHasText(" მისამართები")).nth(3);
    }
}
