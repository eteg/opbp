import http from '@/http'
import * as types from './mutation-types'

export const signIn = ({ commit }, { username, password }) => {
  const formData = new FormData()
  formData.append('username', username)
  formData.append('password', password)

  const config = { headers: { 'Content-Type': 'multipart/form-data' } }

  return http
    .post('signIn', formData, config)
    .then(response => http.get('loggedUser'))
    .then(response => http.get('rest/accounts/search/findByUsername', { params: { username: response.data } }))
    .then(response => commit(types.SIGN_IN, response.data))
}

export const recoverUser = ({ commit }) => {
  return http
    .get('loggedUser')
    .then(response => {
      if (response.data) {
        return http.get('rest/accounts/search/findByUsername', { params: { username: response.data } })
      }

      throw new Error('user cannot be recovered')
    })
    .then(response => commit(types.SIGN_IN, response.data))
    .catch(() => commit(types.SIGN_OUT))
}

export const signOut = ({ commit }) => {
  return http
    .post('signOut')
    .then(() => commit(types.SIGN_OUT))
}

export const signUp = ({ commit }, { username, password, name, email }) => {
  const formData = new FormData()
  formData.append('username', username)
  formData.append('password', password)
  formData.append('name', name)
  formData.append('email', email)

  const config = { headers: { 'Content-Type': 'multipart/form-data' } }

  return http
    .post('signUp', formData, config)
}
