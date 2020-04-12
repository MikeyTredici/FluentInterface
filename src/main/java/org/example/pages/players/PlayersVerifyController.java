package org.example.pages.players;

import com.aventstack.extentreports.Status;
import org.apache.commons.lang3.StringUtils;
import org.example.utilities.Players;
import org.example.utilities.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PlayersVerifyController extends PageBase {
    public WebDriver driver;
    public WebDriverWait wait;

    public PlayersVerifyController(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5);
    }

    @FindBy(xpath = "//h3[@class='player-jumbotron-vitals__name-num']")
    private WebElement playerNameAndNumber;

    public void validatePlayerName(Players fullName) {
        wait.until(ExpectedConditions.visibilityOf(playerNameAndNumber));
        String playerName = fullName.toString();

        Assert.assertTrue(StringUtils.containsIgnoreCase(playerNameAndNumber.getText(), playerName), "Failed to find " + playerName);
        logger.log(Status.PASS, "Successfully validated the Player Search by Name");
    }
}
