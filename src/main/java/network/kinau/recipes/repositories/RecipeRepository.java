package network.kinau.recipes.repositories;

import network.kinau.recipes.entities.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNullApi;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    @Query("select r from Recipe r where r.id = :id")
    Recipe getRecipeById(@Param("id") Long id);
    List<Recipe> findAll();
}
