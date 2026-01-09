package recipeapp;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RecipeTest {
    private Recipe recipe;
    private Ingredient flour;
    private Ingredient milk;
    
    @BeforeEach
    void setUp() {
        recipe = new Recipe("Pancakes");
        flour = new Ingredient("Flour", Location.PANTRY);
        milk = new Ingredient("Milk", Location.DAIRY);
    }

    @Test
    void testName() {
        assertEquals("Pancakes", recipe.getName());
    }

    @Test
    void testAddIngredient() {
        recipe.addIngredient(flour, 1, Unit.CUP, null);
        recipe.addIngredient(milk, 1, Unit.GALLON, "whisked");

        assertEquals(2, recipe.getIngredients().size());
        assertEquals("Flour", recipe.getIngredients().get(0).getIngredient().getName());
    }

    @Test
    void testScale() {
        recipe.addIngredient(flour, 1, Unit.CUP, null);
        recipe.addIngredient(milk, 1, Unit.GALLON, "whisked");

        recipe.scale(2);

        List<RecipeIngredient> ingredients = recipe.getIngredients();

        assertEquals(2, ingredients.get(0).getQuantity());
        assertEquals(2, ingredients.get(1).getQuantity());
    }

    @Test
    void testNull() {
        assertThrows(IllegalArgumentException.class, () -> {recipe.addIngredient(null, 1, Unit.COUNT, null);});
    }

    @Test
    void testString() {
        recipe.addIngredient(flour, 1, Unit.CUP, null);
        recipe.addIngredient(milk, 1, Unit.GALLON, "whisked");

        System.err.println(recipe);

        assertTrue(recipe.toString().contains("Milk: 1 gal, whisked"));
        assertTrue(recipe.toString().contains("Flour: 1 cup"));
    }
}
