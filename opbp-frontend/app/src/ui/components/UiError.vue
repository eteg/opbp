<template>
  <article v-if="errors.length > 0" class="message is-danger">
    <div class="message-body">
      <ul class="errors">
        <li v-for="error in errors">
          {{error}}
        </li>
      </ul>
    </div>
  </article>
</template>

<script>
export default {
  props: {
    errors: {
      type: Array,
      default: []
    }
  }
}
</script>

<style scoped>
.errors {
  margin-top: 0
}
</style>
