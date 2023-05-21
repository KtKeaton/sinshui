<script setup lang="ts">
import TheLayout from '@/components/layout/index.vue';
import { useControlStore } from '@/store/useControlStore';
import { useCompanyStore } from '@/store/useCompanyStore';
const companyStore = useCompanyStore();
const controlStore = useControlStore();
controlStore.setPage('all');
companyStore.setDefault();
</script>
<template>
  <TheLayout />
  <el-backtop :right="30" :bottom="100" />
</template>
