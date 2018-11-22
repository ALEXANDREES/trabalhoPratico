<?php

//Conectando com o banco de dados
include "conexao.php";

?>

<html>

<head>

	<!-- Titulo do site -->
	<title>Editando Cliente</title>
 
</head>

<body>

<?php

//Pegando os dados do imput e passando para uma variavel para a edição dos dados ja existentes no bd	
$id = $_POST['id'];
$nome = $_POST['nome'];
$rg = $_POST['rg'];
$cpf = $_POST['cpf'];
$endereco = $_POST['endereco'];
$cnh = $_POST['cnh'];
$ndependentes = $_POST['ndependentes'];	

//Passando as variaveis com os dados do cliente e editando na tabela do bd por meio de codigo sql
$sql = mysqli_query($conexao, "UPDATE clientes SET nome='$nome', rg='$rg', cpf='$cpf',endereco='$endereco',cnh='$cnh',ndependentes='$ndependentes' WHERE id='$id'");

//Informa para qual a pagina php deve voltar apos executar o codigo sql				
header("Location: listarcliente.php");

?>	

</body>

</html>




