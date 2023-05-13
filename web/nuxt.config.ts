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
        { name: 'author', content: 'nuxt3 by Ming ' },
        { name: 'author', content: 'java by Amber' },
        {
          name: 'description',
          content: 'Taiwan tech salaries from Dcard."',
        },
      ],
    },
  },
  runtimeConfig: {
    public: {
      base: '',
    },
  },
});
