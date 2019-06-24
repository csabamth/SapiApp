<?php

namespace App;

use Illuminate\Notifications\Notifiable;
use Illuminate\Contracts\Auth\MustVerifyEmail;
use Illuminate\Foundation\Auth\User as Authenticatable;
use Laravel\Passport\HasApiTokens;

class User extends Authenticatable
{
    use Notifiable, hasApiTokens;


    protected $fillable = [
        'name', 'email', 'password','szakId','evfolyamId'
    ];

    protected $hidden = [
        'password', 'remember_token','admin'
    ];

    public function is_admin(){
        if($this->admin)
        {
            return true;
        }
        return false;
    }
}

