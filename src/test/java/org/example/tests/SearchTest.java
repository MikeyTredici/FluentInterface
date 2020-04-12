package org.example.tests;

import org.example.utilities.TestBase;
import org.testng.annotations.Test;

public class SearchTest extends TestBase {
    public static final String firstName = "Nathan";
    public static final String lastName = "MacKinnon";
    public static final String fullName = "Nathan MacKinnon";

    @Test(priority = 1, enabled = true, description = "Simple Player Search Test")
    public void playerSearchTest() {
        topMenu.clickTopNavPlayers();
        playerSearch.searchForPlayer(firstName, lastName);
        playerSearch.selectSearchedPlayerByLastName(lastName);
        players.validatePlayerName(fullName);
    }
}
