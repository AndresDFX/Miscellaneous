import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../pages/Home.vue'
import PageSearch from '../pages/PageSearch.vue'
import BookDetails from '../pages/BookDetails.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/search/authors',
    name: 'PageSearchAuthors',
    component: PageSearch,
    props: true
  },
  {
    path: '/search/books',
    name: 'PageSearchBooks',
    component: PageSearch,
    props: true
  },
  {
    path: '/book-details/:key',
    name: 'BookDetails',
    component: BookDetails,
    props: true
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
