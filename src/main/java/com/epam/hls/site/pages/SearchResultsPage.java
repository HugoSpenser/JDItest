package com.epam.hls.site.pages;

import com.epam.hls.site.sections.SearchResultSection;
import com.epam.jdi.uitests.core.interfaces.complex.tables.interfaces.CheckPageTypes;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;

import java.util.List;
import java.util.function.Consumer;

@JPage(title = "Яндекс", titleCheckType = CheckPageTypes.CONTAINS,
        urlTemplate = ".*/search/.*", urlCheckType = CheckPageTypes.MATCH)
public class SearchResultsPage extends WebPage {
    @FindBy(xpath = "//ul[@aria-label='Результаты поиска']//li")
    public List<SearchResultSection> results;

    public void forEachResult(Consumer<SearchResultSection> consumer) {
        for (SearchResultSection result : results) {
            consumer.accept(result);
        }
    }

    public void passResultNamesToLogger(Logger logger) {
        for (SearchResultSection searchResultSection : results) {
            logger.info(searchResultSection.getName());
        }
    }
}