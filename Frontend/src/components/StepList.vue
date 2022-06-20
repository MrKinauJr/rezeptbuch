<template>
  <p>asdf</p>
  <div class="block-content">
    <div v-for="step in steps" v-bind:key="step.stepNumber" class="mb-5 flex">
      <div class="flex flex-column align-items-center" style="width: 2rem;"><span
          class="bg-blue-500 text-0 flex align-items-center justify-content-center border-circle"
          style="min-width: 2.5rem; min-height: 2.5rem;">{{ step.stepNumber }}</span>
        <div class="h-full bg-blue-500" style="width: 2px; min-height: 4rem;"></div>
      </div>
      <StepCard step="step"></StepCard>
    </div>

  </div>
</template>

<script>
import StepCard from "@/components/StepCard";

export default {
  name: "StepList",
  components: {StepCard},
  props: {
    steps: {
      type: Array,
      required: true
    }
  }
}
</script>

<style scoped>

</style>