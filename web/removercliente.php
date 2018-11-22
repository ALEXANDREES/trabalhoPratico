<?php

//Conectando com o banco de dados
include "conexao.php";

?>

<html>

<head>

	<!-- Titulo do site -->
	<title>Removendo Cliente</title>
 
</head>

<body>
 
<?php

//Pega o id do cliente da linha da tabela
$id = $_GET['id'];		

//Passando as variaveis com os dados do cliente e a tabela onde se encontra para remover todos os dados do mesmo no bd por meio de codigo sql
$sql = mysqli_query($conexao, "DELETE FROM clientes WHERE id='$id'");	
	
//Informa para qual a pagina php deve voltar apos executar o codigo sql			
header("Location: listarcliente.php");

?>

</body>

</html>
