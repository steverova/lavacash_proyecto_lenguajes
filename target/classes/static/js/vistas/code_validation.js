$(function () {
    $("#submitCode").click(function () {
      $("#messageDanger").text('Validando codigo');
      validate();
    });
  
    function validate() {
      var formdata = new FormData();
      formdata.append("code", $("#code").val());
      // $('#id').hide();
      // $('#id').show();
      $.ajax({
        type: "POST",
        url: "http://localhost:8080/hola/validateCode",
        dataType: "JSON",
        processData: false,
        contentType: false,
        async: false,
        cache: false,
        data: formdata
      }).done( function(validate) {
        // $("#sendmail").hide();
        // $("#codeverify").show();
        if(validate){
          window.alert("Validacion Exitosa.");
          window.location.replace("http://localhost:8080/cuenta/cambiar_contrasena");
        }else{
          window.alert("Ingresa el codigo enviado al correo electronico");
        }

  
    }).fail( function(validate) {
        alert( 'Error!!' );
    });
    }
  });