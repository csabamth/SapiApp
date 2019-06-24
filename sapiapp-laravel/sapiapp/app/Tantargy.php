<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Tantargy extends Model
{
	protected $table = 'tantargyak';
    protected $fillable = [
        'megnevezes'
    ];
}
