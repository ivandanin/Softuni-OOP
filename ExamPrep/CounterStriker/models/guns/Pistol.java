package CounterStriker.models.guns;

public class Pistol extends GunImpl {

    private final int PISTOL_BULLETS_TO_SHOOT = 1;

    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (super.getBulletsCount() < PISTOL_BULLETS_TO_SHOOT) {
            return 0;
        }
        super.decreaseBullets(PISTOL_BULLETS_TO_SHOOT);
        return PISTOL_BULLETS_TO_SHOOT;
    }
}
