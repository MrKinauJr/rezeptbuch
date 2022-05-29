<template>
  <div class="col-12 md:col-4">
    <div class="recipe-grid-item card">
      <div class="recipe-grid-item-top">
        <div>
          <i class="pi pi-tag recipe-category-icon"></i>
          <span class="recipe-category">{{
              recipeData.tags.join(", ")
            }}</span>
        </div>
      </div>
      <div class="recipe-grid-item-content">
        <img
            :alt="recipeData.name"
            :src="recipeData.image"
            style="height: 20vh;"
        />
        <div class="recipe-name">{{ recipeData.name }}</div>
        <div class="recipe-description">
          {{ recipeData.description }}
        </div>
      </div>
      <div class="recipe-grid-item-bottom">
              <span class="recipe-price">{{ recipeData.steps.length }} Schritte - {{
                  recipeData.time
                }} Minuten</span>
      </div>
    </div>
  </div>
</template>

<script>
import Recipe from "../models/Recipe";

export default {
  name: "RecipeGridItem",
  props: {
    recipeData: {
      type: Recipe,
      required: true
    }
  }
}
</script>

<style lang="scss" scoped>
.card {
  background: #ffffff;
  padding: 2rem;
  box-shadow: 0 2px 1px -1px rgba(0, 0, 0, .2), 0 1px 1px 0 rgba(0, 0, 0, .14), 0 1px 3px 0 rgba(0, 0, 0, .12);
  border-radius: 4px;
  margin-bottom: 2rem;
}


.recipe-name {
  font-size: 1.5rem;
  font-weight: 700;
}

.recipe-description {
  margin: 0 0 1rem 0;
}

.recipe-category-icon {
  vertical-align: middle;
  margin-right: .5rem;
}

.recipe-category {
  font-weight: 600;
  vertical-align: middle;
}

::v-deep(.recipe-list-item) {
  display: flex;
  align-items: center;
  padding: 1rem;
  width: 100%;

img {
  width: 50px;
  box-shadow: 0 3px 6px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.23);
  margin-right: 2rem;
}


.recipe-price {
  font-size: 1.5rem;
  font-weight: 600;
  margin-bottom: .5rem;
  align-self: flex-end;
}

}


</style>