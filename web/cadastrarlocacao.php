<?php

include "conexao.php"; //Conexão com o banco

?>

<?php	
			$datalocacao = $_POST['datalocacao']; //Pega a data de locação.
			$cliente = $_POST['cliente']; //Pega o cliente.
			$veiculo = $_POST['veiculo']; //Pega o veículo.
			$dataencerramento = "INDEFINIDA"; //Pega a data de encerramento.
			$km = "0"; //Pega o km.
			$status = "ATIVA"; //Pega o status.
            $sql = mysqli_query($conexao, "INSERT INTO locacao(datalocacao, cliente, veiculo, dataencerramento, km, status) values ('$datalocacao', '$cliente', '$veiculo', '$dataencerramento', '$km', '$status') ");//	
			
			header("Location: listarLocacao.php");//Volta para a lista após a edição.			
	?>	

            
