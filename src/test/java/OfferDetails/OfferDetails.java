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
    @Test
    public void verifyLoad(){
        offerDetailsSteps
                .verifyTitle()
                .verifyHero()
                .verifyDiscountBadge()
                .verifyOfferDiscription();
    }

}
