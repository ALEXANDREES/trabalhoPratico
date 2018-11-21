<?php

include "conexao.php";

?>

<?php

	
	$id = $_POST['id'];
	$funcionario = $_POST['funcionario'];
	$melhoria =  $_POST['melhoria'];
	$departamento =  $_POST['departamento'];	

	$sql = mysqli_query($conexao, "UPDATE melhoria SET funcionario='$funcionario', melhoria='$melhoria', departamento='$departamento' WHERE id='$id'");
	
	header("Location: listarMelhoria.php");
?>	



