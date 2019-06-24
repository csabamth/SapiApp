<?php

use Illuminate\Database\Seeder;

class MenuSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('menu')->insert([
              [
                'hetfo_leves' =>'Bableves',
                'hetfo_fofogas' => 'Szalmakrumpli bécsiszelettel',
                'kedd_leves' => 'Palócleves',
                'kedd_fofogas' => 'Spagetti',
                'szerda_leves' => 'Meggyleves',
                'szerda_fofogas' => 'Rizotto',
                'csutortok_leves' => 'Répaleves',
                'csutortok_fofogas' => 'Spenót kolbásszal',
                'pentek_leves' => 'Tojásleves',
                'pentek_fofogas' => 'Rizibizi rántottsajttal',
                'mettol' => '2019-05-27',
                'meddig' => '2019-05-31',
              ]
         
             
         ]);
    }
}
