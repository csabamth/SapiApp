<template>
	
	<table class="table">
  <thead>
    <tr>
      <th scope="col">Esemény megnevezése</th>
      <th scope="col">Esemény dátuma</th>
     
    </tr>
  </thead>
  <tbody>
    <tr v-for="esemeny in esemenyek">
      <td>{{esemeny.cim}}</td>
      <td>{{esemeny.esemeny_datum}}</td>
      <a @click="remove(esemeny.id)" class="btn btn-danger"><i class="glyphicon glyphicon-remove"></i></a>
     	<a v-bind:href="'./updateesemeny/'+esemeny.id" class="btn btn-warning"><i class="glyphicon glyphicon-pencil"></i></a>
    </tr>
  </tbody>
</table>
</div>
</template>

<script>
	export default{
		data(){
			return {
				esemenyek: [],
				esemeny: {
					id:'',
					cim: '',
					leiras:'',
					img_url:'',
					esemeny_datum:''
					
				}
			}
		},
		mounted() {
			this.getEsemenyek();
		},
		methods: {
			getEsemenyek(){
				axios.get('../api/esemenyek').then(response => {
					console.log(response)
					this.esemenyek = response.data

				})
			},
			remove(id) {
            axios.delete('.././api/esemenyek/' + id)
                .then(response=>{

                	this.esemenyek=[];
                    this.getEsemenyek();
                })
                .catch(function(error) {
                    console.log(error)
                });
        }   
		}
	}
</script>