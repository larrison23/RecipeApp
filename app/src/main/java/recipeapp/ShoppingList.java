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
            addIngredient(ri.getIngredient(), ri.getQuantity(), ri.getUnit(), ri.getPrepNote());
        }
    }

    public void addIngredient(Ingredient ingredient, double qty, Unit unit, String prepNote) {
        if (items.containsKey(ingredient)) {
            RecipeIngredient cur = items.get(ingredient);
            try {
                double convertQty = unit.convert(qty, cur.getUnit());

                double newQuantity = cur.getQuantity() + convertQty;
                cur.setQuantity(newQuantity);

                prepNote = (prepNote == null) ? "" : prepNote;

                if (!prepNote.isEmpty()) {
                    String prep = cur.getPrepNote();
                    if (cur.getPrep()) {
                        cur.setPrepNote(prep + ", " + prepNote);
                    } else {
                        cur.setPrepNote(prepNote);
                    }
                }
            } catch (Exception e) {
                System.err.println("Could not merge " + cur.getIngredient().getName() + ". " + e.getMessage());
            }
        } else {
            RecipeIngredient ri = new RecipeIngredient(ingredient, qty, unit, prepNote);
            items.put(ingredient, ri);
        }
    }

    public void clear() {
        items.clear();
    }

    public List<RecipeIngredient> getSortedList() {
        List<RecipeIngredient> ris = new ArrayList<>(items.values());
        Collections.sort(ris);
        return ris;
    }

    @Override
    public String toString() {
        List<RecipeIngredient> ris = getSortedList();
        // ? Somehow this is still printing out an extra comma after items with no prep

        StringBuilder output = new StringBuilder("--------SHOPPING LIST-------\n");
        Location cur = null;

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
