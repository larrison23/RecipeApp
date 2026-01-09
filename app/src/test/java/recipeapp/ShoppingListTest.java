package recipeapp;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShoppingListTest {
    private ShoppingList sList;
    private Ingredient onion;
    private Ingredient milk;
    private Ingredient bread;

    @BeforeEach
    void setUp() {
        sList = new ShoppingList();

        onion = new Ingredient("Onion", Location.PRODUCE);
        milk = new Ingredient("Milk", Location.DAIRY);
        bread = new Ingredient("Bread", Location.BAKERY);
    }

    @Test
    void mergeDups() {
        Recipe soup = new Recipe("Soup");

        soup.addIngredient(onion, 1, Unit.COUNT, null);

        Recipe salad = new Recipe("Salad");

        salad.addIngredient(onion, 2, Unit.COUNT, null);

        sList.addRecipe(soup);
        sList.addRecipe(salad);

        List<RecipeIngredient> items = sList.getSortedList();

        assertEquals(1, items.size());
        assertEquals("Onion", items.get(0).getIngredient().getName());
        assertEquals(3, items.get(0).getQuantity());
    }

    @Test
    void distinct() {
        Recipe soup = new Recipe("Soup");

        soup.addIngredient(onion, 1, Unit.COUNT, null);

        Recipe cereal = new Recipe("Cereal");

        cereal.addIngredient(milk, 1, Unit.GALLON, null);

        sList.addRecipe(soup);
        sList.addRecipe(cereal);

        List<RecipeIngredient> items = sList.getSortedList();

        assertEquals(2, items.size());
    }

    @Test
    void sort() {
        sList.addIngredient(onion, 1, Unit.COUNT, "diced");
        sList.addIngredient(milk, 1, Unit.GALLON, null);
        sList.addIngredient(bread, 1, Unit.COUNT, null);

        List<RecipeIngredient> items = sList.getSortedList();

        assertEquals(onion, items.get(2).getIngredient());
        assertEquals(milk, items.get(1).getIngredient());
        assertEquals(bread, items.get(0).getIngredient());
    }

    @Test
    void twoPrep() {
        sList.addIngredient(onion, 1, Unit.COUNT, "diced");
        sList.addIngredient(onion, 1, Unit.COUNT, "cubed");

        List<RecipeIngredient> items = sList.getSortedList();

        assertEquals(onion, items.get(0).getIngredient());
        assertTrue(items.get(0).toString().contains(", diced, cubed"));

        sList.clear();
        sList.addIngredient(onion, 1, Unit.COUNT, "");
        sList.addIngredient(onion, 1, Unit.COUNT, "diced");

        assertEquals(onion, items.get(0).getIngredient());
        assertFalse(items.get(0).toString().contains(", ,"));

        assertFalse(sList.toString().contains(", ,"));
    }

    @Test
    void testMergeDifferentUnits() {
        sList.addIngredient(milk, 1, Unit.QUART, "");
        sList.addIngredient(milk, 2, Unit.CUP, "");

        List<RecipeIngredient> result = sList.getSortedList();

        assertEquals(1, result.size());
        assertEquals(1.5, result.get(0).getQuantity());
        assertEquals(Unit.QUART, result.get(0).getUnit());
    }

    @Test
    void testIncompatible() {
        sList.addIngredient(milk, 1, Unit.CUP, "");
        sList.addIngredient(milk, 1, Unit.COUNT, "");

        assertEquals(1, sList.getSortedList().get(0).getQuantity());
    }

    
}
