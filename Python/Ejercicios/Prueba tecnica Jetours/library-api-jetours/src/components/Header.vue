<template> 
  <v-col cols="12" class="page">
    <v-row class="header">
      <v-col cols="12" class="menu d-flex d-sm-none py-0">
        <v-spacer></v-spacer>
        <div>
          <v-menu offset-y rounded="0" >
            <template v-slot:activator="{on, attrs}">
              <v-btn
                icon
                large
                v-bind="attrs"
                v-on="on"
                color="#0F4275"
              >
                <v-icon>mdi-menu</v-icon>
              </v-btn>
            </template>
            <v-list dense class="py-0">
                <v-list-item link @click="goHome">
                  <v-list-item-title>Inicio</v-list-item-title>
                </v-list-item>
            </v-list>
          </v-menu>
        </div>
        <v-menu offset-y rounded="0">
          <template v-slot:activator="{on, attrs}">
            <v-btn
              icon
              large
              v-bind="attrs"
              v-on="on"
              color="#0F4275"
            >
              <v-icon>mdi-account</v-icon>
            </v-btn>
          </template>
          <v-list dense class="py-0">
              <v-list-item link>
                <v-list-item-title>Autenticarse</v-list-item-title>
              </v-list-item>
              <v-divider></v-divider>
              <v-list-item link>
                <v-list-item-title>Registrarse</v-list-item-title>
              </v-list-item>
          </v-list>
        </v-menu>
      </v-col>
      <v-col cols="12" sm="8" md="5" lg="6" xl="5" class="informacion">
        <span class="text-lg-h3 text-sm-h4 text-h5 font-weight-bold text-uppercase titulo">Biblioteca  Digital</span>
        <div class="divider"></div>        
      </v-col>
      <v-col cols="4" sm="4" md="7" lg="6" class="menu d-none d-sm-block">
        <v-tabs background-color="transparent" v-model="tab">
          <v-tabs-slider color="#0F4275" class="d-none d-md-block"></v-tabs-slider>
          <v-tab @click="goHome" class="mr-2 menu-btn d-none d-md-block">Inicio</v-tab>
          <v-spacer></v-spacer>
          <div class="d-none d-sm-flex d-md-none">
            <v-menu offset-y rounded="0" >
              <template v-slot:activator="{on, attrs}">
                <v-btn
                  icon
                  large
                  v-bind="attrs"
                  v-on="on"
                  color="#0F4275"
                >
                  <v-icon>mdi-menu</v-icon>
                </v-btn>
              </template>
              <v-list dense class="py-0">
                  <v-list-item link @click="goHome">
                    <v-list-item-title>Inicio</v-list-item-title>
                  </v-list-item>
              </v-list>
            </v-menu>
          </div>
          <v-menu offset-y rounded="0">
            <template v-slot:activator="{on, attrs}">
              <v-btn
                icon
                large
                v-bind="attrs"
                v-on="on"
                color="#0F4275"
              >
                <v-icon>mdi-account</v-icon>
              </v-btn>
            </template>
            <v-list dense class="py-0">
                <v-list-item link>
                  <v-list-item-title>Autenticarse</v-list-item-title>
                </v-list-item>
                <v-divider></v-divider>
                <v-list-item link>
                  <v-list-item-title>Registrarse</v-list-item-title>
                </v-list-item>
            </v-list>
          </v-menu>
        </v-tabs>
      </v-col>
      <v-col cols="12" sm="10" md="8" lg="6" xl="6" class="search-header">
        <search/>
      </v-col>
    </v-row>
  </v-col>
</template>


<script>
import Search from './Search.vue'
  export default {
    name: 'Header',
    components: {
      Search
    },
    data: () => ({    
     tab: null
    }),
    created(){
      switch(this.$route.name){
        case 'Home':
          this.tab = 0
          break
      }
    },
    methods:{
      goHome(){
        this.$router.push({
          name: 'Home'
        })
      }
    }
  }
</script>
