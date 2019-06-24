<?php

use Illuminate\Database\Seeder;
use Carbon\Carbon;

class DatabaseSeeder extends Seeder
{
    /**
     * Seed the application's database.
     *
     * @return void
     */
    public function run()
    {
      
         $this->call(EvfolyamSeeder::class);
         $this->call(SzakSeeder::class);
         $this->call(TantargyakSeeder::class);
         $this->call(TanarSeeder::class);
         $this->call(VizsgaSeeder::class);
         $this->call(MenuSeeder::class);
         $this->call(UserSeeder::class);
    }
}
