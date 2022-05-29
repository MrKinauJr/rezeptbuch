package network.kinau.recipes.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "recipe")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Recipe {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "\"time\"", nullable = false)
    private Long time;

    @Column(name = "servings", nullable = false)
    private Long servings;

    @OneToMany(mappedBy = "recipe")
    @ToString.Exclude
    private Set<RecipeIngredient> recipeIngredients = new LinkedHashSet<>();

    @OneToMany(mappedBy = "recipe")
    @ToString.Exclude
    private Set<Step> steps = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Recipe recipe = (Recipe) o;
        return id != null && Objects.equals(id, recipe.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}