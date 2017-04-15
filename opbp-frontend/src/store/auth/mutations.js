import * as types from './mutation-types'

export default {
  [types.SIGN_IN] (state, user) {
    state.loggedUser = user
  },

  [types.SIGN_OUT] (state) {
    state.loggedUser = null
  }
}
