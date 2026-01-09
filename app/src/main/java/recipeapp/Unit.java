package recipeapp;

public enum Unit {
    TSP("tsp", 1.0, Type.VOLUME), 
    TBSP("tbsp", 3.0, Type.VOLUME),
    FL_OZ("fl oz", 6.0, Type.VOLUME),
    CUP("cup", 48, Type.VOLUME),
    PINT("pt", 96, Type.VOLUME),
    QUART("qt", 192, Type.VOLUME),
    GALLON("gal", 768, Type.VOLUME),
    ML("ml", 0.202884, Type.VOLUME),
    LITER("l", 202.884, Type.VOLUME),

    OZ_MASS("oz", 1.0, Type.MASS),
    LB("lb", 16, Type.MASS),
    GRAM("g", 0.035274, Type.MASS),
    KG("kg", 35.274, Type.MASS),

    COUNT("item", 1, Type.COUNT);


    private enum Type { VOLUME, MASS, COUNT}

    private final String label;
    private final double factor;
    private final Type type;

    Unit(String label, double factor, Type type) {
        this.label = label;
        this.factor = factor;
        this.type = type;
    }

    public String getLabel() {
        return label;
    }

    public double toBase(double quantity) {
        throw new UnsupportedOperationException();
    }

    public double fromBase(double baseQuantity) {
        throw new UnsupportedOperationException();
    }

    public double convert(double quantity, Unit targetUnit) {
        throw new UnsupportedOperationException();
    }
}
