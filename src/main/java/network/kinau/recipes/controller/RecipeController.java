package network.kinau.recipes.controller;

import network.kinau.recipes.dto.RecipeDto;
import network.kinau.recipes.services.RecipeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RecipeService recipeService;

    @GetMapping()
    public List<RecipeDto> getAllRecipes() {
        return recipeService.getAllRecipes()
                .stream()
                .map(recipe -> modelMapper.map(recipe, RecipeDto.class))
                .collect(Collectors.toList());
    }
}
