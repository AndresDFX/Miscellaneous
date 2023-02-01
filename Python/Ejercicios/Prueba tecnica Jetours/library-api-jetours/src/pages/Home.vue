<template> 
  <v-col cols="12" class="home">
    <v-row class="info-general">
      <v-col cols="12" class="menu d-flex d-md-none">
        <v-spacer></v-spacer>
          <div>
            <v-menu offset-y rounded="0" >
              <template v-slot:activator="{on, attrs}">
                <v-btn
                  icon
                  large
                  v-bind="attrs"
                  v-on="on"
                  color="#ffffff"
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
                color="#ffffff"
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
      <v-col cols="12" md="5" lg="5" class="informacion mt-3">
        <span class="text-lg-h3 text-sm-h4 text-h5 font-weight-bold text-uppercase titulo">Biblioteca  Digital</span>
        <div class="divider"></div>
        <search/>        
      </v-col>      
      <v-col cols="6" md="6" lg="7" xl="6" class="menu d-none d-md-block">
        <v-tabs background-color="transparent" dark v-model="tab">
          <v-tab @click="goHome" class="mr-2 menu-btn d-none d-lg-block">Inicio</v-tab>

          <v-spacer></v-spacer>
          <div class="d-none d-md-flex d-lg-none">
            <v-menu offset-y rounded="0" >
              <template v-slot:activator="{on, attrs}">
                <v-btn
                  icon
                  x-large
                  v-bind="attrs"
                  v-on="on"
                  color="#ffffff"
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
                 class="d-none d-lg-block pb-5"
                >
                  <v-icon class="pb-2">mdi-account</v-icon>
                </v-btn>
                <v-btn
                 icon
                 x-large
                 v-bind="attrs"
                 v-on="on"
                 class="d-md-flex d-lg-none"
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
    </v-row>   
  </v-col>
</template>

<script>
import Search from '../components/Search.vue'
  export default {
    name: 'Home',
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
