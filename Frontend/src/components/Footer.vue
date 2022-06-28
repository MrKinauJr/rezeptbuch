<template>
  <div class="">
    <div class="px-4 py-8 md:px-6 lg:px-8">
      <div class="border-top-1 border-300 pt-5 text-center"><img alt="Image" height="36"
                                                                 src="images/blocks/logos/bastion-500.svg">
        <ul class="list-none p-0 mx-0 my-5 flex justify-content-center flex-column align-items-center lg:flex-row">
          <li><a class="text-600 cursor-pointer line-height-3 lg:m-5">About Us</a></li>
        </ul>
        <div class="flex align-items-center justify-content-center mb-5">
          <CircleIcon icon="pi-twitter"> </CircleIcon>
          <CircleIcon icon="pi-facebook"> </CircleIcon>
          <CircleIcon icon="pi-github" link="https://github.com/MrKinauJr/rezeptbuch"> </CircleIcon>
        </div>
        <div class="text-center">
          <a class="m-5 text-sm text-600 cursor-pointer">Privacy Policy</a>
          <a class="text-sm text-600 cursor-pointer">Terms of Service</a>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import CircleIcon from "@/components/CircleIcon";

CircleIcon
export default {
  name: "Footer",
  components: {
    CircleIcon
  }
}
</script>

<style scoped>

</style>