<?php

use Illuminate\Database\Seeder;

class TantargyakSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
          DB::table('tantargyak')->insert([
              [
            'megnevezes'=>'Matematika'
              ],

             [
            'megnevezes'=>'Marketing'   
              ],

              [
            'megnevezes'=>'Web programozás'
                       
              ],

              
             
         ]);
    }
}
