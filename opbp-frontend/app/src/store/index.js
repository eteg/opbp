import Vue from 'vue'
import Vuex from 'vuex'

/*
 * Importa os submódulos.
 */
import auth from '@/store/auth'

Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    auth
  }
})
