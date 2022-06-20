<template>
  <div class="">

  </div>
</template>

<script>
import {inject} from 'vue';
import RecipeService from "@/services/RecipeService";

export default {
  name: "RecipeView",
  setup() {
    const recipeService = inject("recipeService", () => {
      return new RecipeService()
    }, true);

    return {
      recipeService
    };
  },
  data() {
    return {
      recipe: null
    }
  }
}
</script>

<style scoped>

</style>