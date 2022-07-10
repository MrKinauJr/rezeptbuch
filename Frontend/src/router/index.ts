import Rezepte from '../views/Rezepte.vue'
import {createRouter, createWebHistory, RouteRecordRaw} from "vue-router";

const routes: Array<RouteRecordRaw> = [
    {
        path: '/',
        name: 'Rezepte',
        component: Rezepte,
        meta: {
            navbar: true
        }
    },
    {
        path: '/recipe/:id',
        name: 'Rezept',
        component: () => import('../views/RecipeView.vue'),
        meta: {
            navbar: false
        }
    },
    {
        path: '/newRecipe/',
        name: 'newRezept',
        component: () => import('../views/RecipeFormView.vue'),
        meta: {
            navbar: false
        }
    },
    {
        path: '/editRecipe/:id',
        name: 'editRezept',
        component: () => import('../views/RecipeFormView.vue'),
        meta: {
            navbar: false
        }
    }
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default {router, routes}
