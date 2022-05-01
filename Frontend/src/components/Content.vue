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
      <v-jsoneditor
        v-model="json"
        :options="{ mode: 'code' }"
        :plus="false"
        @error="onError"
      />
    </v-row>
    <v-row justify="center" class="py-5">
      <v-btn color="teal" elevation="2" @click="generatePath" outlined
        >Generate</v-btn
      >
    </v-row>
  </v-container>
</template>

<script>
import VJsoneditor from "v-jsoneditor";
import axios from "axios";

export default {
  name: "Content",
  components: {
    VJsoneditor,
  },
  data: () => ({
    methodList: ["GET", "POST"],
    name: "msbautista/2001",
    method: "GET",
    json: {"myresponse": "this"},
  }),
  methods: {
    generatePath() {
      axios
        .post("http://localhost:8000/addEndpoint", {
          name: this.name,
          method: this.method,
          body: this.json
        },
        {
          headers: {
            "Content-Type": "application/json"
          }
        }
        )
        .then(function (response) {
          console.log(response);
        })
        .catch(function (error) {
          console.log(error);
        });
    },
    onError() {
      console.log("error in json");
    },
  },
};
</script>

<style>
.ma-title {
  font-size: 300%;
}
</style>