<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class DashboardController extends Controller
{
     public function index()
    {
    	return view("fooldal");
    }

    public function szakok(){
    	return view("szakok");
    }
    public function addszakok(){
        return view("addszak");
    }
    public function oktatok(){
    	return view("oktatok");
    }
     public function addoktato(){
        return view("addoktato");
    }
    public function tantargyak(){
        return view("tantargyak");
    }
     public function addtantargy(){
        return view("addtantargy");
    }
    public function vizsgak(){
        return view("vizsgak");
    }
    public function addvizsga(){
        return view("addvizsga");
    }
    public function esemenyek(){
        return view("esemenyek");
    }
    public function addesemeny(){
        return view("addesemeny");
    }
    public function updateoktato(){
        return view("updateoktato");
    }
    public function menu(){
        return view("menu");
    }
     public function addmenu(){
        return view("addmenu");
    }
     public function updatemenu(){
        return view("updateactualmenu");
    }
    public function changepassword(){
        return view("auth/changepassword");
    }

}
