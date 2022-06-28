import axios, {AxiosResponse} from "axios";
import Recipe from "@/models/Recipe";
import {RecipeDTO, RecipeIngredientDTO, StepDTO} from "@/DTOs/RecipeDTO";
import Ingredient from "@/models/Ingredient";
import Step from "@/models/Step";
import Tag from "@/models/Tag";
import {TagDTO} from "@/DTOs/TagDTO";

export default class RecipeService {
    private static BASE_URL = window.location.origin + "/api/recipes";

    public getRecipes(): Promise<Recipe[]> {
        return new Promise<Recipe[]>((resolve, reject) => {
            axios.get(RecipeService.BASE_URL, {withCredentials: true}).then((response: AxiosResponse<RecipeDTO[]>) => {
                const recipes: Recipe[] = [];
                response.data.forEach((recipeDTO: RecipeDTO) => {
                    console.log(recipeDTO)
                    const ingredients: Ingredient[] = [];
                    recipeDTO.recipeIngredients.forEach((ingredientDTO: RecipeIngredientDTO) => {
                        ingredients.push(new Ingredient(ingredientDTO.ingredient.name, ingredientDTO.amount, ingredientDTO.unit));
                    });
                    const steps: Step[] = [];
                    recipeDTO.steps.forEach((stepDTO: StepDTO) => {
                        steps.push(new Step(stepDTO.title, stepDTO.description, stepDTO.stepNumber));
                        console.log(steps)
                    });
                    const tags: Tag[] = [];
                    recipeDTO.tags.forEach((tagDTO: TagDTO) => {
                        tags.push(new Tag(tagDTO.id as string, tagDTO.name));
                    });
                    recipes.push(new Recipe(recipeDTO.id as string, recipeDTO.name, recipeDTO.description, ingredients, steps, recipeDTO.image, recipeDTO.time, recipeDTO.servings, tags, recipeDTO.createdAt as string));
                });
                resolve(recipes)
            }).catch((error) => {
                reject(error);
            });
        });
    }

    public getRecipe(id: string): Promise<Recipe> {
        console.log("Getting recipe with id: " + id);
        return new Promise<Recipe>((resolve, reject) => {
            axios.get(RecipeService.BASE_URL + "/" + id, {withCredentials: true}).then((response: AxiosResponse<RecipeDTO>) => {
                const ingredients: Ingredient[] = [];
                response.data.recipeIngredients.forEach((ingredientDTO: RecipeIngredientDTO) => {
                    ingredients.push(new Ingredient(ingredientDTO.ingredient.name, ingredientDTO.amount, ingredientDTO.unit));
                });
                const steps: Step[] = [];


                response.data.steps.forEach((stepDTO: StepDTO) => {
                    steps.push(new Step(stepDTO.title, stepDTO.description, stepDTO.stepNumber));
                })
                const tags: Tag[] = [];
                tags.forEach((tagDTO: TagDTO) => {
                    tags.push(new Tag(tagDTO.id as string, tagDTO.name));
                });
                steps.sort((a, b) => a.stepNumber - b.stepNumber);

                resolve(new Recipe(response.data.id as string, response.data.name, response.data.description, ingredients, steps, response.data.image, response.data.time, response.data.servings, tags, response.data.createdAt as string));
            }).catch((error) => {
                reject(error);
            });
        });
    }

    public createRecipe(recipe: Recipe): Promise<Recipe> {
        return new Promise<Recipe>((resolve, reject) => {

            const steps: StepDTO[] = [];
            recipe.steps.forEach((step: Step) => {
                steps.push({id: null, title: step.title, description: step.description, stepNumber: step.stepNumber});
            })

            const tags: TagDTO[] = [];
            recipe.tags.forEach((tag: Tag) => {
                tags.push({id: tag.id, name: tag.name});
            })

            const recipeDTO: RecipeDTO = {
                name: recipe.name,
                description: recipe.description,
                image: recipe.image,
                time: recipe.time,
                servings: recipe.servings,
                recipeIngredients: [],
                steps: steps,
                tags: tags,
                createdAt: "",
                id: ""
            };

            axios.post(RecipeService.BASE_URL, recipeDTO, {withCredentials: true}).then((response: AxiosResponse<RecipeDTO>) => {
                const ingredients: Ingredient[] = [];
                response.data.recipeIngredients.forEach((ingredientDTO: RecipeIngredientDTO) => {
                    ingredients.push(new Ingredient(ingredientDTO.ingredient.name, ingredientDTO.amount, ingredientDTO.unit));
                });
                const steps: Step[] = [];
                response.data.steps.forEach((stepDTO: StepDTO) => {
                    steps.push(new Step(stepDTO.title, stepDTO.description, stepDTO.stepNumber));
                })
                steps.sort((a, b) => a.stepNumber - b.stepNumber);
                const tags: Tag[] = [];
                response.data.tags.forEach((tagDTO: TagDTO) => {
                    tags.push(new Tag(tagDTO.id as string, tagDTO.name));
                })
                resolve(new Recipe(response.data.id as string, response.data.name, response.data.description, ingredients, steps, response.data.image, response.data.time, response.data.servings, tags, response.data.createdAt as string));
            }).catch((error) => {
                reject(error);
            });
        });
    }
}