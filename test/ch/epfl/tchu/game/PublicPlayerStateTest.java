package ch.epfl.tchu.game;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PublicPlayerStateTest {

    private static final Station BAD = new Station(0, "Baden");
    private static final Station BAL = new Station(1, "Bâle");
    private static final Station BEL = new Station(2, "Bellinzone");
    private static final Station BER = new Station(3, "Berne");
    private static final Station BRI = new Station(4, "Brigue");
    private static final Station BRU = new Station(5, "Brusio");
    private static final Station COI = new Station(6, "Coire");

    private static final List<Route> list = List.of(
            new Route("BAD_BAL",BAD, BAL, 4,Route.Level.UNDERGROUND, null),
            new Route("BAL_BRI",BAL, BRI, 2,Route.Level.OVERGROUND, Color.BLACK),
            new Route("BRI_BER",BRI, BER, 6,Route.Level.OVERGROUND, Color.GREEN)
            );

    @Test
    void publicPlayerStateWithWrongArguments() {
        assertThrows(IllegalArgumentException.class, () -> {
            PublicPlayerState pps = new PublicPlayerState(-1, 0, List.of());
        });
        assertThrows(IllegalArgumentException.class, () -> {
            PublicPlayerState pps = new PublicPlayerState(0, -1, List.of());
        });
    }

    @Test
    void carCountTest() {
        PublicPlayerState pps = new PublicPlayerState(3, 5, list);
        assertEquals(28, pps.carCount());
    }

    @Test
    void claimPointsTest() {
        PublicPlayerState pps = new PublicPlayerState(3, 5, list);
        assertEquals(24, pps.claimPoints());

    }



}