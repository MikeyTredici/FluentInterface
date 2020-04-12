package org.example.utilities;

import org.example.pages.players.PlayersPage;
import org.example.pages.topMenu.TopMenu;
import org.example.pages.playerSearch.PlayerSearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase extends PageBase {
    private static final ConfigReader configReader = new ConfigReader();
    public WebDriver driver = null;
    public static TopMenu topMenu = null;
    public static PlayerSearchPage playerSearch = null;
    public static PlayersPage players = null;

    @BeforeSuite
    public void initializeReport() {
        initializeExtent();
    }

    @BeforeMethod
    public void initialize(ITestResult tr) {
        logger = extent.createTest(tr.getMethod().getMethodName());
        System.out.println(ConfigReader.getChromeDriver());
        System.setProperty("webdriver.chrome.driver", ConfigReader.getChromeDriver());

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigReader.getURL());

        topMenu = PageFactory.initElements(driver, TopMenu.class);
        playerSearch = PageFactory.initElements(driver, PlayerSearchPage.class);
        players = PageFactory.initElements(driver, PlayersPage.class);
    }

    @AfterMethod
    public void tearDown(ITestResult tr) throws IOException {
        try {
            PageBase.captureScreenshot(tr, driver);
        } catch (AssertionError e) {
            e.printStackTrace();
            System.out.println("UI VALIDATION FAILED - NO SCREENSHOT");
        }

        extent.attachReporter();
        extent.flush();
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
