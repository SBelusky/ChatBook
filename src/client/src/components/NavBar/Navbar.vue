<template>
    <nav class="navbar level mb-0 pt-2 pb-2" role="navigation" aria-label="main navigation">
        <div class="level-left">
            <div class="level-item has-text-centered">
                <p class="ml-3 flex">
                    <strong><i class="fas fa-user-circle is-size-3"></i></strong>
                    <span class="ml-2">
                        <strong>{{ name }}</strong> | {{ email }}</span
                    >
                </p>
            </div>
        </div>
        <h1 class="level-item has-text-centered has-text-weight-bold is-size-3">
            <span class="mr-2">ChatBook</span><i class="fas fa-comments"></i>
        </h1>
        <div class="level-right">
            <div class="level-item has-text-centered">
                <button class="button logout-btn has-text-weight-bold mr-3" v-on:click="logOut()">Odhlásenie</button>
            </div>
        </div>
    </nav>
</template>

<script>
export default {
    data() {
        return {
            name: null,
            email: null,
        };
    },
    mounted() {
        this.name = this.$store.getters.getLoggedUser.username;
        this.email = this.$store.getters.getLoggedUser.email;
    },
    methods: {
        logOut() {
            this.$store.commit("RESET_LOGGED_USER");
            this.$router.push("/admin/login");
        },
    },
};
</script>

<style lang="scss" scoped>
.flex {
    display: flex;
    align-items: center;
}
.navbar {
    background-color: var(--llgreen);
}
</style>
