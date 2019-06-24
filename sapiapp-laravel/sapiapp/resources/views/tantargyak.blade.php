@extends('dashboard')
@section('page_heading','Tantárgyak kezelése')
@section('section')
<div id="app">
	<a class="btn btn-success" href="{{ url ('dashboard/addtantargy') }}"> <i class="glyphicon glyphicon-plus"></i>Új hozzaadása</a>
<tantargytabla></tantargytabla>
</div>
@stop