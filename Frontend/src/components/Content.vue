<template>
  <v-container>
    <v-row align="center" justify="center" class="ma-title py-5">
      <span>&#9889;</span><span>MOCKAPI</span><span>&#9889;</span>
    </v-row>
    <v-row>
      <v-col>
        <v-text-field label="Path" v-model="name" outlined></v-text-field>
      </v-col>
      <v-col class="d-flex" cols="12" sm="6">
        <v-select :items="methodList" label="Method" v-model="method" outlined></v-select>
      </v-col>
    </v-row>
    <v-row class="px-3">
      <v-jsoneditor v-model="json" :options="{ mode: 'code' }" :plus="false" />
    </v-row>
    <v-row justify="center" class="py-5">
      <v-btn color="teal" elevation="2" class="white--text" @click="submitForm">Generate</v-btn>
    </v-row>
    <v-row align="center" justify="center">
      <v-alert type="success" v-if="alertSuccess" >{{ alertMessage }}</v-alert>
      <v-alert type="error" v-if="alertError">{{ alertMessage }}</v-alert>
    </v-row>
    <v-row>
      <v-virtual-scroll
        :bench="benched"
        :items="history"
        height="200"
        item-height="64"
      >
        <template v-slot:default="{ item }">
          <v-list-item :key="item.name">
            <v-list-item-content>
              <v-list-item-title>
                <strong>{{ item.method }}</strong>: <span>{{ item.name }}</span>
              </v-list-item-title>
            </v-list-item-content>
          </v-list-item>
          <v-divider></v-divider>
        </template>
      </v-virtual-scroll>
    </v-row>
  </v-container>
</template>

<script>
import VJsoneditor from "v-jsoneditor";

import EndpointApi from '../api/EndpointApi.js';
import HistoryUtil from '../util/HistoryUtil.js';

const endpointApi = new EndpointApi();
const historyUtil = new HistoryUtil();

export default {
  name: "Content",
  components: {
    VJsoneditor
  },
  data: () => ({
    methodList: ["GET", "POST"],
    name: "",
    method: "",
    json: { myresponse: "this" },
    alertMessage: "",
    alertSuccess: false,
    alertError: false,
    history: [],
    benched: 0
  }),
  methods: {
    submitForm() {
      this.cleanAlerts();
      if (!this.validateForm()) {
        this.showError("Complete the form");
        return;
      }
      let body = { name: this.name, method: this.method, body: this.json };
      endpointApi.createEndpoint(body)
        .then(() => {
          this.showSuccessMessage("Endpoint generated correctly");
          historyUtil.addRequestToHistory(body);
          this.history = historyUtil.getHistoryFromLocalStorage();
        })
        .catch((response) => {
          this.showErrorMessage(`An error has ocurred: ${response.response.data.error}`);
        });
    },
    validateForm() {
      if(this.name == null || this.name == '' || this.method == null || this.method == '' || this.json == null) {
        return false;
      } else {
        return true;
      }
    },
    showErrorMessage(message){
      this.alertSuccess = false;
      this.alertMessage = message;
      this.alertError = true;
    },
    showSuccessMessage(message){
      this.alertError = false;
      this.alertMessage = message;
      this.alertSuccess = true;
    },
    cleanAlerts(){
      this.alertSuccess = false;
      this.alertError = false;
    }
  },
  mounted() {
    this.history = historyUtil.getHistoryFromLocalStorage();
  }
};
</script>

<style>
.ma-title {
  font-size: 200%;
}
</style>