@extends('dashboard')
@section('page_heading','Aktuális menü')
@section('section')
<div id="app">
	<a class="btn btn-success" href="{{ url ('dashboard/addmenu') }}"><i class="glyphicon glyphicon-plus"></i>Új menü kiírása</a>
	<a class="btn btn-warning" href="{{ url ('dashboard/updateactualmenu') }}"><i class="glyphicon glyphicon-pencil"></i>Aktuális heti menü szerkesztése</a>
<menutabla></menutabla>
</div>
@stop