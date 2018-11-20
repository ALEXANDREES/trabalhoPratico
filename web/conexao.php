<?php

$host = "localhost";
$user = "Alexandre";
$pass = "4738z4690";
$banco = "locaplus";
$conexao = mysqli_connect($host, $user, $pass,$banco) or die(mysqli_error());
$consulta = "";

mysqli_select_db($conexao,$banco) or die(mysqli_error());

?>