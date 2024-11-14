import { createRouter, createWebHistory } from 'vue-router'

const routes = [

  {
    path: '/',
    name: 'mainView',
    component: () => import('../views/mainView.vue'),
    meta:{
      loginRequire: true
    },
    children: [{
      path: 'welcome',
      component: () =>import('../views/main/welcome.vue')
    },]
  },
  {
    path: '/about',
    name: 'about',
    component: () => import('../views/main/about.vue')
  },
  {
    path: '',
    redirect: '/welcome'
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
