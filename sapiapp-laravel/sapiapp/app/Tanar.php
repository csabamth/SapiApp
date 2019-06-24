<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Tanar extends Model
{
	protected $table = 'tanarok';
    protected $fillable = [
        'vezeteknev','keresztnev','funkcio'
    ];
}
