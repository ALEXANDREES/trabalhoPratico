<!DOCTYPE html>

<?php

//Conectando com o banco de dados
include "conexao.php";

?>

<html lang="en">

<head>
	
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	
	<!-- Titulo do site -->
	<title> Lista de Clientes </title>
	
	<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/estilos.css" rel="stylesheet">
    <link href="css/half-slider.css" rel="stylesheet">	
	<script src="js/metodos.js"></script>
	
</head>

<body>

    <!-- Navbar padrão do site -->
	
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	
		<div class="container">
			
			<img src='imagens/icon.png'>
			
			<a class="navbar-brand" href="#">LocaPlus</a>
            
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
		          
				<span class="navbar-toggler-icon"></span>
            
			</button>
			
			<div class="collapse navbar-collapse" id="navbarResponsive">
                
				<ul class="navbar-nav ml-auto">

					<li class="nav-item active">
						
						<a class="nav-link" href="index.html">Inicio<span class="sr-only">(current)</span></a>
						
                    </li>

					<li class="nav-item">
					
						<a class="nav-link" href="listarVeiculo.php">Veiculos</a>
						
                    </li>
				  
					<li class="nav-item">
					
						<a class="nav-link" href="listarLocacao.php">Locação</a>
						
					</li>
				  
					<li class="nav-item">
					
						<a class="nav-link" href="listarCliente.php">Cliente</a>
						
					</li>
			
					<li class="nav-item">
					
						<a class="nav-link" href="listarFuncionario.php">Funcionario</a>
						
					</li>
			
					<li class="nav-item">
					
						<a class="nav-link" href="listarMelhoria.php">Melhoria</a>
						
					</li>

				</ul>
					
			</div>
				
		</div>
			
	</nav>

	<br><br>
	
	<div class="container">
	
		<div class="row">	
		
     		<!-- Tabela que informa os clientes cadastrados no bd -->
			
			<table class='table'>
			
				<tr>
				
					<th>Id</th>
					<th>Nome</th>
					<th>RG</th>
					<th>CPF</th>
					<th>Endereço</th>
					<th>CNH</th>
					<th>Numero de Dependentes</th>
					<th>Ações Disponíveis</th>
					
				</tr>
				
				<?php
					  
					//SQL informando de qual tabela deve puxar os dados dos clientes
					
					$consulta = mysqli_query($conexao, "SELECT * FROM clientes");
					
					if ($resultado = $consulta) 
					{
						
						while ($clientes = $resultado->fetch_row()) 
						{					
					
							echo "<tr>";
							
							    //Puxando cada cliente cadastrado
								
						        echo "<td>$clientes[0]</td>
									  <td>$clientes[1]</td>
									  <td>$clientes[2]</td>
									  <td>$clientes[3]</td>
									  <td>$clientes[4]</td>
									  <td>$clientes[5]</td>
									  <td>$clientes[6]</td>";
							
								    echo"<td>";	
									
							            //Botões de ações sobre a tabela cliente
										
										echo "<a data-toggle='modal' data-target='#editarcliente' data-id='" .$clientes[0] ."' data-nome='" .$clientes[1] ."' data-rg='" .$clientes[2] ."' data-cpf='" .$clientes[3] ."' data-endereco='" .$clientes[4] ."' data-cnh='" .$clientes[5]."'data-ndependentes='" .$clientes[6] ."' class='btn btn-warning'>Editar</a> ";				
									    echo "<a data-toggle='modal' class='btn btn-danger' href='removercliente.php?id=" .$clientes[0] ."'>Remover</a>";
							
								    echo "</td>";
							
							    echo "</tr>";
							
					    }$resultado->close();
						
					}?>
				
	        </table>
			
			<!-- Fim da tabela cliente -->
			
		</div> 	
		
	    <!-- Botão de cadastro de cliente -->
			
		<a class="btn btn-success" data-toggle="modal" data-target="#novocliente">Cadastrar</a>

		<!-- Form contendo os campos que devem ser preenchidos com os dados do cliente -->
			
		<div class="modal" id="novocliente" tabindex="-1" role="dialog" aria-labellebdy="myModalLabel" aria-hidden="true">
            
			<div class="modal-dialog">
			
                <div class="modal-content">
				
                    <div class="modal-header">
					
						<h4>Novo Cliente</h4> 
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						
                    </div>
					
                    <div class="modal-body">
					
                        <form action="cadastrarcliente.php" method="POST">   
					   
                       		<div class="form-group">
							
							    <!-- Campo de nome do cliente -->
                       			<label for="nome">Nome:</label>
                       			<input class="form-control" id="nome" name="nome" type="text" required placeholder="Nome Completo"></input>
								
                       		</div>
							
                       		<div class="form-group">
							
							    <!-- Campo de rg do cliente -->
                       			<label for="rg">RG:</label>
                       			<input class="form-control" id="rg" name="rg" type="text" required placeholder="Informe o RG"></input>
								
                       		</div>
							
							<div class="form-group">
							
							    <!-- Campo de cpf do cliente -->
                       			<label for="cpf">CPF:</label>
                       			<input class="form-control" id="cpf" name="cpf" type="text" required placeholder="Informe o CPF"></input>
								
                       		</div>
							
							<div class="form-group">
							
							    <!-- Campo de endereço do cliente -->
                       			<label for="endereco">Endereço:</label>
                       			<input class="form-control" id="endereco" name="endereco" type="text" required placeholder="Informe seu Endereço"></input>
								
                       		</div>
							
							<div class="form-group">
							
							    <!-- Campo de cnh do cliente -->
                       			<label for="cnh">CNH:</label>
                       			<input class="form-control" id="cnh" name="cnh" type="text" required placeholder="Informe o CNH"></input>
								
                       		</div>
							
							<div class="form-group">
							
							    <!-- Campo de numero de dependentes do cliente -->
                       			<label for="ndependentes">Numero de Dependentes:</label>
                       			<input class="form-control" id="ndependentes" name="ndependentes" type="text" required placeholder="Qual o numero de dependentes"></input>
								
                       		</div>
							
							<div class="modal-footer">
					
					            <!-- Botões de confirmação no cadastro dos clientes -->
								<input type="submit" class="btn btn-success" value="Salvar">
								<button type="button" class="btn btn-danger" data-dismiss="modal">Sair</button>
						
							</div>
							
                        </form>
						
                    </div>
					
                </div>
				
            </div>
			
        </div> 
		
		<!-- Form contendo os campos que devem ser preenchidos com os dados que devem ser editado sobre o cliente -->
		
        <div class="modal" id="editarcliente" tabindex="-1" role="dialog" aria-labellebdy="myModalLabel" aria-hidden="true">
		
            <div class="modal-dialog">
			
                <div class="modal-content">
				
                    <div class="modal-header">
					
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						
                        <h4>Editar Cliente</h4>
						
                    </div>
					
                    <div class="modal-body"> 
					
                        <form action="editarcliente.php" method="POST">                       		
                       		        
                       	    <input  id="id" name="id" type="hidden" ></input> 
							
		                    <div class="form-group">
							
							    <!-- Campo de nome do cliente para ser editado-->
                       			<label for="nome">Nome:</label>
                       			<input class="form-control" id="nome" name="nome" type="text" required placeholder="Nome Completo"></input>
								
                       		</div>
							
                       		<div class="form-group">
							
							    <!-- Campo de rg do cliente para ser editado-->
                       			<label for="rg">RG:</label>
                       			<input class="form-control" id="rg" name="rg" type="text" required placeholder="Informe o RG"></input>
								
                       		</div>
							
							<div class="form-group">
							
							    <!-- Campo de cpf do cliente para ser editado-->
                       			<label for="cpf">CPF:</label>
                       			<input class="form-control" id="cpf" name="cpf" type="text" required placeholder="Informe o CPF"></input>
								
                       		</div>
							
							<div class="form-group">
							
							    <!-- Campo de endereço do cliente para ser editado-->
                       			<label for="endereco">Endereço:</label>
                       			<input class="form-control" id="endereco" name="endereco" type="text" required placeholder="Informe seu Endereço"></input>
								
                       		</div>
							
							<div class="form-group">
							
							    <!-- Campo de cnh do cliente para ser editado-->
                       			<label for="cnh">CNH:</label>
                       			<input class="form-control" id="cnh" name="cnh" type="text" required placeholder="Informe o CNH"></input>
								
                       		</div>
							
							<div class="form-group">
							
							    <!-- Campo de numero de dependetes do cliente para ser editado-->
                       			<label for="ndependentes">Numero de Dependentes:</label>
                       			<input class="form-control" id="ndependentes" name="ndependentes" type="text" required placeholder="Qual o numero de dependentes"></input>
								
                       		</div>
								
							<div class="modal-footer">
				
                                <!-- Botões de confirmação da edição dos dados dos clientes -->
								<input type="submit" class="btn btn-success">
								<button type="button" class="btn btn-danger" data-dismiss="modal">Sair</button>
						
							</div>
					
						</form>
					
					</div>
				
                </div>
				
            </div>
			
        </div> 

	</div>
	
    <!-- Footer do site -->
	
	<div class="footer">
	
      <p>Copyright © LocaPlus 2018</p>
	  
    </div>
	
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>		
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	
	<!-- Script de puxar os valores para a tela editar -->
	
	<script>			 
	
		  $('#editarcliente').on('show.bs.modal', function (event) {
			  
		  var button = $(event.relatedTarget)
		  var recipient0 = button.data('id')
		  var recipient1 = button.data('nome')
		  var recipient2 = button.data('rg')
		  var recipient3 = button.data('cpf')
		  var recipient4 = button.data('endereco')
		  var recipient5 = button.data('cnh')
		  var recipient6 = button.data('ndependentes')
		 
		  var modal = $(this)		 
		  modal.find('.modal-body #id').val(recipient0)
		  modal.find('.modal-body #nome').val(recipient1)
		  modal.find('.modal-body #rg').val(recipient2)
		  modal.find('.modal-body #cpf').val(recipient3)
		  modal.find('.modal-body #endereco').val(recipient4)
          modal.find('.modal-body #cnh').val(recipient5)
          modal.find('.modal-body #ndependentes').val(recipient6)
		  
		});
		
		
	</script>
	
</body>

</html>