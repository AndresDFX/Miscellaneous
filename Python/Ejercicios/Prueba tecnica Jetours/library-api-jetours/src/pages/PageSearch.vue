<template> 
    <v-row class="page">
     <Header/>
     <v-row class="page-search">
       <v-col cols="12" class="mt-2">
          <span class="body-2 text-search font-italic">Resultado de la búsqueda para: <b>{{consulta}}</b></span>
      </v-col>
      <v-col cols="12">
        <v-progress-linear
          color="deep-purple accent-4"
          :active="loading"
          :indeterminate="loading"
          rounded
          height="6"
        ></v-progress-linear>
      </v-col>
      <v-col
        v-for="(libro,index) in libros_covers"
        :key="index"
        cols="12" sm="6" md="4" lg="3"
        class="mb-5 mt-3"
      >
        <v-card class="d-flex justify-center" flat>
          <v-img v-if="libro.cover_id != ''"
            :src="'http://covers.openlibrary.org/b/id/' + libro.cover_id + '-M.jpg'"
            class="portada"
            height="200"
            max-width="200"
            @click="goDetails(libro.key)"
          >
          </v-img>
          <v-img v-else
            src="../assets/img/no_img.jpg"
            class="portada"
            height="200"
            max-width="200"
            @click="goDetails(libro.key)"
          >
          </v-img>
        </v-card>
      </v-col>
      <v-col class="d-flex justify-center" v-if="!loading">
        <v-pagination
          v-model="page"
          :length="total_pages"
          :total-visible="10"
        ></v-pagination>
      </v-col>
     </v-row>
    </v-row>  
</template>

<script>
import axios from 'axios'
import Header from '../components/Header.vue'
  export default {
    name: 'PageSearch',
    components: {
      Header
    },
    data: () => ({   
      consulta: '',
      opcion: '',
      page: 1,
      total_pages: 0,
      libros_mostrar: [],
      libros_covers: [],   
      loading: false   
    }),
    mounted(){
      console.log('mounted', this.$route)
    },
    async created(){     
      this.loading = true  
      this.opcion = this.$route.query.opcion
      this.consulta = this.$route.query.consulta
      var search_show = ''
      switch (this.opcion){
          case 'Libro':
            await axios.get('http://openlibrary.org/search.json?title=' + this.consulta.replace(/ /g, "+") + '&limit=12&page=' + this.page)
              .then((res) => {
                  if(res.status === 200){
                    search_show = res.data                   
                  }
              })
              .catch(function(err){
                  console.log(err)
              })
              break
          case 'Autor':
            await axios.get('http://openlibrary.org/search.json?author=' + this.consulta.replace(/ /g, "+") + '&limit=12&page=' + this.page)
              .then((res) => {
                  if(res.status === 200){
                    search_show = res.data                    
                  }
              })
              .catch(function(err){
                  console.log(err)
              })
              break
      }
      
      this.total_pages = search_show.numFound % 12 === 0
        ? search_show.numFound / 12
        : Math.trunc(search_show.numFound / 12) + 1 

      for(var i = 0; i < search_show.docs.length; i++){
        var key_parts = search_show.docs[i].key.split('/') 
        this.libros_mostrar.push({
          title: search_show.docs[i].title,
          key: key_parts[key_parts.length-1],
        })
      }                    
      for(var j = 0; j < this.libros_mostrar.length; j++){
        var libro = ''
        axios.get('https://openlibrary.org/works/'+ this.libros_mostrar[j].key+'.json')
          .then(response => {
            libro = response.data
            var key_parts = libro.key.split('/') 
            this.libros_covers.push({
              key: key_parts[key_parts.length-1],
              cover_id: libro.covers ? libro.covers[0] : ''
            })          
          })               
      }
      this.loading = false  
    },
    watch:{
      async page(){
        this.libros_mostrar = []
        this.libros_covers = [] 
        this.loading = true  
        var search_show = ''
        switch (this.opcion){
          case 'Libro':
            await axios.get('http://openlibrary.org/search.json?title=' + this.consulta.replace(/ /g, "+") + '&limit=12&page=' + this.page)
              .then((res) => {
                  if(res.status === 200){
                    search_show = res.data                
                  }
              })
              .catch(function(err){
                  console.log(err)
              })
              break
          case 'Autor':
            await axios.get('http://openlibrary.org/search.json?author=' + this.consulta.replace(/ /g, "+") + '&limit=12&page=' + this.page)
              .then((res) => {
                  if(res.status === 200){
                    search_show = res.data              
                  }
              })
              .catch(function(err){
                  console.log(err)
              })
              break
        }
        for(var i = 0; i < search_show.docs.length; i++){
          var key_parts = search_show.docs[i].key.split('/') 
          this.libros_mostrar.push({
            title: search_show.docs[i].title,
            key: key_parts[key_parts.length-1],
          })
        }                   
        for(var j = 0; j < this.libros_mostrar.length; j++){
          var libro = ''
          axios.get('https://openlibrary.org/works/'+ this.libros_mostrar[j].key+'.json')
            .then(response => {
              libro = response.data
              var key_parts = libro.key.split('/') 
              this.libros_covers.push({
                key: key_parts[key_parts.length-1],
                cover_id: libro.covers ? libro.covers[0] : ''
              })          
            })               
        }
        this.loading = false 
      },
    },
    methods:{
      goDetails(key){
        this.$router.push({
          name: 'BookDetails',
          params: {key: key}
        })
      }
    }
  }
</script>
