import { createStore } from "vuex";
import createPersistedState from "vuex-persistedstate";

export default createStore({
    state: {
        user: null,
        initialUserState: {
            user_id: null,
        },
        isLoggedIn: false,
        token: null,
    },
    mutations: {
        SET_LOGGED_USER(state, user) {
            state.user = user;
            state.isLoggedIn = true;
        },
        SET_TOKEN(state, token) {
            state.token = token;
        },
        RESET_LOGGED_USER(state) {
            state.user = state.initialUserState;
            state.isLoggedIn = false;
        },
    },
    getters: {
        getToken(state) {
            return state.token;
        },
        getLoggedUser(state) {
            return state.user;
        },
        isUserLogged(state) {
            return state.isLoggedIn;
        },
    },
    actions: {},
    modules: {},
    plugins: [
        createPersistedState({
            storage: window.sessionStorage,
        }),
    ],
});
