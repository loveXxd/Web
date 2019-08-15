import Vue from 'vue'
import App from './login.vue'
import iview from 'iview'
import Router from 'vue-router'
import 'iview/dist/styles/iview.css'
import '../../assets/iview.css'
Vue.use(iview)
Vue.use(Router)

/* eslint-disable no-new */
new Vue({
  el: '#login',
  render: h => h(App)
})
