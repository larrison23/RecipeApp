package recipeapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class UnitTest {
    @Test
    void testVolumeConversion() {
        assertEquals(48, Unit.CUP.convert(1.0, Unit.TSP));
        assertEquals(3, Unit.TBSP.convert(1.0, Unit.TSP));
        assertEquals(4, Unit.QUART.convert(1.0, Unit.CUP));
    }

    @Test
    void testMassConversion() {
        assertEquals(16, Unit.LB.convert(1, Unit.OZ_MASS));
        assertEquals(8, Unit.LB.convert(0.5, Unit.OZ_MASS));
    }

    @Test
    void testIdentity() {
        assertEquals(10.5, Unit.CUP.convert(10.5, Unit.CUP));
    }

    @Test
    void testBaseHelper() {
        assertEquals(96, Unit.CUP.toBase(2));
        assertEquals(2, Unit.CUP.fromBase(96));
    }

    @Test
    void testIncompatible() {
        assertThrows(IllegalArgumentException.class, () -> {Unit.CUP.convert(1, Unit.LB);});
    }

    @Test
    void testCount() {
        assertEquals(5, Unit.COUNT.convert(5.0, Unit.COUNT));

        assertThrows(IllegalArgumentException.class, () -> {Unit.COUNT.convert(1, Unit.TSP);}); 
    }

    @Test
    void testMetric() {
        double expected = 202.884 / 48.0;

        assertEquals(expected, Unit.LITER.convert(1.0, Unit.CUP));
    }
}
