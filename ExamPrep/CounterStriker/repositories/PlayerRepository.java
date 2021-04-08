package CounterStriker.repositories;

import CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static CounterStriker.common.ExceptionMessages.*;

public class PlayerRepository implements Repository<Player> {

    ArrayList<Player> players;

    public PlayerRepository() {
        this.players = new ArrayList<>();
    }

    @Override
    public Collection<Player> getModels() {
        return Collections.unmodifiableList(players);
    }

    @Override
    public void add(Player model) {
        if (model == null) {
            throw new NullPointerException(INVALID_PLAYER_REPOSITORY);
        }
        players.add(model);
    }

    @Override
    public boolean remove(Player model) {
        for (Player player : players) {
            if (player == model) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Player findByName(String name) {
        return players.stream().filter(p -> p.getUsername().equals(name)).findFirst().orElse(null);
    }
}
