package org.tbc.steps.ui;

import com.microsoft.playwright.Page;
import org.tbc.pages.OffersListPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class OfferListSteps extends OffersListPage {
    private final Page page;
    private final boolean headless;
    public OfferListSteps(Page page, boolean headless){
        super(page);
        this.page = page;
        this.headless = headless;
    }

    public OfferListSteps verifyFilterAndOffersList(){
        if(headless) {
            openFiltersModal.click();
            filterPanelModal.isVisible();
            offersList.isVisible();
        } else {
            filterPanelDesktop.isVisible();
            offersList.isVisible();
        }
        return this;
    }
    public OfferListSteps selectFilter() {
        if(headless) {
            shoppingCategoryModal.click();
            cardCategoryModal.click();
        } else {
            shoppingCategoryDesktop.click();
            cardCategoryDesktop.click();
        }
        return this;
    }
    public OfferListSteps verifyEmptyState(){
        page.waitForTimeout(2000);
        assertThat(emptyState).isVisible();
        return this;
    }
    public OfferListSteps verifyNoOfferCards(){
        assertThat(offersList).not().isVisible();
        return this;
    }
    public OfferListSteps clearFiltersAndVerifyOffersList(){
        categoryFilterClear.click();
        cardFilterClear.click();
        assertThat(offersList).isVisible();
        return this;
    }
}
