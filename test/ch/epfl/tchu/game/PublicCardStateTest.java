package ch.epfl.tchu.game;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PublicCardStateTest {

    @Test
    void PublicCardStateFaceUpCardsOverload() {
        List<Card> list = new ArrayList<>();
        for (Card c : Card.ALL) {
            list.add(c);
        }
        assertThrows(IllegalArgumentException.class, () -> {
            new PublicCardState(list, 5, 5);
        });
    }

    @Test
    void PublicCardStateDecksizeOrDiscardsizeUnderload() {
        List<Card> list = List.of(Card.BLACK, Card.BLACK, Card.BLACK, Card.BLACK, Card.BLACK);
        assertThrows(IllegalArgumentException.class, () -> {
            new PublicCardState(list, 2, -1);
        });
    }

    @Test
    void faceUpCardsTest() {
        List<Card> list = List.of(Card.BLACK, Card.GREEN, Card.BLUE, Card.YELLOW, Card.RED);
        PublicCardState state = new PublicCardState(list, 12, 12);
        assertEquals(Card.GREEN, state.faceUpCard(1));
    }

    @Test
    void faceUpCardTestFalseIndex() {
        List<Card> list = List.of(Card.BLACK, Card.GREEN, Card.BLUE, Card.YELLOW, Card.RED);
        PublicCardState state = new PublicCardState(list, 12, 12);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            state.faceUpCard(8);
        });
    }

    @Test
    void totalSize() {
        List<Card> list = List.of(Card.BLACK, Card.GREEN, Card.BLUE, Card.YELLOW, Card.RED);
        PublicCardState pcs = new PublicCardState(list, 0, 0);
//        assertEquals(5, pcs.totalSize());
    }

    @Test
    void isDeckEmptyWithNonEmptyDeck() {
        List<Card> list = List.of(Card.BLACK, Card.GREEN, Card.BLUE, Card.YELLOW, Card.RED);
        PublicCardState pcs = new PublicCardState(list, 1, 0);
        assertFalse(pcs.isDeckEmpty());
    }

    @Test
    void isDeckEmptyWithEmptyDeck() {
        List<Card> list = List.of(Card.BLACK, Card.GREEN, Card.BLUE, Card.YELLOW, Card.RED);
        PublicCardState pcs = new PublicCardState(list, 0, 5);
        assertTrue(pcs.isDeckEmpty());
    }

    @Test
    void discardsSizeTest() {
        List<Card> list = List.of(Card.BLACK, Card.GREEN, Card.BLUE, Card.YELLOW, Card.RED);
        PublicCardState pcs = new PublicCardState(list, 0, 5);
        assertEquals(5, pcs.discardsSize());
    }
}