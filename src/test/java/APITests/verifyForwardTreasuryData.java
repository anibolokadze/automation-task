package APITests;
import org.tbc.API.TreasuryApiClient;
import org.testng.annotations.Test;
import org.tbc.steps.api.ForwardTreasuryApiSteps;

import java.util.List;

public class verifyForwardTreasuryData {
    @Test
    public void verifyTreasuryApi() {
        TreasuryApiClient apiPage = new TreasuryApiClient()
                .getTreasuryRates();

        ForwardTreasuryApiSteps steps = new ForwardTreasuryApiSteps()
                .deserialize(apiPage.getResponse())
                .validateStructure()
                .validateCurrencyPair()
                .validateNumericFields();

        List<String> periods = steps.getPeriods();
        List<Double> bids = steps.getBidRates();
        List<Double> asks = steps.getAskRates();
    }
}
