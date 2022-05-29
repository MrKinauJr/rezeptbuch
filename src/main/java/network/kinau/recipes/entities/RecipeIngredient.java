package network.kinau.recipes.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Table(name = "recipe_ingredient")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class RecipeIngredient {
    @EmbeddedId
    private RecipeIngredientId id;

    @MapsId("recipeId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recipe_id", nullable = false)
    @ToString.Exclude
    private Recipe recipe;

    @MapsId("ingredientId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ingredient_id", nullable = false)
    @ToString.Exclude
    private Ingredient ingredient;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "unit", nullable = false)
    private String unit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RecipeIngredient that = (RecipeIngredient) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}