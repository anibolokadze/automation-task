package LoanCalculator;

import baseTests.BaseTest;
import org.tbc.steps.ConsumerLoanPageSteps;
import org.tbc.steps.HomePageSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.tbc.data.Constants.*;

public class LoanCalculator extends BaseTest {
    private HomePageSteps homePageSteps;
    private ConsumerLoanPageSteps consumerLoanPageSteps;

    @BeforeClass
    public  void setUpSteps(){
        homePageSteps = new HomePageSteps(getPage());
        consumerLoanPageSteps = new ConsumerLoanPageSteps(getPage());
    }

    @Test
    public void navigateToLoanPage(){
        homePageSteps.navigateToLoanPage();
        consumerLoanPageSteps
                .navigateToConsumerLoanPage()
                .fillLoanAmount(String.valueOf(LOAN_AMOUNT_1))
                .fillLoanDuration(String.valueOf(LOAN_DURATION_1))
                .verifyCalculatedAmounts()
                .updateLoanAmount(String.valueOf(LOAN_AMOUNT_2))
                .verifyUpdatedCalculatedAmounts();
    }
}
