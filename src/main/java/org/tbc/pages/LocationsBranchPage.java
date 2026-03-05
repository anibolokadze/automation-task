package org.tbc.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LocationsBranchPage {
    public Locator title, ATMTitle, ATMBranchContainer, ATMBBranchContainerTitle, branchesTitle, branchesContainerTitle, branchScheduleText;
    public LocationsBranchPage(Page page) {
        this.title = page.getByTitle(" ფილიალი, ბანკომატი და თანხის მიმღები ");
        this.ATMTitle = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("ბანკომატები"));
        this.ATMBranchContainer = page.locator(".tbcx-pw-atm-branches-section__list-item").nth(0);
        this.ATMBBranchContainerTitle = page.locator(".tbcx-pw-atm-branches-section__list-item .tbcx-pw-title").nth(0);
        this.branchesTitle = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("ფილიალები"));
        this.branchesContainerTitle = page.locator(".tbcx-pw-atm-branches-section__list-item").nth(0);
        this.branchScheduleText = page.locator(".tbcx-pw-atm-branches-section__list-item-description").nth(1);
    }
}
