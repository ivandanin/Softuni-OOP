import org.junit.Assert;
import org.junit.Test;
import rpg_lab.Dummy;

public class DummyTest {

    private static final int ATTACK = 5;
    private static final int DURABILITY = 10;


    private Dummy createDummy() {
        return new Dummy(10, 10);
    }

    private Dummy createDeadDummy() {
        return new Dummy(0, 10);
    }

    @Test
    public void dummyLosesHealthWhenAttacked() {
        Dummy dummy = createDeadDummy();
        dummy.takeAttack(ATTACK);
        Assert.assertEquals(5, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testDeadDummyAttacked() {
        Dummy dummy = createDeadDummy();
        dummy.takeAttack(ATTACK);
        Assert.assertEquals(0, dummy.getHealth());
    }

    @Test
    public void testDeadDummyGivesExperience() {
        Dummy dummy = createDeadDummy();
        int actualExperience = dummy.giveExperience();
        Assert.assertEquals(DURABILITY, actualExperience);
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyGivesExperience() {
        Dummy dummy = createDummy();
        dummy.giveExperience();
    }
}
