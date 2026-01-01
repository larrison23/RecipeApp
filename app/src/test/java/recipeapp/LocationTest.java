package recipeapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class LocationTest {
    
    @Test
    void testDisplayName() {
        assertEquals("Produce", Location.PRODUCE.toString());
        assertEquals("Dairy & Cheese", Location.DAIRY.toString());
    }

    @Test
    void testSortOrder() {
        assertEquals(600, Location.PRODUCE.getSortOrder());
        assertEquals(300, Location.DAIRY.getSortOrder());
    }

    @Test
    void testRelativeSortOrder() {
        assertTrue(Location.BAKERY.getSortOrder() < Location.DAIRY.getSortOrder());
        assertTrue(Location.PRODUCE.getSortOrder() > Location.MEAT.getSortOrder());
    }

    @Test
    void testObject() {
        Location loc = Location.valueOf("MEAT");
        assertEquals(Location.MEAT, loc);
    }
}
