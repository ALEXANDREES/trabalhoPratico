<?php

include "conexao.php";

?>

<html>

<head>

	<title>Editando Cliente</title>
 
</head>

<body>

<?php

	
$id = $_POST['id'];
$nome = $_POST['nome'];
$rg = $_POST['rg'];
$cpf = $_POST['cpf'];
$endereco = $_POST['endereco'];
$cnh = $_POST['cnh'];
$ndependentes = $_POST['ndependentes'];	

$sql = mysqli_query($conexao, "UPDATE clientes SET nome='$nome', rg='$rg', cpf='$cpf',endereco='$endereco',cnh='$cnh',ndependentes='$ndependentes' WHERE id='$id'");
	
header("Location: listarcliente.php");

?>	

</body>

</html>




