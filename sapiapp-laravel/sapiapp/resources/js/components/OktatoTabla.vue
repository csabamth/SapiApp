<template>
	
	<table class="table">
  <thead>
    <tr>
      <th scope="col">Vezetéknév</th>
      <th scope="col">Keresztnév</th>
      <th scope="col">Titulus</th>
      
    </tr>
  </thead>
  <tbody>
    <tr v-for="oktato in oktatok">
      <td>{{oktato.vezeteknev}}</td>
      <td>{{oktato.keresztnev}}</td>
      <td>{{oktato.funkcio}}</td>
      <a @click="remove(oktato.id)" class="btn btn-danger"><i class="glyphicon glyphicon-remove"></i></a>
      <a v-bind:href="'./updateoktato/'+oktato.id" class="btn btn-warning"><i class="glyphicon glyphicon-pencil"></i></a>
       
    </tr>
  </tbody>
</table>
</div>
</template>

<script>
	export default{
		data(){
			return {
				oktatok: [],
				oktato: {
					id:'',
					vezeteknev: '',
					keresztnev: '',
					funkcio: '',
				}
			}
		},
		mounted() {
			this.getOktatok();
		},
		methods: {
			getOktatok(){
				axios.get('../api/tanarok').then(response => {
					console.log(response)
					this.oktatok = response.data

				})
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