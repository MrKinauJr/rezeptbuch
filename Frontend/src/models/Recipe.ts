import Ingredient from "@/models/Ingredient";
import Step from "@/models/Step";
import Tag from "@/models/Tag";

export default class Recipe {
    id: string;
    name: string;
    description: string;
    ingredients: Ingredient[];
    steps: Step[];
    image: string;
    time: number;
    servings: number;
    tags: Tag[];
    createdAt: string;


    constructor(id: string, name: string, description: string, ingredients: Ingredient[], steps: Step[], image: string, time: number, servings: number, tags: Tag[], createdAt: string) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.steps = steps;
        this.image = image;
        this.time = time;
        this.servings = servings;
        console.log(tags);
        this.tags = tags;
        this.createdAt = createdAt;
    }
}