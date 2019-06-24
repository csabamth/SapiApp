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
    <label>Hétfő leves</label>
    <input type="text" class="form-control"  v-model="hetfo_leves">
  </div>
  <div class="form-group">
    <label>Hétfő főétel</label>
    <input type="text" class="form-control"  v-model="hetfo_fofogas">
  </div>
  <div class="form-group">
    <label>Kedd leves</label>
    <input type="text" class="form-control"  v-model="kedd_leves">
  </div>
  <div class="form-group">
    <label>Kedd főétel</label>
    <input type="text" class="form-control"  v-model="kedd_fofogas">
  </div>
  <div class="form-group">
    <label>Szerda leves</label>
    <input type="text" class="form-control"  v-model="szerda_leves">
  </div>
  <div class="form-group">
    <label>Szerda főétel</label>
    <input type="text" class="form-control"  v-model="szerda_fofogas">
  </div>
  <div class="form-group">
    <label>Csütörtök leves</label>
    <input type="text" class="form-control"  v-model="csutortok_leves">
  </div>
  <div class="form-group">
    <label>Csütörtök főétel</label>
    <input type="text" class="form-control"  v-model="csutortok_fofogas">
  </div>
  <div class="form-group">
    <label>Péntek leves</label>
    <input type="text" class="form-control" v-model="pentek_leves">
  </div>
  <div class="form-group">
    <label>Péntek főétel</label>
    <input type="text" class="form-control" v-model="pentek_fofogas">
  </div>
   <div class="form-group">
    <label>Mettől</label>
    <div class="col-10">
    <input class="form-control" type="date"  id="example-date-input" v-model="mettol">
   
    </div>
  </div>
  <div class="form-group">
    <label>Meddig</label>
    <div class="col-10">
    <input class="form-control" type="date" id="example-date-input" v-model="meddig">
   
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
      menu:[],
      hetfo_leves: '',
      hetfo_fofogas: '',
      kedd_leves: '',
      kedd_fofogas: '',
      szerda_leves: '',
      szerda_fofogas: '',
      csutortok_leves: '',
      csutortok_fofogas: '',
      pentek_leves: '',
      pentek_fofogas: '',
      mettol:'',
      meddig:'',
      isSuccessInvisible: true,
      isDangerInvisible:true,
    };
  },
  mounted(){
   this.getLatestMenu();
  }, 

  methods: {
    getLatestMenu(){
        axios.get('../api/aktualismenu').then(response => {
          this.menu = response.data;
          this.hetfo_leves=this.menu.hetfo_leves;
          this.hetfo_fofogas=this.menu.hetfo_fofogas;
          this.kedd_leves=this.menu.kedd_leves;
          this.kedd_fofogas=this.menu.kedd_fofogas;
          this.szerda_leves=this.menu.szerda_leves;
          this.szerda_fofogas=this.menu.szerda_fofogas;
          this.csutortok_leves=this.menu.csutortok_leves;
          this.csutortok_fofogas=this.menu.csutortok_fofogas;
          this.pentek_leves=this.menu.pentek_leves;
          this.pentek_fofogas=this.menu.pentek_fofogas;
          this.mettol=this.menu.mettol;
          this.meddig=this.menu.meddig;
      });
      },
    formSubmit(e) {
      e.preventDefault();
       axios.put('./../api/menuk/'+this.menu.id,{
        hetfo_leves:this.hetfo_leves,
        hetfo_fofogas:this.hetfo_fofogas,
        kedd_leves:this.kedd_leves,
        kedd_fofogas:this.kedd_fofogas,
        szerda_leves:this.szerda_leves,
        szerda_fofogas:this.szerda_fofogas,
        csutortok_leves:this.csutortok_leves,
        csutortok_fofogas:this.csutortok_fofogas,
        pentek_leves:this.pentek_leves,
        pentek_fofogas:this.pentek_fofogas,
        mettol:this.mettol,
        meddig:this.meddig,
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