<?php

include "conexao.php"//Conexão com o banco.

?>

<?php

	
	$id = $_POST['id'];//Pega o id.
	$datalocacao = $_POST['datalocacao'];//Pega a data de locação.
	$cliente =  $_POST['cliente'];//Pega o cliente.
	$veiculo =  $_POST['veiculo'];//Pega o veículo.

	$sql = mysqli_query($conexao, "UPDATE locacao SET datalocacao='$datalocacao', cliente='$cliente', veiculo='$veiculo' WHERE id='$id'");//Efetua o update no banco de dados.
	
	header("Location: listarLocacao.php");//Volta para a lista apos o cadastro.	
?>	



