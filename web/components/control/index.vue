<script setup lang="ts">
import { controlOptions } from './model';
import { useControlStore } from '@/store/useControlStore';
const store = useControlStore();
</script>
<template>
  <div class="h-10 flex flex-wrap border-b-[1px] border-stone-950/5">
    <div class="w-5/6">
      <ul class="flex h-full">
        <li
          class="flex items-center"
          v-for="(control, index) in controlOptions"
          :key="index"
        >
          <nuxt-link
            :to="control.value === 'all' ? '/' : '/salary/' + control.value"
          >
            <el-check-tag
              class="mx-4"
              :checked="control.value === store.page"
              @change="() => store.setPage(control.value)"
            >
              {{ control.label }}
            </el-check-tag>
          </nuxt-link>
        </li>
      </ul>
    </div>
    <div class="w-1/6">2</div>
  </div>
</template>
