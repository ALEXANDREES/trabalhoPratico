<?php

include "conexao.php";

?>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<title>LocaPlus</title>
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/estilos.css" rel="stylesheet">
    <link href="css/half-slider.css" rel="stylesheet">	
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
                    <a class="nav-link" href="#">Inicio
                      <span class="sr-only">(current)</span></a>
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

   <br> <br>
   
	<div class="container">
		<div class="row">	
	

			<table class='table'>
				<tr>
					<th>Id</th><th>Nome</th><th>Cpf</th><th>RG</th><th>Endereço</th><th>Cargo</th><th>Data de Adimissão</th><th>Ações Disponíveis</th>
				</tr>			
<?php
            $consulta = mysqli_query($conexao, "SELECT * FROM funcionario");
			if ($resultado = $consulta) 
			{
				while ($funcionario = $resultado->fetch_row()) 
				{					
					echo "<tr>";
					echo "<td>$funcionario[0]</td><td>$funcionario[1]</td><td>$funcionario[2]</td><td>$funcionario[3]</td><td>$funcionario[4]</td><td>$funcionario[5]</td><td>$funcionario[6]</td>";	
					echo"<td>";						
				    echo "<a data-toggle='modal' data-target='#editarFuncionario' data-id='" .$funcionario[0] ."' data-nome='" .$funcionario[1] ."' data-cpf='" .$funcionario[2] ."' data-rg='" .$funcionario[3] ."' data-endereco='" .$funcionario[4] ."' data-cargo='" .$funcionario[5] ."' data-data='" .$funcionario[6] ."' class='btn btn-warning'>Editar</a> ";			
					echo "<a class='btn btn-danger' href='removerFuncionario.php?id=" .$funcionario[0] ."'>Remover</a>";		
					echo "</td>";
					echo "</tr>";
				}
				$resultado->close();
			}		
	
?>
	        </table>
		</div> 

		<a class="btn btn-success" data-toggle="modal" data-target="#novoFuncionario">Novo Funcionario</a>

		<div class="modal" id="novoFuncionario" tabindex="-1" role="dialog" aria-labellebdy="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
					    <h4>Novo Funcionario</h4> 
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>                                          
                    </div>
                    <div class="modal-body">
                       <form action="cadastrofuncionario.php" method="POST">              		
                       		<div class="form-group">
                       			<label for="nome">Nome:</label>
                       			<input class="form-control" id="nome" name="nome" type="text" placeholder="Nome"></input>
                       		</div>
							
					<div class="form-group">
                       			<label for="cpf">Cpf:</label>
                       			<input class="form-control" id="cpf" name="cpf" type="text" placeholder="Cpf"></input>
                       		</div>
							
					<div class="form-group">
                       			<label for="rg">Rg:</label>
                       			<input class="form-control" id="rg" name="rg" type="text" placeholder="Rg"></input>
                       		</div>		
							
					<div class="form-group">
                       			<label for="endereco">Endereco:</label>
                       			<input class="form-control" id="endereco" name="endereco" type="text" placeholder="Endereco"></input>
                       		</div>		
							
					<div class="form-group">
                       			<label for="cargo">Cargo:</label>
                       			<input class="form-control" id="cargo" name="cargo" type="text" placeholder="Cargo"></input>
                       		</div>		
					
					<div class="form-group">
                       			<label for="data">Data de Adimissão:</label>
                       			<input class="form-control" id="data" name="data" type="text" placeholder="Data"></input>
                       		</div>

							<input type="submit" class="btn btn-success" value="Salvar">
                       </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-warning" data-dismiss="modal">Sair</button>
                    </div>
                </div>
            </div>
        </div> 

        <div class="modal" id="editarFuncionario" tabindex="-1" role="dialog" aria-labellebdy="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
					    <h4>Editar Funcionario</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>
                    <div class="modal-body">                      
                       <form action="editarFuncionario.php" method="POST">                       		
                       		        
                       		        <input  id="id" name="id" type="hidden" ></input>   		
		                       		<div class="form-group">
		                       			<label for="nome">Nome:</label>
		                       			<input class="form-control" id="nome" name="nome" type="text" ></input>
		                       		</div>
									
									<div class="form-group">
		                       			<label for="cpf">Cpf:</label>
		                       			<input class="form-control" id="cpf" name="cpf" type="text" ></input>
		                       		</div>
									
									<div class="form-group">
		                       			<label for="rg">Rg:</label>
		                       			<input class="form-control" id="rg" name="rg" type="text" ></input>
		                       		</div>
									
									<div class="form-group">
		                       			<label for="endereco">Endereço:</label>
		                       			<input class="form-control" id="endereco" name="endereco" type="text" ></input>
		                       		</div>
									
									<div class="form-group">
		                       			<label for="cargo">Cargo:</label>
		                       			<input class="form-control" id="cargo" name="cargo" type="text" ></input>
		                       		</div>
									
									<div class="form-group">
		                       			<label for="data">Data de Adimissão:</label>
		                       			<input class="form-control" id="data" name="data" type="text" ></input>
		                       		</div>
									

									<input type="submit" class="btn btn-success">							
                       </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-warning" data-dismiss="modal">Sair</button>
                    </div>
                </div>
            </div>
        </div> 
 


	</div>
	
	<div class="footer">
      <p>Copyright © LocaPlus 2018</p>
    </div>

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>		
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	
	<script>			 
		  $('#editarFuncionario').on('show.bs.modal', function (event) {
		  var button = $(event.relatedTarget)
		  var recipient0 = button.data('id')
		  var recipient1 = button.data('nome')
		  var recipient2 = button.data('cpf')
		  var recipient3 = button.data('rg')
		  var recipient4 = button.data('endereco')
		  var recipient5 = button.data('cargo')
		  var recipient6 = button.data('data')
		  
		  var modal = $(this)		 
		  modal.find('.modal-body #id').val(recipient0)
		  modal.find('.modal-body #nome').val(recipient1)
		  modal.find('.modal-body #cpf').val(recipient2)
		  modal.find('.modal-body #rg').val(recipient3)
		  modal.find('.modal-body #endereco').val(recipient4)
		  modal.find('.modal-body #cargo').val(recipient5)
		  modal.find('.modal-body #data').val(recipient6)
		});
		
		
		
		
	</script>
	
</body>
</html>
