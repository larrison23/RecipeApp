package recipeapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class IngredientTest {

    @Test
    void testCreation() {
        Ingredient test = new Ingredient("Milk", Location.DAIRY);

        assertEquals("Milk", test.getName());
        assertEquals(Location.DAIRY, test.getLocation());
    }

    @Test
    void testEquality() {
        Ingredient milk = new Ingredient("Milk", Location.DAIRY);
        Ingredient milk2 = new Ingredient("Milk", Location.DAIRY);
        
        assertEquals(milk, milk2);

        Ingredient milkL = new Ingredient("milk", Location.DAIRY);

        assertEquals(milk, milkL);

        Ingredient cheese = new Ingredient("Cheese", Location.DAIRY);

        assertNotEquals(milk, cheese);

        Ingredient milkP = new Ingredient("Milk", Location.PANTRY);

        assertNotEquals(milk, milkP);
    }

    @Test
    void testHashCode() {
        Ingredient m = new Ingredient("Milk", Location.DAIRY);
        Ingredient k = new Ingredient("Milk", Location.DAIRY);

        assertEquals(m.hashCode(), k.hashCode());
    }

    @Test
    void testError() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Ingredient(null, Location.PANTRY);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Ingredient("Milk", null);
        });
    }
}
