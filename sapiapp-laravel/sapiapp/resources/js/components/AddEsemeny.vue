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
		<label for="author">Esemény borítóképe:</label>
		<input type="file" class="form-control" @change="onFileChange($event)"/>
	</div>

	<div class="form-group">
		<label>Esemény megnevezése</label>
		<input type="text" class="form-control" placeholder="Megnevezés" v-model="cim" >
	</div>

	<div class="form-group">
		<label for="exampleFormControlTextarea1">Esemény leírása</label>
		<textarea class="form-control" id="exampleFormControlTextarea1" rows="3" v-model="leiras"></textarea>
	</div>

	<div class="form-group">
		<label>Esemény dátuma</label>
		<div class="col-10">
			<input class="form-control" type="date" value="2011-08-19" id="example-date-input" v-model="esemeny_datum" >
		</div>
	</div>
	<button type="submit" class="btn btn-primary">Hozzáadás</button>
</form> 
</div>


<!--
<form method="post" action="http://localhost/sapiapp/public/api/esemenyek" enctype="multipart/form-data">
	<div class="form-group">
		<label for="author">Cover:</label>
		<input type="file" class="form-control" name="cover"/>
	</div>
	
	<div class="form-group">
		<label>Esemény megnevezése</label>
		<input type="text" class="form-control" placeholder="Megnevezés" name="cim" >
	</div>

	<div class="form-group">
		<label for="exampleFormControlTextarea1">Esemény leírása</label>
		<textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="leiras"></textarea>
	</div>

	<div class="form-group">
		<label>Esemény dátuma</label>
		<div class="col-10">
			<input class="form-control" type="text" name="esemeny_datum" >
		</div>
	</div>
	...

	...
	<button type="submit" class="btn btn-primary">Submit</button>
</form>
-->




</template>

<script>
	export default {
		data(){
			return {
				cover: '',
				cim:'',
				leiras:'',
				esemeny_datum:'',
				 isSuccessInvisible: true,
       			 isDangerInvisible:true,
			}
		},
		methods: {
			onFileChange(event) {
				this.cover = event.target.files[0];
			},
			formSubmit(e) {
				e.preventDefault();
				 let formData = new FormData();
		    formData.append('cover', this.cover);
            formData.append('cim', this.cim);
            formData.append('leiras', this.leiras);
            formData.append('esemeny_datum', this.esemeny_datum);
           
            
				axios.post('../api/esemenyek',formData)
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