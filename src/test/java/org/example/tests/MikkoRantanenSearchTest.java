package org.example.tests;

import org.example.utilities.Players;
import org.example.utilities.TestBase;
import org.testng.annotations.Test;

public class MikkoRantanenSearchTest extends TestBase {

    @Test(priority = 1, enabled = true, description = "Simple Player Search Test")
    public void mikkoSearchTest() {
        topMenu.act().
                clickTopNavPlayers();
        playerSearch.act()
                .searchForPlayer(Players.MIKKO, Players.RANTANEN)
                .selectSearchedPlayerByLastName(Players.RANTANEN);
        players.verify().
                validatePlayerName(Players.MIKKO_RANTANEN);
    }
}
