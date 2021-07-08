<template>
    <div class="main">
        <navbar />
        <div class="columns main-window">
            <div class="column is-3 p-0 pl-2 contacts">
                <contact-list />
            </div>
            <div class="column is-9 p-0 chat-replies">
                <chat-replies />
            </div>
        </div>
        <div class="add-con"><i class="fas fa-plus-square" v-on:click="addNewCon()"></i></div>
        <div class="modal" :class="openModal()">
            <div class="modal-background"></div>
            <div class="modal-content p-4 has-background-white">
                <h1 class="has-text-center is-size-4 mb-2 has-text-weight-bold">Vytvorenie novej konverzácie</h1>
                <div class="errorMessageBox has-background-warning mb-2" v-if="showErrorMsg">
                    <p>{{ error.msg }}</p>
                </div>
                <div class="field">
                    <div class="control has-icons-left has-icons-right">
                        <input class="input" type="email" placeholder="E-mail používateľa" v-model="email" />
                        <span class="icon is-small is-left">
                            <i class="fas fa-envelope"></i>
                        </span>
                    </div>
                </div>

                <div class="field is-grouped mt-5">
                    <div class="control">
                        <button class="button send-btn has-text-weight-bold" v-on:click="submit()">Odoslať</button>
                    </div>
                    <div class="control">
                        <button class="button back-btn has-text-weight-bold" v-on:click="closeModal()">Zrušiť</button>
                    </div>
                </div>
            </div>
            <button class="modal-close is-large" aria-label="close" v-on:click="closeModal()"></button>
        </div>
    </div>
</template>

<script>
import ContactList from "@/components/Contacts/ContactList.vue";
import Navbar from "@/components/NavBar/Navbar.vue";
import ChatReplies from "@/components/ChatReplies/ChatReplies.vue";
import axios from "axios";

export default {
    components: {
        ContactList,
        Navbar,
        ChatReplies,
    },
    data() {
        return {
            modalOpen: false,
            email: null,
            showErrorMsg: false,
            error: null,
        };
    },
    methods: {
        openModal() {
            if (this.modalOpen == true) return "is-active";
        },
        closeModal() {
            this.modalOpen = false;
            this.email = null;
            this.showErrorMsg = false;
            this.error = null;
        },
        addNewCon() {
            this.modalOpen = true;
        },
        submit() {
            let formData = {
                user_one: { user_id: this.$store.getters.getLoggedUser.user_id },
                user_two: { email: this.email },
            };

            axios
                .post("http://localhost:8080/api/add/conversation", formData, {
                    headers: {
                        Authorization: "Bearer " + this.$store.getters.getToken,
                    },
                })
                .then((response) => {
                    this.$store.commit("SET_LOGGED_USER", response.data);
                    this.$router.push("/admin/main");
                })
                .catch((error) => {
                    this.error = error.response.data;
                    this.showErrorMsg = true;
                });
        },
    },
};
</script>

<style lang="css" scoped>
.main-window {
    height: 100vh;
}
.contacts {
    background-color: var(--green);
}
.contacts,
.chat-replies {
    overflow: auto !important;
}
.add-con i {
    font-size: 3em;
    color: var(--white);
    cursor: pointer;
}
.add-con {
    position: fixed;
    left: 10px;
    bottom: 0;
}
.modal-content {
    border-radius: 5px;
}
.modal-content input,
.modal-content i {
    font-size: 1.3em;
}
.control.has-icons-left .input,
.control.has-icons-left .select select {
    padding-left: 3em;
}
</style>
