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
        <a class="navbar-brand" href="#">LocaPlus</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
		  <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="#">Inicio
                <span class="sr-only">(current)</span>
              </a>
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




   
   
  
    <br>
    <br>
    <br>
    <br>
    <br>
    
<div class="row" id ="divta">
    <div class="col"></div>
 <div class="col"> <table id="tabelav" class="table table-bordered table-striped table-responsive" >

  <thead>
    <tr>
      <th>#</th>
      <th>Funcionario</th>
      <th>Melhoria</th>
      <th>Departamento</th>
    </tr>
  </thead>

  <tbody>
    <tr>
      <th scope="row">1</th>
      <td></td>
      <td></td>
      <td></td>
    </tr>
    
    
  </tbody>

</table>
</div>
    
  <div class="col">   
              

    </div>
    
</div>
    
    <div class="row">
  <div class="col-sm-4"></div>
  <div class="col-sm-8"><button type="button" id ="modalb" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
    
  Cadastrar
</button>
     <button type="button"  id ="modalb" class="btn btn-primary">Remover</button> 
     <button type="button"  id ="modalb" class="btn btn-primary">Editar</button>
</div>
  
</div>
    
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
                        <label >Funcionario</label>
                        <input  class="form-control" id="exampleInputPassword1" >
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
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>

</html>