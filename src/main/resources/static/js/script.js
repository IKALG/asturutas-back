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
    redirigirInicio();
    redirigirRegistro();
});
