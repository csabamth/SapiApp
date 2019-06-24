<?php

use Illuminate\Database\Seeder;
use Carbon\Carbon;

class VizsgaSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
         DB::table('vizsgak')->insert([
              [
           'tantargyID'=>1,
           'szakID'=>3,
           'evfolyamID'=>1,
           'tanarID'=>1,
           'vizsgadatum'=>Carbon::create('2019', '05', '13')
            ],

            [
           'tantargyID'=>3,
           'szakID'=>1,
           'evfolyamID'=>3,
           'tanarID'=>4,
           'vizsgadatum'=>Carbon::create('2019', '05', '14')
            ],

             [
           'tantargyID'=>2,
           'szakID'=>2,
           'evfolyamID'=>2,
           'tanarID'=>1,
           'vizsgadatum'=>Carbon::create('2019', '05', '15')
            ]
             
         ]);
    }
}
