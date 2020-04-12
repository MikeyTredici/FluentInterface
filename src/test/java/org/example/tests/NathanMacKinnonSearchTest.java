package org.example.tests;

import org.example.pages.playerSearch.Players;
import org.example.utilities.TestBase;
import org.testng.annotations.Test;

public class SearchTest extends TestBase {

    @Test(priority = 1, enabled = true, description = "Simple Player Search Test")
    public void playerSearchTest() {
        topMenu.clickTopNavPlayers();
        playerSearch.act()
                .searchForPlayer(Players.NATHAN, Players.MACKINNON)
                .selectSearchedPlayerByLastName(Players.MACKINNON);
        players.verify().
                validatePlayerName(Players.NATHAN_MACKINNON);
    }
}
