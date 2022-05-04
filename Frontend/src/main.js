import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import VJsoneditor from 'v-jsoneditor'

Vue.use(VJsoneditor)

Vue.config.productionTip = false

new Vue({
  vuetify,
  render: h => h(App)
}).$mount('#app')
