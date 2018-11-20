<!DOCTYPE html>

<?php

include "conexao.php";

?>

<html lang="en">

<head>

	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	
	<title> Lista de Clientes </title>
	
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/estilos.css">	
	
	<script src="js/metodos.js"></script>
	
</head>

<body>

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
							
						<a class="nav-link" href="#">Inicio<span class="sr-only">(current)</span></a>
							
					</li>

					<li class="nav-item">
						
						<a class="nav-link" href="#">Veiculos</a>
						
					</li>

					<li class="nav-item">
				  
						<a class="nav-link" href="#">Locação</a>
					
					</li>

					<li class="nav-item">
						
						<a class="nav-link" href="#">Login</a>
							
					</li>

				</ul>
					
			</div>
				
		</div>
			
	</nav>

	<div class="container">
	
		<div class="row">	

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
					
					$consulta = mysqli_query($conexao, "SELECT * FROM clientes");
					
					if ($resultado = $consulta) 
					{
						
						while ($clientes = $resultado->fetch_row()) 
						{					
					
							echo "<tr>";
							
						        echo "<td>$clientes[0]</td>
									  <td>$clientes[1]</td>
									  <td>$clientes[2]</td>
									  <td>$clientes[3]</td>
									  <td>$clientes[4]</td>
									  <td>$clientes[5]</td>
									  <td>$clientes[6]</td>";
							
								    echo"<td>";			
							
										echo "<a data-toggle='modal' data-target='#editarcliente' data-id='" .$clientes[0] ."' data-nome='" .$clientes[1] ."' data-rg='" .$clientes[2] ."' data-cpf='" .$clientes[3] ."' data-endereco='" .$clientes[4] ."' data-cnh='" .$clientes[5]."'data-ndependentes='" .$clientes[6] ."' class='btn btn-warning'>Editar</a> ";				
									    echo "<a data-toggle='modal' data-target='#removercliente' data-id='".$clientes[0]."'class='btn btn-danger'>Remover</a>";
							
								    echo "</td>";
							
							    echo "</tr>";
							
					    }$resultado->close();
						
					}?>
				
	        </table>
			
		</div> 

		<a class="btn btn-success" data-toggle="modal" data-target="#novocliente">Cadastrar</a>

		<div class="modal" id="novocliente" tabindex="-1" role="dialog" aria-labellebdy="myModalLabel" aria-hidden="true">
            
			<div class="modal-dialog">
			
                <div class="modal-content">
				
                    <div class="modal-header">
					
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						
                        <h4>Novo Cliente</h4> 
						
                    </div>
					
                    <div class="modal-body">
					
                        <form action="cadastrarcliente.php" method="POST">   
					   
                       		<div class="form-group">
							
                       			<label for="nome">Nome:</label>
                       			<input class="form-control" id="nome" name="nome" type="text" required placeholder="Nome Completo"></input>
								
                       		</div>
							
                       		<div class="form-group">
							
                       			<label for="nome">RG:</label>
                       			<input class="form-control" id="rg" name="rg" type="text" required placeholder="Informe o RG"></input>
								
                       		</div>
							
							<div class="form-group">
							
                       			<label for="nome">CPF:</label>
                       			<input class="form-control" id="cpf" name="cpf" type="text" required placeholder="Informe o CPF"></input>
								
                       		</div>
							
							<div class="form-group">
							
                       			<label for="nome">Endereço:</label>
                       			<input class="form-control" id="endereco" name="endereco" type="text" required placeholder="Informe seu Endereço"></input>
								
                       		</div>
							
							<div class="form-group">
							
                       			<label for="nome">CNH:</label>
                       			<input class="form-control" id="cnh" name="cnh" type="text" required placeholder="Informe o CNH"></input>
								
                       		</div>
							
							<div class="form-group">
							
                       			<label for="nome">Numero de Dependentes:</label>
                       			<input class="form-control" id="ndependentes" name="ndependentes" type="text" required placeholder="Qual o numero de dependentes"></input>
								
                       		</div>
							
							<div class="modal-footer">
					
								<input type="submit" class="btn btn-success" value="Salvar">
								<button type="button" class="btn btn-danger" data-dismiss="modal">Sair</button>
						
							</div>
							
                        </form>
						
                    </div>
					
                </div>
				
            </div>
			
        </div> 

		<div class="modal fade" id="removercliente" tabindex="-1" role="dialog" aria-labelledby="removercliente" aria-hidden="true">
					
			<div class="modal-dialog modal-dialog-centered" role="document">
						
				<div class="modal-content">
						
					<div class="modal-header">
							
						<h5 class="modal-title" id="removercliente">Excluindo Clientes</h5>
								
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">						
									
							<span aria-hidden="true">&times;</span>
									
						</button>
								
					</div>
							
					<div class="modal-body">
							
						O usuario selecionado sera deletado, tem certeza que deseja excluir?
								
					</div>
							
					<div class="modal-footer">
							
					
						<?php echo "<a class='btn btn-danger' href='removercliente.php?id='" . $clientes[0] . "'>Remover</a>" ?>
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
								
					</div>
				
				</div>
				
			</div>
			
		</div>
		
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
							
                       			<label for="nome">Nome:</label>
                       			<input class="form-control" id="nome" name="nome" type="text" required placeholder="Nome Completo"></input>
								
                       		</div>
							
                       		<div class="form-group">
							
                       			<label for="nome">RG:</label>
                       			<input class="form-control" id="rg" name="rg" type="text" required placeholder="Informe o RG"></input>
								
                       		</div>
							
							<div class="form-group">
							
                       			<label for="nome">CPF:</label>
                       			<input class="form-control" id="cpf" name="cpf" type="text" required placeholder="Informe o CPF"></input>
								
                       		</div>
							
							<div class="form-group">
							
                       			<label for="nome">Endereço:</label>
                       			<input class="form-control" id="endereco" name="endereco" type="text" required placeholder="Informe seu Endereço"></input>
								
                       		</div>
							
							<div class="form-group">
							
                       			<label for="nome">CNH:</label>
                       			<input class="form-control" id="cnh" name="cnh" type="text" required placeholder="Informe o CNH"></input>
								
                       		</div>
							
							<div class="form-group">
							
                       			<label for="nome">Numero de Dependentes:</label>
                       			<input class="form-control" id="ndependentes" name="ndependentes" type="text" required placeholder="Qual o numero de dependentes"></input>
								
                       		</div>
								
							<div class="modal-footer">
				
								<input type="submit" class="btn btn-success">
								<button type="button" class="btn btn-danger" data-dismiss="modal">Sair</button>
						
							</div>
					
						</form>
					
					</div>
				
                </div>
				
            </div>
			
        </div> 

	</div>
	
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>	
	
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