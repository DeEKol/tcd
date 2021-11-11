import Vue from 'vue'
import App from 'pages/App.vue'


window.axios = require('axios');

new Vue({
	render: a => a(App)
}).$mount('#app')