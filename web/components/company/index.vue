<script setup lang="ts">
import { CompanyIn, Result, useCompanyStore } from '@/store/useCompanyStore';
import { useControlStore } from '@/store/useControlStore';
import { useColumnStore } from '@/store/useColumnStore';

const screenWidth = ref<number>(0);

const controlStore = useControlStore();
const companyStore = useCompanyStore();
const columnStore = useColumnStore();

const runtimeConfig = useRuntimeConfig();
const { base } = runtimeConfig.public;
const { data: lazyData } = await useFetch<Result>(
  base +
    '/position_details?pageNo=1&pageSize=50&companyType=' +
    controlStore.page
);
const { data } = await useFetch<Result>(
  base +
    '/position_details?pageNo=1&pageSize=9999&companyType=' +
    controlStore.page
);

companyStore.setSalary(lazyData.value!.data.list, data.value!.data.list);

onMounted(() => {
  screenWidth.value = window.innerWidth;
});
</script>
<template>
  <el-table
    class="w-full"
    v-loading="false"
    :data="companyStore.lazy ? companyStore.lazyData : companyStore.allData"
    border
    height="100%"
  >
    <el-table-column
      align="center"
      fixed
      prop="companyName"
      label="公司"
      :width="screenWidth > 800 ? 140 : 100"
      sortable
    />
    <el-table-column
      v-if="columnStore.column.position.value"
      align="center"
      prop="position"
      label="職務"
      sortable
      :width="screenWidth > 800 ? 140 : 100"
    />
    <el-table-column
      v-if="columnStore.column.jobLevel.value"
      align="center"
      prop="jobLevel"
      label="職級"
      width="120"
    />
    <el-table-column
      v-if="columnStore.column.relevantExperience.value"
      align="center"
      prop="relevantExperience"
      label="年資(年)"
      width="120"
      sortable
    />
    <el-table-column
      v-if="columnStore.column.currentTenure.value"
      align="center"
      prop="currentTenure"
      label="現職(年)"
      width="120"
      sortable
    />
    <el-table-column
      v-if="columnStore.column.monthlyBaseSalary.value"
      align="center"
      prop="monthlyBaseSalary"
      label="月薪(萬)"
      width="120"
      sortable
    />
    <el-table-column
      v-if="columnStore.column.monthlyBonus.value"
      align="center"
      prop="monthlyBonus"
      label="Bonus(月)"
      width="120"
    />
    <el-table-column
      v-if="columnStore.column.totalAnnualCompensation.value"
      align="center"
      prop="totalAnnualCompensation"
      label="總共年薪(萬)"
      width="140"
      sortable
    />
    <el-table-column
      v-if="columnStore.column.dailyAverageWorkingHours.value"
      align="center"
      prop="dailyAverageWorkingHours"
      label="每日工時(H)"
      width="140"
      sortable
    />
    <el-table-column
      v-if="columnStore.column.monthlyOvertime.value"
      align="center"
      prop="monthlyOvertime"
      label="每月加班(H)"
      width="140"
    />
    <el-table-column
      v-if="columnStore.column.overtimeFrequency.value"
      align="center"
      prop="overtimeFrequency"
      label="加班頻率(1~5)"
      width="160"
      sortable
    />
    <el-table-column
      v-if="columnStore.column.jobSatisfaction.value"
      align="center"
      prop="jobSatisfaction"
      label="爽度(1~5)"
      width="140"
      sortable
    />
    <el-table-column
      v-if="columnStore.column.loading.value"
      align="center"
      prop="loading"
      label="工作量(1~5)"
      width="140"
      sortable
    />
    <el-table-column
      v-if="columnStore.column.supplement.value"
      align="center"
      prop="supplement"
      label="補充說明"
      min-width="300"
      :fixed="screenWidth > 800 ? 'right' : false"
    />
  </el-table>
  <div class="flex justify-center py-2" v-if="companyStore.lazy">
    <el-button plain @click="companyStore.setLazy"> 顯示全部 </el-button>
  </div>
</template>
