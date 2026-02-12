package org.tbc.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class OfferDetailsPage {
    public Locator title;
    public OfferDetailsPage(Page page){
        this.title = page.getByTitle("შეთავაზება extra-ზე");
    }
}
