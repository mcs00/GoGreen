<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/f90d3bf50d.js" crossorigin="anonymous"></script>

        <title>Editar Producto</title>
    </head>
    <body>
        <!--Cabecero-->
        <%@ include file="/common/header.jsp" %> 

        <form name="frm-client" action="${pageContext.request.contextPath}/client" method="POST" class="was-validated">
           <input id="input-action" type="hidden" name="action" value="update" />
           <input type="hidden" name="idClient" value="${producto.id}" />
           
            <!--Botones de Navegacion -->
        	<section id="actions" class="py-4 mb-4 bg-light">
			    <div class="container">
			        <div class="row">
			            <div class="col-md-3">
			                <a href="frmClient.jsp" class="btn btn-ligth btn-block">
			                    <i class="fas fa-arrow-left"></i> Regresar a la lista
			                </a>
			            </div>
			            <div class="col-md-3">
			                <button type="submit" class="btn btn-success btn-block">
			                    <i class="fas fa-check"></i> Guardar Producto
			                </button>
			            </div>
			            <div class="col-md-3">
			                <button id="btn-delete" type="button" class="btn btn-danger btn-block">
			                    <i class="fas fa-trash"></i> Eliminar Producto
			                </button>
			            </div>
			        </div>
			    </div>
			</section>
        	
            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar Producto</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="nombre">Nombre</label>
                                        <input type="text" class="form-control" name="nombre" required value="${producto.name}">
                                    </div>
                                    <div class="form-group">
                                        <label for="apellido">Apellido</label>
                                        <input type="text" class="form-control" name="apellido" required value="${producto.surname}">
                                    </div>
                                    <div class="form-group">
                                        <label for="email">Email</label>
                                        <input type="email" class="form-control" name="email" required value="${producto.email}">
                                    </div>
                                    <div class="form-group">
                                        <label for="telefono">Teléfono</label>
                                        <input type="tel" class="form-control" name="telefono" required value="${producto.phone}">
                                    </div>
                                    <div class="form-group">
                                        <label for="saldo">Saldo</label>
                                        <input type="number" class="form-control" name="saldo" required value="${producto.balance}" step="any">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
                       
        </form>

        <!--Pie de Pagina-->
        <%@ include file="/common/footer.jsp" %> 

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script type="text/javascript">
        	let btnDelete = document.getElementById("btn-delete");
        	btnDelete.onclick = function(){
        		document.getElementById("input-action").value ="delete";
        		document.forms["frm-client"].submit();
        	}
        
        </script>

    </body>
</html>
