@extends('dashboard')
@section('page_heading','Jelszó megváltoztatása')
@section('section')
<div id="app">
<changepassword :id="{{ Auth::user()->id }}"></changepassword>
</div>
@stop