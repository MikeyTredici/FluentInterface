package org.example.pages.playerSearch;

import org.example.utilities.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.example.utilities.DriverFactory.getChromeDriver;

public class PlayerSearchPage extends PageBase {
    WebDriver driver = getChromeDriver();
    private PlayerSearchActController act;
    private PlayerSearchVerifyController verify;

    public PlayerSearchActController act() {
        return act;
    }

    public PlayerSearchVerifyController verify() {
        return verify;
    }

    private PlayerSearchPage(PlayerSearchActController act, PlayerSearchVerifyController verify) {
        this.act = PageFactory.initElements(driver, PlayerSearchActController.class);
        this.verify = PageFactory.initElements(driver, PlayerSearchVerifyController.class);
    }

    private PlayerSearchPage() {
        // Hide me
    }

    public static PlayerSearchPage getPlayerSearchPage() {
        return new PlayerSearchPage(new PlayerSearchActController(getChromeDriver()),
                new PlayerSearchVerifyController());
    }


}
