package org.tbc.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage {
    public Locator personalNavItem, consumerLoanNavButton,
            consumerLoanConditionsButton, languageSwitcherGEO,
            personalNavItemENG, MoneyTransferNavButton;

    public HomePage(Page page){
        this.personalNavItem = page.getByText("ჩემთვის", new Page.GetByTextOptions().setExact(true)).nth(0);
        this.personalNavItemENG = page.getByText("Personal", new Page.GetByTextOptions().setExact(true)).nth(0);
        this.consumerLoanNavButton = page.getByRole(AriaRole.BUTTON,
                        new Page.GetByRoleOptions().setName("სამომხმარებლო"));
        this.MoneyTransferNavButton = page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Money Transfers"));
        this.consumerLoanConditionsButton =
                page.getByRole(
                        AriaRole.BUTTON,
                        new Page.GetByRoleOptions()
                                .setName("პირობები")
                                .setExact(true))
                        .nth(0);
        this.languageSwitcherGEO = page.getByText("ქარ").nth(0);
    }
}
