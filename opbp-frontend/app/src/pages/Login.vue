<template>
  <ui-columns>
    <ui-column size="4" />
    <ui-column size="4">
      <ui-box>
        <ui-section title="Login">
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
            <ui-column size="3" />
            <ui-column size="9">
              <ui-button type="primary"
                           text="Sign in"
                           @click="signIn({username, password})" />
              <ui-button text="Sign up" />
            </ui-column>
          </ui-columns>
        </ui-section>
      </ui-box>
    </ui-column>
    <ui-column size="4" />
  </ui-columns>
</template>

<script>
import { mapState, mapActions } from 'vuex'

import UiSection from '@/ui/layout/UiSection'
import UiColumns from '@/ui/grid/UiColumns'
import UiColumn from '@/ui/grid/UiColumn'
import UiButton from '@/ui/elements/UiButton'
import UiBox from '@/ui/elements/UiBox'

export default {
  components: { UiSection, UiColumns, UiColumn, UiButton, UiBox },

  methods: {
    ...mapActions('auth', ['signIn'])
  },

  data () {
    return {
      username: '',
      password: ''
    }
  }
}
</script>

<style scoped>
input {
  width: 100%;
}
</style>
