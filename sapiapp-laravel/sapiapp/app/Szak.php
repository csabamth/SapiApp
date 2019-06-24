<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Szak extends Model
{
	protected $table = 'szakok';
    protected $fillable = [
        'megnevezes', 'rovidites', 'idotartamEvben','tipus'
    ];
}
