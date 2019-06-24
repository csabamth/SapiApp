<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Http\Resources\EventResource;
use App\Event; 
use Illuminate\Support\Facades\Storage;
use Illuminate\Support\Facades\File;

class EventsController extends Controller
{
    public function index()
    { 
    	$events = Event::all();        
    	return EventResource::collection($events); 
    }

    public function show($id)
    {        
        $event = Event::findOrfail($id);         
        return new EventResource($event);
    } 

    public function store(Request $request)
    {

        $cover = $request->file('cover');
        $extension = $cover->getClientOriginalExtension();
        Storage::disk('public')->put($cover->getFilename().'.'.$extension,File::get($cover));
        $event  = new Event;        
        $event ->cim = $request->input('cim');
        $event ->leiras = $request->input('leiras');
        $event ->img_url =  $cover->getFilename().'.'.$extension;
        $event ->esemeny_datum = $request->input('esemeny_datum');
        
 
        if($event ->save()) {
            return new EventResource($event);
        } 
    }
    
    public function update(Request $request, $id)
    {
        $cover = $request->file('cover');
        $extension = $cover->getClientOriginalExtension();
        Storage::disk('public')->put($cover->getFilename().'.'.$extension,File::get($cover));
        $event  = Event::findOrFail($id);

        $event ->cim = $request->input('cim');
        $event ->leiras = $request->input('leiras');
        $event ->img_url =  $cover->getFilename().'.'.$extension;
        $event ->esemeny_datum = $request->input('esemeny_datum');   

        $event ->update($request->all());   
        return new EventResource($event); 
    
      
      
 
        if($event ->save()) {
            return new EventResource($event);
        } 
    }

    public function destroy($id)
    {
        //Get the task
        $event  = Event::findOrfail($id);
 
        if($event ->delete()) {
            return new EventResource($event);
        } 
    }
}
