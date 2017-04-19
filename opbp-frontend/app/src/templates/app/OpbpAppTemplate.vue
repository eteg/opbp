<template>
    <div>
      <opbp-nav v-if="loggedUser" />
      <div class="container" style="margin-top: 3rem;">
        <slot />
      </div>
      <ui-footer>
        Overpower Boilerplate - Just another boilderplate :)
      </ui-footer>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex'

import UiFooter from '@/ui/layout/UiFooter'
import OpbpNav from './OpbpNav'

export default {
  components: { UiFooter, OpbpNav },

  computed: {
    ...mapState('auth', ['loggedUser'])
  },
}
</script>
