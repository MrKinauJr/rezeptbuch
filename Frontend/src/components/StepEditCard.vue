<template>
  <div class="">
    <div class="ml-5 surface-card shadow-2 border-round p-3 flex-auto">
      <div class="mb-3">
        <Textarea id="step-description" v-on:blur="update" v-model="computedStep.title" placeholder="Titel" :autoResize="true" rows="1" cols="40" class="text-900 font-medium inline-block mr-3 text-center"/>
      </div>
      <span class="mb-3">
        <Textarea id="step-description" v-on:blur="update" v-model="computedStep.description" placeholder="Beschreibung" :autoResize="true" rows="1" cols="50" />
      </span>
    </div>
  </div>
</template>

<script>
import Step from "@/models/Step";
import Textarea from "primevue/textarea";

export default {
  name: "StepEditCard",
  props: {
    step: {
      type: Step,
      required: true
    }
  },
  computed: {
    computedStep: {
      get: function () {
        return this.step;
      },
      set: function (value) {
        this.$emit("update", value);
      }
    }
  },
  methods: {
    update: function () {
      this.$emit("update", this.computedStep);
    }
  },
  components: {
    Textarea
  }
}
</script>

<style scoped>

</style>