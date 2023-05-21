<script setup lang="ts">
import TheLayout from '@/components/layout/index.vue';
import { useControlStore } from '@/store/useControlStore';
import { useCompanyStore } from '@/store/useCompanyStore';
const controlStore = useControlStore();
const companyStore = useCompanyStore();
const route = useRoute();
const { id } = route.params;

controlStore.setPage(id as string);
companyStore.setDefault();
</script>
<template>
  <TheLayout />
</template>
