<template>
  <v-container>
    <v-row align="center" justify="center" class="ma-title py-5">
      MOCKAPI
    </v-row>
    <v-row>
      <v-col>
        <v-text-field label="Path" v-model="name" outlined></v-text-field>
      </v-col>
      <v-col class="d-flex" cols="12" sm="6">
        <v-select
          :items="methodList"
          label="Method"
          v-model="method"
          outlined
        ></v-select>
      </v-col>
    </v-row>
    <v-row class="px-3">
      <v-jsoneditor v-model="json" :options="{ mode: 'code' }" :plus="false" />
    </v-row>
    <v-row justify="center" class="py-5">
      <v-btn color="teal" elevation="2" @click="submitForm" outlined
        >Generate</v-btn
      >
    </v-row>
    <v-row align="center" justify="center">
      <v-alert type="success" v-if="alertSuccess" >The path {{ name }} was generated successfull go to {{ `http://localhost:8000/${this.name}` }}</v-alert>
      <v-alert type="error" v-if="alertError">{{ messageError }}</v-alert>
    </v-row>
  </v-container>
</template>

<script>
import VJsoneditor from "v-jsoneditor";
import axios from "axios";

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
    alertSuccess: false,
    alertError: false,
    messageError: ""
  }),
  methods: {
    validateForm() {
      if(this.name == null || this.name == '' || this.method == null || this.method == '' || this.json == null) {
        return false;
      } else {
        return true;
      }
    },
    submitForm() {
      if (!this.validateForm()) {
        this.messageError = "Complete the form";
        this.alertError = true;
        return;
      }
      axios
        .post(
          "http://localhost:8000/addEndpoint",
          {
            name: this.name,
            method: this.method,
            body: this.json
          },
          {
            headers: {
              "Content-Type": "application/json",
            }
          }
        )
        .then(() => {
          this.alertError = false;
          this.alertSuccess = true;
        })
        .catch(() => {
          this.messageError = "An error has ocurred";
          this.alertError = true;
        });
    }
  }
};
</script>

<style>
.ma-title {
  font-size: 300%;
}
</style>