package LoanCalculator;

import baseTests.BaseTest;
import org.tbc.steps.ConsumerLoanPageSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.tbc.data.Constants.*;

public class LoanCalculator extends BaseTest {
    private ConsumerLoanPageSteps consumerLoanPageSteps;

    @BeforeClass
    public  void setUpSteps(){
        navigateTo(CONSUMER_LOAN_URL);
        consumerLoanPageSteps = new ConsumerLoanPageSteps(getPage());
    }

    @Test
    public void consumerLoan(){
        consumerLoanPageSteps
                .navigateToConsumerLoanPage()
                .fillLoanAmount(String.valueOf(LOAN_AMOUNT_1))
                .fillLoanDuration(String.valueOf(LOAN_DURATION_1))
                .verifyCalculatedAmounts()
                .updateLoanAmount(String.valueOf(LOAN_AMOUNT_2))
                .verifyUpdatedCalculatedAmounts();
    }
}
