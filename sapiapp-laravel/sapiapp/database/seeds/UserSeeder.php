<?php

use Illuminate\Database\Seeder;

class UserSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('users')->insert([
              [
            'name'=>'admin', 
            'email'=>'admin@sapiapp.com',
            'password'=>bcrypt('12345678'),
            'szakId'=>1,
            'evfolyamId'=>1,
            'admin'=>1,
              ],     
         ]);
    }
}
