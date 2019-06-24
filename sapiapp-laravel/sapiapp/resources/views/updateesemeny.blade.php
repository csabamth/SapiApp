w@extends('dashboard')
@section('page_heading','Esemény szerkesztése')
@section('section')
<div id="app">
<updateesemeny :id="{{ $id }}"></updateesemeny>
</div>
@stop