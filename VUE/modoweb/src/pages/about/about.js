import Vue from 'vue'
import App from './about.vue'

// add this to handle exception
Vue.config.errorHandler = function (err) {
  if (console && console.error) {
    console.error(err)
  }
}
/* eslint-disable no-new */
new Vue({
  el: '#about',
  render: h => h(App)
})
