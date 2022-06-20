<template>
  <div class="col-12">
    <div class="recipe-list-item">
      <img
          :alt="recipeData.name"
          :src="recipeData.image"
          style="width: 10em;  border-radius: 5px;"
      />
      <div class="recipe-list-detail">
        <div class="recipe-name">{{ recipeData.name }}</div>
        <div class="recipe-description">
          {{ recipeData.description }}
        </div>
        <i class="pi pi-tag recipe-category-icon"></i>
        <span class="recipe-category">{{
            recipeData.tags.join(", ")
          }}</span>
      </div>
      <div class="recipe-list-action">
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
  name: "RecipeListItem",
  props: {
    recipeData: {
      type: Recipe,
      required: true
    }
  }
}
</script>

<style lang="scss" scoped>

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

.recipe-list-detail {
  flex: 1 1 0;
}


.recipe-price {
  font-size: 1.5rem;
  font-weight: 600;
  margin-bottom: .5rem;
  align-self: flex-end;
}

.recipe-list-action {
  display: flex;
  flex-direction: column;
}

}



@media screen and (max-width: 576px) {
  .recipe-list-item {
    flex-direction: column;
    align-items: center;

  img {
    margin: 2rem 0;
  }

  .recipe-list-detail {
    text-align: center;
  }

  .recipe-price {
    align-self: center;
  }

  .recipe-list-action {
    display: flex;
    flex-direction: column;
  }

  .recipe-list-action {
    margin-top: 2rem;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
    width: 100%;
  }
}
}
</style>