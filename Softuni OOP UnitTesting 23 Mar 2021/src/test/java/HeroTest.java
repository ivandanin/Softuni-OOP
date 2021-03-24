import org.junit.Assert;
import org.junit.Test;
import rpg_lab.Hero;
import rpg_lab.Target;
import rpg_lab.Weapon;

public class HeroTest {
    private static int TARGET_XR;
    private static String HERO_NAME;


    @Test
    public void attackGainsExperienceIfTargetIsDead() {
        Target fakeTarget = new Target() {

            @Override
            public void takeAttack(int attackPoints) {

            }

            @Override
            public int getHealth() {
                return 0;
            }

            @Override
            public int giveExperience() {
                return TARGET_XR;
            }

            @Override
            public boolean isDead() {
                return true;
            }
        };
        Weapon fakeWeapon = new Weapon() {
            @Override
            public void attack(Target target) {

            }

            @Override
            public int getAttackPoints() {
                return 10;
            }

            @Override
            public int getDurabilityPoints() {
                return 0;
            }
        };

        Hero hero = new Hero(HERO_NAME, fakeWeapon);
        hero.attack(fakeTarget);
        Assert.assertEquals("Wrong experience", TARGET_XR, hero.getExperience());
    }
}
