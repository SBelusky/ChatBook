<template>
    <div class="is-fullheight container">
        <div class="columns is-centered">
            <div class="column is-4">
                <h1 class="level-item has-text-centered has-text-weight-bold is-size-1 mb-3 mt-6">
                    <span class="mr-2">ChatBook</span><i class="fas fa-comments"></i>
                </h1>
                <div class="login-container">
                    <h1 class="is-size-1 form-title">Prihlásenie</h1>
                    <form class="login-form" @submit.prevent="handleSubmit()" autocomplete="off">
                        <div class="errorMessageBox mb-4" v-if="showErrorLoginMessage">
                            <p>Nesprávne meno alebo heslo</p>
                        </div>
                        <div class="field">
                            <p class="control has-icons-left has-icons-right">
                                <input class="input mb-2" type="email" placeholder="E-mail" v-model="email" autocomplete="nope" required />
                                <span class="icon is-small is-left">
                                    <i class="fas fa-envelope"></i>
                                </span>
                            </p>
                        </div>
                        <div class="field">
                            <p class="control has-icons-left">
                                <input
                                    class="input mb-2"
                                    type="password"
                                    placeholder="Heslo"
                                    v-model="password"
                                    autocomplete="nope"
                                    required
                                />
                                <span class="icon is-small is-left">
                                    <i class="fas fa-lock"></i>
                                </span>
                            </p>
                        </div>
                        <div class="field mt-5">
                            <p class="control has-text-left">
                                <button class="button is-fullwidth login-btn has-text-weight-bold">Login</button>
                            </p>
                        </div>
                        <div class="field mt-5">
                            <p class="control has-text-center has-text-weight-bold">
                                Nie si členom? <a class="signUpText" v-on:click="redirection()">Registruj sa teraz</a>
                            </p>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import axios from "axios";

export default {
    data() {
        return {
            email: null,
            password: null,
            showErrorLoginMessage: false,
        };
    },
    methods: {
        handleSubmit() {
            let formData = {
                email: this.email,
                password: this.password,
            };
            /*  let self = this;
             */
            axios
                .post("http://localhost:8080/login", formData)
                .then((response) => {
                    if (response.status == 200) {
                        /* localStorage.setItem("token", response.data.token); */
                        this.$store.commit("SET_TOKEN", response.data.token);
                        this.$store.commit("RESET_LOGGED_USER");
                        this.showErrorLoginMessage = false;

                        axios
                            .post("http://localhost:8080/api/user", formData, {
                                headers: {
                                    Authorization: "Bearer " + this.$store.getters.getToken,
                                },
                            })
                            .then((response) => {
                                this.$store.commit("SET_LOGGED_USER", response.data);
                                this.$router.push("/admin/main");
                            })
                            .catch((error) => {
                                console.log(error);
                            });
                    }
                })
                .catch((error) => {
                    console.log(error);
                    this.showErrorLoginMessage = true;
                });
        },
        redirection() {
            this.$router.push("register");
        },
    },
};
</script>

<style lang="css" scoped>
.login-container {
    background-color: var(--white);
    border-radius: 5px;
}
.login-form {
    border-radius: 10px;
    padding: 15px;
}
.is-fullheight {
    display: flex;
    flex-direction: column;
    justify-content: center;
}
.control.has-icons-left .input,
.control.has-icons-left .select select {
    padding-left: 3em;
}
.form-title {
    background-color: var(--green);
    color: var(--white);
    padding: 20px 5px;
}
.signUpText {
    color: var(--green);
}
</style>
