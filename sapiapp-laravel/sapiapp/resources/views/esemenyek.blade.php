@extends('dashboard')
@section('page_heading','Események kezelése')
@section('section')
<div id="app">
	<a class="btn btn-success" href="{{ url ('dashboard/addesemeny') }}"> <i class="glyphicon glyphicon-plus"></i>Új hozzaadása</a>
<esemenytabla></esemenytabla>
</div>
@stop