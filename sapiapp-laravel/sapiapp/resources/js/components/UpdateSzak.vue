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
    <label>Megnevezés</label>
    <input type="text" class="form-control"  aria-describedby="emailHelp" placeholder="Szak megnevezése:" v-model="megnevezes">
  </div>
  <div class="form-group">
    <label>Rövidítés</label>
    <input type="text" class="form-control" placeholder="Rövidítés" v-model="rovidites">
  </div>
  <div class="form-group">
    <label>Időtartam évben</label>
    <input type="number" class="form-control"  placeholder="Időtartam" v-model="idotartamEvben">
  </div>
  <div class="form-group">
    <label>Típus</label>
     <select class="form-control" v-model="tipus" placeholder="Tipus">
      <option>BsC</option>
      <option>MsC</option>
    </select>
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
              userdata:[],
              megnevezes: '',
              rovidites: '',
              idotartamEvben: '',
              tipus:'',
              isSuccessInvisible: true,
              isDangerInvisible:true,
            };
    },
    mounted(){
      this.getSzak();
      
    },
    props: ['id'],
    methods: {
      getSzak(){
        axios.get('../../api/szakok/'+this.id).then(response => {
          this.userdata = response.data;
          this.megnevezes = this.userdata.megnevezes;
          this.rovidites = this.userdata.rovidites;
          this.idotartamEvben = this.userdata.idotartamEvben;
          this.tipus = this.userdata.tipus;
        });
      },
      formSubmit(e) {
        e.preventDefault();
        axios.put('../../api/szakok/'+this.id,{
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

      },
    }
  }
</script>

<style>

.visibilityoff.alert{
  display:none;
}
</style>