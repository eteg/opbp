// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import axios from 'axios'
import VueAxios from 'vue-axios'

import App from '@/App'
import router from '@/router'
import store from '@/store'

axios.interceptors.response
  .use(response => response,
  error => {
    if (error.response.status === 401) {
      router.go('/')
    }

    return Promise.reject(error)
  })


Vue.use(VueAxios, axios)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  template: '<App/>',
  components: { App }
})
