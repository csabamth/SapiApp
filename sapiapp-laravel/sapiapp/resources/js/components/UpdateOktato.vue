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
    <label>Vezetéknév</label>
    <input type="text" class="form-control" id="vezeteknev" v-model="vezeteknev" value="Jack" >
  </div>
  <div class="form-group">
    <label>Keresztnév</label>
    <input type="text" class="form-control" id="keresztnev" placeholder="Keresztnév" v-model="keresztnev">
  </div>
  <div class="form-group">
    <label>Titulus</label>
    <input type="text" class="form-control" id="funcio" placeholder="Titulus" v-model="funkcio">
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
        vezeteknev: '',
        keresztnev: '',
        funkcio: '',
        isSuccessInvisible: true,
        isDangerInvisible:true,
      };
    },
    mounted(){
      this.getOktato();
      
    },
    props: ['id'],
    methods: {
      getOktato(){
        axios.get('../../api/tanar/'+this.id).then(response => {
          this.userdata = response.data;
          this.vezeteknev = this.userdata.vezeteknev;
          this.keresztnev = this.userdata.keresztnev;
          this.funkcio = this.userdata.funkcio;
        });
      },
      formSubmit(e) {
        e.preventDefault();
        axios.put('../../api/tanarok/'+this.id,{
          vezeteknev:this.vezeteknev,
          keresztnev:this.keresztnev,
          funkcio:this.funkcio
        })
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