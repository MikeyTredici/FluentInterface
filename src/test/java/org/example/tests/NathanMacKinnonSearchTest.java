package org.example.tests;

import org.example.utilities.Players;
import org.example.utilities.TestBase;
import org.testng.annotations.Test;

public class NathanMacKinnonSearchTest extends TestBase {

    @Test(priority = 1, enabled = true, description = "Simple Player Search Test")
    public void nathanSearchTest() {
        topMenu.act().
                clickTopNavPlayers();
        playerSearch.act()
                .searchForPlayer(Players.NATHAN, Players.MACKINNON)
                .selectSearchedPlayerByLastName(Players.MACKINNON);
        players.verify().
                validatePlayerName(Players.NATHAN_MACKINNON);
    }
}
