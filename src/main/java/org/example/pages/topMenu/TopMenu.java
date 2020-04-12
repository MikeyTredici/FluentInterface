package org.example.pages.topMenu;

import org.example.utilities.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.example.utilities.DriverFactory.getChromeDriver;

public class TopMenu extends PageBase {
    WebDriver driver = getChromeDriver();
    private TopMenuActController act;
    private TopMenuVerifyController verify;

    public TopMenuActController act() {
        return act;
    }

    public TopMenuVerifyController verify() {
        return verify;
    }

    private TopMenu(TopMenuActController act, TopMenuVerifyController verify) {
        this.act = PageFactory.initElements(driver, TopMenuActController.class);
        this.verify = PageFactory.initElements(driver, TopMenuVerifyController.class);
    }

    private TopMenu() {
        // Hide me
    }

    public static TopMenu getTopMenu() {
        return new TopMenu(new TopMenuActController(getChromeDriver()),
                new TopMenuVerifyController());
    }
}
