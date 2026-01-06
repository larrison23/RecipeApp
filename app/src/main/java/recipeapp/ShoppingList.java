package recipeapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingList {
    private final Map<Ingredient, RecipeIngredient> items = new HashMap<>();

    public void addRecipe(Recipe recipe) {
        if (recipe == null) return;

        for (RecipeIngredient ri : recipe.getIngredients()) {
            Ingredient key = ri.getIngredient();

            if (items.containsKey(key)) {
                RecipeIngredient cur = items.get(key);
                double newQuantity = cur.getQuantity() + ri.getQuantity();
                cur.setQuantity(newQuantity);
            } else {
                RecipeIngredient val = new RecipeIngredient(key, ri.getQuantity(), ri.getUnit(), ri.getPrepNote());
                items.put(key, val);
            }
        }
    }

    public void addIngredient(Ingredient ingredient, double qty, String unit, String prepNote) {
        if (items.containsKey(ingredient)) {
            RecipeIngredient cur = items.get(ingredient);
            double newQuantity = cur.getQuantity() + qty;
            cur.setQuantity(newQuantity);

            if (prepNote != null) {
                StringBuilder prep = new StringBuilder(cur.getPrepNote());
                prep.append(", ").append(prepNote);
                cur.setPrepNote(prep.toString());
            }
        } else {
            RecipeIngredient ri = new RecipeIngredient(ingredient, qty, unit, prepNote);
            items.put(ingredient, ri);
        }
    }

    public List<RecipeIngredient> getSortedList() {
        List<RecipeIngredient> ris = new ArrayList<>(items.values());
        Collections.sort(ris);
        return ris;
    }

    @Override
    public String toString() {
        List<RecipeIngredient> ris = getSortedList();

        StringBuilder output = new StringBuilder("--------SHOPPING LIST-------\n");
        Location cur = Location.BAKERY;

        for (RecipeIngredient ri : ris) {
            if (ri.getIngredient().getLocation() != cur) {
                cur = ri.getIngredient().getLocation();
                output.append("--------").append(cur).append("--------\n");
            }
            output.append(ri).append("\n");
        }

        return output.toString();
    }
}
