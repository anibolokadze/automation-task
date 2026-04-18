package APITests;

import BaseTests.BaseTest;
import org.tbc.API.TreasuryAPIClient;
import org.tbc.data.Constants;
import org.tbc.steps.api.ForwardTreasuryAPISteps;
import org.tbc.steps.web.ForwardTreasurySteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class verifyForwardTreasuryData extends BaseTest {

    ForwardTreasurySteps forwardTreasurySteps;

    @BeforeClass
    public void setup() {
        forwardTreasurySteps = new ForwardTreasurySteps(page);
    }

    @Test
    public void verifyTreasuryApi() {

        // 🔵 API
        TreasuryAPIClient apiPage = new TreasuryAPIClient()
                .getTreasuryRates();

        ForwardTreasuryAPISteps steps = new ForwardTreasuryAPISteps()
                .deserialize(apiPage.getResponse())
                .validateStructure()
                .validateCurrencyPair()
                .validateNumericFields();

        List<String> periods = steps.getPeriods();
        List<Double> bids = steps.getBidRates();
        List<Double> asks = steps.getAskRates();

        // 🔵 UI
        forwardTreasurySteps
                .navigate(Constants.TREASURY_PRODUCTS_URL)
                .assertTableData(periods, bids, asks);
    }
}