<?php

include "conexao.php";

?>

<?php	
			$nome = $_POST['nome'];
			$cpf = $_POST['cpf'];
			$rg = $_POST['rg'];
			$endereco= $_POST["endereco"]; 
			$cargo = $_POST["cargo"];
			$data = $_POST["data"];
            $sql = mysqli_query($conexao, "INSERT INTO funcionario(nome, cpf, rg, endereco, cargo, data) values ('$nome', '$cpf', '$rg', '$endereco', '$cargo', '$data') ");	
			
			header("Location: listarFuncionario.php");			
	?>	

            
