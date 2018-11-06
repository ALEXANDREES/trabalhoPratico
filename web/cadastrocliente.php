<!DOCTYPE html>

<html lang="pt br">

<head>

  <meta http-equiv=Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
  <title>Cadrastro Clientes</title>

  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  
</head>
<body>
  <nav>
    <div class="nav-wrapper">
      <a href="#" class="brand-logo">LocaPlus</a>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
        <li><a href="sass.html">Clientes</a></li>
        <li><a href="badges.html">Funcionario</a></li>
<li><a href="badges.html">Locação</a></li>
        <li><a href="collapsible.html">Veiculos</a></li>
      </ul>
    </div>
	</nav>
  <div class="container">
  
	<div class="section">
	
		<div class="row">
		
      <form id="Formulario" action="action.php">
	  
  			<div class="col s6 offset-s3">
			
          <div class="row">
		  
            <div class="input-field col s12">
			
              <input id="nome" name="nome" type="text" class="form validate">
			  
              <label for="nome">Digite seu Nome</label>
			  
            </div>          
			
          </div>
		   <div class="row">
		  
            <div class="input-field col s12">
			
              <input id="rg" name="rg" type="text" class="form validate">
			  
              <label for="rg">Informe seu RG</label>
			  
            </div>          
			
          </div>
		   <div class="row">
		  
            <div class="input-field col s12">
			
              <input id="cpf" name="cpf" type="text" class="form validate">
			  
              <label for="cpf">Digite seu CPF</label>
			  
            </div>          
			
          </div>
		  
		  <div class="row">
		  
            <div class="input-field col s12">
			
              <input id="end" name="end" type="text" class="form validate">
			  
              <label for="end">Digite seu endereço </label>
			  
            </div>          
			
          </div>
		  
		  <div class="row">
		  
            <div class="input-field col s12">
			
              <input id="cnh" name="cnh" type="text" class="form validate">
			  
              <label for="cnh">Digite seu CNH </label>
			  
            </div>          
			
          </div>
		  
		  
		  <div class="row">
		  
            <div class="input-field col s12">
			
              <input id="n_dep" name="n_dep" type="text" class="form validate">
			  
              <label for="cpf">Numero de Dependentes </label>
			  
            </div>          
			
          </div>
		  

          <div class="row">
            <button class="waves-effect waves-light btn blue-grey darken-3 z-depth-5" type="cadastrar" name="action">Cadastrar
          
            </button>
			<button class="waves-effect waves-light btn blue-grey darken-3 z-depth-5" type="editar" name="action">Editar
            
            </button>
			<button class="waves-effect waves-light btn blue-grey darken-3 z-depth-5" type="excluir" name="action">Excluir
       
            </button>
          </div>
		  
        </div>
      </form>
		</div>
	</div>
  </div>

  <!-- Footer  -->
          <footer class="page-footer">
          <div class="container">
            <div class="row">
              <div class="col l6 s12">
                <h5 class="white-text">Sobre a empresa</h5>
                <p class="grey-text text-lighten-4">
Informações ao consumidor: LocaPlus <br>
E-mail: Locaplus.br
</p>
              </div>
            </div>
          </div>
          <div class="footer-copyright">
            <div class="container">
            2018 Copyright
            <a class="grey-text text-lighten-4 right" href="#!">Mais Informações</a>
            </div>
          </div>
        </footer>
		
		
		
  <!--  Scripts-->
  <script src="js/materialize.min.js"></script>
  <script src="js/materialize.js"></script>

  </body>
</html>
