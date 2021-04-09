package computers;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ComputerManagerTests {

    private ComputerManager manager;
    private static Computer computer;
    private static final String manufacturer = "Dell";
    private static final String model = "Inspiron";

    @Before
    public void setUp() {
        manager = new ComputerManager();
        int price = 1000;
        computer = new Computer(manufacturer, model, price);
        manager.addComputer(computer);
    }

    @Test
    public void testAddComputerWithCorrectData() {
        setUp();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerShouldFailWithNull() {
        manager.addComputer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerShouldFailWhenComputerExists() {
        manager.addComputer(computer);
    }

    @Test
    public void testRemoveComputer() {
        assertEquals(computer, manager.removeComputer(manufacturer, model));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveComputerShouldFailWhenComputerDoesNotExist() {
        assertNull(manager.removeComputer("Asus", "Rog"));
    }


    @Test
    public void testGetCount() {
        manager.getCount();
        assertEquals(1, manager.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputersShouldFailWithNull() {
        manager.getComputersByManufacturer(null);
    }

    @Test
    public void testGetComputersByManufacturerShouldReturnAllInTheList() {
        Computer computer1 = new Computer("Asus", "Rog", 1000);
        Computer computer2 = new Computer("Macbook", "Pro", 2000);
        manager.addComputer(computer1);
        manager.addComputer(computer2);
        List<Computer> computers = manager.getComputersByManufacturer("Macbook");
        assertEquals(computer2, computers.get(0));
    }
}