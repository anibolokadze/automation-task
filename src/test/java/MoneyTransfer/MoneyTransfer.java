package MoneyTransfer;

import baseTests.BaseTest;
import org.tbc.pages.MoneyTransferPage;
import org.tbc.steps.HomePageSteps;
import org.tbc.steps.MoneyTransferSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.tbc.data.Constants.REMITTANCE_FEE_AMOUNT;

public class MoneyTransfer extends BaseTest {
    private HomePageSteps homePageSteps;
    private MoneyTransferSteps moneyTransferSteps;

    @BeforeClass
    public void setUpSteps(){
        homePageSteps = new HomePageSteps(getPage());
        moneyTransferSteps = new MoneyTransferSteps(getPage());
    }

    @Test
    public void moneyTransfer(){
        homePageSteps.changeLanguageToENG()
                .navigateToMoneyTransfersPage();
        moneyTransferSteps.selectRemittanceFee()
                .fillRemittanceFeeAmount(REMITTANCE_FEE_AMOUNT)
                .selectRemittanceFeeAmountCurrency()
                .selectRemittanceFeeCountry()
                .verifyCalculationResult()
                .verifyCalculationResultValue()
        ;
    }
}
