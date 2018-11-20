<?php

include "conexao.php";

?>

<?php

	
	$id = $_POST['id'];
	$dataencerramento = $_POST['dataencerramento'];
	$km =  $_POST['km'];
	$status = "ENCERRADA";	

	$sql = mysqli_query($conexao, "UPDATE locacao SET dataencerramento='$dataencerramento', km='$km', status='$status' WHERE id='$id'");
	
	header("Location: listarLocacao.php");
?>	



