package network.kinau.recipes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDto implements Serializable {
    private Long id;
    private String name;
    private String description;
    private String image;
    private Long time;
    private Long servings;
    private Set<RecipeIngredientDto> recipeIngredients;
    private Set<StepDto> steps;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RecipeIngredientDto implements Serializable {
        private IngredientDto ingredient;
        private Integer amount;
        private String unit;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class IngredientDto implements Serializable {
            private Long id;
            private String name;
        }
    }

    @Data
    public static class StepDto implements Serializable {
        private Long id;
        private Long stepNumber;
        private String description;
        private String title;
    }
}
