package org.tbc.models;

import java.util.List;

public class TransferSystems {
    private String mtSystem;
    private String name;
    private String imageUrl;
    private List<String> currencies;

    public String getName() {
        return name;
    }

    public String getMtSystem() {
        return mtSystem;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public List<String> getCurrencies() {
        return currencies;
    }
}
