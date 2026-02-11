package org.tbc.steps;

import com.microsoft.playwright.Page;
import org.tbc.data.Constants;
import org.tbc.pages.HomePage;

public class HomePageSteps extends HomePage {
    private final Page page;

    public HomePageSteps(Page page){
        super(page);
        this.page = page;
    }

    public HomePageSteps navigateToLoanPage(){
        personalNavItem.click();
        consumerLoanNavButton.click();
        return this;
    }
    public HomePageSteps changeLanguageToENG(){
        languageSwitcherGEO.click();
        return this;
    }
    public HomePageSteps navigateToMoneyTransfersPage(){
        personalNavItemENG.click();
        MoneyTransferNavButton.click();
        return this;
    }
}
