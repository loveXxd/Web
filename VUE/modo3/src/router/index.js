import Vue from 'vue'
import Router from 'vue-router'
import register from '@/components/Register'
import siterule from '@/components/SiteRule'
import teacherinfo from '@/components/TeacherInfo'
import teacherdetails from '@/components/TeacherDetails'
import adminlogin from '@/components/AdminLogin'
import teachermanage from '@/components/TeacherManager'
import startpage from '@/components/StartPage'
import infopreview from '@/components/TeacherInfoPreview'
import iview from 'iview'
import 'iview/dist/styles/iview.css'
import '../assets/less/default.less'

Vue.use(Router)
Vue.use(iview)

export default new Router({
  base: '/modo/',
  // mode: 'history',
  routes: [
    {
      path: '/',
      name: 'startpage',
      component: startpage
    },
    {
      path: '/register',
      name: 'Register',
      component: register
    },
    {
      path: '/agreement',
      name: 'siterule',
      component: siterule
    },
    {
      path: '/teachinfo',
      name: 'teachinfo',
      component: teacherinfo
    },
    {
      path: '/teachdetails',
      name: 'teachdetails',
      component: teacherdetails
    },
    {
      path: '/admin',
      name: 'adminlogin',
      component: adminlogin
    },
    {
      path: '/teachermanage',
      name: 'teachermanage',
      component: teachermanage
    },
    {
      path: '/infopreview',
      name: 'infopreview',
      component: infopreview
    }
  ]
})
