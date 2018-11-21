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
                    <a class="nav-link" href="index.html">Inicio
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
					<th>Id</th><th>Data Locação</th><th>Cliente</th><th>Veículo</th><th>Data Encerramento</th><th>Quilometros</th><th>Status</th><th>Ações Disponíveis</th>
				</tr>			
<?php
            $consulta = mysqli_query($conexao, "SELECT * FROM locacao");
			if ($resultado = $consulta) 
			{
				while ($locacoes = $resultado->fetch_row()) 
				{					
					echo "<tr>";
					echo "<td>$locacoes[0]</td><td>$locacoes[1]</td><td>$locacoes[2]</td><td>$locacoes[3]</td><td>$locacoes[4]</td><td>$locacoes[5]</td><td>$locacoes[6]</td>";	
					echo"<td>";						
				    echo "<a data-toggle='modal' data-target='#editarLocacao' data-id='" .$locacoes[0] ."' data-datalocacao='" .$locacoes[1] ."' data-cliente='" .$locacoes[2] ."' data-veiculo='" .$locacoes[3] ."' class='btn btn-warning'>Editar</a> ";			
					echo "<a data-toggle='modal' data-target='#encerrarLocacao' data-id='" .$locacoes[0] ."' data-dataencerramento='" .$locacoes[4] ."' data-km='" .$locacoes[5] ."' data-status='" .$locacoes[6]. "' class='btn btn-danger'>Encerrar</a> ";
					echo "<a class='btn btn-danger' href='removerLocacao.php?id=" .$locacoes[0] ."'>Remover</a>";		
					echo "</td>";
					echo "</tr>";
				}
				$resultado->close();
			}		
	
?>
	        </table>
		</div> 

		<a class="btn btn-success" data-toggle="modal" data-target="#novaLocacao">Nova Locação</a>

		<div class="modal" id="novaLocacao" tabindex="-1" role="dialog" aria-labellebdy="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
					    <h4>Nova Locação</h4> 
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>                                          
                    </div>
                    <div class="modal-body">
                       <form action="cadastrarLocacao.php" method="POST">              		
                       		<div class="form-group">
                       			<label for="datalocacao">Data Locação:</label>
                       			<input class="form-control" id="datalocacao" name="datalocacao" type="text" placeholder="Data Locação"></input>
                       		</div>
							
						    <div class="form-group">
					    		  <label for="cliente" class="form-group"> Cliente </label>
								    <select id="cliente" class="form-control" name="cliente" required>
									<option value= "0"> Selecione o Cliente </option>
									<?php
									$selecionar = "SELECT * FROM clientes";
								   	$selcliente = mysqli_query($conexao, $selecionar);
									while($elemento = mysqli_fetch_assoc($selcliente)){

										$nome = $elemento['nome'];
										echo "<option value= '$nome' > $nome</option>";
									}	
								
							    	?>	
									</select>
							</div>
							
						    <div class="form-group">
					    		  <label for="veiculo" class="form-group"> Veículo </label>
								    <select id="veiculo" class="form-control" name="veiculo" required>
									<option value= "0"> Selecione o Veículo </option>
									<?php
									$selecionar = "SELECT * FROM veiculos";
								   	$selveiculos = mysqli_query($conexao, $selecionar);
									while($elemento = mysqli_fetch_assoc($selveiculos)){

										$nome = $elemento['nome'];
										echo "<option value= '$nome' > $nome</option>";
									}	
								
							    	?>	
									</select>
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

        <div class="modal" id="editarLocacao" tabindex="-1" role="dialog" aria-labellebdy="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
					    <h4>Editar Locação</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>
                    <div class="modal-body">                      
                       <form action="editarLocacao.php" method="POST">                       		
                       		        
                       		        <input  id="id" name="id" type="hidden" ></input>   		
		                       		<div class="form-group">
		                       			<label for="datalocacao">Data Locação:</label>
		                       			<input class="form-control" id="datalocacao" name="datalocacao" type="text" ></input>
		                       		</div>
									
									<div class="form-group">
									  <label for="cliente" class="form-group"> Cliente </label>
								      <select id="cliente" class="form-control" name="cliente" required>
									  <option value= "0"> Selecione o Cliente </option>
									  <?php
	
									  $selecionar = "SELECT * FROM clientes";
								   	  $selcliente = mysqli_query($conexao, $selecionar);
									  while($elemento = mysqli_fetch_assoc($selcliente)){

											$nome = $elemento['nome'];
											echo "<option value= '$nome' > $nome</option>";
									  }	
								
							    	  ?>	
									  </select>
									</div>
									
									<div class="form-group">
									  <label for="veiculo" class="form-group"> Veículos </label>
								      <select id="veiculo" class="form-control" name="veiculo" required>
									  <option value= "0"> Selecione o Veículo </option>
									  <?php
	
									  $selecionar = "SELECT * FROM veiculos";
								   	  $selveiculos = mysqli_query($conexao, $selecionar);
									  while($elemento = mysqli_fetch_assoc($selveiculos)){

											$nome = $elemento['nome'];
											echo "<option value= '$nome' > $nome</option>";
									  }	
								
							    	  ?>	
									  </select>
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

		
        <div class="modal" id="encerrarLocacao" tabindex="-1" role="dialog" aria-labellebdy="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4>Encerrar Locação</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>
                    <div class="modal-body">                      
                       <form action="encerrarLocacao.php" method="POST">                       		
                       		        
                       		        <input  id="id" name="id" type="hidden" ></input>   		
		                       		<div class="form-group">
		                       			<label for="dataencerramento">Data Encerramento:</label>
		                       			<input class="form-control" id="dataencerramento" name="dataencerramento" type="text" ></input>
		                       		</div>
		                       		<div class="form-group">
		                       			<label for="km">Quilometragem:</label>
		                       			<input class="form-control" id="km" name="km" type="text" ></input>
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
		  $('#editarLocacao').on('show.bs.modal', function (event) {
		  var button = $(event.relatedTarget)
		  var recipient0 = button.data('id')
		  var recipient1 = button.data('datalocacao')
		  var recipient2 = button.data('cliente')
		  var recipient3 = button.data('veiculo')
		 
		  var modal = $(this)		 
		  modal.find('.modal-body #id').val(recipient0)
		  modal.find('.modal-body #datalocacao').val(recipient1)
		  modal.find('.modal-body #cliente').val(recipient2)
		  modal.find('.modal-body #veiculo').val(recipient3)	  
		});
		
		
		  $('#encerrarLocacao').on('show.bs.modal', function (event) {
		  var button = $(event.relatedTarget)
		  var recipient0 = button.data('id')
		  var recipient1 = button.data('dataencerramento')
		  var recipient2 = button.data('km')
		  var recipient3 = button.data('status')
		 
		  var modal = $(this)		 
		  modal.find('.modal-body #id').val(recipient0)
		  modal.find('.modal-body #dataencerramento').val(recipient1)
		  modal.find('.modal-body #km').val(recipient2)
		  modal.find('.modal-body #status').val(recipient3)	  
		});
		
		
	</script>
	
</body>
</html>
