package network.kinau.recipes.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RecipeTagId implements Serializable {
    private static final long serialVersionUID = 6622136367145800835L;
    @Column(name = "tag_id", nullable = false)
    private Long tagId;

    @Column(name = "recipe_id", nullable = false)
    private Long recipeId;

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RecipeTagId entity = (RecipeTagId) o;
        return Objects.equals(this.tagId, entity.tagId) &&
                Objects.equals(this.recipeId, entity.recipeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tagId, recipeId);
    }

}