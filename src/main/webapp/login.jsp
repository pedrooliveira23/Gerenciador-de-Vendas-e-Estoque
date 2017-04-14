<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <!--Import Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="css/login.css" media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta charset="UTF-8">
</head>

<body>
<!--Import jQuery before materialize.js-->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>

<script src="https://use.typekit.net/ayg4pcz.js"></script>
<script>try{Typekit.load({ async: true });}catch(e){}</script>

<div class="container">
    <h1 class="welcome center-align">Gerenciador de Vendas e Estoque</h1>
    <div class="card card-container">
        <h2 class='login_title text-center'>Bem-vindo</h2>
        <hr>

        <form class="form-signin" action="/login" method="post">
            <span id="reauth-email" class="reauth-email"></span>
            <p class="input_title">Nome de Usuário</p>
            <input type="text" id="inputEmail" class="login_box" name="username" required autofocus>
            <p class="input_title">Senha</p>
            <input type="password" id="inputPassword" class="login_box" name="password" required>
            <div id="remember" class="checkbox">
                <label>

                </label>
            </div>
            <button class="btn btn-lg btn-primary" type="submit">Entrar</button>
        </form><!-- /form -->
    </div><!-- /card-container -->
</div><!-- /container -->

</body>
</html>