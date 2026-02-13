package OfferDetails;

import baseTests.BaseTest;
import org.tbc.steps.OfferDetailsSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.tbc.data.Constants.OFFER_DETAILS_URL;

public class OfferDetails extends BaseTest {
    private OfferDetailsSteps offerDetailsSteps;

    @BeforeClass
    public void setUpSteps(){
        navigateTo(OFFER_DETAILS_URL);
        offerDetailsSteps = new OfferDetailsSteps(getPage());
    }
    @Test(priority = 1)
    public void verifyTitle(){
        offerDetailsSteps
                .verifyTitle();
    }
    @Test(priority = 2)
    public void verifyHero(){
        offerDetailsSteps
                .verifyHero();
    }
    @Test(priority = 3)
    public void verifyDiscountBadge(){
        offerDetailsSteps
                .verifyDiscountBadge();
    }
    @Test(priority = 4)
    public void verifyOfferDescription(){
        offerDetailsSteps
                .verifyOfferDescription();
    }
}
