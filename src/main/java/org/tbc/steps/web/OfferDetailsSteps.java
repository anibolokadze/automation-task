package org.tbc.steps.web;

import com.microsoft.playwright.Page;
import org.tbc.pages.OfferDetailsPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class OfferDetailsSteps extends OfferDetailsPage {
    private final Page page;
    public OfferDetailsSteps(Page page){
        super(page);
        this.page = page;
    }

    public OfferDetailsSteps verifyTitle(){
        assertThat(title).isVisible();
        return this;
    }
    public OfferDetailsSteps verifyHero(){
        assertThat(heroImg).isVisible();
        return this;
    }
    public OfferDetailsSteps verifyDiscountBadge(){
        assertThat(discountBadge).isVisible();
        return this;
    }
    public OfferDetailsSteps verifyOfferDescription(){
        assertThat(offerDiscription).isVisible();
        return this;
    }
}
