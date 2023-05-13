<script setup lang="ts">
import * as ElementPlusIconsVue from '@element-plus/icons-vue';
import { useCompanyStore } from './store/useCompanyStore';
const nuxtApp = useNuxtApp();
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  nuxtApp.vueApp.component(key, component);
}
</script>
<template>
  <NuxtPage />
</template>
