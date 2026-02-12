package MoneyTransfer;

import baseTests.BaseTest;
import org.tbc.steps.MoneyTransferSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.tbc.data.Constants.*;

public class MoneyTransfer extends BaseTest {
    private MoneyTransferSteps moneyTransferSteps;

    @BeforeClass
    public void setUpSteps(){
        navigateTo(MONEY_TRANSFERS_URL);
        moneyTransferSteps = new MoneyTransferSteps(getPage());
    }

    @Test
    public void moneyTransfer(){
        moneyTransferSteps.selectRemittanceFee()
                .fillRemittanceFeeAmount(REMITTANCE_FEE_AMOUNT)
                .selectRemittanceFeeAmountCurrency()
                .selectRemittanceFeeCountry()
                .verifyCalculationResult()
                .verifyCalculationResultValue()
        ;
    }
}
