<?php

include "conexao.php";

?>

<?php	
			$datalocacao = $_POST['datalocacao'];
			$cliente = $_POST['cliente'];
			$veiculo = $_POST['veiculo'];
			$dataencerramento = "INDEFINIDA"; 
			$km = "0";
			$status = "ATIVA";
            $sql = mysqli_query($conexao, "INSERT INTO locacao(datalocacao, cliente, veiculo, dataencerramento, km, status) values ('$datalocacao', '$cliente', '$veiculo', '$dataencerramento', '$km', '$status') ");	
			
			header("Location: listarLocacao.php");			
	?>	

            
