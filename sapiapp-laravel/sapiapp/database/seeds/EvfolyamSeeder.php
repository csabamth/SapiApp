<?php

use Illuminate\Database\Seeder;

class EvfolyamSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
         DB::table('evfolyamok')->insert([
              [
                'id' => 1,
                'megnevezes' => 'I',
              ],
              [
                'id' => 2,
                'megnevezes' => 'II',
              ],
              [
                'id' => 3,
                'megnevezes' => 'III',
              ],

               [
                'id' => 4,
                'megnevezes' => 'IV',
              ],
             
         ]);
    }
}
