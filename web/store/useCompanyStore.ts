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

export interface CompanyStoreIn {
  lazy: boolean;
  lazyData: CompanyIn[];
  allData: CompanyIn[];
  company: string;
  salary: string;
  annual: string;
}

export const useCompanyStore = defineStore({
  id: 'company',
  state: (): CompanyStoreIn => {
    return {
      lazy: true,
      lazyData: [],
      allData: [],
      company: '',
      salary: '',
      annual: '',
    };
  },
  actions: {
    async setSalary(lazy: CompanyIn[], all: CompanyIn[]) {
      this.lazy = true;
      this.lazyData = lazy;
      this.allData = all;
    },
    setLazy() {
      this.lazy = false;
      this.setDefault();
    },
    setDefault() {
      this.company = '';
      this.salary = '';
      this.annual = '';
    },
    setSalaryByCompany() {
      this.lazy = true;
      this.salary = '';
      this.annual = '';
      this.lazyData = this.allData.filter(
        (e) => e.companyName === this.company
      );
    },
    setSalaryBySalary() {
      this.lazy = true;
      this.company = '';
      this.annual = '';
      switch (+this.salary) {
        case 1:
          this.lazyData = this.allData.filter((e) => e.monthlyBaseSalary < 5);
          break;
        case 2:
          this.lazyData = this.allData.filter(
            (e) => e.monthlyBaseSalary >= 5 && e.monthlyBaseSalary < 10
          );
          break;
        case 3:
          this.lazyData = this.allData.filter((e) => e.monthlyBaseSalary >= 10);
          break;
      }
    },
    setSalaryByAnnual() {
      this.lazy = true;
      this.company = '';
      this.salary = '';
      switch (+this.annual) {
        case 1:
          this.lazyData = this.allData.filter(
            (e) => e.totalAnnualCompensation < 50
          );
          break;
        case 2:
          this.lazyData = this.allData.filter(
            (e) =>
              e.totalAnnualCompensation >= 50 && e.totalAnnualCompensation < 100
          );
          break;
        case 3:
          this.lazyData = this.allData.filter(
            (e) =>
              e.totalAnnualCompensation >= 100 &&
              e.totalAnnualCompensation < 150
          );
          break;
        case 4:
          this.lazyData = this.allData.filter(
            (e) =>
              e.totalAnnualCompensation >= 150 &&
              e.totalAnnualCompensation < 200
          );
          break;
        case 5:
          this.lazyData = this.allData.filter(
            (e) => e.totalAnnualCompensation >= 200
          );
          break;
      }
    },
  },
  getters: {
    getCompany: (state): string[] => [
      ...new Set(state.allData.map((e) => e.companyName)),
    ],
  },
});
