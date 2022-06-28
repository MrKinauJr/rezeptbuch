package network.kinau.recipes.controller;

import network.kinau.recipes.dto.RecipeDto;
import network.kinau.recipes.services.RecipeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RecipeService recipeService;


    @GetMapping("/{id}")
    public RecipeDto getRecipe(@PathVariable("id") long id) {
        return modelMapper.map(recipeService.getRecipe(id), RecipeDto.class);
    }


    @GetMapping()
    public List<RecipeDto> getAllRecipes() {
        return recipeService.getAllRecipes()
                .stream()
                .map(recipe -> modelMapper.map(recipe, RecipeDto.class))
                .toList();
    }

    @PostMapping()
    public RecipeDto createRecipe(@RequestBody RecipeDto recipeDto) {
        return modelMapper.map(recipeService.createRecipe(recipeDto), RecipeDto.class);
    }
}
