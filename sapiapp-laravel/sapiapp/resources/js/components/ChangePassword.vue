<template>


  <div>
   <form @submit="formSubmit">
  <div class="form-group">
    <div class="alert alert-success" 
    v-bind:class="{ visibilityoff: isSuccessInvisible }"
    role="alert">
      Jelszó megváltoztatva!
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
    <label>Új jelszó</label>
    <input type="password" class="form-control" v-model="password">
  </div>  
  <button type="submit" class="btn btn-primary">Szerkesztés</button>
</form>
</div>
</template>

<script>
  export default {
    data() {
      return {
              password: '',
              isSuccessInvisible: true,
              isDangerInvisible:true,
            };
    },
    props: ['id'],
    methods: {
     
      formSubmit(e) {
        e.preventDefault();
        axios.put('./../api/users/'+this.id,{
          password:this.password,
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