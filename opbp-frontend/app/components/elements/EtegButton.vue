<template>
  <a :class="clazz" @click="emitClick">{{text}}</a>
</template>

<script>
export default {
  props: {
    text: {
      type: String,
      default: ''
    },
    type: {
      type: String,
      default: '',

      validator (value) {
        return [
          '',
          'white',
          'light',
          'dark',
          'black',
          'link',
          'primary',
          'info',
          'success',
          'warning',
          'danger'
        ].indexOf(value) !== -1
      }
    }
  },

  data () {
    return {
      clazz: this.type === '' ? 'button' : `button is-${this.type}`
    }
  },

  methods: {
    emitClick () {
      this.$emit('click')
    }
  }
}
</script>
