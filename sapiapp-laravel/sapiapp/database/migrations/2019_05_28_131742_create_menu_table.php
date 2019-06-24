<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateMenuTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('menu', function (Blueprint $table) {
            $table->increments('id');
            $table->string('hetfo_leves');
            $table->string('hetfo_fofogas');
            $table->string('kedd_leves');
            $table->string('kedd_fofogas');
            $table->string('szerda_leves');
            $table->string('szerda_fofogas');
            $table->string('csutortok_leves');
            $table->string('csutortok_fofogas');
            $table->string('pentek_leves');
            $table->string('pentek_fofogas');
            $table->date('mettol');
            $table->date('meddig');
            
            $table->timestamps();
           
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('tanarok');
    }
}
