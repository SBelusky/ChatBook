import { createRouter, createWebHistory } from "vue-router";
import store from "../store";

import Login from "../views/login/Login.vue";
import Register from "../views/register/Register.vue";
import Main from "../views/main/Main.vue";

const routes = [
    {
        path: "/",
        redirect: "/admin/login",
    },
    {
        path: "/admin/login",
        component: Login,
    },
    {
        path: "/admin/register",
        component: Register,
    },
    {
        path: "/admin/main",
        component: Main,
        meta: {
            requiresAuth: true,
        },
    },
    {
        path: "/admin/conversation/:cId",
        component: Main,
        meta: {
            requiresAuth: true,
        },
    },
];

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes,
});

router.beforeEach((to, from, next) => {
    if (to.matched.some((record) => record.meta.requiresAuth)) {
        // this route requires auth, check if logged in
        // if not, redirect to login page.
        if (store.getters.isUserLogged == false) {
            next("/admin/login");
        } else {
            next(); // go to wherever I'm going
        }
    } else {
        next(); // does not require auth, make sure to always call next()!
    }
});

export default router;
