<template>
	
	<table class="table">
  <thead>
    <tr>
      <th scope="col">Hétfő</th>
      <th scope="col">Kedd</th>
      <th scope="col">Szerda</th>
      <th scope="col">Csütörtök</th>
      <th scope="col">Csütörtök</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>{{menu.hetfo_leves}}</td>
      <td>{{menu.kedd_leves}}</td> 
       <td>{{menu.szerda_leves}}</td>        
      <td>{{menu.csutortok_leves}}</td>
      <td>{{menu.pentek_leves}}</td>
    </tr> 
    <tr> 
      <td>{{menu.hetfo_fofogas}}</td>
      <td>{{menu.kedd_fofogas}}</td>
      <td>{{menu.szerda_fofogas}}</td>
      <td>{{menu.csutortok_fofogas}}</td>
      <td>{{menu.pentek_fofogas}}</td>     
    </tr>
  </tbody>
</table>
</div>
</template>

<script>
	export default{
		data(){
			return {
				menu: [],
				
			}
		},
		mounted() {
			this.getLatestMenu();
		},
		methods: {
			getLatestMenu(){
				axios.get('../api/aktualismenu').then(response => {
					console.log(response)
					this.menu = response.data

				})
			}     	              
    
		}
	}
</script>