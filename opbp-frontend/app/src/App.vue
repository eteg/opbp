<template>
  <div id="app">
    {{loggedUser}}
    <div class="container" style="margin-top: 3rem;">
      <router-view></router-view>
    </div>
    <ui-footer>
      Overpower Boilerplate - Just another boilderplate :)
    </ui-footer>
  </div>
</template>

<script>
import { mapState } from 'vuex'

import UiFooter from '@/ui/layout/UiFooter'

export default {
  components: { UiFooter },
  name: 'app',

  computed: {
    ...mapState('auth', ['loggedUser'])
  },
}
</script>
