<template>
	
	<table class="table">
  <thead>
    <tr>
      <th scope="col">Megnevezés</th>
      <th scope="col">Rövidítés</th>
      <th scope="col">Időtartam</th>
      <th scope="col">Típus</th>
    </tr>
  </thead>
  <tbody>
    <tr v-for="szak in szakok">
      <td>{{szak.megnevezes}}</td>
      <td>{{szak.rovidites}}</td>
      <td>{{szak.idotartamEvben}} év</td>
      <td>{{szak.tipus}}</td>
      <a @click="remove(szak.id)" class="btn btn-danger"><i class="glyphicon glyphicon-remove"></i>Törlés</a>
      <a v-bind:href="'./updateszak/'+szak.id" class="btn btn-warning"><i class="glyphicon glyphicon-pencil"></i></a>
    </tr>
  </tbody>
</table>
</div>
</template>

<script>
	export default{
		data(){
			return {
				szakok: [],
				szak: {
					id:'',
					idotartamEvben: '',
					megnevezes: '',
					rovidites: '',
					tipus: '',
				}
			}
		},
		mounted() {
			this.getSzakok();
		},
		methods: {
			getSzakok(){
				axios.get('../api/szakok').then(response => {
					console.log(response)
					this.szakok = response.data

				})
			},
			remove(id) {
            axios.delete('.././api/szakok/' + id)
                .then(response=>{

                	this.szakok=[];
                    this.getSzakok();
                })
                .catch(function(error) {
                    console.log(error)
                });
        }  ,

        update(id){
        	this.szakok=[];
        	
        }              
    
		}
	}
</script>