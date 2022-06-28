<template>
  <div class="card mt-3">
    <DataView :layout="layout" :paginator="true" :rows="9" :value="recipes">
      <template #header>
        <div class="grid grid-nogutter">
          <div class="col-6" style="text-align: left">
            <DataViewLayoutOptions v-model="layout"/>
          </div>
          <div class="col-6" style="text-align: right">
            <button v-on:click="$router.push({name: 'newRezept'})" class="p-button p-component p-button-raised p-button-success" type="button">
              <i class="pi pi-plus"></i><span class="p-button-label ml-2">Neues Rezept</span>
            </button>
          </div>
        </div>
      </template>

      <template #list="slotProps">
        <RecipeListItem :recipe-data="slotProps.data"></RecipeListItem>
      </template>
      <template #grid="slotProps">
        <RecipeGridItem :recipe-data="slotProps.data"></RecipeGridItem>
      </template>
      <template #empty><p class="m-5 text-center">{{ emptyMessage }}</p></template>

    </DataView>

  </div>
</template>

<script lang="ts">
import {defineComponent, inject} from 'vue';
import DataView from 'primevue/dataview';
import Recipe from './../models/Recipe';
import DataViewLayoutOptions from "primevue/dataviewlayoutoptions";
import RecipeListItem from "@/components/RecipeListItem.vue";
import RecipeGridItem from "@/components/RecipeGridItem.vue";
import RecipeService from "@/services/RecipeService";


interface dataViewProps {
  layout: string;
  recipes: Recipe[];
  emptyMessage: string;
}

export default defineComponent({
  name: 'Home',
  setup() {
    const recipeService = inject("recipeService", (): RecipeService =>{return new RecipeService()}, true);

    return {
      recipeService
    };
  },
  data: (): dataViewProps => {
    return {
      layout: 'grid',
      recipes: [],
      emptyMessage: 'Lade Rezepte...'
    }
  },
  mounted() {
    this.recipeService.getRecipes().then((recipes: Recipe[]) => {
      this.recipes = recipes;
      if (recipes.length === 0) {
        this.emptyMessage = 'Keine Rezepte gefunden';
      }
    });
  },
  components: {
    RecipeListItem,
    RecipeGridItem,
    DataView,
    DataViewLayoutOptions
  },
});
</script>
<style lang="scss" scoped>
.card {
  background: #ffffff;
  padding: 2rem;
  box-shadow: 0 2px 1px -1px rgba(0, 0, 0, .2), 0 1px 1px 0 rgba(0, 0, 0, .14), 0 1px 3px 0 rgba(0, 0, 0, .12);
  border-radius: 4px;
  margin-bottom: 2rem;
}

.p-dropdown {
  width: 14rem;
  font-weight: normal;
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

  .recipe-list-detail {
    flex: 1 1 0;
  }

  .p-rating {
    margin: 0 0 .5rem 0;
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

  .p-button {
    margin-bottom: .5rem;
  }
}

::v-deep(.recipe-grid-item) {
  margin: .5rem;
  border: 1px solid var(--surface-border);

  .recipe-grid-item-top,
  .recipe-grid-item-bottom {
    display: flex;
    align-items: center;
    justify-content: space-between;
  }

  img {
    box-shadow: 0 3px 6px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.23);
    margin: 2rem 0;
  }

  .recipe-grid-item-content {
    text-align: center;
  }

  .recipe-price {
    font-size: 1.5rem;
    font-weight: 600;
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
