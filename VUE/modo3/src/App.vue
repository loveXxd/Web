<template>
  <div id="app">
    <c_head></c_head>
    <router-view/>
    <c_foot></c_foot>
  </div>
</template>

<script>

import footer from './components/footer/footer'
import header from './components/header/header'
export default {
  name: 'App',
  components: {
    c_foot: footer,
    c_head: header
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
