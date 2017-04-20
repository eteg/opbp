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
    .then(response => http.get('rest/accounts/search/findByUsername', { params: { username } }))
    .then(response => commit(types.SIGN_IN, response.data))
}
