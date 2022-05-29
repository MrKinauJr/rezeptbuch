import Ingredient from "@/models/Ingredient";
import Step from "@/models/Step";

export default class Recipe {
    id: number;
    name: string;
    description: string;
    ingredients: Ingredient[];
    steps: Step[];
    image: string;
    time: number;
    servings: number;
    tags: string[];


    constructor(id: number, name: string, description: string, ingredients: Ingredient[], steps: Step[], image: string, time: number, servings: number, tags: string[]) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.steps = steps;
        this.image = image;
        this.time = time;
        this.servings = servings;
        this.tags = tags;
    }
}