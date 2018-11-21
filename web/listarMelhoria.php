<?php

include "conexao.php";

?>
<!DOCTYPE html>
<html lang="pt-br">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>LocaPlus</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/estilos.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/half-slider.css" rel="stylesheet">

  </head>

  <body>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
	  <img src='imagens/icon.png'>
        <a class="navbar-brand" href="index.html">LocaPlus</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
		  <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="principal.php">Inicio
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="cadastroveiculo.php">Veiculos</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="cadastrarlocacao.php">Locação</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="cadastrocliente.php">Cliente</a>
            </li>
			<li class="nav-item">
              <a class="nav-link" href="cadastrofuncionario.php">Funcionario</a>
            </li>
			<li class="nav-item">
              <a class="nav-link" href="listarMelhoria.php">Melhoria</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>


<!-- conexao, tabela -->
<br>
<br>
   	<div class="container">
		<div class="row">	
	

			<table class='table'>
				<tr>
					<th>Funcionario</th><th>Melhoria</th><th>Departamento</th>
				</tr>			
<?php
            $consulta = mysqli_query($conexao, "SELECT * FROM melhoria");
			if ($resultado = $consulta) 
			{
				while ($melhoria = $resultado->fetch_row()) 
				{					
					echo "<tr>";
					echo "<td>$melhoria[0]</td><td>$melhoria[1]</td><td>$melhoria[2]</td><td>$melhoria[3]</td>";	
					echo"<td>";						
				    echo "<a data-toggle='modal' data-target='#editarMelhoria' data-id='" .$melhoria[0] ."' data-funcionario='" .$melhoria[1] ."' data-melhoria='" .$melhoria[2] ."' data-departamento='" .$melhoria[3] ."' class='btn btn-warning'>Editar</a> ";			
					echo "<a class='btn btn-danger' href='removerLocacao.php?id=" .$locacoes[0] ."'>Remover</a>";		
					echo "</td>";
					echo "</tr>";
				}
				$resultado->close();
			}		
	
?>
	        </table>
		</div> 

		<a class="btn btn-success" data-toggle="modal" data-target="#novaMelhoria">Nova Melhoria</a>

		<div class="modal" id="novaMelhoria" tabindex="-1" role="dialog" aria-labellebdy="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
					    <h4>Nova Melhoria</h4> 
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>                                          
                    </div>
                    <div class="modal-body">
                       <form action="cadastrarmelhoria.php" method="POST">              		
                       		<div class="form-group">
                       			<label for="funcionario">Funcionario</label>
                       			<input class="form-control" id="funcionario" name="funcionario" type="text" placeholder="Funcionario"></input>
                       		</div>
							<div class="form-group">
                       			<label for="melhoria">Melhoria</label>
                       			<input class="form-control" id="melhoria" name="melhoria" type="text" placeholder="Informe a melhoria"></input>
                       		</div>
						    <div class="form-group">
                       			<label for="departamento">Departamento</label>
                       			<input class="form-control" id="departamento" name="departamento" type="text" placeholder="Informe o departamento"></input>
                       		</div>
							
						    

							<input type="submit" class="btn btn-success" value="Salvar">
							 <button type="button" class="btn btn-warning" data-dismiss="modal">Sair</button>
                       </form>
                    </div>
                </div>
            </div>
        </div> 

        <div class="modal" id="editarMelhoria" tabindex="-1" role="dialog" aria-labellebdy="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
					    <h4>Editar Melhoria</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>
                    <div class="modal-body">                      
                       <form action="editarMelhoria.php" method="POST">                       		
                       		        
                       		        <input  id="id" name="id" type="hidden" ></input>   		
		                       		<div class="form-group">
		                       			<label for="funcionario">funcionario</label>
		                       			<input class="form-control" id="funcionario" name="funcionario" type="text" ></input>
		                       		</div>
									<div class="form-group">
		                       			<label for="melhoria">Melhoria</label>
		                       			<input class="form-control" id="melhoria" name="melhoria" type="text" ></input>
		                       		</div>
									<div class="form-group">
		                       			<label for="departamento">Departamento</label>
		                       			<input class="form-control" id="departamento" name="departamento" type="text" ></input>
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
   
  
    <br>
    <br>
    <br>
    <br>
    <br>
    


    
  <div class="footer">
  <p>Footer</p>
</div>
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Cadastro Veiculo</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
                        <form>
                    <div class="form-group">
                    </div>
					 <div class="form-group">
					    		  <label for="funcionario" class="form-group"> Funcionario </label>
								    <select id="funcionario" class="form-control" name="funcionario" required>
									<option value= "0"> Selecione o funcionario </option>
									<?php
									$selecionar = "SELECT * FROM funcionario";
								   	$selfuncionario = mysqli_query($conexao, $selecionar);
									while($elemento = mysqli_fetch_assoc($selfuncionario)){

										$nome = $elemento['nome'];
										echo "<option value= '$nome' > $nome</option>";
									}	
								
							    	?>	
									</select>
							</div>
                    <div class="form-group">
                        <label >Melhoria</label>
                        <input class="form-control" id="exampleInputPassword1" >
                    </div>
                    <div class="form-group">
                        <label >Departamento</label>
                        <input class="form-control" id="exampleInputPassword1" >
                    </div>
                </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Sair</button>
        <button type="button" class="btn btn-primary">Salvar</button>
      </div>
    </div>
  </div>
</div>



    <!-- Bootstrap core JavaScript -->
    <script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>		
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	
	<script>			 
		  $('#editarMelhoria').on('show.bs.modal', function (event) {
		  var button = $(event.relatedTarget)
		  var recipient0 = button.data('id')
		  var recipient1 = button.data('funcionario')
		  var recipient2 = button.data('melhoria')
		  var recipient3 = button.data('departamento')
		 
		  var modal = $(this)		 
		  modal.find('.modal-body #id').val(recipient0)
		  modal.find('.modal-body #funcionario').val(recipient1)
		  modal.find('.modal-body #melhoria').val(recipient2)
		  modal.find('.modal-body #departamento').val(recipient3)	  
		});	
	</script>
	
  </body>

</html>