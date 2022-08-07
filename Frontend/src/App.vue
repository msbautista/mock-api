<template>
  <v-app>
    <v-app-bar app color="teal" :absolute="true">
      <v-toolbar-title
        ><span class="white--text">msbautista/mockapi</span> <span>&#129302;</span></v-toolbar-title
      >
    </v-app-bar>
    <v-main>
      <v-container fluid>
        <Content />
      </v-container>
    </v-main>
    <v-footer
      dark
      padless
    >
      <v-card
        flat
        tile
        class="flex teal lighten-1 white--text text-center"
      >
        <v-card-text>
            <v-btn class="mx-4" v-on:click="goToPage('https://www.linkedin.com/in/msbautista')" dark icon>
              <v-icon size="24px"> mdi-linkedin </v-icon>
            </v-btn>
            <v-btn class="mx-4" v-on:click="goToPage('https://github.com/msbautista')" dark icon>
              <v-icon size="24px"> mdi-github </v-icon>
            </v-btn>
        </v-card-text>

        <v-card-text class="white--text pt-0">
          msbautista/mockapi is an application for creating endpoints with customizable json responses. It's a tool when you need to mock an API for your frontend applications.
        </v-card-text>

        <v-divider></v-divider>

        <v-card-text class="white--text">
          {{ new Date().getFullYear() }} — <strong>Developed by msbautista</strong>
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
