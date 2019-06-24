<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Vizsga extends Model
{
    protected $table = 'vizsgak';
    protected $fillable = [
        'tantargyID', 'szakID', 'evfolyamID','tanarID','vizsgadatum'
    ];
}
