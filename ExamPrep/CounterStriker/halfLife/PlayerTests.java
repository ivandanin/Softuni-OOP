package halfLife;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTests {

    private Player player;
    private final Gun gun1 = new Gun("Pistol", 100);
    private final Gun gun2 = new Gun("Pistol2", 100);


    @Before
    public void setUp() {
        player = new Player("Pesho", 80);
    }

    @Test
    public void testConstructorWithCorrectData() {
        assertEquals("Pesho", player.getUsername());
        assertEquals(80, player.getHealth());
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorShouldFail() {
        new Player("", 101);
        assertEquals("Pesho", player.getUsername());
        assertEquals(80, player.getHealth());
    }

    @Test
    public void testSetUsernameWithCorrectData() {
        assertEquals("Pesho", player.getUsername());
    }

    @Test(expected = NullPointerException.class)
    public void testSetUsernameShouldFailWithNull() {
        new Player(null, 101);
        assertNull(player.getUsername());
    }

    @Test(expected = NullPointerException.class)
    public void testSetUsernameShouldFailBecauseLengthLessThanOne() {
        player = new Player("", 101);
        assertEquals("", player.getUsername());
    }

    @Test
    public void testSetHealthWithCorrectData() {
        assertEquals(80, player.getHealth());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetHealthShouldFailWhenHealthLessThanZero() {
        player = new Player("Pesho", -1);
        assertEquals(-1, player.getHealth());
    }

    @Test
    public void testTakeDamageWithCorrectData() {
        player.takeDamage(40);
        assertEquals(40, player.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testTakeDamageShouldFailWhenHealthLessOrEqualsZero() {
        player.takeDamage(80);
        player.takeDamage(1);
    }

    @Test
    public void testAddGunWithCorrectData() {
        player.addGun(gun1);
    }

    @Test(expected = NullPointerException.class)
    public void testAddGunShouldFailWhenGunIsNull() {
        player.addGun(null);
    }

    @Test
    public void testRemoveGunWithCorrectData() {
        player.addGun(gun1);
        assertTrue(player.removeGun(gun1));
        assertFalse(player.removeGun(gun1));
    }

    @Test
    public void testGetGunShouldReturnGun() {
        player.addGun(gun1);
        player.addGun(gun2);
        assertEquals("Pistol", player.getGun("Pistol").getName());
        assertEquals(100, player.getGun("Pistol").getBullets());
    }
}
