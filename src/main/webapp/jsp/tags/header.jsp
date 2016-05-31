
<div id="navbar-full">
	<div id="navbar">
		<nav class="navbar navbar-ct-blue navbar-fixed-top"
			role="navigation">

			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only"></span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">IAS AVES</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">

                        <li class="dropdown"><a href="#" class="dropdown-toggle"
                                                data-toggle="dropdown">Zonas <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="<%=request.getContextPath()%>/zonas/all.html">
                                    Todas las Zonas</a></li>

                                <li class="divider"></li>
                                <li><a href="<%=request.getContextPath()%>/zonas/new">
                                    Nueva Zonas</a></li>
                            </ul>
                        </li>

                        <li class="dropdown"><a href="#" class="dropdown-toggle"
                                                data-toggle="dropdown">Paises <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="<%=request.getContextPath()%>/country/all.html">
                                    Todos los paises</a></li>

                                <li class="divider"></li>
                                <li><a href="<%=request.getContextPath()%>/country/new">
                                    Nuevo Pais</a></li>
                            </ul>
                        </li>

                            <li class="dropdown"><a href="#" class="dropdown-toggle"
                                                    data-toggle="dropdown">Aves <span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="<%=request.getContextPath()%>/aves/all.html">
                                        Todos las Aves</a></li>

                                    <li class="divider"></li>
                                    <li><a href="<%=request.getContextPath()%>/aves/new">
                                        Nueva Aves</a></li>
                                </ul>
                            </li>
					</ul>

				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
	</div>
	<!--  end navbar -->

</div>
<!-- end menu-dropdown -->
