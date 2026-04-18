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

    public ForwardTreasurySteps navigate(String path){
        page.navigate(Constants.TREASURY_PRODUCTS_URL);

        // დაელოდე table-ს
        periodColumn.first().waitFor();

        System.out.println("PAGE URL: " + page.url());
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

        System.out.println("🔵 UI PERIODS: " + uiPeriods);
        System.out.println("🔵 UI BIDS: " + uiBids);
        System.out.println("🔵 UI ASKS: " + uiAsks);

        assertEquals(uiPeriods.size(), apiPeriods.size(), "Row count mismatch");

        double delta = 0.0001;

        for (int i = 0; i < apiPeriods.size(); i++) {

            double uiBid = Double.parseDouble(uiBids.get(i).trim());
            double uiAsk = Double.parseDouble(uiAsks.get(i).trim());

            String uiPeriod = uiPeriods.get(i).trim();
            String apiPeriod = apiPeriods.get(i).trim();

            System.out.println("➡️ Comparing row " + i);
            System.out.println("Period: " + apiPeriod + " vs " + uiPeriod);
            System.out.println("Bid: " + apiBids.get(i) + " vs " + uiBid);
            System.out.println("Ask: " + apiAsks.get(i) + " vs " + uiAsk);

            // ✅ FIXED assertions
            assertEquals(uiPeriod, apiPeriod, "Period mismatch at row " + i);
            assertEquals(uiBid, apiBids.get(i), delta);
            assertEquals(uiAsk, apiAsks.get(i), delta);

            System.out.println("✅ ROW PASSED\n");
        }
    }
}