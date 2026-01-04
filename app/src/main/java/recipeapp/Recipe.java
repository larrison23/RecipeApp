package recipeapp;

import java.util.List;
import java.util.Map;

public class Recipe {
    private String name;
    private Map<Ingredient, RecipeIngredient> ingredientMap;

    public Recipe(String name) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public List<RecipeIngredient> getIngredients() {
        throw new UnsupportedOperationException();
    }

    public void addIngredient(Ingredient ingredient, double qty, String unit, String prepNote) {
        throw new UnsupportedOperationException();
    }

    public void scale(double factor) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException();
    }
}
