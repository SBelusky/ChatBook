<template>
    <div class="is-fullheight container">
        <div class="columns is-centered">
            <div class="column is-4">
                <h1 class="level-item has-text-centered has-text-weight-bold is-size-1 mb-3 mt-6">
                    <span class="mr-2">ChatBook</span><i class="fas fa-comments"></i>
                </h1>
                <div class="reg-container">
                    <h1 class="is-size-1 reg-title">Registrácia</h1>
                    <form class="register-form" @submit.prevent="handleSubmit()" autocomplete="off">
                        <div class="errorMessageBox" v-if="showErrorLoginMessage">
                            <p>{{ error.msg }}</p>
                        </div>
                        <div class="field">
                            <p class="control has-icons-left has-icons-right">
                                <input class="input mb-2" type="name" placeholder="Meno používateľa" v-model="username" required />
                                <span class="icon is-small is-left">
                                    <i class="fas fa-user"></i>
                                </span>
                            </p>
                        </div>
                        <div class="field">
                            <p class="control has-icons-left has-icons-right">
                                <input class="input mb-2" type="email" placeholder="E-mail" v-model="email" required />
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
                                    <i class="fas fa-unlock"></i>
                                </span>
                            </p>
                        </div>
                        <div class="field">
                            <p class="control has-icons-left">
                                <input
                                    class="input mb-2"
                                    type="password"
                                    placeholder="Zopakovanie hesla"
                                    v-model="repeatPassword"
                                    required
                                />
                                <span class="icon is-small is-left">
                                    <i class="fas fa-lock"></i>
                                </span>
                            </p>
                        </div>
                        <p class="has-text-weight-bold">
                            Vytvorením účtu súhlasíte s <a href="/admin/terms-of-privacy">Podmienky a ochrana osobných údajov</a>.
                        </p>
                        <div class="field mt-5">
                            <p class="control has-text-left">
                                <button class="button is-fullwidth has-text-weight-bold reg-btn">Registrácia</button>
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
            username: null,
            email: null,
            password: null,
            repeatPassword: null,
            showErrorLoginMessage: false,
            error: null,
        };
    },
    methods: {
        handleSubmit() {
            let formData = {
                username: this.username,
                email: this.email,
                password: this.password,
                repeatPassword: this.repeatPassword,
            };
            axios
                .post("http://localhost:8080/api/add/user", formData)
                .then((response) => {
                    if (response.status == 200) {
                        this.showErrorLoginMessage = false;
                    }
                    this.$router.push("/admin/login");
                })
                .catch((error) => {
                    this.error = error.response.data;
                    this.showErrorLoginMessage = true;
                });
        },
    },
};
</script>

<style lang="scss" scoped>
.reg-container {
    background-color: var(--white);
    border-radius: 5px;
}
.register-form {
    padding: 15px;
    background-color: #fff;
}
.is-fullheight {
    display: flex;
    flex-direction: column;
    justify-content: center;
}
.reg-title {
    background-color: var(--green);
    color: var(--white);
    padding: 20px 5px;
}
.errorMessageBox {
    padding: 0.5em 0.2em;
    text-align: center;
    margin-bottom: 0.6em;
    color: #000;
    border-radius: 0.5em;
}
.input:-webkit-autofill::first-line {
    font-size: 240px !important;
}
.control.has-icons-left .input,
.control.has-icons-left .select select {
    padding-left: 3em;
}
</style>
