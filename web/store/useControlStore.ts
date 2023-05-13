import { defineStore } from 'pinia';

export const useControlStore = defineStore({
  id: 'control',
  state: () => {
    return {
      page: 'soft',
    };
  },
  actions: {
    setPage(page: string) {
      this.page = page;
    },
  },
  getters: {},
});
