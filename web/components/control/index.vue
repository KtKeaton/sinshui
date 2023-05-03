<script setup lang="ts">
import { ref } from 'vue';

const checked = ref(false);

const onChange = (status: boolean) => {
  checked.value = status;
};
</script>
<template>
  <div class="h-10 flex flex-wrap border-b-[1px] border-stone-950/5">
    <div class="w-5/6">
      <ul class="flex h-full">
        <li class="flex items-center">
          <el-check-tag class="mx-4" :checked="checked" @change="onChange">
            全部
          </el-check-tag>
        </li>
        <li class="flex items-center">
          <el-check-tag class="mx-4" :checked="checked" @change="onChange">
            純軟
          </el-check-tag>
        </li>
        <li class="flex items-center">
          <el-check-tag class="mx-4" :checked="checked" @change="onChange">
            豬屎屋
          </el-check-tag>
        </li>
        <li class="flex items-center">
          <el-check-tag class="mx-4" :checked="checked" @change="onChange">
            系統廠
          </el-check-tag>
        </li>
        <li class="flex items-center">
          <el-check-tag class="mx-4" :checked="checked" @change="onChange">
            化工化學
          </el-check-tag>
        </li>
        <li class="flex items-center">
          <el-check-tag class="mx-4" :checked="checked" @change="onChange">
            設備商
          </el-check-tag>
        </li>
        <li class="flex items-center">
          <el-check-tag class="mx-4" :checked="checked" @change="onChange">
            非設計半導體
          </el-check-tag>
        </li>
      </ul>
    </div>
    <div class="w-1/6">2</div>
  </div>
</template>
