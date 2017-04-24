<template>
  <ui-nav>
    <template slot="left">
      <ui-nav-item>
        <img class="logo"
             src="https://avatars0.githubusercontent.com/u/26028399" /> Eteg - Overpower Boilerplate
      </ui-nav-item>
    </template>
    <template slot="center">

    </template>
    <template slot="right">
      <ui-nav-item>
        {{loggedUser.username}}
      </ui-nav-item>
      <ui-nav-item>
        <ui-button text="Sign out"
                   @click="doSignOut()" />
      </ui-nav-item>
    </template>
  </ui-nav>
</template>

<script>
import { mapState, mapActions } from 'vuex'

import UiNav from '@/ui/components/UiNav'
import UiNavItem from '@/ui/components/UiNavItem'
import UiButton from '@/ui/elements/UiButton'

export default {
  components: { UiNav, UiNavItem, UiButton },

  methods: {
    ...mapActions('auth', ['signOut']),

    doSignOut() {
      this.signOut().then(() => {
        this.$router.replace('/')
      })
    }
  },

  computed: {
    ...mapState('auth', ['loggedUser'])
  },
}
</script>

<style scoped>
.logo {
  margin-right: 1em;
}
</style>
