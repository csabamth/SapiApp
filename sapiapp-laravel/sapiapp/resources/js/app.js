
/**
 * First we will load all of this project's JavaScript dependencies which
 * includes Vue and other libraries. It is a great starting point when
 * building robust, powerful web applications using Vue and Laravel.
 */
import Vue from 'vue';
import Axios from 'axios';
import VueResource from 'vue-resource';
import Router from 'vue-router';
require('./bootstrap');

window.Vue = require('vue');
window.axios = require('axios');
Vue.use(VueResource)
Vue.use(Router)
window.Vue = require('vue');
window.axios = require('axios');

window.axios.defaults.headers.common = {
    'X-Requested-With': 'XMLHttpRequest',
    'X-CSRF-TOKEN': window.Laravel.csrfToken,
};

//axios.defaults.headers.common = {'Authorization': `Bearer ${window.Laravel.}`}
/**
 * The following block of code may be used to automatically register your
 * Vue components. It will recursively scan this directory for the Vue
 * components and automatically register them with their "basename".
 *
 * Eg. ./components/ExampleComponent.vue -> <example-component></example-component>
 */

// const files = require.context('./', true, /\.vue$/i);
// files.keys().map(key => Vue.component(key.split('/').pop().split('.')[0], files(key).default));

Vue.component('example-component', require('./components/ExampleComponent.vue').default);
Vue.component('szaktabla', require('./components/SzakTabla.vue').default);
Vue.component('oktatotabla', require('./components/OktatoTabla.vue').default);
Vue.component('tantargytabla', require('./components/TantargyTabla.vue').default);
Vue.component('vizsgatabla', require('./components/VizsgaTabla.vue').default);
Vue.component('esemenytabla', require('./components/EsemenyTabla.vue').default);
Vue.component('addszak', require('./components/AddSzak.vue').default);
Vue.component('addoktato', require('./components/AddOktato.vue').default);
Vue.component('addtantargy', require('./components/AddTantargy.vue').default);
Vue.component('addvizsga', require('./components/AddVizsga.vue').default);
Vue.component('addesemeny', require('./components/AddEsemeny.vue').default);
Vue.component('updateoktato',require('./components/UpdateOktato.vue').default);
Vue.component('updateszak',require('./components/UpdateSzak.vue').default);
Vue.component('updatevizsga',require('./components/UpdateVizsga.vue').default);
Vue.component('updateesemeny',require('./components/UpdateEsemeny.vue').default);
Vue.component('menutabla',require('./components/MenuTabla.vue').default);
Vue.component('changepassword',require('./components/ChangePassword.vue').default);
Vue.component('addmenu',require('./components/AddMenu.vue').default);
Vue.component('updateactualmenu',require('./components/UpdateActualMenu.vue').default);
/**
 * Next, we will create a fresh Vue application instance and attach it to
 * the page. Then, you may begin adding components to this application
 * or customize the JavaScript scaffolding to fit your unique needs.
 */

const app = new Vue({
    el: '#app'
});
