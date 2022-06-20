import axios, {AxiosResponse} from "axios";
import Recipe from "@/models/Recipe";
import {RecipeDTO, RecipeIngredientDTO, StepDTO} from "@/DTOs/RecipeDTO";
import Ingredient from "@/models/Ingredient";
import Step from "@/models/Step";

export default class RecipeService {
    public getRecipes(): Promise<Recipe[]> {
        return new Promise<Recipe[]>((resolve) => {
            axios.get("http://localhost/api/recipes", {withCredentials: true}).then((response: AxiosResponse<RecipeDTO[]>) => {
                const recipes: Recipe[] = [];
                response.data.forEach((recipeDTO: RecipeDTO) => {
                    const ingredients: Ingredient[] = [];
                    recipeDTO.recipeIngredients.forEach((ingredientDTO: RecipeIngredientDTO) => {
                        ingredients.push(new Ingredient(ingredientDTO.ingredient.name, ingredientDTO.amount, ingredientDTO.unit));
                    });
                    const steps: Step[] = [];
                    recipeDTO.steps.forEach((stepDTO: StepDTO) => {
                        steps.push(new Step(stepDTO.title, stepDTO.description, stepDTO.stepNumber));
                        console.log(steps)
                    });
                    recipes.push(new Recipe(recipeDTO.id, recipeDTO.name, recipeDTO.description, ingredients, steps, recipeDTO.image, recipeDTO.time, recipeDTO.servings, []));
                });
                resolve(recipes)
            });
        });
    }
}