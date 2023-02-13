package com.example.finalproject;

public class recipes {

    private String RecipeName;
    private  String RecipeIngredients;
    private String RecipeMethodTitle;
    private String Recipe;
    private String Category;
    private int Image;


    public recipes(String name,String recipeIngredients, String recipeMethodTitle,String recipe,String category, int image ){

        this.RecipeName = name;
        this.Image = image;
        this.RecipeIngredients = recipeIngredients;
        this.Recipe = recipe;
        this.RecipeMethodTitle = recipeMethodTitle;
        this.Category = category;
    }

    public String getRecipeName(){
        return RecipeName;
    }
    public String getRecipeIngredients(){
        return RecipeIngredients;
    }
    public String getRecipeMethodTitle(){
        return RecipeMethodTitle;
    }
    public String getRecipe(){
        return Recipe;
    }
    public int getImage(){
        return Image;
    }
    public String getCategory() {return Category;}

}
