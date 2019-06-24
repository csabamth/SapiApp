<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Http\Resources\MenuResource;
use App\Menu; 

class MenuController extends Controller
{
    public function index()
    { 
    	$menuk = Menu::all();        
    	return MenuResource::collection($menuk); 
    }

    public function show($id)
    {        
        $menu = Menu::findOrfail($id);         
        return new MenuResource($menu);
    } 

    public function getLatest(){
    	$menu = Menu::latest()->first();
    	return new MenuResource($menu);
    }

    public function store(Request $request)
    {
        $menu = new Menu;        
        $menu->hetfo_leves = $request->input('hetfo_leves');
        $menu->hetfo_fofogas = $request->input('hetfo_fofogas');
        $menu->kedd_leves = $request->input('kedd_leves');
        $menu->kedd_fofogas = $request->input('kedd_fofogas');
        $menu->szerda_leves = $request->input('szerda_leves');
        $menu->szerda_fofogas = $request->input('szerda_fofogas');
        $menu->csutortok_leves = $request->input('csutortok_leves');
        $menu->csutortok_fofogas = $request->input('csutortok_fofogas');
        $menu->pentek_leves = $request->input('pentek_leves');
        $menu->pentek_fofogas = $request->input('pentek_fofogas');
        $menu->mettol = $request->input('mettol');
        $menu->meddig = $request->input('meddig');
       
 
        if($menu->save()) {
            return new MenuResource($menu);
        } 
    }
    
    public function update(Request $request, $id)
    {
        $menu = Menu::findOrFail($id);  

        $menu->hetfo_leves = $request->input('hetfo_leves');
        $menu->hetfo_fofogas = $request->input('hetfo_fofogas');
        $menu->kedd_leves = $request->input('kedd_leves');
        $menu->kedd_fofogas = $request->input('kedd_fofogas');
        $menu->szerda_leves = $request->input('szerda_leves');
        $menu->szerda_fofogas = $request->input('szerda_fofogas');
        $menu->csutortok_leves = $request->input('csutortok_leves');
        $menu->csutortok_fofogas = $request->input('csutortok_fofogas');
        $menu->pentek_leves = $request->input('pentek_leves');
        $menu->pentek_fofogas = $request->input('pentek_fofogas');
        $menu->mettol = $request->input('mettol');
        $menu->meddig = $request->input('meddig');

        $menu->update($request->all());   
        return new MenuResource($menu); 
      
 
        if($menu->save()) {
            return new MenuResource($menu);
        } 
    }

    public function destroy($id)
    {
        //Get the task
        $menu = Menu::findOrfail($id);
 
        if($menu->delete()) {
            return new MenuResource($menu);
        } 
    }
}
