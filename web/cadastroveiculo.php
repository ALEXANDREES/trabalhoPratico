<?php

include "conexao.php";

?>

<?php	
			$placa = $_POST['placa'];
			$nome = $_POST['nome'];
			$marca = $_POST['marca'];
            $modelo = $_POST['modelo'];
            $valorseguro = $_POST['valorseguro'];
            $valorlocacao = $_POST['valorlocacao'];
            $ativo = $_POST['ativo'];
            $cor = $_POST['cor'];
                        
                        
                        
            $sql = mysqli_query($conexao, "INSERT INTO veiculos(placa, nome, marca, modelo, valorseguro, valorlocacao, ativo, cor) values  ('$placa', '$nome', '$marca', '$modelo', '$valorseguro', '$valorlocacao', '$ativo', '$cor') ");	
			
			header("Location: listarVeiculo.php");			
	?>	