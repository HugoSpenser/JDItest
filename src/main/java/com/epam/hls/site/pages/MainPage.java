package com.epam.hls.site.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.Search;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import org.openqa.selenium.By;

@JPage(title = "Яндекс", url = "/")
public class MainPage extends WebPage {
    private Search searchString = new Search(By.id("text"), By.xpath("//div[@class='search2__button']/button"));

    public void searchFor(String searchQuery) {
        searchString.find(searchQuery);
    }
}
