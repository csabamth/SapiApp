<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Http\Resources\TanarResource;
use App\Tanar; 

class TanarController extends Controller
{
    public function index()
    { 
    	$tanarok = Tanar::all();        
    	return TanarResource::collection($tanarok); 
    }

    public function show($id)
    {        
        $tanar = Tanar::findOrfail($id);         
        return new TanarResource($tanar);
    } 

    public function store(Request $request)
    {
        $tanar = new Tanar;        
        $tanar->vezeteknev = $request->input('vezeteknev');
        $tanar->keresztnev = $request->input('keresztnev');
        $tanar->funkcio = $request->input('funkcio'); 
        if($tanar->save()) {
            return new TanarResource($tanar);
        } 
 }

    public function update(Request $request, $id)
    {
        $tanar = Tanar::findOrFail($id);   

        $tanar->update($request->all());   
        return new TanarResource($tanar); 
        $tanar->vezeteknev = $request->input('vezeteknev');
        $tanar->keresztnev = $request->input('keresztnev');
        $tanar->funkcio = $request->input('funkcio'); 
 
        if($tanar->save()) {
            return new TanarResource($tanar);
        } 
    }

    public function destroy($id)
    {
        //Get the task
        $tanar = Tanar::findOrfail($id);
 
        if($tanar->delete()) {
            return new TanarResource($tanar);
        } 
    }
}

