<template>
  <section class="section">
    <div class="container">
      <div class="heading">
        <h1 class="title">{{title}}</h1>
        <h2 class="subtitle">
          {{subtitle}}
        </h2>
      </div>
      <div class="content">
        <slot />
      </div>
    </div>
  </section>
</template>

<script>
export default {
  props: {
    title: {
      type: String,
      default: ''
    },
    subtitle: {
      type: String,
      default: ''
    }
  }
}
</script>
