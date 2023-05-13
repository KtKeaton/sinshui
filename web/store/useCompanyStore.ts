import { type } from 'os';
import { defineStore } from 'pinia';

export interface Result {
  traceId: string;
  code: number;
  message: string;
  dateTime: string;
  data: Data;
}

export interface Data {
  pageData: PageData;
  list: CompanyIn[];
}

export interface PageData {
  currentPage: number;
  totalPage: number;
  totalElement: number;
}

export interface CompanyIn {
  timestamp: string;
  companyName: string;
  jobSatisfaction: number;
  supplement: string;
  monthlyOvertime: string;
  jobLevel: string;
  relevantExperience: number;
  currentTenure: number;
  monthlyBaseSalary: number;
  monthlyBonus: string;
  totalAnnualCompensation: number;
  dailyAverageWorkingHours: number;
  overtimeFrequency: number;
  loading: number;
  position: string;
}

export interface CompanyStoreIn {}

export const useCompanyStore = defineStore({
  id: 'company',
  state: () => {
    return {};
  },
  actions: {
    async getLazySalary() {
      const runtimeConfig = useRuntimeConfig();
      const { base } = runtimeConfig.public;
    },
  },
  getters: {},
});
