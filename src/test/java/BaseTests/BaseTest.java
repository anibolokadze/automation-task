package BaseTests;

import com.microsoft.playwright.*;
import org.testng.annotations.BeforeClass;

import java.util.List;

public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeClass
    public void setUp(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(true)
                        .setArgs(List.of("--start-maximized"))
        );
        context = browser.newContext(
                new Browser.NewContextOptions().setViewportSize(null)
        );
        page = context.newPage();
    }
    protected void navigateTo(String url) {
        page.navigate(url);
    }

    protected Page getPage(){return page;}
}
