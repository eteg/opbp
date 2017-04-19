<template>
  <opbp-app-template id="app">
    <router-view></router-view>
  </opbp-app-template>
</template>

<script>
import OpbpAppTemplate from '@/templates/app/OpbpAppTemplate'

export default {
  components: { OpbpAppTemplate },
  name: 'app'
}
</script>
