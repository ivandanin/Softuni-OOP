package carTrip;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {

    private Car car;

    @Before
    public void setUp() {
        this.car = new Car("Corolla", 55, 10, 1);
    }

    @Test
    public void testConstructorWithCorrectInput() {
        setUp();
        assertEquals("Corolla", car.getModel());
        assertEquals(55, (int) car.getTankCapacity());
        assertEquals(10, (int) car.getFuelAmount());
        assertEquals(1, (int) car.getFuelConsumptionPerKm());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithWrongInput() {
        new Car(null, 10, 10, 10);
        assertEquals("Corolla", car.getModel());
        assertEquals(55, (int) car.getTankCapacity());
        assertEquals(10, (int) car.getFuelAmount());
        assertEquals(1, (int) car.getFuelConsumptionPerKm());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNameShouldFailWhenNull() {
        new Car(null, 10, 10, 10);
    }

    @Test
    public void testSetNameShouldFailWhenEmpty() {
        new Car(" ", 10, 10, 10);
    }

    @Test
    public void testSetNameWithCorrectData() {
        setUp();
        car.setModel("Alfa");
        assertEquals("Alfa", car.getModel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetFuelAmountShouldFailWhenMoreThanCapacity() {
        setUp();
        car.setFuelAmount(65);
        assertEquals(65, (int) car.getFuelAmount());
    }

    @Test
    public void testSetFuel() {
        setUp();
        car.setFuelAmount(55);
        assertEquals(55, (int) car.getTankCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetFuelConsumptionLessThanZero() {
        setUp();
        car.setFuelConsumptionPerKm(-1);
        assertEquals(-1, (int) car.getFuelConsumptionPerKm());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetFuelConsumptionZero() {
        setUp();
        car.setFuelConsumptionPerKm(0);
        assertEquals(0, (int) car.getFuelConsumptionPerKm());
    }

    @Test
    public void testSetFuelConsumptionToMoreThanFuelCapacity() {
        setUp();
        car.setFuelConsumptionPerKm(55);
        assertEquals(55, (int) car.getFuelConsumptionPerKm());
    }

    @Test(expected = IllegalStateException.class)
    public void testDriveShouldFailBecauseThereIsNotEnoughFuel() {
        setUp();
        car.drive(11);
        assertEquals(0, (int) car.getFuelAmount());
    }

    @Test
    public void testDriveMustReturnCorrectMessageWhenDrive() {

        double testDouble = 1.00;
        double expected = car.getFuelAmount()-testDouble*car.getFuelConsumptionPerKm();
        String message = "Have a nice trip";
        assertEquals(message,car.drive(testDouble));
        assertEquals(expected,car.getFuelAmount(),0.00);
    }

    @Test(expected = IllegalStateException.class)
    public void testRefuelShouldFailWhenFuelIsMoreThanCapacity() {
        setUp();
        car.refuel(60);
        assertEquals(55, (int) car.getFuelAmount());
    }

    @Test
    public void testRefuelShouldFailWhenFuelIsNegative() {
        setUp();
        car.refuel(-60);
        assertEquals(-50, (int) car.getFuelAmount());
    }
}