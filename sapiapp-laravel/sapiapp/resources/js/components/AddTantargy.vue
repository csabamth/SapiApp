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
    <input type="text" class="form-control" placeholder="Megnevezés" v-model="megnevezes">
  </div>

  
  <button type="submit" class="btn btn-primary">Hozzáadás</button>
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
              isSuccessInvisible: true,
              isDangerInvisible:true,
            };
        },
        methods: {
            formSubmit(e) {
                  e.preventDefault();
                  axios.post('../api/tantargyak',{
                  megnevezes:this.megnevezes,
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
                
            }
        }
    }
</script>

<style>

 .visibilityoff.alert{
  display:none;
}
</style>