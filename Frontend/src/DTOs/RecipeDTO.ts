export interface RecipeDTO {
    id: number;
    name: string;
    description: string;
    image: string;
    time: number;
    servings: number;
    recipeIngredients: RecipeIngredientDTO[];
    steps: StepDTO[];
}

export interface RecipeIngredientDTO {
    ingredient: IngredientDTO;
    amount: number;
    unit: string;
}

export interface IngredientDTO {
    id: number;
    name: string;
}

export interface StepDTO {
    id: number;
    stepNumber: number;
    description: string;
    title: string;
}
