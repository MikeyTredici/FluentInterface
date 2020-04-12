package org.example.pages.topMenu;

import org.example.utilities.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopMenu extends PageBase {
    public WebDriver driver;
    public WebDriverWait wait;

    public TopMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5);
    }

    @FindBy(xpath = "//li[@class='top-nav__primary__menu__item top-nav__primary__menu__item--players']")
    private WebElement topNavPlayers;


    public void clickTopNavPlayers() {
        wait.until(ExpectedConditions.elementToBeClickable(topNavPlayers));
        topNavPlayers.click();

        logger.info("Clicked on Players in the Top Nav Bar");
    }



}
