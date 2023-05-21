<script setup lang="ts">
import { controlOptions, salaryOptions, annualOptions } from './model';
import { useControlStore } from '@/store/useControlStore';
import { useCompanyStore } from '@/store/useCompanyStore';
import { useColumnStore, ColumnIn } from '@/store/useColumnStore';
import { Filter, Menu, RefreshLeft, Finished } from '@element-plus/icons-vue';
const controlStore = useControlStore();
const columnStore = useColumnStore();
const companyStore = useCompanyStore();
const router = useRouter();

const screenWidth = ref<number>(0);
const drawer = ref<boolean>(false);
const show = ref<'salary' | 'column'>();

const salaryFilters = () => {
  drawer.value = true;
  show.value = 'salary';
};

const columnFilters = () => {
  drawer.value = true;
  show.value = 'column';
};

const onDefault = () => {
  switch (show.value) {
    case 'column':
      columnStore.setDefault();
      break;
    case 'salary':
      companyStore.setLazy();
      break;
  }
};

const onSelectChange = () => {
  router.push(
    controlStore.page === 'all' ? '/' : '/salary/' + controlStore.page
  );
};

onMounted(() => {
  screenWidth.value = window.innerWidth;
});
</script>

<template>
  <div class="h-20 lg:h-10 flex flex-wrap border-b-[1px] border-stone-950/5">
    <div class="w-full lg:w-3/4">
      <div class="h-full flex flex-wrap items-center lg:hidden">
        <ul class="w-full flex flex-wrap">
          <li class="w-1/2 flex justify-center">
            <el-button
              class="w-11/12"
              type="default"
              plain
              :icon="Filter"
              @click="salaryFilters"
            >
              篩選條件
            </el-button>
          </li>
          <li class="w-1/2 flex justify-center">
            <el-button
              class="w-11/12"
              type="default"
              plain
              :icon="Menu"
              @click="columnFilters"
            >
              顯示欄位
            </el-button>
          </li>
        </ul>
        <el-select
          v-model="controlStore.page"
          @change="onSelectChange"
          class="w-full px-1"
          placeholder="select company type"
        >
          <el-option
            v-for="item in controlOptions"
            :key="item.value"
            :label="item.label"
            :value="item.value"
          />
        </el-select>
      </div>
      <ul class="h-full hidden lg:flex">
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
              :checked="control.value === controlStore.page"
              @change="() => controlStore.setPage(control.value)"
            >
              {{ control.label }}
            </el-check-tag>
          </nuxt-link>
        </li>
      </ul>
    </div>
    <div class="hidden lg:w-1/4 lg:flex items-center justify-center">
      <ul class="flex">
        <li class="mx-2 hidden lg:flex">
          <el-button type="default" plain :icon="Filter" @click="salaryFilters">
            篩選條件
          </el-button>
        </li>
        <li class="mx-2 hidden lg:flex">
          <el-button type="default" plain :icon="Menu" @click="columnFilters">
            顯示欄位
          </el-button>
        </li>
      </ul>
    </div>

    <client-only>
      <el-drawer v-model="drawer" :size="screenWidth > 800 ? '25%' : '70%'">
        <template #header>
          <div class="w-full flex flex-wrap">
            <div
              class="w-full lg:w-1/3 flex justify-center items-center font-bold"
            >
              {{ show === 'salary' ? '篩選條件' : '顯示欄位' }}
            </div>
            <div class="w-1/2 my-2 lg:w-1/3 flex justify-center">
              <el-button
                @click="columnStore.setAll"
                :disabled="show === 'salary'"
                :icon="Finished"
                >全選</el-button
              >
            </div>
            <div class="w-1/2 my-2 lg:w-1/3 flex justify-center">
              <el-button @click="onDefault" :icon="RefreshLeft">預設</el-button>
            </div>
          </div>
        </template>
        <div class="flex w-full">
          <ul class="w-full" v-if="show === 'column'">
            <li
              class="my-2"
              v-for="(item, index) in Object.keys(columnStore.column)"
              :key="index"
            >
              <el-checkbox
                class="w-full"
                v-model="columnStore.column[item as keyof ColumnIn].value"
                :label="columnStore.column[item as keyof ColumnIn].label"
                size="default"
                border
              />
            </li>
          </ul>

          <ul class="w-full" v-if="show === 'salary'">
            <li>
              <el-select
                filterable
                v-model="companyStore.company"
                class="w-full py-2"
                placeholder="select company"
                @change="
                  () => {
                    companyStore.setSalaryByCompany();
                    drawer = false;
                  }
                "
              >
                <el-option
                  v-for="item in companyStore.getCompany"
                  :key="item"
                  :label="item"
                  :value="item"
                />
              </el-select>
            </li>
            <li class="my-4">
              <el-select
                v-model="companyStore.salary"
                @change="
                  () => {
                    companyStore.setSalaryBySalary();
                    drawer = false;
                  }
                "
                class="w-full"
                placeholder="select monthly salary"
              >
                <el-option
                  v-for="item in salaryOptions"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                />
              </el-select>
            </li>
            <li class="my-4">
              <el-select
                v-model="companyStore.annual"
                @change="
                  () => {
                    companyStore.setSalaryByAnnual();
                    drawer = false;
                  }
                "
                class="w-full py-2"
                placeholder="select company type"
              >
                <el-option
                  v-for="item in annualOptions"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                />
              </el-select>
            </li>
          </ul>
        </div>
      </el-drawer>
    </client-only>
  </div>
</template>
