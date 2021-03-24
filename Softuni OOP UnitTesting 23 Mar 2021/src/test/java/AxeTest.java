import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class AxeTest {

    private static final int ATTACK = 10;
    private static final int DURABILITY = 1;


    private Axe axe;
    private Dummy dummy;

    @Before
    public void setUp() {
        this.axe = createAxe(ATTACK, DURABILITY);
        this.dummy = createDummy();
    }

    @Test
    public void testIfWeaponLosesDurabilityWhenAttacking() {
        //Arrange
        setUp();
        //Act
        axe.attack(dummy);
        //Assert
        Assert.assertEquals(19, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void testIfBrokenWeaponAttack() {
        setUp();
        axe.attack(dummy);
        axe.attack(dummy);
    }

    private Dummy createDummy() {
        return new Dummy(100, 100);
    }

    private Axe createAxe(int attack, int durability) {
        return new Axe(attack, durability);
    }
}
