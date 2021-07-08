<template>
    <div class="card">
        <div class="card-content">
            <div class="media">
                <div class="media-left">
                    <avatar :fullname="contact.user_two.username" />
                </div>
                <div class="media-content has-text-left">
                    <p class="title is-4">{{ contact.user_two.username }}</p>
                    <p class="subtitle is-6">{{ contact.user_two.email }}</p>
                </div>
            </div>
            <div class="content mt-3">
                <p class="last-msg" :class="whoLastSendMsg(contact.userIdOfLastMsg)">
                    Posledná správa:
                    <span>{{ contact.lastMsg }}</span>
                </p>
            </div>
        </div>
        <i class="icon fas fa-chevron-right"></i>
    </div>
</template>

<script>
import Avatar from "vue-avatar-component";

export default {
    components: {
        Avatar,
    },
    props: ["contact"],
    methods: {
        whoLastSendMsg(lastUserId) {
            if (lastUserId != this.$store.getters.getLoggedUser.user_id) return "has-text-weight-bold";
        },
    },
};
</script>

<style lang="scss" scoped>
.content {
    text-overflow: ellipsis;
    overflow: hidden;
    max-width: 100%;
    height: 1.3em;
    white-space: nowrap;
}
.card .media {
    margin-bottom: 0.3em !important;
}
.card {
    border-radius: 0px;
}
.card-content:hover {
    background-color: var(--llgreen) !important;
    cursor: pointer;
}
.last-msg {
    font-style: italic;
    text-align: left;
}
.card-content {
    padding: 20px 24px;
    border-radius: 0px !important;
}
.icon {
    position: absolute;
    right: 0;
    top: 50%;
    background-color: rgba(255, 255, 255, 0);
}
</style>
