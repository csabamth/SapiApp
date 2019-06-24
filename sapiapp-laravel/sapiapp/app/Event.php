<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Event extends Model
{
	protected $table = 'hirek';
    protected $fillable = [
        'cim', 'leiras', 'img_url','esemeny_datum'
    ];
}
