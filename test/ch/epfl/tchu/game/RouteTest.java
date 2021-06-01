package ch.epfl.tchu.game;

import org.junit.jupiter.api.Test;

import ch.epfl.tchu.game.Route.Level;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RouteTest {

    /**
     * Valide
     */
    @Test
    void sameStationError(){
        Station LAU = new Station(14, "Lausanne");
        assertThrows(IllegalArgumentException.class, () -> {
            new Route("Lausanne - Lausanne",
                    LAU, LAU, 1,
                    Level.OVERGROUND,
                    Color.BLUE);
        });
    }

    /**
     * Valide
     */
    @Test
    void highLengthError() {
        Station LAU = new Station(14, "Lausanne");
        Station STG = new Station(2, "Saint-Gall");
        assertThrows(IllegalArgumentException.class, () -> {
            new Route("Lausanne - Saint-Gall",
                    LAU, STG, 10,
                    Level.OVERGROUND, Color.GREEN);
        });
    }

    /**
     * Valide
     */
    @Test
    void nullIdError() {
        Station LAU = new Station(14, "Lausanne");
        Station STG = new Station(2, "Saint-Gall");
        assertThrows(NullPointerException.class, () -> {
            new Route(null,
                    LAU, STG, 3,
                    Level.OVERGROUND, Color.GREEN);
        });
    }

    /**
     * Valide
     */
    @Test
    void nullStationError() {
        Station STG = new Station(2, "Saint-Gall");
        assertThrows(NullPointerException.class, () -> {
            new Route("null - Saint-Gall",
                    null, STG, 3,
                    Level.OVERGROUND, Color.GREEN);
        });
    }

    /**
     * Valide
     */
    @Test
    void nullLevelError() {
        Station LAU = new Station(14, "Lausanne");
        Station STG = new Station(2, "Saint-Gall");
        assertThrows(NullPointerException.class, () -> {
            new Route("Lausanne - Saint-Gall",
                    LAU, STG, 3,
                    null, Color.GREEN);
        });
    }

    /**
     * valide
     */
    @Test
    void stationOppositeError() {
        Station LAU = new Station(14, "Lausanne");
        Station STG = new Station(2, "Saint-Gall");
        Station EPFL = new Station(23, "EPFL");
        Route route = new Route("Lausanne - Saint-Gall",
                LAU, STG, 3,
                Level.OVERGROUND, Color.GREEN);
        assertThrows(IllegalArgumentException.class, () -> {
            route.stationOpposite(EPFL);
        });
    }

    /**
     * Valide
     */
    @Test
    void stationOppositeTest() {
        Station LAU = new Station(14, "Lausanne");
        Station STG = new Station(2, "Saint-Gall");
        Route route = new Route("Lausanne - Saint-Gall",
                LAU, STG, 3,
                Level.OVERGROUND, Color.GREEN);
        assertEquals(STG, route.stationOpposite(LAU));
    }

    /**
     * Validé
     */
    @Test
    void colorWithNullColorRoute(){
        Station BEL = new Station(2, "Bellinzone");
        Station WAS = new Station(29, "Wassen");
        Route BEL_WAS = new Route("BEL_WAS_1", BEL, WAS, 4, Level.UNDERGROUND, null);
        assertEquals(null, BEL_WAS.color());
    }

    /**
     * Valide
     */
    @Test
    void possibleClaimCardsTestUndergroundNullColor() {
        Station BEL = new Station(2, "Bellinzone");
        Station WAS = new Station(29, "Wassen");
        Route BEL_WAS = new Route("BEL_WAS_1", BEL, WAS, 4, Level.UNDERGROUND, null);
        String expectedClaimCards = "";
        List<String> sequence = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {
            for (Card c : Card.CARS) {
                if (i == 0) {
                    sequence.add("{4×" + c.toString() + "}");
                }
                if (i == 1) {
                    sequence.add(String.join(", ",List.of("{3×" + c.toString(), "LOCOMOTIVE}")));
                } else if (i == 2) {
                    sequence.add(String.join(", ",List.of("{2×" + c.toString(), "2×LOCOMOTIVE}")));
                } else if (i == 3) {
                    sequence.add(String.join(", ",List.of("{" + c.toString(), "3×LOCOMOTIVE}")));
                } else if (i == 4) {
                    if (!sequence.contains("{4×LOCOMOTIVE}")) {sequence.add("{4×LOCOMOTIVE}");}
                }
            }
        }
        expectedClaimCards = String.format("[%s]", String.join(", ", sequence));
        assertEquals(expectedClaimCards, BEL_WAS.possibleClaimCards().toString());
    }

    @Test
    void neighborTest() {
        assertEquals(ChMap.routes().get(9), ChMap.routes().get(10).neighbor());
        assertEquals(ChMap.routes().get(4), ChMap.routes().get(4).neighbor());
    }

    
}
