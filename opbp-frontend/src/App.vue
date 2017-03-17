<template>
  <div id="app">
    <table>
      <tr>
        <td><img src="./assets/logo.png"></td>
        <td>
          Todo: <input type="text" />
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
  export default {
    name: 'app',
    data() {
      return {
        msg: 'Welcome to Your Vue.js App'
      }
    }
  }

</script>

<style lang="scss">
  img {
    margin-right: 50px;
    height: 50px;
  }
</style>