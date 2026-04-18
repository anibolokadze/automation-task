package APITests;
import org.tbc.API.TreasuryAPIClient;
import org.testng.annotations.Test;
import org.tbc.steps.api.ForwardTreasuryAPISteps;

import java.util.List;

public class verifyForwardTreasuryData {
    @Test
    public void verifyTreasuryApi() {
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
    }
}
