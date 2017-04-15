<template>
  <section class="hero">
    <div class="hero-body">
      <div class="container">
        <h1 class="title">
            {{title}}
          </h1>
        <h2 class="subtitle">
            {{subtitle}}
          </h2>
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
