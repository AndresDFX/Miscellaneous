<template> 
    <v-row class="page">
     <Header/>
     <v-row class="page-details">
       <v-col cols="12" md="4">
        <v-card class="d-flex justify-center" flat>
          <v-img v-if="libro.cover_id != ''"
            :src="'http://covers.openlibrary.org/b/id/' + libro.cover_id + '-L.jpg'"
            height="500"
            max-width="450"
          >
          </v-img>
          <v-img v-else
            src="../assets/img/no_img.jpg"
            height="400"
            max-width="400"
          >
          </v-img>
        </v-card>
      </v-col>
       <v-col cols="12" md="8" lg="8" xl="7" class="contenido">
          <p class="display-2 font-weight-bold info-titulo">{{libro.title}}</p>
          <p class="display-1 font-weight-regular info-titulo">{{libro.author}}</p>
          <div class="divider"></div>
          <p class="title font-weight-regular info-descripcion">{{libro.description}}</p>
      </v-col>
     </v-row>
    </v-row>  
</template>

<script>
import axios from 'axios'
import Header from '../components/Header.vue'
  export default {
    name: 'BookDetails',
    components: {
      Header
    },
    data: () => ({   
      loading: false,
      libro: ''   
    }),
    mounted(){
      console.log('mounted', this.$route)
    },
    async created(){     
      this.loading = true  
      await axios.get('https://openlibrary.org/works/'+ this.$route.params.key+'.json')
          .then(response => {
            var result = response.data
            this.libro = {
              cover_id: result.covers ? result.covers[0] : '',
              title: result.title,
              author: result.subject_people[0],
              description: result.description.value === undefined ? result.description : result.description.value
            }         
          })   
          .catch(function(err){
            console.log(err)
          })  
      this.loading = false  
    },
   
    methods:{
     
    }
  }
</script>
