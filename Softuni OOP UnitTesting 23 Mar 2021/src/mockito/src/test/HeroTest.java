import org.junit.Assert;
import org.junit.Test;
import rpg_lab.Hero;
import rpg_lab.Target;
import rpg_lab.Weapon;

import static org.mockito.Mockito.*;

public class HeroTest {


    @Test
    public void attackGainsExperienceIfTargetIsDead() {
        Weapon fakeWeapon = mock(Weapon.class);
        Target fakeTarget = mock(Target.class);

        when(fakeTarget.isDead()).thenReturn(true);
        when(fakeTarget.giveExperience()).thenReturn(13);

        Hero hero = new Hero("HERO_NAME", fakeWeapon);

        hero.attack(fakeTarget);

        Assert.assertEquals("Wrong experience", 13, hero.getExperience());
    }
}
