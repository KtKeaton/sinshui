import { defineStore } from 'pinia';

export interface ColumnIn {
  position: {
    value: boolean;
    label: string;
  }; // 職務
  jobLevel: {
    value: boolean;
    label: string;
  }; // 職級
  relevantExperience: {
    value: boolean;
    label: string;
  }; // 相關年資
  currentTenure: {
    value: boolean;
    label: string;
  }; // 現職年資
  monthlyBaseSalary: {
    value: boolean;
    label: string;
  }; // 月底薪(萬)
  monthlyBonus: {
    value: boolean;
    label: string;
  }; // Bonus (月)
  totalAnnualCompensation: {
    value: boolean;
    label: string;
  }; // 總年薪(萬) 分紅+年終+底薪
  dailyAverageWorkingHours: {
    value: boolean;
    label: string;
  }; // 每日平均工時
  monthlyOvertime: {
    value: boolean;
    label: string;
  }; // 每月加班
  overtimeFrequency: {
    value: boolean;
    label: string;
  }; // 加班頻率
  jobSatisfaction: {
    value: boolean;
    label: string;
  }; // 爽度(1~5) 5最爽
  loading: {
    value: boolean;
    label: string;
  }; // Loading
  supplement: {
    value: boolean;
    label: string;
  }; // 補充
}

type ColumnStoreIn = {
  column: ColumnIn;
};

const columnData = {
  position: {
    value: true,
    label: '任職職務',
  },
  jobLevel: {
    value: false,
    label: '目前職級',
  },
  relevantExperience: {
    value: false,
    label: '相關年資',
  },
  currentTenure: {
    value: false,
    label: '在職年資',
  },
  monthlyBaseSalary: {
    value: true,
    label: '每月底薪',
  },
  monthlyBonus: {
    value: false,
    label: '獎金分紅',
  },
  totalAnnualCompensation: {
    value: true,
    label: '總共年薪',
  },
  dailyAverageWorkingHours: {
    value: false,
    label: '平均工時',
  },
  monthlyOvertime: {
    value: false,
    label: '每月加班',
  },
  overtimeFrequency: {
    value: false,
    label: '加班頻率',
  },
  jobSatisfaction: {
    value: false,
    label: '工作爽度',
  },
  loading: {
    value: false,
    label: '總工作量',
  },
  supplement: {
    value: true,
    label: '補充說明',
  },
};

export const useColumnStore = defineStore({
  id: 'column',
  state: (): ColumnStoreIn => {
    return {
      column: columnData,
    };
  },
  actions: {
    setColumn(key: keyof ColumnIn, value: boolean) {
      this.column[key].value = value;
    },
    setDefault() {
      this.column = JSON.parse(JSON.stringify(columnData));
    },
    setAll() {
      let data = JSON.parse(JSON.stringify(columnData));
      for (const key in data) {
        data[key as keyof ColumnIn].value = true;
      }
      this.column = data;
    },
  },
  getters: {},
});
