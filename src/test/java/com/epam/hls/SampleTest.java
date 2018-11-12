package com.epam.hls;

import com.epam.hls.site.YandexSite;
import com.epam.hls.site.sections.SearchResultSection;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.settings.WebSettings;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import com.epam.web.matcher.testng.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.hls.site.YandexSite.mainPage;
import static com.epam.hls.site.YandexSite.searchResultsPage;

public class SampleTest extends TestNGBase {
    private static final Logger LOG = LoggerFactory.getLogger(SampleTest.class);

    //@BeforeSuite(alwaysRun = true)
    public static void setUp() {
        WebSite.init(YandexSite.class);
        LOG.info("Site initialized!");
    }

    @Test(testName = "Смоук", dataProvider = "Search")
    public void smokeTest(String toSearch, String toCheck) {
        setUp();
        mainPage.open();
        mainPage.checkOpened();
        mainPage.searchFor(toSearch);

        searchResultsPage.checkOpened();

        Assert.assertTrue(searchResultsPage.results.stream().map(SearchResultSection::getName)
                .anyMatch(title -> title.toLowerCase().contains(toCheck.toLowerCase())));
    }

    @DataProvider(name = "Search")
    public static Object[][] provideSearchPairs() {
        return new Object[][]{
                {"EPAM", "EPAM Systems"},
                {"Яндекс", "Википедия"},
                {"Яндекс", "Вконтакте"}
        };
    }

    @AfterSuite
    public static void tearDown() {
        WebSettings.getDriver().quit();
    }
}
