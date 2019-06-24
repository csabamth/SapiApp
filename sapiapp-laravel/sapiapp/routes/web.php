<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/



Route::get('/login', function () {
    return view('auth/login');
})->name('login')->middleware('guest');

Route::get('/signup', [
    'uses' => 'AuthController@getSignup',
    'as' => 'auth.signup',
    'middleware' => ['guest'],
]);

Route::get('/', function () {
    return view('welcome');
})->name('welcome');






Route::group(['middleware'=>'auth'],function(){

Route::get('/dashboard', 'DashboardController@index')->name('dashboard');
Route::get('dashboard/szakok', 'DashboardController@szakok')->name('szakok');
Route::get('dashboard/addszakok', 'DashboardController@addszakok')->name('addszakok');
Route::get('dashboard/oktatok', 'DashboardController@oktatok')->name('oktatok');
Route::get('dashboard/addoktato', 'DashboardController@addoktato')->name('addoktato');
Route::get('dashboard/tantargyak', 'DashboardController@tantargyak')->name('tantargyak');
Route::get('dashboard/addtantargy', 'DashboardController@addtantargy')->name('addtantargy');
Route::get('dashboard/vizsgak', 'DashboardController@vizsgak')->name('vizsgak');
Route::get('dashboard/addvizsga', 'DashboardController@addvizsga')->name('addvizsga');
Route::get('dashboard/esemenyek', 'DashboardController@esemenyek')->name('esemenyek');
Route::get('dashboard/addesemeny', 'DashboardController@addesemeny')->name('addesemeny');
Route::get('dashboard/menu', 'DashboardController@menu')->name('menu');
Route::get('dashboard/addmenu', 'DashboardController@addmenu')->name('addmenu');
Route::get('dashboard/updateactualmenu', 'DashboardController@updatemenu')->name('updatemenu');
Route::get('dashboard/changepassword', 'DashboardController@changepassword')->name('changepassword');


Route::get('dashboard/updateoktato/{id}', function ($id) {
   return view('updateoktato',compact('id'));
})->name('updateoktato');

Route::get('dashboard/updateszak/{id}', function ($id) {
   return view('updateszak',compact('id'));
})->name('updateszak');

Route::get('dashboard/updatevizsga/{id}', function ($id) {
   return view('updatevizsga',compact('id'));
})->name('updatevizsga');

Route::get('dashboard/updateesemeny/{id}', function ($id) {
   return view('updateesemeny',compact('id'));
})->name('updateesemeny');

Route::get('logout', 'API\AuthController@logoutweb')->name('logout');

});
