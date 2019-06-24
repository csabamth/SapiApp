<?php

use Illuminate\Database\Seeder;

class HirekSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
         DB::table('hirek')->insert([
              [
            'cim'=>'Államvizsga',
            'leiras'=>'Allamvizsga bemutatasanak idopontja. varunk mindenkit szeretettel!',
            'img_url'=>'asset/asd.png',
            'esemeny_datum'=>'2019-07-04'
              ]
         ]);
    }
}
