<template>
  <div class="">
    <div class="ml-5 surface-card shadow-2 border-round p-3 flex-auto">
      <div class="mb-3">
        <span class="text-900 font-medium inline-block mr-3">Schritt {{ step.stepNumber }} - {{ step.title }}</span>
      </div>
      <div class="line-height-3 text-700 mb-3"> {{ step.description }}</div>
    </div>
  </div>
</template>

<script>
import Step from "@/models/Step";

export default {
  name: "StepCard",
  props: {
    step: {
      type: Step,
      required: true
    }
  }
}
</script>

<style scoped>

</style>