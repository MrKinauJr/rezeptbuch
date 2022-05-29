package network.kinau.recipes.repositories;

import network.kinau.recipes.entities.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    List<Recipe> findAll();
}
