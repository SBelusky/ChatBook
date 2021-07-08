import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import axios from "axios";
import VueAxios from "vue-axios";
import "bulma/css/bulma.css";
import "@fortawesome/fontawesome-free/css/all.css";

require("@/assets/style.css");
require("@fortawesome/fontawesome-free/css/all.css");
/* require("bulma-tooltip/dist/css/bulma-tooltip.min.css"); */

const app = createApp(App).use(store).use(router);
app.use(VueAxios, axios);
app.mount("#app");
