<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Http\Resources\TantargyResource;
use App\Tantargy; 

class TantargyController extends Controller
{
    public function index()
    { 
    	$tantargyak = Tantargy::all();        
    	return TantargyResource::collection($tantargyak); 
    }

    public function show($id)
    {        
        $tantargy = Tantargy::findOrfail($id);         
        return new TantargyResource($tantargy);
    } 

    public function store(Request $request)
    {
        $tantargy = new Tantargy;        
        $tantargy->megnevezes = $request->input('megnevezes');
 
        if($tantargy->save()) {
            return new TantargyResource($tantargy);
        } 
    }
     public function update(Request $request, $id)
    {
        $tantargy = Tantargy::findOrFail($id);   

        $tantargy->update($request->all());   
        return new TantargyResource($tantargy); 
        $tantargy->megnevezes = $request->input('megnevezes');

        if($tantargy->save()) {
            return new TantargyResource($tantargy);
        } 
    }

    public function destroy($id)
    {
        //Get the task
        $tantargy = Tantargy::findOrfail($id);
 
        if($tantargy->delete()) {
            return new TantargyResource($tantargy);
        } 
    }
 
}