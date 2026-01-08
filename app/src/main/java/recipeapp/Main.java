package recipeapp;

public class Main {
    public static void main(String[] args) {
        ShoppingList sList = new ShoppingList();

        sList.addRecipe(chicPic());
        sList.addRecipe(bakedPasta());
        sList.addRecipe(lemonPepChic());

        System.out.print(sList.toString());
    }

    private static Recipe chicPic() {
        Recipe chicPic = new Recipe("Chicken Picatta");

        chicPic.addIngredient(new Ingredient("Boneless, Skinless, Chicken Thighs", Location.MEAT), 1, "pound", "cut into 1-inch cubes");
        chicPic.addIngredient(new Ingredient("Lemon", Location.PRODUCE), 1, "item", null);
        chicPic.addIngredient(new Ingredient("Shallot", Location.PRODUCE), 1, "item", "chopped");
        chicPic.addIngredient(new Ingredient("Orzo", Location.PANTRY), 1, "cup", null);
        chicPic.addIngredient(new Ingredient("Capers", Location.PANTRY), 1, "tablespoon", null);
        chicPic.addIngredient(new Ingredient("Chicken Stock", Location.PANTRY), 2, "cups", null);

        return chicPic;
    }

    private static Recipe bakedPasta() {
        Recipe bakedPasta = new Recipe("Baked Pasta");

        bakedPasta.addIngredient(new Ingredient("Crushed Tomatoes", Location.PANTRY), 2, "28-ounce can", null);
        bakedPasta.addIngredient(new Ingredient("Butter", Location.DAIRY), 1, "stick", null);
        bakedPasta.addIngredient(new Ingredient("Mozzarella", Location.DAIRY), 6, "ounces", "sliced");
        bakedPasta.addIngredient(new Ingredient("Parmesan", Location.DAIRY), 0.5, "cups", "grated");
        bakedPasta.addIngredient(new Ingredient("Ricotta", Location.DAIRY), 0.5, "cups", null);
        bakedPasta.addIngredient(new Ingredient("Cavatappi", Location.PANTRY), 1, "lb", null);

        return bakedPasta;
    }

    private static Recipe lemonPepChic() {
        Recipe lemonPepChic = new Recipe("Lemon Pepper Chicken");

        lemonPepChic.addIngredient(new Ingredient("Lemon", Location.PRODUCE), 4, "items", "zest");
        lemonPepChic.addIngredient(new Ingredient("Bone-In, Skin-On Chicken Thighs", Location.MEAT), 2, "lbs", null);
        lemonPepChic.addIngredient(new Ingredient("Chicken Stock", Location.PANTRY), 0.5, "cups", null);
        lemonPepChic.addIngredient(new Ingredient("Large Yukon Gold Potatoes", Location.PRODUCE), 3, "lbs", "peeled and cut into 8");

        return lemonPepChic;
    }
}
