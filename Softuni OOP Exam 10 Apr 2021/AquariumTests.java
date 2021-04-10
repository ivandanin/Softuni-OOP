package aquarium;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

public class AquariumTests {

    Aquarium aquarium;
    private Collection<Fish> fish;

    @Before
    public void setUp() {
       aquarium = new Aquarium("aqua1", 2);
       fish = new ArrayList<>();
    }


    @Test
    public void testSetNameWithCorrectData() {
        assertEquals("aqua1", aquarium.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldFailWhenNull() {
        aquarium = new Aquarium(null, 100);
        assertNull(null, aquarium.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldFailWhenEmpty() {
        aquarium = new Aquarium("    ", 100);
        assertNull("    ", aquarium.getName());
    }

    @Test
    public void testSetCapacityWithCorrectData() {
        assertEquals(2, aquarium.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldFailWhenCapacityLessThanZero() {
        aquarium = new Aquarium("aqua", -1);
        assertEquals(2, aquarium.getCapacity());
    }

    @Test
    public void testAddWithCorrectData() {
        Fish fishy = new Fish("Fishko");
        aquarium.add(fishy);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldFailWhenAquariumIsFull() {
        Fish fishy = new Fish("Fishko");
        Fish fishy2 = new Fish("Fishko");
        Fish fishy3 = new Fish("Fishko");
        aquarium.add(fishy);
        aquarium.add(fishy2);
        aquarium.add(fishy3);
        assertEquals(2, aquarium.getCapacity());
    }

    @Test
    public void testRemoveWithCorrectData() {
        Fish fishy = new Fish("Fishko");
        Fish fishy2 = new Fish("Fishko2");
        aquarium.add(fishy);
        aquarium.add(fishy2);
        aquarium.remove("Fishko");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveShouldFailWhenRemovingNull() {
        aquarium.remove(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveShouldFailWhenRemovingADoesNotExistName() {
        aquarium.remove("Fishko");
    }

    @Test
    public void testSellFishWithCorrectData() {
        Fish fishy = new Fish("Fishko");
        Fish fishy2 = new Fish("Fishko2");
        aquarium.add(fishy);
        aquarium.add(fishy2);
        aquarium.sellFish("Fishko");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellFishShouldFailWhenRemovingNull() {
        aquarium.sellFish(null);
    }


    @Test
    public void testReportMustReturnsCorrectReportOfFishInCollection() {
        Fish fishy = new Fish("Fishko");
        Fish fishy2 = new Fish("Fishko2");
        aquarium.add(fishy);
        aquarium.add(fishy2);
        String expected = "Fish available at aqua1: Fishko, Fishko2";
        assertEquals(expected, aquarium.report());
    }
}

