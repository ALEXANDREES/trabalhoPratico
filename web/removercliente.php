<?php

include "conexao.php";

?>

<html>

<head>

	<title>Removendo Cliente</title>
 
</head>

<body>
 
<?php

	$id = $_GET['id'];		
	$sql = mysqli_query($conexao, "DELETE FROM clientes WHERE id='$id'");	
	
	header("Location: listarcliente.php");

?>

</body>

</html>
