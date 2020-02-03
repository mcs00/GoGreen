<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es-ES" variant="euro"/>

<section id="clientes">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Productos</h4>
                    </div>
                    <table class="table table-hover">
                        <thead class="thead-green">
                            <tr>
                                <th>#</th>
                                <th>Producto</th>
                                <th>Precio</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Iteramos cada elemento de la lista de productos -->
                            <c:forEach var="producto" items="${productos}" varStatus="status" >
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${producto.name} ${producto.surname}</td>
                                    <td> <fmt:formatNumber value="${producto.balance}" type="currency" currencySymbol="€"/></td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/client?action=edit&idClient=${producto.id}"
                                           class="btn btn-secondary">
                                            <i class="fas fa-edit"></i> Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <!--Inicio Tarjetas para los totales-->
            <div class="col-md-3">
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Total Cesta</h3>
                        <h4 class="display-4">
                            <fmt:formatNumber value="${saldoTotal}" type="currency" />
                        </h4>
                    </div>
                </div>

                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Total Productos</h3>
                        <h4 class="display-4">
                            <i class="fas fa-users"></i> ${totalProductos}
                        </h4>
                    </div>
                </div>        
            </div>
            <!--Fin Tarjetas para los totales-->
            
        </div>
    </div>
</section>
                        