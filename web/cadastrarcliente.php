<?php

include "conexao.php";

?>

<html>

<head>

	<title>Cadastrando Cliente</title>
 
</head>

<body>
 
<?php

$nome = $_POST['nome'];
$rg = $_POST['rg'];
$cpf = $_POST['cpf'];
$endereco = $_POST['endereco'];
$cnh = $_POST['cnh'];
$ndependentes = $_POST['ndependentes'];

$sql = mysqli_query($conexao, "INSERT INTO clientes(nome, rg, cpf,endereco,cnh,ndependentes) 
VALUES ('$nome','$rg','$cpf','$endereco','$cnh','$ndependentes')");
			
header("Location: listarcliente.php");

?>

</body>

</html>

            
