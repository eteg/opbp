<template>
  <nav class="nav">
    <div class="nav-left">
      <slot name="left" />
    </div>
    <div class="nav-center">
      <slot name="center" />
    </div>
    <div class="nav-right">
      <slot name="right" />
    </div>
  </nav>
</template>

<script>
export default {}
</script>
