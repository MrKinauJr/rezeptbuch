import {TagDTO} from "@/DTOs/TagDTO";

export interface RecipeDTO {
    id: string | null;
    name: string;
    description: string;
    image: string;
    time: number;
    servings: number;
    recipeIngredients: RecipeIngredientDTO[];
    steps: StepDTO[];
    tags: TagDTO[];
    createdAt: string | null;
}

export interface RecipeIngredientDTO {
    ingredient: IngredientDTO;
    amount: number;
    unit: string;
}

export interface IngredientDTO {
    id: string | null;
    name: string;
}

export interface StepDTO {
    id: string | null;
    stepNumber: number;
    description: string;
    title: string;
}
