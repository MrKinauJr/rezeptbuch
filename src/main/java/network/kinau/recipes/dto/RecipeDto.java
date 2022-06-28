package network.kinau.recipes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDto implements Serializable {
    private String id;
    private String name;
    private String description;
    private String image;
    private Long servings;
    private Long time;
    private Date createdAt;
    private Set<RecipeIngredientDto> recipeIngredients;
    private Set<StepDto> steps;
    private Set<TagDto> tags;
    private Set<CategoryDto> categories;

    @Data
    public static class RecipeIngredientDto implements Serializable {
        private IngredientDto ingredient;
        private Integer amount;
        private String unit;

        @Data
        public static class IngredientDto implements Serializable {
            private String id;
            private String name;
        }
    }

    @Data
    public static class StepDto implements Serializable {
        private String id;
        private Long stepNumber;
        private String description;
        private String title;
    }

    @Data
    public static class TagDto implements Serializable {
        private String id;
        private String name;
    }

    @Data
    public static class CategoryDto implements Serializable {
        private String id;
        private String name;
    }
}
