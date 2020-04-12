package org.example.utilities;

import org.example.pages.playerSearch.PlayerSearchPage;
import org.example.pages.players.PlayersPage;
import org.example.pages.topMenu.TopMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.example.utilities.DriverFactory.getChromeDriver;

public class TestBase extends PageBase {
    private static final ConfigReader configReader = new ConfigReader();
    WebDriver driver;
    WebDriverWait wait;
    public static TopMenu topMenu = null;
    public static PlayerSearchPage playerSearch = null;
    public static PlayersPage players = null;

    @BeforeSuite
    public void initialize() {
        initializeExtent();
    }

    @BeforeMethod
    public void goToHomePage(ITestResult tr) {
        logger = extent.createTest(tr.getMethod().getMethodName());

        driver = getChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigReader.getURL());

        topMenu = TopMenu.getTopMenu();
        playerSearch = PlayerSearchPage.getPlayerSearchPage();
        players = PlayersPage.getPlayersPage();
    }

    @AfterMethod (alwaysRun = true)
    public void endTestReport(ITestResult tr) throws IOException {
        try {
            PageBase.captureScreenshot(tr, driver);
        } catch (AssertionError e) {
            e.printStackTrace();
            System.out.println("UI VALIDATION FAILED - NO SCREENSHOT");
        }

        extent.attachReporter();
        extent.flush();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
