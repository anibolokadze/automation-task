package org.tbc.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ConsumerLoanTermsPage {
    public Locator applyBtn;
    public ConsumerLoanTermsPage(Page page){
        this.applyBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("სესხის მოთხოვნა"));
    }
}
