<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Http\Resources\SzakResource;
use App\Szak; 

class SzakController extends Controller
{
    public function index()
    { 
    	$szakok = Szak::all();        
    	return SzakResource::collection($szakok); 
    }

    public function show($id)
    {        
        $szak = Szak::findOrfail($id);         
        return new SzakResource($szak);
    } 

    public function store(Request $request)
    {
        $szak = new Szak;        
        $szak->megnevezes = $request->input('megnevezes');
        $szak->rovidites = $request->input('rovidites');
        $szak->idotartamEvben = $request->input('idotartamEvben');
        $szak->tipus = $request->input('tipus');
 
        if($szak->save()) {
            return new SzakResource($szak);
        } 
    }
    
    public function update(Request $request, $id)
    {
        $szak = Szak::findOrFail($id);   

        $szak->update($request->all());   
        return new SzakResource($szak); 
        $szak->megnevezes = $request->input('megnevezes');
        $szak->rovidites = $request->input('rovidites');
        $szak->idotartamEvben = $request->input('idotartamEvben');
        $szak->tipus = $request->input('tipus');
 
        if($szak->save()) {
            return new SzakResource($szak);
        } 
    }

    public function destroy($id)
    {
        //Get the task
        $szak = Szak::findOrfail($id);
 
        if($szak->delete()) {
            return new SzakResource($szak);
        } 
    }
}
