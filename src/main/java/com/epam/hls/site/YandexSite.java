package com.epam.hls.site;

import com.epam.hls.site.pages.MainPage;
import com.epam.hls.site.pages.SearchResultsPage;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;

@JSite("https://yandex.ru")
public class YandexSite extends WebSite {
    public static MainPage mainPage;

    public static SearchResultsPage searchResultsPage;
}
