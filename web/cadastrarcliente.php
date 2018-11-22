<?php

//Conectando com o banco de dados
include "conexao.php";

?>

<html>

<head>

	<!-- Titulo do site -->
	<title>Cadastrando Cliente</title>
 
</head>

<body>
 
<?php

//Pegando os dados do imput e passando para uma variavel 
$nome = $_POST['nome'];
$rg = $_POST['rg'];
$cpf = $_POST['cpf'];
$endereco = $_POST['endereco'];
$cnh = $_POST['cnh'];
$ndependentes = $_POST['ndependentes'];

//Passando as variaveis com os dados do cliente e cadastrando na tabela do bd por meio de codigo sql
$sql = mysqli_query($conexao, "INSERT INTO clientes(nome, rg, cpf,endereco,cnh,ndependentes) 
VALUES ('$nome','$rg','$cpf','$endereco','$cnh','$ndependentes')");
			
//Informa para qual a pagina php deve voltar apos executar o codigo sql			
header("Location: listarcliente.php");

?>

</body>

</html>

            
