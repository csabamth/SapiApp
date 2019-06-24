<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Http\Resources\EvfolyamResource;
use App\Evfolyam; 

class EvfolyamController extends Controller
{
    public function index()
    { 
    	$evfolyamok = Evfolyam::all();        
    	return EvfolyamResource::collection($evfolyamok); 
    }

    public function show($id)
    {        
        $evfolyam = Evfolyam::findOrfail($id);         
        return new EvfolyamResource($evfolyam);
    } 

    public function store(Request $request)
    {
        $evfolyam = new Evfolyam;        
        $evfolyam->megnevezes = $request->input('megnevezes');
 
        if($evfolyam->save()) {
            return new EvfolyamResource($evfolyam);
        } 
    }
    /*

    // postman: form-urlencoded
    public function update(Request $request, $id)
    {
        $stud = Student::findOrFail($id);   

        //$stud->update($request->all());   
        //return new StudentResource($stud); 
        $stud->nev = $request->input('nev');
        $stud->szak = $request->input('szak');
        $stud->evfolyam = $request->input('evfolyam');
 
        if($stud->save()) {
            return new StudentResource($stud);
        } 
    }

    public function destroy($id)
    {
        //Get the task
        $stud = Student::findOrfail($id);
 
        if($stud->delete()) {
            return new StudentResource($stud);
        } 
    }*/  
}
