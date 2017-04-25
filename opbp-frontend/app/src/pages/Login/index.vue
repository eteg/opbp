<template>
  <ui-columns>
    <ui-column size="4" />
    <ui-column size="4">
      <login-form />
    </ui-column>
    <ui-column size="4" />
  </ui-columns>
</template>

<script>
import { mapState, mapActions } from 'vuex'

import UiColumns from '@/ui/grid/UiColumns'
import UiColumn from '@/ui/grid/UiColumn'

import LoginForm from './LoginForm'

export default {
  components: { UiColumns, UiColumn, LoginForm },

  methods: {
    ...mapActions('auth', ['recoverUser'])
  },

  computed: {
    ...mapState('auth', ['loggedUser'])
  },

  created() {
    this.recoverUser().then(
      () => { if (this.loggedUser) this.$router.replace('home') }
    )
  }
}
</script>
