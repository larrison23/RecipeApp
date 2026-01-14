# RecipeApp

Application that allows a user to select a set of recipes and output a shopping list with categories and the prep needed for those ingredients.

## Architecture

Contains:
1. Ingredient class which contains the name and location of a given ingredient
2. RecipeIngredient class which contains an ingredient and the quantity/prep for a given ingredient
3. Recipe class which contains a list of RecipeIngredients needed
4. ShoppingList class which contains a list of RecipeIngredients provided either individually or through added Recipes

## Run/Test

To run: `./gradlew run`

To test: `./gradlew test`

To build: `./gradlew clean build`