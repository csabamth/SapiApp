<template>


  <div>
    <form @submit="formSubmit">
      <div class="form-group">
        <div class="alert alert-success" 
        v-bind:class="{ visibilityoff: isSuccessInvisible }"
        role="alert">
        Szerkesztés sikeres!
      </div>
    </div>

    <div class="form-group">
      <div class="alert alert-danger" 
      v-bind:class="{ visibilityoff: isDangerInvisible }"
      role="alert">
      Uh oh! Próbálja újra!
    </div>
  </div>
  <div class="form-group">
    <label>Tantárgy</label>
    <select class="form-control" v-model="tantargyId" placeholder="Tantárgy">
      <option value="" selected disabled>Válasszon új tantárgyat!</option>
      <option v-for="tantargy in tantargyak"  v-bind:value="tantargy.id">{{tantargy.megnevezes}}</option>
    </select>

  </div>
  <div class="form-group"">
    <label>Szak</label>
    <select class="form-control" v-model="szakId" placeholder="Szak">
      <option value="" selected disabled>Válasszon új szakot!</option>
      <option v-for="szak in szakok" v-bind:value="szak.id">{{szak.megnevezes}}</option>
    </select>
   
  </div>

  
  <div class="form-group">
    <label>Évfolyam</label>
       <select class="form-control" v-model="evfolyamId">
        <option value="" selected disabled>Válasszon új évfolyamot!</option>
      <option v-for="evfolyam in evfolyamok" v-bind:value="evfolyam.id">{{evfolyam.megnevezes}}</option>
    </select>
   
  </div>
  <div class="form-group">
    <label>Oktató</label>
       <select class="form-control" v-model="tanarId">
        <option value="" selected disabled>Válasszon új oktatót!</option>
      <option v-for="oktato in oktatok" v-bind:value="oktato.id">{{oktato.vezeteknev}} {{oktato.keresztnev}}</option>
    </select>
    
  </div>
  <div class="form-group">
    <label>Vizsgadátum</label>
    <div class="col-10">

    <input class="form-control" type="date" value="2011-08-19" id="example-date-input" v-model="vizsgadatum">
   
    </div>
  </div>
  
  <button type="submit" class="btn btn-primary">Szerkesztés</button>
</form>
</div>
</template>

<script>
  export default {
    mounted() {
      console.log('Component mounted.')
    },
    data() {
      return {
        tantargyId: '',
        szakId: '',
        evfolyamId: '',
        tanarId: '',
        vizsgadatum: '',
        

        isSuccessInvisible: true,
        isDangerInvisible:true,
        vizsgak: [],
        vizsga: {
          id:'',
          tantargyId: '',
          szakId: '',
          evfolyamId: '',
          tanarId: '',
          vizsgadatum: '',
        },
        szakok: [],
        szak: {
          id:'',
          idotartamEvben: '',
          megnevezes: '',
          rovidites: '',
          tipus: '',
        },
        oktatok: [],
        oktato: {
          id:'',
          vezeteknev: '',
          keresztnev: '',
          funkcio: '',
        },
        tantargyak: [],
        tantargy: {
          id:'',
          megnevezes: '',
          
        },
        evfolyamok:[],
        evfolyam:{
          id:'',
          megnevezes:'',
        }


      };
    },

    mounted() {
      this.getVizsgak();
      this.getSzakok();
      this.getOktatok();
      this.getEvfolyamok();
      this.getTantargyak();

    },
    props: ['id'],
    methods: {
     getVizsgak(){
      axios.get('../../api/vizsgak').then(response => {
        console.log(response)
        this.vizsgak = response.data
      })
    },
    getSzakok(){
      axios.get('../../api/szakok').then(response => {
        console.log(response)
        this.szakok = response.data
      })
    },
    getTantargyak(){
      axios.get('../../api/tantargyak').then(response => {
        console.log(response)
        this.tantargyak = response.data

      })
    },
    getOktatok(){
      axios.get('../../api/tanarok').then(response => {
        console.log(response)
        this.oktatok = response.data

      })
    },
    getEvfolyamok(){
      axios.get('../../api/evfolyamok').then(response => {
        console.log(response)
        this.evfolyamok = response.data

      })
    },

    formSubmit(e) {
     e.preventDefault();
        axios.put('../../api/vizsgak/'+this.id,{
          megnevezes:this.megnevezes,
                  rovidites:this.rovidites,
                  idotartamEvben:this.idotartamEvben,
                  tipus:this.tipus})
       .then(response => {
          this.isSuccessInvisible = false;
          this.isDangerInvisible = true;
        }
        )
        .catch(error => {
          console.log(error);
          this.isDangerInvisible = false;
          this.isSuccessInvisible = true;
        });

    } 
  }
}
</script>

<style>

.visibilityoff.alert{
  display:none;
}
</style>