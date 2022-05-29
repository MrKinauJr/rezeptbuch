<template>
  <a :href="link" target="_blank" rel="noopener" class="cursor-pointer border-circle bg-bluegray-100 text-bluegray-500 block inline-flex justify-content-center align-items-center m-3"
     style="width: 2.5rem; height: 2.5rem; text-decoration: none;"><i :class="'pi ' + icon"></i></a>
</template>

<script>
export default {
  name: "CircleIcon",
  props: {
    icon: {
      type: String,
      default: "",
      required: true
    },
    link: {
      type: String,
      default: "#"
    }
  }
}
</script>

<style scoped>

</style>