@extends('dashboard')
@section('page_heading','Oktatók kezelése')
@section('section')
<div id="app">
	<a class="btn btn-success" href="{{ url ('dashboard/addoktato') }}"><i class="glyphicon glyphicon-plus"></i>Új hozzaadása</a>
<oktatotabla></oktatotabla>
</div>
@stop