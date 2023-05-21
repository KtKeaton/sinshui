// https://nuxt.com/docs/api/configuration/nuxt-config
export default defineNuxtConfig({
  modules: ['@nuxtjs/tailwindcss', '@element-plus/nuxt', '@pinia/nuxt'],
  app: {
    head: {
      title: 'SinShui | 科技業薪水資訊 ',
      htmlAttrs: {
        lang: 'zh-TW',
      },
      meta: [
        { name: 'author', content: 'Ming & Amber' },
        {
          name: 'description',
          content: 'Taiwan tech salaries from Dcard.',
        },
        {
          name: 'og:description',
          content: 'Taiwan tech salaries from Dcard.',
        },
        {
          property: 'image"',
          content:
            'https://zhong1016.github.io/software-salaries/images/money.jpg',
        },
        {
          property: 'og:image"',
          content:
            'https://zhong1016.github.io/software-salaries/images/money.jpg',
        },
      ],
    },
  },
  runtimeConfig: {
    public: {
      base: 'http://localhost:8080',
    },
  },
});
