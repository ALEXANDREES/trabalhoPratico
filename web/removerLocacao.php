<?php

include "conexao.php";//Conexão com o banco

?>

<?php

	$id = $_GET['id'];//Pega o id para remover a locação vinculada ao id.	
	$sql = mysqli_query($conexao, "DELETE FROM locacao WHERE id='$id'");//Deleta aa locação do banco.	
	
	header("Location: listarLocacao.php");//Volta para a lista após a edição.

?>