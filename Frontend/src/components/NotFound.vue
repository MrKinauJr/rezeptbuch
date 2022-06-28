<template>
  <div class="">
    <div class="surface-ground px-4 py-8 md:px-6 lg:px-8">
      <div class="shadow-2 border-round surface-card px-4 md:px-6 py-6">
        <div class="border-left-2 border-pink-500"><span
            class="bg-white text-pink-500 font-bold text-2xl inline-block px-3">404</span></div>
        <div class="mt-6 mb-5 font-bold text-6xl text-900">{{ nameDefinition }} nicht gefunden</div>
        <p class="text-700 text-3xl mt-0 mb-6">Sorry, wir konnten dein {{ nameDefinition }} nicht finden.</p>
        <ul class="list-none px-0 pb-0 pt-4 m-0 border-top-1 surface-border">
          <li class="py-2"><a
              class="cursor-pointer flex align-items-center border-round border-1 border-transparent hover:border-300 p-3 transition-colors transition-duration-150"><span
              class="inline-flex align-items-center justify-content-center bg-indigo-500 border-round flex-shrink-0"
              style="height: 52px; width: 52px;"><i class="pi pi-envelope text-white text-3xl"></i></span>
            <div class="ml-3"><span class="text-900 font-medium text-2xl mb-3">Home</span>
              <p class="text-600 m-0 line-height-3">Gehe zurück zu deinen Rezepten</p></div>
            <i class="text-600 pi pi-chevron-right ml-auto"></i></a></li>
          <li class="py-2"><a
              class="cursor-pointer flex align-items-center border-round border-1 border-transparent hover:border-300 p-3 transition-colors transition-duration-150"><span
              class="inline-flex align-items-center justify-content-center bg-orange-500 border-round flex-shrink-0"
              style="height: 52px; width: 52px;"><i class="pi pi-chart-bar text-white text-3xl"></i></span>
            <div class="ml-3"><span class="text-900 font-medium text-2xl mb-3">Zufallsrezept</span>
              <p class="text-600 m-0 line-height-3">Lass dich überraschen</p></div>
            <i class="text-600 pi pi-chevron-right ml-auto"></i></a></li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "NotFoundView",
  props: {
    name: {
      type: String,
      required: false,
      default: "Site"
    }
  },
  data() {
    return {
      nameDefinition: this.name
    }
  }
}
</script>

<style scoped>

</style>