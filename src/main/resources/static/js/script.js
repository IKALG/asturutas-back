$(document).ready(function(){

    function redirigirInicio() {
        $("#login").click(function(){
            window.location.href = "/login";
        });
    }

    function redirigirRegistro() {
        $("#register").click(function(){
            window.location.href = "/register";
        });
    }
    
    function cerrarSesion() {
		$("#logout").click(function(){
            window.location.href = "/logout";
        });
	}
	
	    function nuevaRuta() {
		$("#nuevaRuta").click(function(){
            window.location.href = "/rutas/crear";
        });
	}
	
		    function mostrarMisRutas() {
		$("#misRutas").click(function(){
            window.location.href = "/rutas/usuario";
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
});
