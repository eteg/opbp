import http from '@/http'
import * as types from './mutation-types'

export const signIn = ({ commit }, { username, password }) => {
  const loginFormData = new FormData()
  loginFormData.append('action', 'login')
  loginFormData.append('username', username)
  loginFormData.append('password', password)

  const config = { headers: { 'Content-Type': 'multipart/form-data' } }

  return http
    .post('login', loginFormData, config)
    .then(response => http.get('login'))
    .then(response => http.get('rest/accounts/search/findByUsername', { params: { username: response.data } }))
    .then(response => commit(types.SIGN_IN, response.data))
}

export const recoverUser = ({ commit }) => {
  return http
    .get('login')
    .then(response => http.get('rest/accounts/search/findByUsername', { params: { username: response.data } }))
    .then(response => commit(types.SIGN_IN, response.data))
    .catch(() => commit(types.SIGN_OUT))
}
