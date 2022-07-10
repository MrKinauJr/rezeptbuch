<template>
  <div v-if="recipe != null" class="w-9 ml-auto mr-auto ">
    <div class="px-4 py-8 md:px-6 lg:px-8">
      <div class="surface-card p-4 shadow-2 border-round">
        <div class="text-6xl mb-3 font-normal text-900">{{ recipe.name }}</div>
        <div class="flex" style="min-height: 20rem;">
          <div class="col-6">
            <img :src="recipe.image" alt="Image"
                 class="col-12"
                 style="">
            <div class="col-12 text-500 mr-0 md:mr-3">{{ recipe.description }}</div>
          </div>
          <StepList :steps="recipe.steps" class="ml-3 col-6"></StepList>
        </div>
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
      setTimeout(()=>{this.recipe = recipe;}, 1000);
    }).catch((error: Error) => {
      console.error(error);
      this.error = true;
    });
  },
});
</script>
