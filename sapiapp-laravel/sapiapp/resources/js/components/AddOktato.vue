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
    <label>Vezetéknév</label>
    <input type="text" class="form-control" placeholder="Vezetéknév" v-model="vezeteknev">
  </div>
  <div class="form-group">
    <label>Keresztnév</label>
    <input type="text" class="form-control" placeholder="Keresztnév" v-model="keresztnev">
  </div>
  <div class="form-group">
    <label>Titulus</label>
    <input type="text" class="form-control" placeholder="Titulus" v-model="funkcio">
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
              vezeteknev: '',
              keresztnev: '',
              funkcio: '',
            
              isSuccessInvisible: true,
              isDangerInvisible:true,
            };
        },
        methods: {
            formSubmit(e) {
                  e.preventDefault();
                  axios.post('../api/tanarok',{
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
            remove(id) {
            axios.delete('.././api/tanarok/' + id)
                .then(response=>{

                  this.oktatok=[];
                    this.getOktatok();
                })
                .catch(function(error) {
                    console.log(error)
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