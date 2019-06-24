<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateVizsgaTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('vizsgak', function (Blueprint $table) {
            $table->bigIncrements('id');
            $table->unsignedInteger('tantargyID');
            $table->unsignedInteger('szakID');
            $table->unsignedInteger('evfolyamID');
            $table->unsignedInteger('tanarID');
            $table->date('vizsgadatum');
            $table->timestamps();
        });

        Schema::table('vizsgak', function ($table) {
            $table->foreign('tantargyID')->references('id')->on('tantargyak');
            $table->foreign('szakID')->references('id')->on('szakok');
            $table->foreign('evfolyamID')->references('id')->on('evfolyamok');
            $table->foreign('tanarID')->references('id')->on('tanarok');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
    
        Schema::dropIfExists('vizsgak');
    }
}
