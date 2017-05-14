<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <!--Import Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta charset="UTF-8">
    <title>Gerenciador de Vendas e Estoque</title>
</head>

<body>
<!--Import jQuery before materialize.js-->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<ul id="estoque" class="dropdown-content">
    <li><a href="gerenciarEstoque">Gerenciar</a></li>
</ul>
<ul id="cadastro" class="dropdown-content">
    <li><a href="cadastroDeProdutos">Produtos</a></li>
    <li><a href="cadastroDeClientes">Clientes</a></li>
</ul>
<ul id="usuario" class="dropdown-content">
    <li><a href="logout">Sair</a></li>
</ul>
<nav>
    <div class="nav-wrapper blue darken-1">
        <a href="#!" class="brand-logo">GVE</a>
        <a href="#" data-activates="mobile" class="button-collapse"><i class="material-icons">menu</i></a>
        <ul class="right hide-on-med-and-down">
            <li><a class="dropdown-button" href="#!" data-activates="dropdown1">Vendas<i class="material-icons right">arrow_drop_down</i></a></li>
            <li><a class="dropdown-button" href="#!" data-activates="estoque">Estoque<i class="material-icons right">arrow_drop_down</i></a></li>
            <li><a class="dropdown-button" href="#!" data-activates="cadastro">Cadastro<i class="material-icons right">arrow_drop_down</i></a></li>
            <li><a class="dropdown-button" href="#!" data-activates="usuario">Conta<i class="material-icons right">arrow_drop_down</i></a></li>
        </ul>
<!--        <ul class="side-nav" id="mobile">
            <li><a class="dropdown-button" href="#!" data-activates="dropdown1">Vendas<i class="material-icons right">arrow_drop_down</i></a></li>
            <li><a class="dropdown-button" href="#!" data-activates="estoque">Estoque<i class="material-icons right">arrow_drop_down</i></a></li>
            <li><a class="dropdown-button" href="#!" data-activates="cadastro">Cadastro<i class="material-icons right">arrow_drop_down</i></a></li>
            <li><a class="dropdown-button" href="#!" data-activates="usuario">Conta<i class="material-icons right">arrow_drop_down</i></a></li>
        </ul> -->
    </div>
</nav>
<div class="container">
<h1>Bem-vindo, <%=request.getAttribute("username")%></h1>
</div>
</body>
</html>