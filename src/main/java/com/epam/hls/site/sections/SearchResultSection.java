package com.epam.hls.site.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

public class SearchResultSection extends Section {
    @FindBy(xpath = ".//div[@class='organic__url-text']")

    private Text name;

    @Override
    public String getName() {
        return name.getText();
    }
}
