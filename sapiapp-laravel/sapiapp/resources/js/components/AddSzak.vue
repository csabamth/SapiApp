<template>

 
<div>
<form @submit="formSubmit">
  <div class="form-group">
    <div class="alert alert-success" 
    v-bind:class="{ visibilityoff: isSuccessInvisible }"
    role="alert">
      Hozzáadás sikeres!
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
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Szak megnevezése:" v-model="megnevezes">
  </div>
  <div class="form-group">
    <label>Rövidítés</label>
    <input type="text" class="form-control" id="exampleInputPassword1" placeholder="Rövidítés" v-model="rovidites">
  </div>
  <div class="form-group">
    <label>Időtartam évben</label>
    <input type="number" class="form-control" id="exampleInputPassword1" placeholder="Időtartam" v-model="idotartamEvben">
  </div>
  <div class="form-group">
    <label>Típus</label>
    <select class="form-control" v-model="tipus" placeholder="Tipus">
      <option>BsC</option>
      <option>MsC</option>
    </select>
  </div>
  
  <button type="submit" class="btn btn-primary">Hozzaadás</button>
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
              megnevezes: '',
              rovidites: '',
              idotartamEvben: '',
              tipus:'',
              isSuccessInvisible: true,
              isDangerInvisible:true,
            };
        },
        methods: {
            formSubmit(e) {
                  e.preventDefault();
                  axios.post('../api/szakok',{
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