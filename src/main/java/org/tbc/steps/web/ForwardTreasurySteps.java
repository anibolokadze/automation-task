package org.tbc.steps.web;

import com.microsoft.playwright.Page;
import org.tbc.data.Constants;
import org.tbc.pages.TreasuryProductsPage;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ForwardTreasurySteps extends TreasuryProductsPage {
    protected final Page page;

    public ForwardTreasurySteps(Page page) {
        super(page);
        this.page = page;
    }

    public ForwardTreasurySteps navigate(String treasuryProductsURL){
        page.navigate(Constants.TREASURY_PRODUCTS_URL);
        periodColumn.first().waitFor();
        return this;
    }

    public void assertTableData(
            List<String> apiPeriods,
            List<Double> apiBids,
            List<Double> apiAsks
    ) {
        List<String> uiPeriods = periodColumn.allTextContents();
        List<String> uiBids = buyColumn.allTextContents();
        List<String> uiAsks = sellColumn.allTextContents();

        assertEquals(uiPeriods.size(), apiPeriods.size());

        double delta = 0.0001;

        for (int i = 0; i < apiPeriods.size(); i++) {
            double uiBid = Double.parseDouble(uiBids.get(i).trim());
            double uiAsk = Double.parseDouble(uiAsks.get(i).trim());
            String uiPeriod = uiPeriods.get(i).trim();
            String apiPeriod = apiPeriods.get(i).trim();

            assertEquals(uiPeriod, apiPeriod);
            assertEquals(uiBid, apiBids.get(i), delta);
            assertEquals(uiAsk, apiAsks.get(i), delta);
        }
    }
}