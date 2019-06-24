<?php

use Illuminate\Database\Seeder;

class SzakSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
          DB::table('szakok')->insert([
              [
            'megnevezes'=>'Gazdasági informatika',
            'rovidites'=>'GI',
            'idotartamEvben'=>'3',
            'tipus'=>'BsC'
              ],

             [
            'megnevezes'=>'Marketing',
            'rovidites'=>'M',
            'idotartamEvben'=>'3',
            'tipus'=>'BsC'
             ],  

             [
            'megnevezes'=>'Általános közgazdaság',
            'rovidites'=>'ÁK',
            'idotartamEvben'=>'3',
            'tipus'=>'BsC'
             ]
              
             
         ]);
    }
}
