@extends('layouts.plane')
<html>
	<head>
		<link href='//fonts.googleapis.com/css?family=Lato:100' rel='stylesheet' type='text/css'>

		<style>
			body {
				margin: 0;
				padding: 0;
				width: 100%;
				height: 100%;
				display: table;
				font-weight: bold;
				font-family: 'Lato'!important;
			}

			.container {
				text-align: center;
				display: table-cell;
				
			}

			.content {
				text-align: center;
				display: inline-block;
			}

			.title {
				font-size: 4em;
				margin-bottom: 30px;
			}

			.quote {
				font-size: 2em;
				margin-bottom: 20px;
			}
			.img{
				width:170px;
				margin-bottom: 20px;
			}
		</style>
	</head>
	<body>
		<div class="container">
			<div class="content">
				<div class="title">Üdvözlünk a Sapiappon!</div>
				<div class="quote">Diák vagy?</div>
				<div class="quote">Töltsd le az alkalmazást a Google Play Áruházból!</div>
				<a href="#"><img src="http://localhost/sapiapp/public/images/gp.png" class="img"></a>
				<div class="quote">Adminisztrátor vagy?</div>
				<div class="quote">Jelentkezz be a gombra kattintva!</div>
				<a href="{{ route('login') }}" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Bejelentkezés</a>

			</div>
		</div>
	</body>
</html>
