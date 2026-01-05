package recipeapp;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String name;
    private List<RecipeIngredient> ingredients;

    public Recipe(String name) {
        this.name = name;
        ingredients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<RecipeIngredient> getIngredients() {
        return ingredients;
    }

    public void addIngredient(Ingredient ingredient, double qty, String unit, String prepNote) {
        RecipeIngredient ri = new RecipeIngredient(ingredient, qty, unit, prepNote);
        ingredients.add(ri);
    }

    public void scale(double factor) {
        for (RecipeIngredient ri : ingredients) {
            ri.scale(factor);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (RecipeIngredient ri : ingredients) {
            result.append(ri).append("\n");
        }

        return result.toString();
    }
}
