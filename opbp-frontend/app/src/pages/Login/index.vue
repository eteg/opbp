<template>
  <ui-columns>
    <ui-column size="4" />
    <ui-column size="4">
      <sign-in-form v-if="!showSignUpForm"
                    @sign-up="changeToSignUpForm()" />
      <sign-up-form v-if="showSignUpForm"
                    @go-back="changeToSignInForm()" />
    </ui-column>
    <ui-column size="4" />
  </ui-columns>
</template>

<script>
import { mapState, mapActions } from 'vuex'

import UiColumns from '@/ui/grid/UiColumns'
import UiColumn from '@/ui/grid/UiColumn'

import SignInForm from './SignInForm'
import SignUpForm from './SignUpForm'

export default {
  components: { UiColumns, UiColumn, SignInForm, SignUpForm },

  methods: {
    ...mapActions('auth', ['recoverUser']),

    changeToSignUpForm() {
      this.showSignUpForm = true
    },

    changeToSignInForm() {
      this.showSignUpForm = false
    }
  },

  computed: {
    ...mapState('auth', ['loggedUser'])
  },

  data() {
    return {
      showSignUpForm: false
    }
  },

  created() {
    this.showSignUpForm = false

    this.recoverUser().then(
      () => { if (this.loggedUser) this.$router.replace('home') }
    )
  }
}
</script>
