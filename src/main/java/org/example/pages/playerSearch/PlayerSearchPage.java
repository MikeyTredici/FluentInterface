package org.example.pages.playerSearch;

import org.example.utilities.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PlayerSearchPage extends PageBase {
    public WebDriver driver;
    public WebDriverWait wait;

    public PlayerSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5);
    }

    @FindBy(xpath = "//div[@class='title-banner__navigation title-banner__navigation--padded']/form/input")
    private WebElement playersSearch;

    @FindBy(xpath = "//tr[@style='display: table-row;']/td/a")
    private List<WebElement> searchResultPlayerLinks;

    @FindBy(xpath = "//tr[@style='display: table-row;']/td/a/span[2]/span")
    private List<WebElement> searchResultLastNames;

    public void searchForPlayer(String firstName, String lastName) {
        final String fullName = firstName + " " + lastName;
        wait.until(ExpectedConditions.visibilityOf(playersSearch));
        playersSearch.clear();
        playersSearch.sendKeys(fullName);

        logger.info("Searched for player: " + fullName);
    }

    public void selectSearchedPlayerByLastName(String lastName) {
        wait.until(ExpectedConditions.visibilityOf(searchResultPlayerLinks.get(0)));
        for (int i = 0; i < searchResultPlayerLinks.size(); i++) {
            if (searchResultLastNames.get(i).getText().equalsIgnoreCase(lastName)) {
                searchResultPlayerLinks.get(i).click();
                logger.info("Clicking on " + lastName);
            }
        }
    }
}
