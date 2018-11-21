<?php

include "conexao.php";

?>

<?php

	
	$id = $_POST['id'];
	$nome = $_POST['nome'];
	$cpf =  $_POST['cpf'];
	$rg =  $_POST['rg'];
	$endereco =  $_POST['endereco'];	
	$cargo =  $_POST['cargo'];
	$data =  $_POST['data'];
	
	$sql = mysqli_query($conexao, "UPDATE funcionario SET nome='$nome', cpf='$cpf', rg='$rg', endereco='$endereco', cargo='$cargo', data='$data' WHERE id='$id'");
	
	header("Location: listarFuncionario.php");
?>	



