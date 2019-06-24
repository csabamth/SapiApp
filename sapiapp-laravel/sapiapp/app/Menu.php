<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Menu extends Model
{
    protected $table = 'menu';
    protected $fillable = [
        'hetfo_leves', 'hetfo_fofogas', 'kedd_leves', 'kedd_fofogas', 'szerda_leves', 'szerda_fofogas', 'csutortok_leves', 'csutortok_fofogas', 'pentek_leves', 'pentek_fofogas', 'mettol', 'meddig'
    ];
}
