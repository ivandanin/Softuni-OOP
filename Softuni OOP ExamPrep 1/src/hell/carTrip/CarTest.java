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

    @Test(expected = IllegalArgumentException.class)
    public void testSetNameShouldFailWhenNull() {
        new Car(null, 10, 10, 10);
    }

    @Test
    public void testSetNameShouldFailWhenEmpty() {
        new Car(" ", 10, 10, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetFuelAmountShouldFailWhenMoreThanCapacity() {
        setUp();
        car.setFuelAmount(65);
        assertEquals( 65, (int) car.getFuelAmount());
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

    @Test (expected = IllegalStateException.class)
    public void testDriveShouldFailBecauseThereIsNotEnoughFuel() {
        setUp();
        car.drive(11);
        assertEquals(0, (int) car.getFuelAmount());
    }

    @Test (expected = IllegalStateException.class)
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