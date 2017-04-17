import Vue from 'vue'
import axios from 'axios'
import VueAxios from 'vue-axios'

export default function () {
  if (!process.env.NODE_ENV || process.env.NODE_ENV === 'development') {
    axios.defaults.baseURL = 'http://localhost:8080'
  }

  Vue.use(VueAxios, axios)
}

