import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class CardTest 
{
    
    @Test public void testEqualsSame() {
        Card c1 = new Card(5, 'H');
        Card c2 = new Card(5, 'H');
        assertEquals(c1, c2);

        Card c3 = new Card(11, 'C');
        Card c4 = new Card(11, 'C');
        assertEquals(c3, c4);
    }

    @Test public void testEqualsNotSame() {
        // Different rank and suit
        Card c1 = new Card(4, 'H');
        Card c2 = new Card(1, 'S');
        assertNotEquals(c1, c2);

        // Same rank, different suit
        Card c3 = new Card(11, 'C');
        Card c4 = new Card(11, 'H');
        assertNotEquals(c3, c4);

        // Same suit, different rank
        assertNotEquals(c1, c4);

        // Wrong type of object
        assertNotEquals(c1, "hello");
    }

    @Test public void testCompareToNegative() {
        // Different rank and suit
        Card first = new Card(2, 'S');
        Card second = new Card(7, 'H');
        
        assertTrue(first.compareTo(second) < 0);

        // Different rank, same suit
        first = new Card(10, 'C');
        second = new Card(11, 'C');
        assertTrue(first.compareTo(second) < 0);

        // Same rank, clubs and diamonds
        first = new Card(4, 'C');
        second = new Card(4, 'D');
        assertTrue(first.compareTo(second) < 0);

        // Same rank, diamonds and spades
        first = new Card(2, 'D');
        second = new Card(2, 'S');
        assertTrue(first.compareTo(second) < 0);

        // Same rank, hearts and spades
        first = new Card(12, 'H');
        second = new Card(12, 'S');
        assertTrue(first.compareTo(second) < 0);
    }

    @Test public void testCompareToPositive() {
        // Different rank and suit
        Card first = new Card(13, 'D');
        Card second = new Card(11, 'C');
        
        assertTrue(first.compareTo(second) > 0);

        // Different rank, same suit
        first = new Card(3, 'H');
        second = new Card(2, 'H');
        assertTrue(first.compareTo(second) > 0);

        // Same rank, hearts and diamonds
        first = new Card(12, 'H');
        second = new Card(12, 'C');
        assertTrue(first.compareTo(second) > 0);

        // Same rank, diamonds and clubs
        first = new Card(8, 'D');
        second = new Card(8, 'C');
        assertTrue(first.compareTo(second) > 0);

        // Same rank, spades and clubs
        first = new Card(3, 'S');
        second = new Card(3, 'C');
        assertTrue(first.compareTo(second) > 0);
    }

    @Test public void testCompareZero() {
        // Equal diamonds
        Card first = new Card(6, 'D');
        Card second = new Card(6, 'D');
        
        assertTrue(first.compareTo(second) == 0);

        // Equal hearts
        first = new Card(4, 'H');
        second = new Card(4, 'H');
        assertTrue(first.compareTo(second) == 0);
    }

    @Test public void testToStringRegular() {
        Card c = new Card(6, 'D');
        assertEquals(c.toString(), "6 of Diamonds");

        c = new Card(2, 'H');
        assertEquals(c.toString(), "2 of Hearts");

        c = new Card(10, 'S');
        assertEquals(c.toString(), "10 of Spades");

        c = new Card(9, 'C');
        assertEquals(c.toString(), "9 of Clubs");
    }

    @Test public void testToStringFaceCards() {
        Card c = new Card(11, 'D');
        assertEquals(c.toString(), "Jack of Diamonds");

        c = new Card(12, 'H');
        assertEquals(c.toString(), "Queen of Hearts");

        c = new Card(13, 'S');
        assertEquals(c.toString(), "King of Spades");

        c = new Card(14, 'C');
        assertEquals(c.toString(), "Ace of Clubs");
    }
}
