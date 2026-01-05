package recipeapp;

public class Main {
    public static void main(String[] args) {
        Recipe chicPic = makeChicPic();

        System.out.println(chicPic);
    }

    private static Recipe makeChicPic() {
        Recipe chicPic = new Recipe("Chicken Picatta");

        chicPic.addIngredient(new Ingredient("Boneless, Skinless, Chicken Thighs", Location.MEAT), 1, "pound", "cut into 1-inch cubes");
        chicPic.addIngredient(new Ingredient("Lemon", Location.PRODUCE), 1, "item", null);
        chicPic.addIngredient(new Ingredient("Shallot", Location.PRODUCE), 1, "item", "chopped");
        chicPic.addIngredient(new Ingredient("Orzo", Location.PANTRY), 1, "cup", null);
        chicPic.addIngredient(new Ingredient("Capers", Location.PANTRY), 1, "tablespoon", null);
        chicPic.addIngredient(new Ingredient("Chicken Stock", Location.PANTRY), 2, "cups", null);

        return chicPic;
    }
}
