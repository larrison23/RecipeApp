package recipeapp;

public enum Location {
    BAKERY("Bakery & Bread", 100),
    MEAT("Meat & Seafood", 200),
    DAIRY("Dairy & Cheese", 300),
    PANTRY("Dry Goods", 400),
    FROZEN("Frozen Foods", 500),
    PRODUCE("Produce", 600),
    UNKNOWN("Other", 999);

    private final String displayName;
    private final int sortOrder;

    Location(String displayName, int sortOrder) {
        this.displayName = displayName;
        this.sortOrder = sortOrder;
    }

    @Override
    public String toString() {
        return displayName;
    }

    public int getSortOrder() {
        return sortOrder;
    }
}
