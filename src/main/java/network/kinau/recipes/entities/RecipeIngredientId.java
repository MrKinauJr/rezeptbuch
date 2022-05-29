package network.kinau.recipes.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RecipeIngredientId implements Serializable {
    private static final long serialVersionUID = -4202062844126105066L;
    @Column(name = "recipe_id", nullable = false)
    private Long recipeId;

    @Column(name = "ingredient_id", nullable = false)
    private Long ingredientId;

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RecipeIngredientId entity = (RecipeIngredientId) o;
        return Objects.equals(this.ingredientId, entity.ingredientId) &&
                Objects.equals(this.recipeId, entity.recipeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredientId, recipeId);
    }

}