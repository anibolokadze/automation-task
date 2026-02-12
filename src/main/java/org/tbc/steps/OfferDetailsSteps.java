package org.tbc.steps;

import com.microsoft.playwright.Page;
import org.tbc.pages.OfferDetailsPage;

public class OfferDetailsSteps extends OfferDetailsPage {
    private final Page page;
    public OfferDetailsSteps(Page page){
        super(page);
        this.page = page;
    }

//    public OfferDetailsSteps verifyTitle(){
//        title
//    }
}
