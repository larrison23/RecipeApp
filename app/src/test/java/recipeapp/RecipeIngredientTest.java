package recipeapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RecipeIngredientTest {
    private Ingredient milk;

    @BeforeEach
    void setUp() {
        milk = new Ingredient("Milk", Location.DAIRY);
    }

    @Test
    void testCreation() {
        RecipeIngredient ri = new RecipeIngredient(milk, 1, Unit.GALLON, null);

        assertEquals(milk, ri.getIngredient());
        assertEquals(1, ri.getQuantity());
        assertEquals(Unit.GALLON, ri.getUnit());
        assertFalse(ri.getPrep());
        assertEquals("", ri.getPrepNote());
    }

    @Test
    void testScale() {
        RecipeIngredient ri = new RecipeIngredient(milk, 1, Unit.GALLON, null);

        ri.scale(2);

        assertEquals(2, ri.getQuantity());
    }

    @Test
    void testScaleToZero() {
        RecipeIngredient ri = new RecipeIngredient(milk, 1, Unit.GALLON, null);

        ri.scale(0);

        assertEquals(0, ri.getQuantity());
    }

    @Test
    void testString() {
        RecipeIngredient ri = new RecipeIngredient(milk, 1, Unit.GALLON, "frozen");

        String result = ri.toString();

        System.out.println(result);

        assertTrue(result.contains("1 gal"));
        assertTrue(result.contains("frozen"));
        assertTrue(ri.getPrep());
        
        RecipeIngredient nullPrep = new RecipeIngredient(milk, 1, Unit.GALLON, null);
        assertFalse(nullPrep.toString().contains(","));
        assertFalse(nullPrep.getPrep());
    }

    @Test
    void testNull() {
        RecipeIngredient ri = new RecipeIngredient(milk, 1, Unit.GALLON, null);

        String result = ri.toString();

        assertEquals("Milk: 1 gal", result.trim());
        assertFalse(result.contains("null"));
    }

    @Test
    void testNegative() {
        assertThrows(IllegalArgumentException.class, () -> new RecipeIngredient(milk, -1, Unit.GALLON, null));
    }
}
