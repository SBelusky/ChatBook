<template>
    <div class="mt-6 bigger-bmargin">
        <div class="replies mb-6">
            <ul>
                <li id="tu" class="mb-3 px-6" v-for="reply in replies" :key="reply.id">
                    <p :class="alignReplies(reply.user.user_id)" class="reply-p">
                        <span class="reply mb-3">{{ reply.reply }}</span>
                        <br />
                        <span class="time">{{ reply.time }}</span>
                    </p>
                </li>
            </ul>
        </div>
        <div class="reply-input level">
            <input class="input is-primary" type="text" v-model="msg" placeholder="Správa..." />
            <button class="button send-reply-btn has-text-weight-bold" v-on:click="handleSubmit()" :disabled="msg == ''">Odoslať</button>
        </div>
    </div>
</template>

<script>
import axios from "axios";

export default {
    data() {
        return {
            cId: this.$route.params.cId,
            replies: [],
            msg: "",
        };
    },
    created() {
        axios
            .get("http://localhost:8080/api/conversation/" + this.cId + "/conversation-reply", {
                headers: {
                    Authorization: "Bearer " + this.$store.getters.getToken,
                },
            })
            .then((response) => {
                response.data.forEach((reply) => {
                    this.replies.push(reply);
                });
            });
    },
    methods: {
        alignReplies(id) {
            if (id == this.$store.getters.getLoggedUser.user_id) return "has-text-right left-text ";
            else return "has-text-left right-text ";
        },
        handleSubmit() {
            let formData = {
                user: { user_id: this.$store.getters.getLoggedUser.user_id },
                reply: this.msg,
            };

            axios.post("http://localhost:8080/api/conversation/" + this.cId + "/add/conversation-reply", formData, {
                headers: {
                    Authorization: "Bearer " + this.$store.getters.getToken,
                },
            });
            this.$router.go();
        },
    },
    watch: {
        $route() {
            this.replies = [];
            this.cId = this.$route.params.cId;

            axios
                .get("http://localhost:8080/api/conversation/" + this.cId + "/conversation-reply", {
                    headers: {
                        Authorization: "Bearer " + this.$store.getters.getToken,
                    },
                })
                .then((response) => {
                    response.data.forEach((reply) => {
                        this.replies.push(reply);
                    });
                });
        },
    },
};
</script>

<style lang="scss" scoped>
.reply {
    padding: 5px;
    color: var(--black);
    border-radius: 7px;
    font-size: 1.3em;
    text-align: left;
    width: max-content;
}
.reply-p {
    background-color: var(--llgreen);
    border-radius: 15px;
    padding: 5px 10px;
}
.time {
    color: var(--black);
    font-size: 0.8em;
}
.left-text {
    margin-left: 60%;
}
.right-text {
    margin-right: 60%;
}
.reply-input {
    background-color: #dfeeff;
    position: fixed;
    bottom: 0;
}
.level {
    width: 75.5%;
}
.bigger-bmargin {
    margin-bottom: 80px;
}
.input {
    border-radius: 0;
    border: none;
    box-shadow: none !important;
}
.send-reply-btn {
    height: 52px;
    border-radius: 0px;
}
</style>
