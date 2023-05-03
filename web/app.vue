<script setup lang="ts">
import * as ElementPlusIconsVue from '@element-plus/icons-vue';
const nuxtApp = useNuxtApp();
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  nuxtApp.vueApp.component(key, component);
}
</script>
<template>
  <NuxtPage />
</template>
