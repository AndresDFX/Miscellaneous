<template>
    <div>
        <v-row class="ml-1 search d-flex d-sm-none">
            <v-col cols="10" class="">
                <v-text-field
                    v-model="consulta"
                    hide-details="true"
                    outlined
                    dense
                    rounded
                ></v-text-field>
            </v-col>
            <v-col cols="2" class="search-btn d-flex d-sm-none">
                <v-btn 
                @click="search"
                fab
                small
                dark
                color="#0F4275"
                >
                    <v-icon>mdi-magnify</v-icon>
                </v-btn>
            </v-col>
            <v-col cols="10" class="d-flex d-sm-none pt-0">
                <v-overflow-btn 
                    hide-details="true"
                    v-model="opcion"
                    class="pt-0 mt-0"
                    :items="items"
                    dense
                ></v-overflow-btn> 
            </v-col>
            <v-snackbar 
                v-model="snackbar"
                right
                top
                color="orange"
                text
            >
                {{ text }}
                <template v-slot:action="{ attrs }">
                    <v-btn
                    color="orange"
                    icon
                    v-bind="attrs"
                    @click="snackbar = false"
                    >
                        <v-icon>mdi-close</v-icon>
                    </v-btn>
                </template>
            </v-snackbar>
        </v-row>
        <div class="ml-1 search d-none d-sm-block">   
            <v-row class="ml-1 search ">
                <v-col cols="10" class="search-filtros">
                    <v-row>
                        <v-text-field
                            v-model="consulta"
                            hide-details="true"
                            outlined
                            dense
                        ></v-text-field>
                        <v-overflow-btn 
                            hide-details="true"
                            v-model="opcion"
                            class="pt-0 mt-0"
                            :items="items"
                            dense
                        ></v-overflow-btn>
                    </v-row>  
                </v-col>
                <v-col cols="2" class="search-btn pb-0 pt-1">
                    <v-btn 
                    @click="search"
                    fab
                    small
                    dark
                    color="#0F4275"
                    >
                        <v-icon>mdi-magnify</v-icon>
                    </v-btn>
                </v-col>
                <v-snackbar 
                v-model="snackbar"
                right
                top
                color="orange"
                text
                >
                    {{ text }}
                    <template v-slot:action="{ attrs }">
                        <v-btn
                        color="orange"
                        icon
                        v-bind="attrs"
                        @click="snackbar = false"
                        >
                            <v-icon>mdi-close</v-icon>
                        </v-btn>
                    </template>
                </v-snackbar>
            </v-row>
        </div>
    </div>
</template>

<script>
  export default {
    name: 'Search',
    data: () => ({    
        opcion:'',
        consulta: '',
        items: ['Libro', 'Autor'],  
        snackbar: false,
        text:''
    }),
    mounted(){
        this.opcion = this.items[0 ]
    },
    methods:{
        search(){
            console.log('search')
            if(this.consulta == ''){
                this.text = 'Ingrese al menos un término para realizar la búsqueda.'
                this.snackbar = true
            } else {
                var route = ''
                switch (this.opcion){
                    case 'Libro':
                        route = 'PageSearchBooks'
                        break
                    case 'Autor':
                        route = 'PageSearchAuthors'
                        break
                }
                let routeData = this.$router.resolve({
                    name: route,
                    query: { opcion:this.opcion, consulta: this.consulta},
                })
                window.open(routeData.href, '_self')                
            }
        }
    }
  }
</script>
