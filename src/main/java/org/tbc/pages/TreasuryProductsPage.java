package org.tbc.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class TreasuryProductsPage {
    public Locator usdGelTable, periodColumn, buyColumn, sellColumn;
    public TreasuryProductsPage(Page page) {
        this.usdGelTable = page.locator("div.business-treasury-product-table")
                .filter(new Locator.FilterOptions().setHasText("USD/GEL"))
                .first();
        this.periodColumn = usdGelTable.locator("div[col-id='period'] .tbcx-pw-table-cell__content__title");
        this.buyColumn = usdGelTable.locator("div[col-id='buy'] .tbcx-pw-table-cell__content__title");
        this.sellColumn = usdGelTable.locator("div[col-id='sell'] .tbcx-pw-table-cell__content__title");
    }
}
