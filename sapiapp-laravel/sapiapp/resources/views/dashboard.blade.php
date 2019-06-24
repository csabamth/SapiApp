@extends('layouts.plane')

@section('body')
 <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="{{ url ('dashboard') }}">SapiApp Control Panel</a>

            </div>
            <!-- /.navbar-header -->
            <ul class="nav navbar-top-links navbar-right">
                @if (Auth::guest())
                        <li><a href="/auth/login">Login</a></li>
                        <li><a href="/auth/register">Register</a></li>
                    @else
                            <a href="#"  data-toggle="dropdown" role="button" aria-expanded="true">{{ Auth::user()->name }} <span class="caret"></span></a>
                            <a class="btn btn-success" href="{{ url ('logout') }}">Kijelentkezés</a>
                            

                    @endif
            </ul>

           
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li {{ (Request::is('/') ? 'class="active"' : '') }}>
                            <a href="{{ url ('dashboard') }}"><i class="fa fa-dashboard fa-fw"></i> Főoldal</a>
                        </li>
                      
                        <li >
                            <a href="#"><i class="fa fa-wrench fa-fw"></i> Szerkesztés<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="{{ url ('dashboard/oktatok') }}">Oktatók kezelése</a>
                                </li>
                                <li>
                                    <a href="{{ url ('dashboard/szakok' ) }}">Szakok kezelése</a>
                                </li>
                                <li>
                                    <a href="{{ url('dashboard/tantargyak') }}">Tantárgyak kezelése</a>
                                </li>
                                <li>
                                    <a href="{{ url ('dashboard/vizsgak') }}">Vizsgák kezelése</a>
                                </li>
                                <li>
                                    <a href="{{ url ('dashboard/esemenyek') }}"> Események kezelése</a>
                                </li>
                                <li>
                                    <a href="{{ url ('dashboard/menu') }}"> Heti menü kezelése</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>


                    </ul>

                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
             <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">@yield('page_heading')</h1>
                </div>

                <!-- /.col-lg-12 -->
           </div>
            <div class="row">  
                @yield('section')
                
            </div>
            <!-- /#page-wrapper -->
        </div>
    </div>
@stop

