<template>
	
	<table class="table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Megnevezés</th>
     
    </tr>
  </thead>
  <tbody>
    <tr v-for="tantargy in tantargyak">
      <td>{{tantargy.id}}</td>
      <td>{{tantargy.megnevezes}}</td>
      <a @click="remove(tantargy.id)" class="btn btn-danger"><i class="glyphicon glyphicon-remove"></i>Törlés</a>
     
     
    </tr>
  </tbody>
</table>
</div>
</template>

<script>
	export default{
		data(){
			return {
				tantargyak: [],
				tantargy: {
					id:'',
					megnevezes: '',
					
				}
			}
		},
		mounted() {
			this.getTantargyak();
		},
		methods: {
			getTantargyak(){
				axios.get('../api/tantargyak').then(response => {
					console.log(response)
					this.tantargyak = response.data

				})
			},
			remove(id) {
            axios.delete('.././api/tantargyak/' + id)
                .then(response=>{

                	this.tantargyak=[];
                    this.getTantargyak();
                })
                .catch(function(error) {
                    console.log(error)
                });
        }   
		}
	}
</script>