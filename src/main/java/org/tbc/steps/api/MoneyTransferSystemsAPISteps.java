package org.tbc.steps.api;

import io.restassured.response.Response;
import org.tbc.models.TransferSystems;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class MoneyTransferSystemsAPISteps {
    private List<TransferSystems> transferSystems;

    public MoneyTransferSystemsAPISteps deserializeTransferSystems(Response response) {
        transferSystems = Arrays.asList(
                response.as(TransferSystems[].class)
        );
        return this;
    }

    public MoneyTransferSystemsAPISteps validateStructure() {
        assertNotNull(transferSystems);
        assertFalse(transferSystems.isEmpty());
        return this;
    }

    public MoneyTransferSystemsAPISteps validateNames() {
        transferSystems.forEach(t -> {
            assertNotNull(t.getName());
            assertFalse(t.getName().isEmpty());
        });
        return this;
    }

    public MoneyTransferSystemsAPISteps validateCurrencies() {
        transferSystems.forEach(t -> {
            assertNotNull(t.getCurrencies());
            assertFalse(t.getCurrencies().isEmpty());
        });
        return this;
    }

    public List<String> getTransferSystemsNames() {
        return transferSystems.stream()
                .map(TransferSystems::getName)
                .toList();
    }

    public List<String> getTransferSystemsCurrencies() {
        return transferSystems.stream()
                .map(t -> "currency - " + String.join("/", t.getCurrencies()))
                .toList();
    }
}