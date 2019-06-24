@extends('dashboard')
@section('page_heading','Oktató szerkesztése')
@section('section')
<div id="app">
<updateoktato :id="{{ $id }}"></updateoktato>
</div>
@stop