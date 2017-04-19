import Vue from 'vue'
import * as types from './mutation-types'

export const signIn = ({ commit }, { username, password }) => {
  let loginFormData = new FormData()
  loginFormData.append('action', 'login')
  loginFormData.append('username', username)
  loginFormData.append('password', password)

  return Vue.axios.post('login', loginFormData,
    {
      headers: { 'Content-Type': 'multipart/form-data' }
    }).then((response) => {
      return Vue.axios.get('rest/accounts/search/findByUsername', {
        params: { username }
      })
    }).then((response) => {
      commit(types.SIGN_IN, response.data)
    })
}
