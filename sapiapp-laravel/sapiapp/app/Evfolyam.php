<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Evfolyam extends Model
{
	protected $table = 'evfolyamok';
    protected $fillable = [
        'megnevezes'
    ];
}
