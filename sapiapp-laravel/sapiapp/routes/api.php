<?php

use Illuminate\Http\Request;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

/*Route::middleware('auth:api')->get('/user', function (Request $request) {
    return $request->user();
});*/

	Route::post('login', 'API\AuthController@login')->name('adminlogin');
    Route::post('register', 'API\AuthController@register'); 
    Route::post('androidlogin', 'API\AuthController@androidlogin')->name('androidlogin');
    

    Route::get('szakok','SzakController@index')->name('szakok');
	Route::get('szakok/{id}','SzakController@show');

	Route::get('evfolyamok','EvfolyamController@index');
	Route::get('evfolyamok/{id}','EvfolyamController@show');

		


 Route::group([
      'middleware' => 'auth:api'
    ], function() {
    	Route::get('users','UserController@index');
		Route::get('user/{id}','UserController@show');
        Route::put('users/{id}','UserController@updatepassword');

		Route::get('tanarok','TanarController@index');
		Route::get('tanar/{id}','TanarController@show');
		Route::post('tanarok','TanarController@store');
		Route::put('tanarok/{id}','TanarController@update');
		Route::delete('tanarok/{id}','TanarController@destroy'); 

		Route::get('vizsgak','VizsgaController@index');
		Route::get('vizsga/{id}','VizsgaController@show');
		Route::post('vizsgak','VizsgaController@store');
		Route::put('vizsgak/{id}','VizsgaController@update');
		Route::delete('vizsgak/{id}','VizsgaController@destroy');

		Route::post('esemenyek','EventsController@store');
		Route::get('esemenyek','EventsController@index');
		Route::get('esemeny/{id}','EventsController@show');
		Route::post('esemenyek/{id}','EventsController@update');
		Route::delete('esemenyek/{id}','EventsController@destroy');

		Route::get('menuk','MenuController@index');
		Route::get('aktualismenu','MenuController@getLatest');
		Route::get('menu/{id}','MenuController@show');
		Route::post('menuk','MenuController@store');
		Route::put('menuk/{id}','MenuController@update');
		Route::delete('menuk/{id}','MenuController@destroy'); 
		
		Route::get('tantargyak','TantargyController@index');
		Route::get('tantargy/{id}','TantargyController@show');
		Route::post('tantargyak','TantargyController@store');
		Route::put('tantargyak/{id}','TantargyController@update');
		Route::delete('tantargyak/{id}','TantargyController@destroy'); 

		Route::post('szakok','SzakController@store');
		Route::put('szakok/{id}','SzakController@update');
		Route::delete('szakok/{id}','SzakController@destroy'); 

		Route::post('evfolyamok','EvfolyamController@store');	
		Route::post('logout', 'API\AuthController@logoutandroid');
    });



 		







