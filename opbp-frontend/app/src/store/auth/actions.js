import Vue from 'vue'
import * as types from './mutation-types'

export const signIn = ({ commit }, { username, password }) => {
  let data = new FormData()
  data.append('action', 'login')
  data.append('username', username)
  data.append('password', password)

  Vue.axios.post('login', data,
    {
      headers: { 'Content-Type': 'multipart/form-data' }
    }).then((response) => {
      console.log(response)
      commit(types.SIGN_IN, response.data)
    })
}
