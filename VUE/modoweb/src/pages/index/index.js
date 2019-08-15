import Vue from 'vue'
import App from './index.vue'
import iview from 'iview'
import Router from 'vue-router'
import 'iview/dist/styles/iview.css'
import '../../assets/iview.css'
import article from '@/components/article'
import tmanager from '@/components/TeacherManager'
import student from '@/components/studentManager'
import teacherInfo from '@/components/teacherInfo'
import mytime from '@/components/mytime'
import project from '@/components/project/projectmanager'
import stubaseinfo from '@/components/student/studentbaseinfo'
import classperiods from '@/components/student/classperiods'
import stuprojects from '@/components/student/stuprojects'
import classperiodsinfo from '@/components/student/classperiodsinfo'
import stuprojectsinfo from '@/components/student/stuprojectsinfo'

Vue.use(iview)
Vue.use(Router)

/*
const app = new Vue(App)
app.$mount()
*/

const routes = [
  { path: '/article', component: article },
  { path: '/teachermanager',
    component: tmanager,
    children: [
      {path: '/teachermanager/:id', component: teacherInfo, meta: { keepAlive: false }}
    ]
  },
  { path: '/studentmanager',
    component: student,
    children: [
      {path: '/studentmanager/baseinfo', component: stubaseinfo, meta: { keepAlive: false }},
      {path: '/studentmanager/classperiods',
        component: classperiods,
        children: [
          {path: '/studentmanager/classperiods/:id', component: classperiodsinfo, meta: { keepAlive: false }}
        ]
      },
      {path: '/studentmanager/stuprojects',
        component: stuprojects,
        children: [
          {path: '/studentmanager/stuprojects/:id', component: stuprojectsinfo, meta: { keepAlive: false }}
        ]
      }

    ]
  },
  { path: '/mytime', component: mytime },
  { path: '/project', component: project }
]

// 3. 创建 router 实例，然后传 `routes` 配置
// 你还可以传别的配置参数, 不过先这么简单着吧。
const router = new Router({
  base: '/modo/manager/',
  mode: 'history',
  routes: routes // (缩写) 相当于 routes: routes
})

/* eslint-disable no-new */
new Vue({
  el: '#index',
  router: router,
  render: h => h(App)
})

/* eslint-disable no-new */
/*
const app = new Vue(App)
app.$mount()
*/
