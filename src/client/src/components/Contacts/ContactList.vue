<template>
    <div class="contact-list">
        <ul>
            <li v-for="contact in contacts" :key="contact.id">
                <contact :contact="contact" v-on:click="openConversation(contact.c_id)" />
            </li>
        </ul>
    </div>
</template>

<script>
import axios from "axios";
import Contact from "@/components/Contacts/Contact.vue";

export default {
    components: {
        Contact,
    },
    data() {
        return {
            contacts: [],
        };
    },
    mounted() {
        let User = { user_id: this.$store.getters.getLoggedUser.user_id };

        axios
            .post("http://localhost:8080/api/conversation", User, {
                headers: {
                    Authorization: "Bearer " + this.$store.getters.getToken,
                },
            })
            .then((response) => {
                response.data.forEach((contact) => {
                    this.contacts.push(this.formatContacts(contact));
                });
            });
    },
    methods: {
        formatContacts(contact) {
            let formatedContact = {
                c_id: contact.c_id,
                user_two: contact.user_two,
                lastMsg: contact.lastMsg,
                userIdOfLastMsg: contact.userIdOfLastMsg,
            };

            if (contact.user_two == null) {
                formatedContact.user_two = contact.user_one;
            }
            return formatedContact;
        },
        openConversation(id) {
            this.$router.push("/admin/conversation/" + id);
        },
    },
};
</script>

<style lang="scss" scoped>
.contact-list {
    margin-top: 12px;
}
</style>
