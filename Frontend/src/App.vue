<template>
  <v-app>
    <v-app-bar app color="teal" :absolute="true">
      <v-toolbar-title
        ><span class="white--text">msbautista/mockapi</span></v-toolbar-title
      >
    </v-app-bar>
    <v-main>
      <v-container fluid>
        <Content />
      </v-container>
    </v-main>
    <v-footer dark padless :absolute="true">
      <v-card class="flex" flat tile>
        <v-card-title class="teal">
          <strong class="subheading"
            >Get connected with us on social networks!</strong
          >

          <v-spacer></v-spacer>

          <v-btn class="mx-4" v-on:click="goToPage('https://www.linkedin.com/in/msbautista')" dark icon>
            <v-icon size="24px"> mdi-linkedin </v-icon>
          </v-btn>
          <v-btn class="mx-4" v-on:click="goToPage('https://github.com/msbautista')" dark icon>
            <v-icon size="24px"> mdi-github </v-icon>
          </v-btn>
        </v-card-title>

        <v-card-text class="py-2 white--text text-center">
          Developed by msbautista
        </v-card-text>
      </v-card>
    </v-footer>
  </v-app>
</template>

<script>
import Content from "./components/Content.vue";

export default {
  name: "App",

  components: {
    Content,
  },
  data: () => ({
  }),
  methods: {
    goToPage(url) {
      window.open(url);
    }
  }
};
</script>
