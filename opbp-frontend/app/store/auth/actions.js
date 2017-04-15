import Vue from 'vue'
import axios from 'axios'
import VueAxios from 'vue-axios'

import * as types from './mutation-types'

Vue.use(VueAxios, axios)

export const signIn = ({ commit }, { username, password }) => {
  Vue.axios(`/accounts/search/findByUsername?username=${username}`,
    {
      baseURL: 'http://localhost:8080/rest',
      withCredentials: true,
      auth: {
        username, password
      }
    }).then((response) => {
      commit(types.SIGN_IN, response.data)
    })
}
