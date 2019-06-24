@extends('dashboard')
@section('page_heading','Szakok kezelése')
@section('section')
<div id="app">
	<a class="btn btn-success" href="{{ url ('dashboard/addszakok') }}"><i class="glyphicon glyphicon-plus"></i> Új hozzaadása</a>
<szaktabla></szaktabla>
</div>
@stop