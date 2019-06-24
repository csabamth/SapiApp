<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Http\Resources\UserResource;
use App\User;

class UserController extends Controller
{
    public function index()
    { 
    	$users = User::all();        
    	return UserResource::collection($users); 
    }

    public function show($id)
    {        
        $user = User::findOrfail($id);         
        return new UserResource($user);
    } 

    public function updatepassword(Request $request, $id)
    {
        $user = User::findOrFail($id);   

        $user->update($request->all());  
        $user->password = bcrypt($request->input('password'));
        
        

       
 
        if($user->save()) {
            return new UserResource($user);
        } 
    }
}
