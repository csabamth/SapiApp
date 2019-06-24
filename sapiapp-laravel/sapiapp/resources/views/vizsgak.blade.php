@extends('dashboard')
@section('page_heading','Vizsgák kezelése')
@section('section')
<div id="app">
	<a class="btn btn-success" href="{{ url ('dashboard/addvizsga') }}"> <i class="glyphicon glyphicon-plus"></i>Új hozzaadása</a>
<vizsgatabla></vizsgatabla>
</div>
@stop