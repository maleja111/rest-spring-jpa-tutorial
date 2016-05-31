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
			<form:form class="form-horizontal" action="saveAves" method="post"
				commandName="newAves">
				<fieldset>

					<!-- Form Name -->
					<legend>Nueva Ave</legend>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="cdAve">cdAve</label>
						<div class="col-md-5">
							<input id="cdAve" name="cdAve" type="text"
								placeholder="cdAve" class="form-control input-md" required="">

						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="dsNombreComun">dsNombreComun</label>
						<div class="col-md-5">
							<input id="dsNombreComun" name="dsNombreComun" type="text" placeholder="dsNombreComun"
								class="form-control input-md" required="">

						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="dsNombreCientifico">dsNombreCientifico</label>
						<div class="col-md-5">
							<input id="dsNombreCientifico" name="dsNombreCientifico" type="text"
								placeholder="dsNombreCientifico" class="form-control input-md">

						</div>
					</div>

					<div class="form-group">
						<label class="col-md-4 "></label>
                        <div class="col-md-5">
                            <input type="submit" name="" value="Guardar" class="btn btn-fill btn-success">
                            &nbsp;&nbsp; <input type="reset" name="" value="Limpiar"
                                                class="btn btn-fill btn-primary"> &nbsp;&nbsp; <a
                                href="<%=request.getContextPath()%>/aves/all.html"
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