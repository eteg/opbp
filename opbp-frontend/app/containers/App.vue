<template>
  <div>
    <eteg-tabs>
      <eteg-tab title="To Do" active="true">
        <tab1 />
      </eteg-tab>
      <eteg-tab title="Counter">
        <tab2 />
      </eteg-tab>
    </eteg-tabs>
  </div>
</template>

<script>
  import EtegTabs from '../components/EtegTabs.vue';
  import EtegTab from '../components/EtegTab.vue';
  import Tab1 from './tab1/Tab1.vue';
  import Tab2 from './tab2/Tab2.vue';

  export default {
    components: { EtegTabs, EtegTab, Tab1, Tab2 },
  };
</script>
