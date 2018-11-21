<?php

include "conexao.php";

?>

<?php	
			$funcionario = $_POST['funcionario'];
			$melhoria = $_POST['melhoria'];
			$departamento = $_POST['departamento'];
            $sql = mysqli_query($conexao, "INSERT INTO melhoria(funcionario, melhoria, departamento) values ('$funcionario', '$melhoria', '$departamento') ");	
			
			header("Location: listarMelhoria.php");			
	?>	

            
