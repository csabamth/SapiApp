<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Http\Resources\VizsgaResource;
use App\Vizsga;


class VizsgaController extends Controller
{
     public function index()
    { 
    	$vizsgak = Vizsga::all();        
    	return VizsgaResource::collection($vizsgak); 
    }

    public function show($id)
    {        
        $vizsga = Vizsga::findOrfail($id);         
        return new VizsgaResource($vizsga);
    } 

     public function store(Request $request)
    {
        $vizsga = new Vizsga;     
        $vizsga->tantargyID = $request->input('tantargyID');   
        $vizsga->szakID = $request->input('szakID');
        $vizsga->evfolyamID = $request->input('evfolyamID');
        $vizsga->tanarID = $request->input('tanarID');
        $vizsga->vizsgadatum = $request->input('vizsgadatum');
 
        if($vizsga->save()) {
            return new VizsgaResource($vizsga);
        } 
    }
     public function update(Request $request, $id)
    {
        $vizsga = Vizsga::findOrFail($id);   

        $vizsga->update($request->all());   
        return new VizsgaResource($vizsga); 
        $vizsga->tantargyID = $request->input('tantargyID');   
        $vizsga->szakID = $request->input('szakID');
        $vizsga->evfolyamID = $request->input('evfolyamID');
        $vizsga->tanarID = $request->input('tanarID');
        $vizsga->vizsgadatum = $request->input('vizsgadatum');


        if($vizsga->save()) {
            return new VizsgaResource($vizsga);
        } 
    }

    public function destroy($id)
    {
        //Get the task
        $vizsga = Vizsga::findOrfail($id);
 
        if($vizsga->delete()) {
            return new VizsgaResource($vizsga);
        } 
    }
}
