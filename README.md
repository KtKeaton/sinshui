# Sinshui ( 薪水 )

<p align="center">
    <img
      src="./web/public/favicon.ico"
      />
</p>
<p align="center">
      <img
        src="https://img.shields.io/badge/nuxt-3.4.3-green.svg?style=plasticr"
      />
      <img
        src="https://img.shields.io/badge/element--plus-2.3.4-blue.svg?style=plasticr"
      />
      <img
        src="https://img.shields.io/badge/tailwindcss-6.6.7-blue.svg?style=plasticr"
      />
      <img
        src="https://img.shields.io/badge/pinia-2.0.35-yellow.svg?style=plasticr"
      />
      <img
        src="https://img.shields.io/badge/Java-17-orange.svg?style=plasticr"
      />
      <img
        src="https://img.shields.io/badge/springboot-3.0.5-green.svg?style=plasticr"
      />
      <img
        src="https://img.shields.io/badge/openapi-2.1.0-green.svg?style=plasticr"
      />
      <img
        src="https://img.shields.io/badge/mysql-8.0.30-blue.svg?style=plasticr"
      />
    </p>

### 介绍 ✨

歡迎來到 sinshui，此作品為台灣科技業薪水資訊，可自訂欄位的顯示與薪水區間的篩選，幫助使用者更快的查找資訊，也提供 docker-compose 給想要自己佈署的開發者。

資料參考資訊為 [Dcard 科技業 薪水 分享](https://www.dcard.tw/f/tech_job/p/241759899)

### 網站地址 ✨

- Link : [https://sinshui.com/](https://sinshui.com/)

### API ✨

- 整理表單儲存到 `./server/setting/json`，server 啟動後讀取資料寫進 mysql

### 開始 ✨

1. Clone 此專案

```bash
git clone https://github.com/zhong1016/sinshui.git
cd ./sinshui
```

2. 執行程式

Server

```bash
docker-compose up -d
```

提供 OpenAPI ​(Swagger)​， server 啟動後連線至 `http://localhost:8080/swagger`

Web

```bash
cd ./web
npm install
npm run generate
npx serve .output/public
```

完成後瀏覽器訪問 `http://localhost:3000`

### 免責聲明 ✨

本作品僅供學術和研究目的使用，開發者不保證其資訊的准確性、可靠性、完整性或合法性。使用者應評估所有資訊的真實性和可靠性，並自行承擔任何可能產生的後果。開發者不承擔任何責任，包括但不限於因使用本作品而產生的任何損失或損害，或因資訊內容引起的法律責任。使用本作品即表示您同意遵守本免責聲明中的所有條款和條件。

- 本作品中的薪資資訊是根據公開資料和調查所得，僅供參考。它們可能會因行業、地理位置、工作年資、技能等因素而有所不同。使用者應評估其特定情況下的薪資情況，並自行承擔因使用此作品中薪資資訊而產生的風險。
- 本作品的目的是促進公開和透明的薪資討論，以促進工作市場的透明度和公正性。它不應該被視為具有指導意義的薪資指南，也不應被視為就任何特定工作職位的薪資要求作出建議或建議。
- 開發者不保證本作品中包含的資訊是最新的或最準確的。使用者應評估任何資訊的可靠性和準確性，並在必要時進行進一步驗證。
- 本作品中的資訊可能會變更或過時，而開發者並沒有義務更新該資訊。使用者應該自行負責確保他們所依賴的任何資訊是最新的和正確的。
- 開發者不應承擔因使用本作品而產生的任何法律責任或任何其他損失或損害。使用者應該自行承擔任何風險並對其行為負責。
- 開發者不對任何第三方提供的資訊進行背景調查或審核，且不保證這些資訊的可靠性或真實性。使用者應該自行評估任何第三方提供的資訊的真實性和可靠性。

### 最後 ✨

感謝所有提供資訊的工程師，以及感謝提供表單的 [@southeasteast](https://www.dcard.tw/@southeasteast) [@fitness112](https://www.dcard.tw/@fitness112)

如果此作品對你有幫助，請考慮給我一顆星星！您的支持將激勵我更加努力 ：）

[MIT](./LICENSE)
