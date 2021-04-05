package hell.entities.items;

import hell.interfaces.Recipe;

import java.util.List;

public class RecipeItem extends Items implements Recipe {

    public RecipeItem(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus) {
        super(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
    }


    @Override
    public List<String> getRequiredItems() {
        return null;
    }
}
