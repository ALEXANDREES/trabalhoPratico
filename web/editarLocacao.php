<?php

include "conexao.php";

?>

<?php

	
	$id = $_POST['id'];
	$datalocacao = $_POST['datalocacao'];
	$cliente =  $_POST['cliente'];
	$veiculo =  $_POST['veiculo'];	

	$sql = mysqli_query($conexao, "UPDATE locacao SET datalocacao='$datalocacao', cliente='$cliente', veiculo='$veiculo' WHERE id='$id'");
	
	header("Location: listarLocacao.php");
?>	



