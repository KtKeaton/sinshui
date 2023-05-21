import { defineStore } from 'pinia';

export const useControlStore = defineStore({
  id: 'control',
  state: () => {
    return {
      page: 'all',
    };
  },
  actions: {
    setPage(page: string) {
      this.page = page;
    },
  },
  getters: {},
});
