@extends('dashboard')
@section('page_heading','Főoldal')
@section('section')
<div class="alert alert-success" role="alert">
  <h4 class="alert-heading">Üdvözlünk {{ Auth::user()->name }}!</h4>
  <p>A bal oldali "Szerkesztés" menüt lenyomva éred el a különböző kezelési menüket, kijelentkezni a bal felső sarokban található "Kijelentkezés" gombbal tudsz.</p>
  <hr>
  <p class="mb-0">Amennyiben ez egy első bejelentkezés, javasoljuk a jelszó megváltoztatását. Ezt az alább található "Jelszó megváltozatása" gombbal teheted meg.</p>


</div>
<a class="btn btn-primary" href="{{ route('changepassword') }}" role="button">Jelszó megváltoztatása</a>

@stop