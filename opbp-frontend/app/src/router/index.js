import Vue from 'vue'
import Router from 'vue-router'

import Login from '@/pages/Login'
import Home from '@/pages/Home'

import store from '@/store'

Vue.use(Router)

function requireAuth (to, from, next) {
  if (!store.state.auth.loggedUser) {
    next('/')
  } else {
    next()
  }
}

export default new Router({
  routes: [
    { path: '/', component: Login },
    { path: '/home', component: Home, beforeEnter: requireAuth }
  ]
})
