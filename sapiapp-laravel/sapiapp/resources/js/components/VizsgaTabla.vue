<template>
	
	<table class="table">
    <thead>
      <tr>
        <th scope="col">Tantárgy</th>
        <th scope="col">Szak</th>
        <th scope="col">Évfolyam</th>
        <th scope="col">Oktató</th>
        <th scope="col">Dátum</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="vizsga in vizsgak">
        <td>{{vizsga.tantargyId}}</td>
        <td>{{vizsga.szakId}} </td>
        <td>{{vizsga.evfolyamId}}</td>
        <td>{{vizsga.tanarId}}</td>
        <td>{{vizsga.vizsgadatum}}</td>
        <a @click="remove(vizsga.id)" class="btn btn-danger"><i class="glyphicon glyphicon-remove"></i></a>
        <a v-bind:href="'./updatevizsga/'+vizsga.id" class="btn btn-warning"><i class="glyphicon glyphicon-pencil"></i></a>
      </tr>
    </tbody>
  </table>
</div>
</template>

<script>
	export default{
		data(){
			return {
				vizsgak: [],
        szakok:[],
        evfolyamok:[],
        tantargyak:[],
        oktatok:[],
        tantargyData:[],
        oktatoData:[],
        evfolyamData:[],
        vizsga: {
         id:'',
         tantargyId: '',
         szakId: '',
         evfolyamId: '',
         tanarId: '',
         vizsgadatum: '',
       },
     }
   },
   async mounted() {


     
     await this.getTantargyak();
     await this.getSzakok();
     await this.getOktatok();
     await this.getEvfolyamok();
     this.$nextTick(() => {
     this.getVizsgak();
  })
     

   },
   methods: {
     getVizsgak(){

      axios.get('../api/vizsgak').then(response => {
       console.log(response)

       this.vizsgak = response.data;
       for(let i = 0; i < this.vizsgak.length; i++){
        for(let k = 0; k < this.szakok.length; k++){
          if(this.vizsgak[i].szakId == this.szakok[k].id){
            this.vizsgak[i].szakId = this.szakok[k].megnevezes;
          }
        }
        for(let k = 0; k < this.oktatok.length; k++){
          if(this.vizsgak[i].tanarId == this.oktatok[k].id){
            this.vizsgak[i].tanarId = this.oktatok[k].vezeteknev + " " + this.oktatok[k].keresztnev;
          }
        }
         for(let k = 0; k < this.tantargyak.length; k++){
          if(this.vizsgak[i].tantargyId == this.tantargyak[k].id){
            this.vizsgak[i].tantargyId = this.tantargyak[k].megnevezes;
          }
        }
      }

    });
    }, 
   
    getSzakok(){
      axios.get('../api/szakok').then(response => {
        console.log(response)
        this.szakok = response.data

      })
    },
    getTantargyak(){
      axios.get('../api/tantargyak').then(response => {
        console.log(response)
        this.tantargyak = response.data

      })
    }, 
    getOktatok(){
      axios.get('../api/tanarok').then(response => {
        console.log(response)
        this.oktatok = response.data

      })
    }, 
    getEvfolyamok(){
      axios.get('../api/evfolyamok').then(response => {
        console.log(response)
        this.evfolyamok = response.data
      })
    },     
    remove(id) {
      axios.delete('.././api/vizsgak/' + id)
      .then(response=>{

       this.vizsgak=[];
       this.getVizsgak();
     })
      .catch(function(error) {
        console.log(error)
      });
    }  



  }
}
</script>