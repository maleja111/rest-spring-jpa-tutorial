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


        <c:url var="url"
               value="${request.contextPath}/country/update/${editCountry.id}" />


        <form:form class="form-horizontal" action="${url}" method="post"
                   commandName="editCountry">
            <fieldset>

                <!-- Form Name -->
                <legend>Editar Pais</legend>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="id">Id</label>
                    <div class="col-md-5">
                        <form:input path="id" readonly="true"
                                    class="form-control input-md" />

                    </div>
                </div>



                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="cdPais">cdPais</label>
                    <div class="col-md-5">
                        <form:input path="cdPais" class="form-control input-md" />

                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="dsNombre">dsNombre</label>
                    <div class="col-md-5">
                        <form:input path="dsNombre" class="form-control input-md" />

                    </div>
                </div>

                <div class="form-group ">
                    <label class="col-md-4 control-label" for="zonas">Zona</label>
                    <table class="table" style="width: 40%;">
                        <tr>
                            <th>Id</th>
                            <th>cdZona</th>
                            <th>dsNombre</th>
                        </tr>
                        <c:if test="${empty zonas}">
                            <tr>
                                <td colspan="4">No Results found</td>
                            </tr>
                        </c:if>
                        <c:if test="${! empty zonas}">
                            <c:forEach var="zona" items="${zonas}">
                                <tr>
                                    <td><c:out value="${zona.id}"></c:out></td>
                                    <td><c:out value="${zona.cdZona}"></c:out></td>
                                    <td><c:out value="${zona.dsNombre}"></c:out></td>
                                </tr>
                            </c:forEach>
                        </c:if>
                    </table>
                </div>

                <input type="hidden" value="${zonas}" id="zonaList" name="zonaList" />


                <div class="form-group">
                    <label class="col-md-4 "></label>
                    <div class="col-md-5">
                        <input type="submit" name="" value="Guardar"
                               class="btn btn-fill btn-success"> &nbsp;&nbsp; <input
                            type="reset" name="" value="Limpiar"
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