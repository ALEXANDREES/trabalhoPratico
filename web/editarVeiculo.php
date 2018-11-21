<?php

include "conexao.php";

?>

<?php

	
	$id = $_POST['id'];
	$placa = $_POST['placa'];
	$nome = $_POST['nome'];
	$marca = $_POST['marca'];
        $modelo = $_POST['modelo'];
        $valorseguro = $_POST['valorseguro'];
        $valorlocacao = $_POST['valorlocacao'];
        $ativo = $_POST['ativo'];
        $cor = $_POST['cor'];	

	$sql = mysqli_query($conexao, "UPDATE veiculos SET placa='$placa', nome='$nome', marca='$marca', modelo='$modelo', valorseguro='$valorseguro', valorlocacao='$valorlocacao', ativo='$ativo', cor='$cor' WHERE id='$id'");
	
	header("Location: listarVeiculo.php");
?>	