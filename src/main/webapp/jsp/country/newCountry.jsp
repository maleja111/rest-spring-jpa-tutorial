<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <jsp:include page="../tags/includes.jsp" />
<body>

<jsp:include page="../tags/header.jsp" />
<div class="main">
    <div class="container tim-container"
         style="max-width: 800px; padding-top: 100px; min-height: 510px;">

        <form:form class="form-horizontal" action="saveCountry" method="post"
                   commandName="newCountry">
            <fieldset>

                <!-- Form Name -->
                <legend>Nuevo Pais</legend>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="cdPais">cdPais</label>
                    <div class="col-md-5">
                        <input id="cdPais" name="cdPais" type="text"
                               placeholder="cdPais" class="form-control input-md" required="">

                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="dsNombre">dsNombre</label>
                    <div class="col-md-5">
                        <input id="dsNombre" name="dsNombre" type="text"
                               placeholder="dsNombre" class="form-control input-md"
                               required="">

                    </div>
                </div>

                <div class="form-group ">
                    <label class="col-md-4 control-label" for="zonas">Zona</label>
                    <table class="table" style="width: 40%;">
                        <tr>
                            <th>Id</th>
                            <th>cdZona</th>
                            <th>dsNombre</th>
                            <th></th>
                        </tr>
                        <c:if test="${empty zonas}">
                            <tr>
                                <td colspan="4">No hay resultados</td>
                            </tr>
                        </c:if>
                        <c:if test="${! empty zonas}">
                            <c:forEach var="zona" items="${zonas}">
                                <tr>
                                    <td><c:out value="${zona.id}"></c:out></td>
                                    <td><c:out value="${zona.cdZona}"></c:out></td>
                                    <td><c:out value="${zona.dsNombre}"></c:out></td>
                                    <td><input type="checkbox" value="${zona.id}" id="zonaId"
                                               name="zonaId"></td>
                                </tr>
                            </c:forEach>
                        </c:if>
                    </table>
                </div>




                <div class="form-group">
                    <label class="col-md-4 "></label>
                    <div class="col-md-5">
                        <input type="submit" name="" value="Guardar" class="btn btn-fill btn-success">
                        &nbsp;&nbsp; <input type="reset" name="" value="Limpiar"
                                            class="btn btn-fill btn-primary"> &nbsp;&nbsp; <a
                            href="<%=request.getContextPath()%>/country/all.html"
                            class="btn btn-fill btn-warning"> Atras</a>
                    </div>
                </div>




            </fieldset>
        </form:form>
    </div>
</div>

<jsp:include page="../tags/footer.jsp" />

</body>
</html>