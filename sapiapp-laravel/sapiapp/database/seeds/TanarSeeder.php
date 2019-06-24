<?php

use Illuminate\Database\Seeder;

class TanarSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('tanarok')->insert([
              [
            'vezeteknev'=>'Oláh-Gál',
            'keresztnev'=>'Róbert',
            'funkcio'=>'adjunktus',
            
              ],

            [
            'vezeteknev'=>'Illyés',
            'keresztnev'=>'László',
            'funkcio'=>'adjunktus',
            
              ],

            [
            'vezeteknev'=>'Salamon',
            'keresztnev'=>'Júlia',
            'funkcio'=>'docens',
            
              ],

            [
            'vezeteknev'=>'Pál',
            'keresztnev'=>'László',
            'funkcio'=>'docens',
            
              ],
              
             
         ]);
    }
}
