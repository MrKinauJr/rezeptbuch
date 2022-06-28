<template>
  <div class="block-content">
    <div v-for="step in steps" v-bind:key="step.stepNumber" class="mb-5 flex">
      <div class="flex flex-column align-items-center" style="width: 2rem;"><span
          class="bg-blue-500 text-0 flex align-items-center justify-content-center border-circle"
          style="min-width: 2.5rem; min-height: 2.5rem;">{{ step.stepNumber }}</span>
        <div class="h-full bg-blue-500" style="width: 2px; min-height: 4rem;"></div>
      </div>
      <StepEditCard @update="update" :step="step"></StepEditCard>
    </div>
  </div>
</template>

<script>

import StepEditCard from "@/components/StepEditCard";

export default {
  name: "StepEditList",
  components: {StepEditCard},
  props: {
    steps: {
      type: Array,
      required: true
    }
  },
  methods: {
    update: function (step) {
      this.$emit("update", step);
    }
  }
}
</script>

<style scoped>

</style>