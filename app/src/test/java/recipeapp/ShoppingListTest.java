package recipeapp;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

        soup.addIngredient(onion, 1, "item", null);

        Recipe salad = new Recipe("Salad");

        salad.addIngredient(onion, 2, "item", null);

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

        soup.addIngredient(onion, 1, "item", null);

        Recipe cereal = new Recipe("Cereal");

        cereal.addIngredient(milk, 1, "gallon", null);

        sList.addRecipe(soup);
        sList.addRecipe(cereal);

        List<RecipeIngredient> items = sList.getSortedList();

        assertEquals(2, items.size());
    }

    @Test
    void sort() {
        sList.addIngredient(onion, 1, "item", "diced");
        sList.addIngredient(milk, 1, "gallon", null);
        sList.addIngredient(bread, 1, "loaf", null);

        List<RecipeIngredient> items = sList.getSortedList();

        assertEquals(onion, items.get(2).getIngredient());
        assertEquals(milk, items.get(1).getIngredient());
        assertEquals(bread, items.get(0).getIngredient());
    }
}
