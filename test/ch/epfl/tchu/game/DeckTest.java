package ch.epfl.tchu.game;

import ch.epfl.tchu.SortedBag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    void ofTestWithEmptySortedBag() {
        SortedBag.Builder<Card> deckB = new SortedBag.Builder<>();
        Deck deck1 = Deck.of(deckB.build(), new Random());
        assertEquals(0, deck1.size());
    }

    @Test
    void sizeTest() {
        SortedBag.Builder<Card> deckB = new SortedBag.Builder<>();
        deckB.add(Card.LOCOMOTIVE);
        deckB.add(Card.BLUE);
        deckB.add(Card.BLACK);
        Deck deck = Deck.of(deckB.build(), new Random());
        assertEquals(3, deck.size());
    }

    @Test
    void isEmptyWithNonEmptyDeck() {
        SortedBag.Builder<Card> deckB = new SortedBag.Builder<>();
        deckB.add(Card.LOCOMOTIVE);
        Deck deck = Deck.of(deckB.build(), new Random());
        assertEquals(false, deck.isEmpty());
    }

    @Test
    void isEmptyWithEmptyDeck() {
        SortedBag.Builder<Card> deckB = new SortedBag.Builder<>();
        Deck deck1 = Deck.of(deckB.build(), new Random());
        assertEquals(true, deck1.isEmpty());
    }

    @Test
    void topCardWithEmptyDeck() {
        assertThrows(IllegalArgumentException.class, () -> {
            Deck.of(new SortedBag.Builder<>().build(), new Random()).topCard();
        });
    }

    /**
     *
     * ###  LES TESTS SUIVANT ONT ETE EFFECTUES EN METTANT
     * L'ATTRIBUT CARDDECK EN PUBLIC  ###
     *
    @Test
    void topCardTest() {
        SortedBag.Builder<Card> deckB = new SortedBag.Builder<>();
        deckB.add(Card.LOCOMOTIVE);
        deckB.add(Card.BLUE);
        deckB.add(Card.BLACK);
        deckB.add(Card.RED);
        deckB.add(Card.GREEN);
        deckB.add(Card.YELLOW);
        Deck deck = Deck.of(deckB.build(), new Random());
        List<Object> list = new ArrayList<>();
        for (Object c : deck.cardDeck) {
            list.add(c);
        }
        assertEquals(list.get(0), deck.topCard());
    }

    @Test
    void withoutTopCardTest() {
        SortedBag.Builder<Card> deckB = new SortedBag.Builder<>();
        deckB.add(Card.LOCOMOTIVE);
        deckB.add(Card.BLUE);
        deckB.add(Card.BLACK);
        deckB.add(Card.RED);
        deckB.add(Card.GREEN);
        deckB.add(Card.YELLOW);
        Deck deck = Deck.of(deckB.build(), new Random());
        List<Object> list = new ArrayList<>();
        for (Object c : deck.cardDeck) {
            list.add(c);
        }
        boolean bool = true;
        for (int i = 0; i < deck.withoutTopCard().size(); ++i) {
            if (!deck.withoutTopCard().cardDeck.get(i).equals(list.subList(1, list.size()).get(i))) {
                bool = false;
            }
        }
        assertEquals(true, bool);
    }

    @Test
    void withoutTopCards() {
        SortedBag.Builder<Card> deckB = new SortedBag.Builder<>();
        deckB.add(Card.LOCOMOTIVE);
        deckB.add(Card.BLUE);
        deckB.add(Card.BLACK);
        deckB.add(Card.RED);
        deckB.add(Card.GREEN);
        deckB.add(Card.YELLOW);
        Deck deck = Deck.of(deckB.build(), new Random());
        List<Object> list = new ArrayList<>();
        for (Object c : deck.cardDeck) {
            list.add(c);
        }
        boolean bool = true;
        Deck subDeck = deck.withoutTopCards(4);
        Collections.sort(subDeck.cardDeck);
        for (int i = 0; i < deck.withoutTopCards(4).size(); ++i) {
            if (!subDeck.cardDeck.get(i).equals(list.subList(4, list.size()).get(i))) {
                bool = false;
            }
            System.out.print(list.subList(4, list.size()).get(i).toString() + " ");
            System.out.print(subDeck.cardDeck.get(i) + " ");
            System.out.println();
        }
        assertTrue(bool);

    }

    @Test
    void withoutTopCardsWithEmptyDeck() {
        SortedBag.Builder<Card> deckB = new SortedBag.Builder<>();
        Deck deck1 = Deck.of(deckB.build(), new Random());
        assertThrows(IllegalArgumentException.class, () -> {
            Deck subDeck = deck1.withoutTopCards(2);
        });

    }

    //Valide si le test ne passe pas

    @Test
    void withoutTopCardsWithCountEqualsSize() {
        SortedBag.Builder<Card> deckB = new SortedBag.Builder<>();
        deckB.add(Card.LOCOMOTIVE);
        deckB.add(Card.BLUE);
        Deck deck1 = Deck.of(deckB.build(), new Random());
        assertThrows(IllegalArgumentException.class, () -> {
            deck1.withoutTopCards(2);
        });
    }

    @Test
    void topCardsTest() {
        SortedBag.Builder<Card> deckB = new SortedBag.Builder<>();
        List<Card> list = new ArrayList<>();
        for (int i = 0; i < 6; ++i) {
            deckB.add(Card.LOCOMOTIVE);
            list.add(Card.LOCOMOTIVE);
        }
        boolean bool = true;
        Deck deck = Deck.of(deckB.build(), new Random());
        List<Object> topCards = deck.topCards(5).toList();
        for (int i = 0; i < topCards.size(); ++i) {
            if (!topCards.get(i).equals(list.get(i))) {
                bool = false;
            }
        }
        assertTrue(bool);

    }

    @Test
    void topCardsCountOverload() {
        SortedBag.Builder<Card> deckB = new SortedBag.Builder<>();
        for (int i = 0; i < 6; ++i) {
            deckB.add(Card.LOCOMOTIVE);
        }
        Deck deck = Deck.of(deckB.build(), new Random());
        assertThrows(IllegalArgumentException.class, () -> {
            deck.topCards(6);
        });
    }

    **/

}