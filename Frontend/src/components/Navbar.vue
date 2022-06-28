<template>
  <div>
    <Menubar class="surface-card" :model="routes">
      <template #start>
        <img alt="logo" src="/icon.png" height="40" class="mr-2">
      </template>

    </Menubar>
  </div>
</template>

<script>
import Menubar from 'primevue/menubar';
import router from "@/router";

export default {
  name: "Navbar",
  data: function () {
    return {

    }
  },
  computed: {
    routes() {
      var items = [];
      router.routes.forEach((route)=>{
        if (route.meta.navbar) {
          items.push({
            label: route.name,
            to: route.path
          })
        }
      })
      return items;
    }
  },
  components: {
    Menubar
  }
}
</script>

<style scoped>

</style>