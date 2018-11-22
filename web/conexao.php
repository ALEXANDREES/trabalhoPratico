<?php

$host = "localhost";//Banco de dados local.
$user = "Alexandre";//Usuário do banco de dados.
$pass = "4738z4690";//Senha do banco de dados.
$banco = "locaplus";//Nome do banco de dados.
$conexao = mysqli_connect($host, $user, $pass,$banco) or die(mysqli_error());//Efetua a conexão com o banco.
$consulta = "";//Variável que recebe a consulta SQL.

mysqli_select_db($conexao,$banco) or die(mysqli_error());//Faz a conexão com o BD.

?>