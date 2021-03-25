import org.junit.Before;
import org.junit.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {

    private Database database;
    private final Integer[] EXPECTED = {13, 42, 69, 72};

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(13, 42, 69, 72);
    }

    @Test
    public void testDataBaseConstructorShouldCreateObjectWithValidState() {
        Integer[] elements = database.getElements();
        assertEquals(EXPECTED.length, elements.length);
        for (int i = 0; i < EXPECTED.length; i++) {
            assertEquals(EXPECTED[i], elements[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDataBaseConstructorShouldThrowWhenCalledWithMoreThanSixteenElements()
            throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDataBaseConstructorShouldThrowWhenCalledZeroElements()
            throws OperationNotSupportedException {
        Integer[] numbers = new Integer[0];
        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowExceptionWhenParameterIsNull()
            throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddShouldAddAtFirstFreeIndex()
            throws OperationNotSupportedException {
        database.add(666);
        Integer[] elements = database.getElements();
        assertEquals(5, elements.length);
        assertEquals(Integer.valueOf(666), elements[4]);
    }

    @Test
    public void testRemoveShouldRemoveLastElement()
            throws OperationNotSupportedException {
        database.remove();
        Integer[] actual = database.getElements();
        Integer[] expected = {13, 42, 69};
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void testRemoveShouldThrowExceptionWithEmptyDatabase()
            throws OperationNotSupportedException {
        for (int i = 0; i < 4; i++) {
        database.remove();
        }
    }

    @Test
    public void testGetElementsShouldReturnCorrectArray() {
        Integer[] actual = database.getElements();
        assertEquals(EXPECTED.length, actual.length);
        for (int i = 0; i < EXPECTED.length; i++) {
            assertEquals(EXPECTED[i], actual[i]);
        }
    }
}
