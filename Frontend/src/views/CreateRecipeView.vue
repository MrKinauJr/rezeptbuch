<template>
  <div class="w-8 ml-auto mr-auto px-4 py-5 md:px-6 lg:px-8">
    <div
        class="flex md:align-items-center md:justify-content-between flex-column md:flex-row pb-4 border-bottom-1 surface-border">
      <div class="mb-3 lg:mb-0">
        <div class="text-6xl font-normal text-900">Neues Rezept</div>
      </div>
    </div>

    <div class="surface-ground mt-5">
      <div class="surface-card p-4 shadow-2 border-round">
        <div class="grid formgrid p-fluid">
          <div class="field mb-3 col-12">
            <label class="font-medium text-900" for="recipe-name">Rezept</label>
            <span v-if="v$.recipe.name.$error && submitted" class="ml-1 font-normal text-xs p-error">Dieses Feld ist benötigt.</span>
            <InputText id="recipe-name" v-model="recipe.name" type="text"/>
          </div>
          <div class="surface-border border-top-1 opacity-50 mb-2 col-12"></div>
          <div class="field mb-3 col-6">
            <label class="font-medium text-900" for="recipe-description">Beschreibung</label>
            <span v-if="v$.recipe.description.$error && submitted" class="ml-1 font-normal text-xs p-error">Dieses Feld ist benötigt.</span>
            <Textarea id="recipe-description" v-model="recipe.description" :autoResize="true" rows="3" type="text"/>
          </div>
          <div class="field mb-3 col-6">
            <label class="font-medium text-900" for="recipe-image">Imagelink</label>
            <span v-if="v$.recipe.image.$error && submitted" class="ml-1 font-normal text-xs p-error">Dieses Feld ist benötigt.</span>
            <Textarea id="recipe-image" v-model="recipe.image" :autoResize="true" rows="3" type="text"/>
          </div>
          <div class="surface-border border-top-1 opacity-50 mb-3 col-12"></div>

          <div class="field mb-4 col-12 md:col-6">
            <label class="font-medium text-900" for="recipe-time">Zubereitungszeit</label>
            <InputNumber id="recipe-time" v-model="recipe.time" :step="recipe.time === 1 ? 4 : 5 "
                         buttonLayout="horizontal"
                         decrementButtonClass="p-button-danger"
                         decrementButtonIcon="pi pi-minus" incrementButtonClass="p-button-success"
                         incrementButtonIcon="pi pi-plus"
                         min="1" showButtons suffix=" min"/>
          </div>
          <div class="field mb-4 col-12 md:col-6">
            <label class="font-medium text-900" for="recipe-servings">Portionen</label>
            <InputNumber id="recipe-servings" v-model="recipe.servings" :step="1"
                         :suffix=" recipe.servings === 1 ? ' Portion' : ' Portionen'" buttonLayout="horizontal"
                         decrementButtonClass="p-button-danger" decrementButtonIcon="pi pi-minus"
                         incrementButtonClass="p-button-success"
                         incrementButtonIcon="pi pi-plus" min="1"
                         showButtons/>
          </div>

          <div class="field mb-4 col-12 md:col-6">
            <label class="font-medium text-900" for="step-count">Schrittanzahl</label>
            <InputNumber id="step-count" v-model="stepCount" :step="1" buttonLayout="horizontal"
                         decrementButtonClass="p-button-danger"
                         decrementButtonIcon="pi pi-minus" incrementButtonClass="p-button-success"
                         incrementButtonIcon="pi pi-plus"
                         min="1" showButtons/>
          </div>
          <div class="field mb-4 col-12 md:col-6"><label class="font-medium text-900" for="country2">Tags</label>
            <span v-if="v$.recipe.tags.$error && submitted" class="ml-1 font-normal text-xs p-error">Dieses Feld ist benötigt.</span>
            <MultiSelect v-model="recipe.tags" :filter="true" :emptyMessage="emptyText" :options="tags" :showToggleAll="false" display="chip"
                         optionLabel="name"/>
          </div>
          <div class="surface-border border-top-1 opacity-50 mb-3 col-12"></div>
          <div class="col-4"></div>
          <div class="col-4">
            <span v-if="v$.recipe.steps.$error && submitted" class="ml-1 font-normal text-sm p-error">Nicht alle Felder sind ausgefüllt.</span>
            <StepEditList class="mt-2" :steps="recipe.steps" @remove="removeStep" @update="updateStep"></StepEditList>
          </div>
          <div class="col-4"></div>
          <div class="surface-border border-top-1 opacity-50 mb-3 col-12"></div>
          <div class="col-12">
            <button class="p-button p-component w-auto mt-3" type="button" @click="saveRecipe">
              <span class="p-button-label">Erstellen</span>
              <span class="p-ink"></span>
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import InputText from "primevue/inputtext";
import StepEditList from "@/components/StepEditList";
import InputNumber from "primevue/inputnumber";
import Textarea from "primevue/textarea";
import MultiSelect from "primevue/multiselect";
import {useVuelidate} from "@vuelidate/core";
import { helpers, required } from '@vuelidate/validators'
import {inject} from "vue";
import TagService from "@/services/TagService";
import RecipeService from "@/services/RecipeService";

export default {
  name: "CreateRecipeView",
  setup: () => ({v$: useVuelidate()}),
  data: function () {
    return {
      recipe: {
        name: "",
        description: "",
        image: "",
        time: 1,
        servings: 1,
        tags: [],
        steps: [{
          stepNumber: 1,
          title: "",
          description: ""
        }],
        ingredients: []
      },
      tags: [],
      submitted: false,
      tagService: null,
      loaded: false,
    }
  },
  validations() {
    return {
      recipe: {
        name: {required},
        description: {required},
        time: {required},
        servings: {required},
        image: {required},
        steps: {
          $each: helpers.forEach({
            title: {
              required
            },
            description: {
              required
            }
          })
        },
        tags: {required}
      }
    }
  },
  methods: {
    addStep: function () {
      this.recipe.steps.push({
        stepNumber: this.recipe.steps.length + 1,
        title: "",
        description: ""
      });
    },
    removeStep: function () {
      this.recipe.steps.pop();
    },
    updateStep: function (step) {
      this.recipe.steps[step.stepNumber - 1] = step;
    },
    saveRecipe: async function () {
      this.submitted = true
      const isValid = await this.v$.$validate()
      console.log(isValid)
      console.log(this.recipe);
      if (!isValid) {
        return;
      }
      this.recipeService.createRecipe(this.recipe).then(() => {
        this.$router.push("/");
      });
    }
  },
  components: {
    StepEditList,
    InputText,
    InputNumber,
    Textarea,
    MultiSelect
  },
  computed: {
    stepCount: {
      get: function () {
        return this.recipe.steps.length;
      },
      set: function (value) {
        while (this.recipe.steps.length < value) {
          this.addStep();
        }
        while (this.recipe.steps.length > value) {
          this.removeStep();
        }
      }
    },
    emptyText: function () {
      return this.loaded ? "Keine Tags gefunden" : "Lade Tags...";
    }
  },
  mounted() {
    this.tagService = inject('tagService', () => {return new TagService()}, true)
    this.recipeService = inject('recipeService', () => {return new RecipeService()}, true)

    this.tagService.getTags().then(tags => {
      this.tags = tags;
    })
  }
}
</script>

<style scoped>

</style>