<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
  <title>Cadastro de Veículo</title>

  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  
</head>
<body>
<div class="row">
    <h6> Cadastro de Veículo</h6>         
          </div>
  
  <div class="container">
	<div class="section">
		<div class="row">
      <form id="Formulario" action="action.php">
  			<div class="col s6 offset-s3">
          <div class="row">
            <div class="input-field col s12">
              <input id="placa" name="placav" type="text" class="form validate">
              <label for="nome">Placa Veículo</label>
            </div>          
          </div>
		    <div class="row">
            <div class="input-field col s12">
              <input id="nome" name="nome" type="text" class="form validate">
              <label for="nome">Nome Veículo</label>
            </div>          
          </div>
		    <div class="row">
            <div class="input-field col s12">
              <input id="marca" name="marca" type="text" class="form validate">
              <label for="nome">Marca Veículo</label>
            </div>          
          </div>
		  <div class="row">
            <div class="input-field col s12">
              <input id="modelo" name="modelo" type="text" class="form validate">
              <label for="nome"> Modelo Veículo</label>
            </div>          
          </div>
		   
          <div class="row">
            <div class="input-field col s12">
              <input id="valors" name="valors" type="text" class="form validate">
              <label for="nome"> Valor do Seguro</label>
            </div>          
          </div>
		    <div class="row">
            <div class="input-field col s12">
              <input id="valorl" name="valorl" type="text" class="form validate">
              <label for="nome"> Valor da Locação</label>
            </div>          
          </div>
		    <div class="row">
            <div class="input-field col s12">
              <input id="cor" name="cor" type="text" class="form validate">
              <label for="nome"> Cor do Veículo</label>
            </div>          
          </div>
        
            <div class="row">
             <div class="input-field col s12">
                <select id="ativo" name="ativo" class="form">              
                  <option value="1" selected>Sim</option>
                  <option value="2">Não</option>
                 
                </select>
                <label>Ativo</label>
              </div>
          </div>
        
        
        
        
              <div class="row">
            <div class="col s3">
			 <button class="btn waves-effect waves-light" type="submit" name="action">Cadastrar
               
             </button>
			</div>

			<div class="col s3">
             <button class="btn waves-effect waves-light" type="submit" name="action">Editar
             
             </button>
			</div>

			<div class="col s3">
            <button class="btn waves-effect waves-light" type="submit" name="action">Excluir
              
            </button>
			</div>


			
          </div>

         
		  
		
        </div>
      </form>
		</div>
	</div>
  </div>

  <!--  Scripts-->
  <script src="js/jquery-3.3.1.js"></script>
  <script src="js/materialize.js"></script>
  <script src="js/init.js"></script>

  </body>
</html>
