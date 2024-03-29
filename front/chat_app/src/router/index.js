import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '../views/LoginView.vue';
import RegisterView from '../views/RegisterView.vue';
import HomeView from '../views/HomeView.vue';
const routes = [
  {
    path: '/login',
    name: 'login',
    component: LoginView
  },
  {
    path:'/register',
    name:'register',
    component:RegisterView
  },
  {
    path:'/',
    name:'home',
    component:HomeView

  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
