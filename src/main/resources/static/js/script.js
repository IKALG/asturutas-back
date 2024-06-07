$(document).ready(function() {

	function redirigirInicio() {
		$("#login").click(function() {
			window.location.href = "/login";
		});
	}

	function redirigirRegistro() {
		$("#register").click(function() {
			window.location.href = "/register";
		});
	}

	function cerrarSesion() {
		$("#logout").click(function() {
			window.location.href = "/logout";
		});
	}
	
	function mostrarUsuarios() {
		$("#mostrarUsuarios").click(function() {
			window.location.href = "/usuarios";
		});
	}

	function nuevaRuta() {
		$("#nuevaRuta").click(function() {
			window.location.href = "/rutas/crear";
		});
	}

	function mostrarMisRutas() {
		$("#misRutas").click(function() {
			window.location.href = "/rutas/usuario";
		});
	}

	function mostrarConsultas() {
		$("#mostrarConsultas").click(function() {
			window.location.href = "/contacto/mostrar/consultas";
		});
	}

	function mostrarRutas() {
		$("#mostrarRutas").click(function() {
			window.location.href = "/mostrar/rutas";
		});
	}

	function realizarRegistro() {
		$("#registro").click(function() {
			var nombre = $("#nombre").val()
			alert(nombre + ", tu usuario se ha registrado con éxito.")
		})
	}

	redirigirInicio();
	redirigirRegistro();
	realizarRegistro();
	cerrarSesion();
	nuevaRuta();
	mostrarMisRutas();
	mostrarRutas();
	mostrarConsultas();
	mostrarUsuarios();
});
