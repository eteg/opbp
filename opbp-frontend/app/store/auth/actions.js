import Vue from 'vue'
import * as types from './mutation-types'

export const signIn = ({ commit }, { username, password }) => {
  const authHash = btoa(`${username}:${password}`)

  Vue.axios.get(`rest/accounts/search/findByUsername?username=${username}`,
    {
      headers: {
        'Authorization': `Basic ${authHash}`
      }
    }).then((response) => {
      commit(types.SIGN_IN, response.data)
    })
}
