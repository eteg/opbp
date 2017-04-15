<template>
  <eteg-columns>
    <eteg-column size="4" />
    <eteg-column size="4">
      <eteg-box>
        <eteg-section title="Login">
          <eteg-columns>
            <eteg-column size="3">
              <label for="username">Username: </label>
            </eteg-column>
            <eteg-column size="9">
              <input id="username" />
            </eteg-column>
          </eteg-columns>
          <eteg-columns>
            <eteg-column size="3">
              <label for="password">Password: </label>
            </eteg-column>
            <eteg-column size="9">
              <input id="password" type="password" />
            </eteg-column>
          </eteg-columns>
          <eteg-columns>
            <eteg-column size="3"/>
            <eteg-column size="9">
              <eteg-button type="primary"
                           text="Sign in" />
              <eteg-button text="Sign up" />
            </eteg-column>
          </eteg-columns>
        </eteg-section>
      </eteg-box>
    </eteg-column>
    <eteg-column size="4" />
  </eteg-columns>
</template>

<script>
import EtegSection from '@/components/layout/EtegSection'
import EtegColumns from '@/components/grid/EtegColumns'
import EtegColumn from '@/components/grid/EtegColumn'
import EtegButton from '@/components/elements/EtegButton'
import EtegBox from '@/components/elements/EtegBox'

export default {
  components: { EtegSection, EtegColumns, EtegColumn, EtegButton, EtegBox }
}
</script>

<style scoped>
input {
  width: 100%;
}
</style>
