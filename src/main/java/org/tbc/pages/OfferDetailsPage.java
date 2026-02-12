package org.tbc.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class OfferDetailsPage {
    public Locator title, heroImg, discountBadge, offerDiscription;
    public OfferDetailsPage(Page page){
        this.title = page.locator("h2");
        this.heroImg = page.getByAltText("1110x400");
        this.discountBadge = page.locator(".tbcx-pw-text-badge");
        this.offerDiscription = page.locator(".with-container");
    }
}
