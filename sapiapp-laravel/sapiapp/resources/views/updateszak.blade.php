@extends('dashboard')
@section('page_heading','Szak szerkesztése')
@section('section')
<div id="app">
<updateszak :id="{{ $id }}"></updateszak>
</div>
@stop