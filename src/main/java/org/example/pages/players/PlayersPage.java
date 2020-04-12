package org.example.pages.players;

import org.example.utilities.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.example.utilities.DriverFactory.getChromeDriver;

public class PlayersPage extends PageBase {
    WebDriver driver = getChromeDriver();
    private PlayersActController act;
    private PlayersVerifyController verify;

    public PlayersActController act() {
        return act;
    }

    public PlayersVerifyController verify() {
        return verify;
    }

    private PlayersPage(PlayersActController act, PlayersVerifyController verify) {
        this.act = PageFactory.initElements(driver, PlayersActController.class);
        this.verify = PageFactory.initElements(driver, PlayersVerifyController.class);
    }

    private PlayersPage() {
        // Hide me
    }

    public static PlayersPage getPlayersPage() {
        return new PlayersPage(new PlayersActController(),
                new PlayersVerifyController(getChromeDriver()));
    }
}
