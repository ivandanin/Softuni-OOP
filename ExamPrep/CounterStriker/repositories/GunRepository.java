package CounterStriker.repositories;
import CounterStriker.models.guns.Gun;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static CounterStriker.common.ExceptionMessages.*;

public class GunRepository implements Repository<Gun> {

    ArrayList<Gun> guns;

    public GunRepository() {
        this.guns = new ArrayList<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return Collections.unmodifiableList(guns);
    }

    @Override
    public void add(Gun model) {
        if (model == null) {
            throw new NullPointerException(INVALID_GUN_REPOSITORY);
        }
        guns.add(model);
    }

    @Override
    public boolean remove(Gun model) {

        for (Gun gun : guns) {
            if (gun == model) {
                guns.remove(model);
                return true;
            }
        }
        return false;
    }

    @Override
    public Gun findByName(String name) {
        return guns.stream().filter(g -> g.getName().equals(name)).findFirst().orElse(null);
    }
}
