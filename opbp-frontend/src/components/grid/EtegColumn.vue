<template>
  <div :class="clazz">
    <slot />
  </div>
</template>

<script>
export default {
  props: {
    size: {
      type: Number,
      default: 1
    }
  },
  data () {
    return {
      clazz: `column is-${this.size}`
    }
  }
}
</script>
