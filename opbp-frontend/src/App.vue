<template>
  <div id="app">
    <div class="container" style="margin-top: 3rem;">
      <router-view></router-view>
    </div>
    <eteg-footer>
      Overpower Boilerplate - Just another boilderplate :)
    </eteg-footer>
  </div>
</template>

<script>
import EtegHero from '@/components/layout/EtegHero'
import EtegFooter from '@/components/layout/EtegFooter'

export default {
  components: { EtegHero, EtegFooter },
  name: 'app'
}
</script>
