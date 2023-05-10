<script setup lang="ts">
import TheLayout from '@/components/layout/index.vue';
import { useControlStore } from '@/store/useControlStore';
const store = useControlStore();

const route = useRoute();
const { id } = route.params;

store.setPage(id as string);
</script>
<template>
  <TheLayout />
</template>
