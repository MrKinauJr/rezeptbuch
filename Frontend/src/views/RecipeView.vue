<template>
  <div v-if="recipe != null" class="w-8 ml-auto mr-auto px-4 py-5 md:px-6 lg:px-8">
    <div class="flex md:align-items-center md:justify-content-between flex-column md:flex-row pb-4 border-bottom-1 surface-border">
      <div class="mb-3 lg:mb-0">
        <div class="text-6xl font-normal text-900">{{ recipe.name }}</div>
      </div>
    </div>

    <div class="text-800">
      <div class="w-auto p-2 text-center md:text-left flex justify-content-center align-items-center flex-column">
        <img :src="recipe.image" alt="Image"
             class="xl:w-6 sm:w-10 w-7"
             style="">
        <div class="mt-3 mb-4 text-center text-700">{{
            recipe.description
          }}
        </div>
        <StepList :steps="recipe.steps" class="xl:w-7 sm:w-10 w-7"></StepList>

      </div>
    </div>
  </div>
  <NotFoundView v-else-if="error" name="Rezept"></NotFoundView>
</template>

<script lang="ts">
import {defineComponent, inject} from 'vue';
import Recipe from "@/models/Recipe";
import RecipeService from "@/services/RecipeService";
import StepList from "@/components/StepList.vue";
import NotFoundView from "@/components/NotFound.vue";

interface DataViewProps {
  recipe: Recipe | null;
  error: boolean;
}

export default defineComponent({
  name: 'RecipeView',
  components: {NotFoundView, StepList},
  setup() {
    const recipeService = inject("recipeService", (): RecipeService => {
      return new RecipeService()
    }, true);

    return {
      recipeService
    };
  },
  data: (): DataViewProps => {
    return {
      recipe: null,
      error: false
    }
  },
  mounted() {
    this.recipeService.getRecipe(this.$route.params.id as string).then((recipe: Recipe) => {
      console.log(recipe)
      this.recipe = recipe;
    }).catch((error: Error) => {
      console.error(error);
      this.error = true;
    });
  },
});
</script>
