<!DOCTYPE html>
<html lang="pt-br">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>LocaPlus</title>

<!-- --><!-- --><!-- --><!-- --><!-- --><!-- BOOTSTRAP CSS --><!-- --><!-- --><!-- --><!-- --><!-- --><!-- --><!-- --><!-- -->

    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/estilos.css" rel="stylesheet">

<!-- --><!-- --><!-- --><!-- --><!-- --><!-- ESTILO DO TEMPLATE --><!-- --><!-- --><!-- --><!-- --><!-- --><!-- --><!-- --><!-- -->

    <link href="css/half-slider.css" rel="stylesheet">

  </head>

  <body>

<!-- --><!-- --><!-- --><!-- --><!-- --><!-- NAVBAR DA TELA DE LOCAÇÃO --><!-- --><!-- --><!-- --><!-- --><!-- --><!-- --><!-- --><!-- -->

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

   <br><br><br><br><br>

<!-- --><!-- --><!-- --><!-- --><!-- --><!-- TABELA RESPONSIVA DA TELA DE LOCAÇÃO --><!-- --><!-- --><!-- --><!-- --><!-- --><!-- --><!-- --><!-- -->

   <div class="row" id ="divTabela">
     <div class="col"></div>
       <div class="col">
         <table id="tabelaLocacao" class="table table-bordered table-striped table-responsive" >

         <thead>
           <tr>
             <th>#</th>
             <th>Data de Locação</th>
             <th>Data de Encerramento</th>
             <th>Quilometragem</th>
           </tr>
         </thead>

         <tbody>
           <tr>
             <th scope="row">1</th>
             <td></td>
             <td></td>
             <td></td>
           </tr>

           <tr>
             <th scope="row">2</th>
             <td></td>
             <td></td>
             <td></td>
           </tr>

           <tr>
             <th scope="row">3</th>
             <td></td>
             <td></td>
             <td></td>
           </tr>
         </tbody>

         </table>

       </div>
     <div class="col"></div>
   </div>

<!-- --><!-- --><!-- --><!-- --><!-- --><!-- BOTÕES DA TELA "PRINCIPAL" --><!-- --><!-- --><!-- --><!-- --><!-- --><!-- --><!-- --><!-- -->

   <div class="row">
     <div class="col-sm-4"></div>
       <div class="col-sm-8">
         <button type="button" id ="modalb" class="btn btn-primary" data-toggle="modal" data-target="#modalCadastro">Cadastrar</button>
         <button type="button" id ="modalb" class="btn btn-primary"data-toggle="modal" data-target="#modalEditar">Editar</button>
         <button type="button" id ="modalb" class="btn btn-primary"data-toggle="modal" data-target="#modalRemover">Remover</button>
         <button type="button" id ="modalb" class="btn btn-primary"data-toggle="modal" data-target="#modalEncerrar">Encerrar</button>
       </div>
   </div>

<!-- --><!-- --><!-- --><!-- --><!-- --><!-- MODAL DA TELA DE CADASTRO --><!-- --><!-- --><!-- --><!-- --><!-- --><!-- --><!-- --><!-- -->

   <div class="modal fade" id="modalCadastro" tabindex="-1" role="dialog" aria-labelledby="tituloTelaCadastro" aria-hidden="true">
     <div class="modal-dialog modal-dialog-centered" role="document">
       <div class="modal-content">
         <div class="modal-header">
           <h5 class="modal-title" id="tituloModalCadastro">Cadastro de Locação</h5>
             <button type="button" class="close" data-dismiss="modal" aria-label="Close">
               <span aria-hidden="true">&times;</span>
             </button>
         </div>

            <div class="modal-body">
               <form>
                    <div class="form-group">
                        <label >Data de Locação</label>
                        <input  class="form-control" id="dataLocacao"  placeholder=>
                        <small id="dataAjuda" class="form-text text-muted"></small>
                    </div>
                    <div class="form-group">
                        <label >Data de Encerramento</label>
                        <input  class="form-control" id="dataEncerramento" >
                    </div>
                    <div class="form-group">
                        <label >Quilometragem</label>
                        <input class="form-control" id="quilometragem" >
                    </div>
               </form>
            </div>

            <div class="modal-footer">
              <button type="button" class="btn btn-primary">Salvar</button>
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
            </div>
       </div>
     </div>
   </div>

<!-- --><!-- --><!-- --><!-- --><!-- --><!-- MODAL DA TELA DE EDITAR LOCAÇÃO --><!-- --><!-- --><!-- --><!-- --><!-- --><!-- --><!-- --><!-- -->

   <div class="modal fade" id="modalEditar" tabindex="-1" role="dialog" aria-labelledby="tituloTelaEditar" aria-hidden="true">
     <div class="modal-dialog modal-dialog-centered" role="document">
       <div class="modal-content">
         <div class="modal-header">
           <h5 class="modal-title" id="tituloModalEditar">Editar Locação</h5>
             <button type="button" class="close" data-dismiss="modal" aria-label="Close">
               <span aria-hidden="true">&times;</span>
             </button>
         </div>

            <div class="modal-body">
               <form>
                    <div class="form-group">
                        <label >Data de Locação</label>
                        <input  class="form-control" id="dataLocacao"  placeholder=>
                        <small id="dataAjuda" class="form-text text-muted"></small>
                    </div>
                    <div class="form-group">
                        <label >Data de Encerramento</label>
                        <input  class="form-control" id="dataEncerramento" >
                    </div>
                    <div class="form-group">
                        <label >Quilometragem</label>
                        <input class="form-control" id="quilometragem" >
                    </div>
               </form>
            </div>

            <div class="modal-footer">
              <button type="button" class="btn btn-primary">Salvar</button>
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
            </div>
       </div>
     </div>
   </div>

<!-- --><!-- --><!-- --><!-- --><!-- --><!-- MODAL DA TELA DE REMOVER LOCAÇÃO --><!-- --><!-- --><!-- --><!-- --><!-- --><!-- --><!-- --><!-- -->

   <div class="modal fade" id="modalRemover" tabindex="-1" role="dialog" aria-labelledby="tituloTelaRemover" aria-hidden="true">
     <div class="modal-dialog modal-dialog-centered" role="document">
       <div class="modal-content">
         <div class="modal-header">
           <h5 class="modal-title" id="tituloModalRemover">Remover Locação</h5>
             <button type="button" class="close" data-dismiss="modal" aria-label="Close">
               <span aria-hidden="true">&times;</span>
             </button>
         </div>

            <div class="modal-body">
               <form>
                    <div class="form-group">
                        <label >Data de Locação</label>
                        <input  class="form-control" id="dataLocacao"  placeholder=>
                        <small id="dataAjuda" class="form-text text-muted"></small>
                    </div>
                    <div class="form-group">
                        <label >Data de Encerramento</label>
                        <input  class="form-control" id="dataEncerramento" >
                    </div>
                    <div class="form-group">
                        <label >Quilometragem</label>
                        <input class="form-control" id="quilometragem" >
                    </div>
               </form>
            </div>

            <div class="modal-footer">
              <button type="button" class="btn btn-primary">Excluir</button>
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
            </div>
       </div>
     </div>
   </div>

<!-- --><!-- --><!-- --><!-- --><!-- --><!-- MODAL DA TELA DE ENCERRAR LOCAÇÃO --><!-- --><!-- --><!-- --><!-- --><!-- --><!-- --><!-- --><!-- -->

   <div class="modal fade" id="modalEncerrar" tabindex="-1" role="dialog" aria-labelledby="tituloTelaEncerrar" aria-hidden="true">
     <div class="modal-dialog modal-dialog-centered" role="document">
       <div class="modal-content">
         <div class="modal-header">
           <h5 class="modal-title" id="tituloModalEncerrar">Encerrar a Locação</h5>
             <button type="button" class="close" data-dismiss="modal" aria-label="Close">
               <span aria-hidden="true">&times;</span>
             </button>
         </div>

            <div class="modal-body">
               <form>
                    <div class="form-group">
                        <label >Data de Locação</label>
                        <input  class="form-control" id="dataLocacao"  placeholder=>
                        <small id="dataAjuda" class="form-text text-muted"></small>
                    </div>
                    <div class="form-group">
                        <label >Data de Encerramento</label>
                        <input  class="form-control" id="dataEncerramento" >
                    </div>
                    <div class="form-group">
                        <label >Quilometragem</label>
                        <input class="form-control" id="quilometragem" >
                    </div>
               </form>
            </div>

            <div class="modal-footer">
              <button type="button" class="btn btn-primary">Encerrar</button>
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
            </div>
       </div>
     </div>
   </div>


   <!-- Footer -->

   <div class="footer">
      <p>Copyright © LocaPlus 2018</p>
   </div>


   <!-- Bootstrap core JavaScript -->

   <script src="vendor/jquery/jquery.min.js"></script>
   <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>

</html>
