package CounterStriker.models.guns;

public class Rifle extends GunImpl {

    private static final int RIFLE_BULLETS_TO_SHOOT = 10;

    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (super.getBulletsCount() < RIFLE_BULLETS_TO_SHOOT) {
            return 0;
        }
        super.decreaseBullets(RIFLE_BULLETS_TO_SHOOT);
        return RIFLE_BULLETS_TO_SHOOT;
    }
}
