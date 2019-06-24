@extends('dashboard')
@section('page_heading','Vizsga szerkesztése')
@section('section')
<div id="app">
<updatevizsga :id="{{ $id }}"></updatevizsga>
</div>
@stop