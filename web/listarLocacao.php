<?php

include "conexao.php";//Conexão com o banco

?>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8"><!--Mostrar acentos-->
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<title>LocaPlus</title><!--Titulo-->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet"><!--Link com o bootstrap-->
    <link href="css/estilos.css" rel="stylesheet"><!--Link com os estilos-->
    <link href="css/half-slider.css" rel="stylesheet">	<!--Link com os estilos-->
	<script src="js/metodos.js"></script><!--Link com o script-->
</head>
<body>

    <!--Navbar padrão do site-->
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
	

	        <!--Inclusão da tabela-->
			<table class='table'>
				<tr>
				    <!--Campos da tabela-->
					<th>Id</th><th>Data Locação</th><th>Cliente</th><th>Veículo</th><th>Data Encerramento</th><th>Quilometros</th><th>Status</th><th>Ações Disponíveis</th>
				</tr>			
<?php
            $consulta = mysqli_query($conexao, "SELECT * FROM locacao");//Consulta dos dados para popular a tabela.
			if ($resultado = $consulta) 
			{
				while ($locacoes = $resultado->fetch_row())//Adiciona linha por linha na tabela.
				{					
					echo "<tr>";
					echo "<td>$locacoes[0]</td><td>$locacoes[1]</td><td>$locacoes[2]</td><td>$locacoes[3]</td><td>$locacoes[4]</td><td>$locacoes[5]</td><td>$locacoes[6]</td>";	
					echo"<td>";						
				    echo "<a data-toggle='modal' data-target='#editarLocacao' data-id='" .$locacoes[0] ."' data-datalocacao='" .$locacoes[1] ."' data-cliente='" .$locacoes[2] ."' data-veiculo='" .$locacoes[3] ."' class='btn btn-warning'>Editar</a> ";//Editar locação.	
					echo "<a data-toggle='modal' data-target='#encerrarLocacao' data-id='" .$locacoes[0] ."' data-dataencerramento='" .$locacoes[4] ."' data-km='" .$locacoes[5] ."' data-status='" .$locacoes[6]. "' class='btn btn-danger'>Encerrar</a> ";//Encerrar locação.
					echo "<a class='btn btn-danger' href='removerLocacao.php?id=" .$locacoes[0] ."'>Remover</a>";//Remove a locação passando o id da tabela.	
					echo "</td>";
					echo "</tr>";
				}
				$resultado->close();//Após adicionar todos os registro ele para.
			}		
	
?>
	        </table>
		</div> 

		<a class="btn btn-success" data-toggle="modal" data-target="#novaLocacao">Nova Locação</a>
        <!--Modal de cadastro da locação-->
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
								    <!--Combobox que pega os clientes-->
								    <select id="cliente" class="form-control" name="cliente" required>
									<option value= "0"> Selecione o Cliente </option>
									<?php
									$selecionar = "SELECT * FROM clientes";//Seleciona os clientes e popula o combobox.
								   	$selcliente = mysqli_query($conexao, $selecionar);
									while($elemento = mysqli_fetch_assoc($selcliente)){

										$nome = $elemento['nome'];
										echo "<option value= '$nome' > $nome</option>";//Puxa apenas o nome do cliente no combobox.
									}	
								
							    	?>	
									</select>
							</div>
							
						    <div class="form-group">
					    		  <label for="veiculo" class="form-group"> Veículo </label>
								    <!--Combobox que pega os veiculos-->
								    <select id="veiculo" class="form-control" name="veiculo" required>
									<option value= "0"> Selecione o Veículo </option>
									<?php
									$selecionar = "SELECT * FROM veiculos";//Seleciona os veiculos e popula o combobox.
								   	$selveiculos = mysqli_query($conexao, $selecionar);
									while($elemento = mysqli_fetch_assoc($selveiculos)){

										$nome = $elemento['nome'];
										echo "<option value= '$nome' > $nome</option>";//Puxa apenas o nome do veiculo no combobox.
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

		<!--Modal da tela de editar-->
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
									  <!--Combobox que pega os clientes-->
								      <select id="cliente" class="form-control" name="cliente" required>
									  <option value= "0"> Selecione o Cliente </option>
									  <?php
	
									  $selecionar = "SELECT * FROM clientes";//Seleciona os clientes e popula o combobox.
								   	  $selcliente = mysqli_query($conexao, $selecionar);
									  while($elemento = mysqli_fetch_assoc($selcliente)){

											$nome = $elemento['nome'];
											echo "<option value= '$nome' > $nome</option>";//Puxa apenas o nome do cliente no combobox.
									  }	
								
							    	  ?>	
									  </select>
									</div>
									
									<div class="form-group">
									  <label for="veiculo" class="form-group"> Veículos </label>
									  <!--Combobox que pega os veiculos-->
								      <select id="veiculo" class="form-control" name="veiculo" required>
									  <option value= "0"> Selecione o Veículo </option>
									  <?php
	
									  $selecionar = "SELECT * FROM veiculos";//Seleciona os veiculos e popula o combobox.
								   	  $selveiculos = mysqli_query($conexao, $selecionar);
									  while($elemento = mysqli_fetch_assoc($selveiculos)){

											$nome = $elemento['nome'];
											echo "<option value= '$nome' > $nome</option>";//Puxa apenas o nome do veiculo no combobox.
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

		<!--Modal de encerrar locação-->
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

	<script src="js/jquery.min.js"></script><!--Link com o script-->
	<script src="js/bootstrap.min.js"></script><!--Link com o script-->
    <script src="vendor/jquery/jquery.min.js"></script><!--Link com o script-->
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script><!--Link com o script-->
	
	<script>			 
		  $('#editarLocacao').on('show.bs.modal', function (event) {
		  var button = $(event.relatedTarget)
		  var recipient0 = button.data('id')//Pega o id que está na tabela.
		  var recipient1 = button.data('datalocacao')//Pega a data da locação que está na tabela.
		  var recipient2 = button.data('cliente')//Pega o cliente que está na tabela.
		  var recipient3 = button.data('veiculo')//Pega o veiculo que está na tabela.
		 
		  var modal = $(this)		 
		  modal.find('.modal-body #id').val(recipient0)
		  modal.find('.modal-body #datalocacao').val(recipient1)//Puxa para o campo no modal.
		  modal.find('.modal-body #cliente').val(recipient2)//Puxa para o campo no modal.
		  modal.find('.modal-body #veiculo').val(recipient3)//Puxa para o campo no modal.	  
		});
		
		
		  $('#encerrarLocacao').on('show.bs.modal', function (event) {
		  var button = $(event.relatedTarget)
		  var recipient0 = button.data('id')//Pega o id que está na tabela.
		  var recipient1 = button.data('dataencerramento')//Pega a data de encerramento que está na tabela.
		  var recipient2 = button.data('km')//Pega o km que está na tabela.
		  var recipient3 = button.data('status')//Pega o status que está na tabela.
		 
		  var modal = $(this)		 
		  modal.find('.modal-body #id').val(recipient0)//Puxa para o campo no modal.
		  modal.find('.modal-body #dataencerramento').val(recipient1)//Puxa para o campo no modal.
		  modal.find('.modal-body #km').val(recipient2)//Puxa para o campo no modal.
		  modal.find('.modal-body #status').val(recipient3)//Puxa para o campo no modal. 
		});
		
		
	</script>
	
</body>
</html>
