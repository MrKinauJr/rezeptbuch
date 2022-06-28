package network.kinau.recipes.services;

import network.kinau.recipes.dto.RecipeDto;
import network.kinau.recipes.entities.Recipe;
import network.kinau.recipes.entities.Step;
import network.kinau.recipes.repositories.RecipeRepository;
import network.kinau.recipes.repositories.TagRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private StepService stepService;

    @Autowired
    private ModelMapper modelMapper;

    public Recipe getRecipe(Long id) {
        return recipeRepository.getRecipeById(id);
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public RecipeDto createRecipe(RecipeDto recipeDto) {
        Recipe recipe = modelMapper.map(recipeDto, Recipe.class);
        Recipe savedRecipe = recipeRepository.save(recipe);

        recipeDto.getSteps().forEach(stepDto -> {
            Step step = modelMapper.map(stepDto, Step.class);
            step.setRecipe(savedRecipe);
            stepService.saveStep(step);
        });

        recipeDto.getTags().forEach(tagDto -> savedRecipe.getTags().add(tagRepository.findById(Long.parseLong(tagDto.getId())).get()));
        recipeRepository.save(savedRecipe);

        return modelMapper.map(savedRecipe, RecipeDto.class);
    }
}
