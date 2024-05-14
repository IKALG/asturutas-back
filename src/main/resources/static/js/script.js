$(document).ready(function(){

    function redirigirInicio() {
        $("#login").click(function(){
            window.location.href = "/usuarios";
        });
    }

    function redirigirRegistro() {
        $("#register").click(function(){
            window.location.href = "/registrate";
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
});
