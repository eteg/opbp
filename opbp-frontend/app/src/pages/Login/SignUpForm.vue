<template>
  <ui-box>
    <ui-section title="Sign up">
      <ui-columns>
        <ui-column size="12">
          <ui-error :errors="errors" />
        </ui-column>
      </ui-columns>
      <ui-columns>
        <ui-column size="3">
          <label for="name">Name: </label>
        </ui-column>
        <ui-column size="9">
          <input id="name"
                 v-model="name" />
        </ui-column>
      </ui-columns>
      <ui-columns>
        <ui-column size="3">
          <label for="email">Email: </label>
        </ui-column>
        <ui-column size="9">
          <input id="email"
                 v-model="email" />
        </ui-column>
      </ui-columns>
      <ui-columns>
        <ui-column size="3">
          <label for="username">Username: </label>
        </ui-column>
        <ui-column size="9">
          <input id="username"
                 v-model="username" />
        </ui-column>
      </ui-columns>
      <ui-columns>
        <ui-column size="3">
          <label for="password">Password: </label>
        </ui-column>
        <ui-column size="9">
          <input id="password"
                 type="password"
                 v-model="password" />
        </ui-column>
      </ui-columns>
      <ui-columns>
        <ui-column size="3">
          <label for="confirmPassword">Confirm password: </label>
        </ui-column>
        <ui-column size="9">
          <input id="confirmPassword"
                 type="password"
                 v-model="confirmPassword" />
        </ui-column>
      </ui-columns>
      <ui-columns>
        <ui-column size="3" />
        <ui-column size="9">
          <ui-button type="primary"
                     text="Sign up"
                     @click="doSignUp()" />
          <ui-button text="Go back"
                     @click="goBack()" />
        </ui-column>
      </ui-columns>
    </ui-section>
  </ui-box>
</template>

<script>
import { mapActions } from 'vuex'

import UiColumns from '@/ui/grid/UiColumns'
import UiColumn from '@/ui/grid/UiColumn'
import UiSection from '@/ui/layout/UiSection'
import UiButton from '@/ui/elements/UiButton'
import UiBox from '@/ui/elements/UiBox'
import UiError from '@/ui/components/UiError'

export default {
  components: { UiSection, UiColumns, UiColumn, UiButton, UiBox, UiError },

  methods: {
    ...mapActions('auth', ['signUp']),

    doSignUp() {
      this.errors = []

      if (!this.name) {
        this.errors.push('Name is required.')
      }

      if (!this.email) {
        this.errors.push('Email is required.')
      }

      if (!this.username) {
        this.errors.push('Username is required.')
      }

      if (!this.password) {
        this.errors.push('Password is required.')
      }

      if (!this.confirmPassword) {
        this.errors.push('Confirm password is required.')
      }

      if (this.password && this.confirmPassword && this.password !== this.confirmPassword) {
        this.errors.push('Password does not match the confirm password.')
      }

      if (this.errors.length === 0) {
        let data = { name: this.name, email: this.email, username: this.username, password: this.password }

        this.signUp(data).then(() => {
          this.goBack()
        }).catch(error => {
          if (error.response.status === 403) {
            this.errors.push('Invalid username/password')
          } else {
            this.errors.push(`Server returned error ${error.response.status} - ${error.response.statusText}`)
          }
        })
      }
    },

    goBack() {
      this.$emit('go-back')
    },
  },

  data() {
    return {
      name: '',
      email: '',
      username: '',
      password: '',
      confirmPassword: '',
      errors: []
    }
  }
}
</script>

<style scoped>
input {
  width: 100%;
}
</style>
