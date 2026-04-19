package org.tbc.steps.api;

import io.restassured.response.Response;
import org.tbc.models.ForwardTreasuryRates;

import java.util.List;

import static org.testng.Assert.*;

public class ForwardTreasuryAPISteps {
    private List<ForwardTreasuryRates> rates;

    public ForwardTreasuryAPISteps deserialize(Response response) {
        rates = response.jsonPath()
                .getList("rates[1].forwardRates", ForwardTreasuryRates.class);
        return this;
    }

    public ForwardTreasuryAPISteps validateStructure() {
        assertNotNull(rates);
        assertFalse(rates.isEmpty());
        return this;
    }

    public ForwardTreasuryAPISteps validateCurrencyPair() {
        rates.forEach(r -> {
            assertEquals(r.getIso1(), "USD");
            assertEquals(r.getIso2(), "GEL");
        });
        return this;
    }

    public ForwardTreasuryAPISteps validateNumericFields() {
        rates.forEach(r -> {
            assertTrue(r.getBidForwardRate() > 0);
            assertTrue(r.getAskForwardRate() > 0);
        });
        return this;
    }

    public List<String> getPeriods() {
        return rates.stream()
                .map(ForwardTreasuryRates::getPeriod)
                .toList();
    }

    public List<Double> getBidRates() {
        return rates.stream()
                .map(ForwardTreasuryRates::getBidForwardRate)
                .toList();
    }

    public List<Double> getAskRates() {
        return rates.stream()
                .map(ForwardTreasuryRates::getAskForwardRate)
                .toList();
    }
}