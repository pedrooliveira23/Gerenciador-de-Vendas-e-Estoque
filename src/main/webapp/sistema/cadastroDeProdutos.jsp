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
            <li><a class="dropdown-button" href="#!" data-activates="dropdown1">Estoque<i class="material-icons right">arrow_drop_down</i></a></li>
            <li><a class="dropdown-button" href="#!" data-activates="cadastro">Cadastro<i class="material-icons right">arrow_drop_down</i></a></li>
            <li><a class="dropdown-button" href="#!" data-activates="usuario">Conta<i class="material-icons right">arrow_drop_down</i></a></li>
        </ul>
<!--        <ul class="side-nav" id="mobile">
            <li><a class="dropdown-button" href="#!" data-activates="dropdown1">Vendas<i class="material-icons right">arrow_drop_down</i></a></li>
            <li><a class="dropdown-button" href="#!" data-activates="dropdown1">Estoque<i class="material-icons right">arrow_drop_down</i></a></li>
            <li><a class="dropdown-button" href="#!" data-activates="cadastro">Cadastro<i class="material-icons right">arrow_drop_down</i></a></li>
            <li><a class="dropdown-button" href="#!" data-activates="usuario">Conta<i class="material-icons right">arrow_drop_down</i></a></li>
        </ul> -->
    </div>
</nav>
<div class="container">
    <h1>Cadastro de Produtos</h1>
    <p><%=request.getAttribute("mensagem")%></p>
    <form class="row">
        <div class="col s9">
        <input placeholder="Código" type="text" class="validate" name="codigo">
        <input placeholder="Nome" type="text" class="validate" name="nome">
        <input placeholder="Valor Unitário" type="number" class="validate" name="valorUnitario">
        </div>
        <div class="col s3">
            <div class="center-align">
                <button class="btn btn-lg btn-primary" style="margin-bottom: 10px;" type="submit" name="acao" value="pesquisar">Pesquisar</button>

                <button class="btn btn-lg btn-primary" type="submit" name="acao" value="adicionar">Adicionar</button>
            </div>
        </div>
    </form>
    <div class="row">
        <table class="col s12 m12 l12">
            <thead>
            <th>Código</th>
            <th>Nome</th>
            <th>Valor Unitário</th>
            <th>Operações</th>
            </thead>
            <tbody>
            <%
                java.util.List<model.entidades.Produto> lista = (java.util.List<model.entidades.Produto>) session
                        .getAttribute("listaDeProdutos");
                for (int i = 0; i < lista.size(); i++) {
            %>
            <tr>
                <td><%=lista.get(i).getCodigo()%></td>
                <td><%=lista.get(i).getNome()%></td>
                <td><%=lista.get(i).getValorUnitario()%></td>
                <td><form><button class="btn btn-lg btn-primary" type="submit" name="acao" value="remover|<%=lista.get(i).getCodigo()%>">Remover</button></form></td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>