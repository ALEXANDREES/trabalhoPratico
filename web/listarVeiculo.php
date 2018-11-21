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
					<th>Id</th><th>Placa</th><th>Nome</th><th>Marca</th><th>Modelo</th><th>Valor Seguro</th><th>Valor Locação</th><th>Ativo</th><th>Cor</th><th>Ações Disponíveis</th>
				</tr>			
<?php
            $consulta = mysqli_query($conexao, "SELECT * FROM veiculos");
			if ($resultado = $consulta) 
			{
				while ($veiculos = $resultado->fetch_row()) 
				{					
					echo "<tr>";
					echo "<td>$veiculos[0]</td><td>$veiculos[1]</td><td>$veiculos[2]</td><td>$veiculos[3]</td><td>$veiculos[4]</td><td>$veiculos[5]</td><td>$veiculos[6]</td><td>$veiculos[7]</td><td>$veiculos[8]</td>";	
					echo"<td>";						
				   echo "<a data-toggle='modal' data-target='#editarVeiculo' data-id='" .$veiculos[0] ."' data-placa='" .$veiculos[1] ."' data-nome='" .$veiculos[2] ."' data-marca='" .$veiculos[3] ."' data-modelo='" .$veiculos[4] ."' data-valorseguro='" .$veiculos[5]."'data-valorlocacao='" .$veiculos[6]."'data-ativo='" .$veiculos[7]."'data-cor='" .$veiculos[8] ."' class='btn btn-warning'>Editar</a> ";			
					echo "<a class='btn btn-danger' href='removerVeiculo.php?id=" .$veiculos[0] ."'>Remover</a>";		
					echo "</td>";
					echo "</tr>";
				}
				$resultado->close();
			}		
	
?>
	        </table>
                    
        <!-- fim conexao, tabela -->            
                 
                    
		</div> 
            
 <!-- Modal Cadastro -->
		<a class="btn btn-success" data-toggle="modal" data-target="#novoVeiculo">Novo Veiculo</a>

		<div class="modal" id="novoVeiculo" tabindex="-1" role="dialog" aria-labellebdy="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
					    <h4>Novo Veiculo</h4> 
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>                                          
                    </div>
                    <div class="modal-body">
                        <form action="cadastroveiculo.php" method="POST">              		
                       	<div class="form-group">
                        <label >Placa</label>
                        <input class="form-control" id="placa" name="placa" type="text" required placeholder="Placa"></input>
                       
                    </div>
                    <div class="form-group">
                        <label >Nome</label>
                         <input class="form-control" id="nome" name="nome" type="text" required placeholder="Nome"></input>
                    </div>
                    <div class="form-group">
                        <label >Marca</label>
                         <input class="form-control" id="marca" name="marca" type="text" required placeholder="Marca"></input>
                    </div>
                    <div class="form-group">
                        <label >Modelo</label>
                         <input class="form-control" id="modelo" name="modelo" type="text" required placeholder="Modelo"></input>
                    </div>
                    <div class="form-group">
                        <label >Valor Seguro</label>
                         <input class="form-control" id="valorseguro" name="valorseguro" type="text" required placeholder="Valor Seguro"></input>
                    </div>
                     <div class="form-group">
                        <label >Valor Locaçao</label>
                         <input class="form-control" id="valorlocacao" name="valorlocacao" type="text" required placeholder="Valor Locacao"></input>
                     </div>
                     <div class="form-group">
                        <label>Ativo</label>
                        <select class="form-control" id="ativo" name="ativo" type="text">
                            <option>Sim</option>
                            <option>Não</option>

                        </select>
                        </div>
                       <div class="form-group">
                        <label >Cor</label>
                       <input class="form-control" id="cor" name="cor" type="text" required placeholder="Cor"></input>
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

             <!-- Fim Modal Cadastro -->    
             
             <!-- Modal Editar -->   
                
        <div class="modal" id="editarVeiculo" tabindex="-1" role="dialog" aria-labellebdy="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
					    <h4>Editar Veiculo</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>
                    <div class="modal-body">                      
                        <form action="editarVeiculo.php" method="POST">                       		
                       		        
                       		        <input  id="id" name="id" type="hidden" ></input>   		
		       	<div class="form-group">
                        <label >Placa</label>
                        <input class="form-control" id="placa" name="placa" type="text" required placeholder="Placa"></input>
                       
                    </div>
                    <div class="form-group">
                        <label >Nome</label>
                         <input class="form-control" id="nome" name="nome" type="text" required placeholder="Nome"></input>
                    </div>
                    <div class="form-group">
                        <label >Marca</label>
                         <input class="form-control" id="marca" name="marca" type="text" required placeholder="Marca"></input>
                    </div>
                    <div class="form-group">
                        <label >Modelo</label>
                         <input class="form-control" id="modelo" name="modelo" type="text" required placeholder="Modelo"></input>
                    </div>
                    <div class="form-group">
                        <label >Valor Seguro</label>
                         <input class="form-control" id="valorseguro" name="valorseguro" type="text" required placeholder="Valor Seguro"></input>
                    </div>
                     <div class="form-group">
                        <label >Valor Locaçao</label>
                         <input class="form-control" id="valorlocacao" name="valorlocacao" type="text" required placeholder="Valor Locacao"></input>
                     </div>
                      <div class="form-group">
                        <label>Ativo</label>
                        <select class="form-control" id="ativo" name="ativo" type="text">
                            <option>Sim</option>
                            <option>Não</option>

                        </select>
                        </div>
                       <div class="form-group">
                        <label >Cor</label>
                       <input class="form-control" id="cor" name="cor" type="text" required placeholder="Cor"></input>
                    </div>
						    

			<div class="modal-footer">
					
					<input type="submit" class="btn btn-success" value="Salvar">
		                 <button type="button" class="btn btn-danger" data-dismiss="modal">Sair</button>
						
				</div>
															
                       </form>
               
                </div>
            </div>
        </div> 
      <!-- Fim Modal Editar -->         
             
	</div>
   
  
    <br>
    <br>
    <br>
    <br>
    <br>
    


     
  <div class="footer">
  <p>Copyright © LocaPlus 2018</p>
</div>



    <!-- Bootstrap core JavaScript -->
    <script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>		
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	
	<script>			 
		  $('#editarVeiculo').on('show.bs.modal', function (event) {
		  var button = $(event.relatedTarget)
		  var recipient0 = button.data('id')
		  var recipient1 = button.data('placa')
		  var recipient2 = button.data('nome')
		  var recipient3 = button.data('marca')
                  var recipient4 = button.data('modelo')
                  var recipient5 = button.data('valorseguro')
                  var recipient6 = button.data('valorlocacao')
                  var recipient7 = button.data('ativo')
                  var recipient8 = button.data('cor')
                  
		 
		  var modal = $(this)		 
		  modal.find('.modal-body #id').val(recipient0)
		  modal.find('.modal-body #placa').val(recipient1)
		  modal.find('.modal-body #nome').val(recipient2)
		  modal.find('.modal-body #marca').val(recipient3)
                  modal.find('.modal-body #modelo').val(recipient4)
                  modal.find('.modal-body #valorseguro').val(recipient5)
                  modal.find('.modal-body #valorlocacao').val(recipient6)
                  modal.find('.modal-body #ativo').val(recipient7)
                  modal.find('.modal-body #cor').val(recipient8)
                  
		});	
	</script>
	
  </body>

</html>