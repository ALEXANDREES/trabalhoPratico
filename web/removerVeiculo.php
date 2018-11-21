<?php

include "conexao.php";

?>

<?php

	$id = $_GET['id'];		
	$sql = mysqli_query($conexao, "DELETE FROM veiculos WHERE id='$id'");	
	
	header("Location: listarVeiculo.php");

?>