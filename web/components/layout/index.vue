<script setup lang="ts">
import TheHeader from './TheHeader.vue';
import TheSection from './TheSection.vue';
</script>
<template>
  <div class="border-b-[1px] border-stone-950/5">
    <div class="container mx-auto">
      <TheHeader />
    </div>
  </div>
  <div class="bg-zinc-300/5">
    <div class="container mx-auto">
      <TheSection />
    </div>
  </div>
</template>
