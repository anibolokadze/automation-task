package org.tbc.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class OffersListPage {
    public Locator filterPanelModal, filterPanelDesktop, offersList, shoppingCategoryDesktop, shoppingCategoryModal, cardCategoryDesktop, cardCategoryModal, openFiltersModal, emptyState, categoryFilterClear, cardFilterClear;

    public OffersListPage(Page page) {
        this.filterPanelModal = page.locator("div.filters").nth(1);
        this.filterPanelDesktop = page.locator("div.filters");
        this.offersList = page.locator("app-marketing-list .marketing__cards-list");

        this.shoppingCategoryDesktop = page
                .locator("app-marketing-main app-marketing-filter-item")
                .filter(new Locator.FilterOptions().setHasText("შოპინგი"))
                .locator("input[type='checkbox']");

        this.cardCategoryDesktop = page
                .locator("app-marketing-main app-marketing-filter-item")
                .filter(new Locator.FilterOptions().setHasText("მასტერქარდი"))
                .locator("input[type='checkbox']");

        this.shoppingCategoryModal = page
                .locator("#cdk-dialog-serverApp0 app-marketing-filter-item")
                .filter(new Locator.FilterOptions().setHasText("შოპინგი"))
                .locator("input[type='checkbox']");

        this.cardCategoryModal = page
                .locator("#cdk-dialog-serverApp0 app-marketing-filter-item")
                .filter(new Locator.FilterOptions().setHasText("მასტერქარდი"))
                .locator("input[type='checkbox']");

        this.openFiltersModal = page.locator("div.marketing__filter-chip__title:has-text('ფილტრი')");

        this.emptyState = page.locator("h3:has-text('შეთავაზებები არ მოიძებნა')");;
        this.categoryFilterClear = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("გასუფთავება")).nth(0);
        this.cardFilterClear = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("გასუფთავება")).nth(0);
    }
}
