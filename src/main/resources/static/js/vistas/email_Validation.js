$(function () {
  let e = $("#email").val();
  $("#email").keyup(function (event) {
    if ($("#email").val().includes('@')) {
      validate();
    }
  });

  function validate() {
    var formdata = new FormData();
    formdata.append("email", $("#email").val());
    $.ajax({
      type: "POST",
      url: "http://localhost:8080/hola/validateEmail",
      dataType: "JSON",
      processData: false,
      contentType: false,
      async: true,
      cache: false,
      data: formdata,
    })
      .done(function (validate) {
        if (validate == 0) {
          $("#sendverify").prop("disabled", true);
          $("#messageDanger").css("color", "red");
          $("#messageDanger").text("Este correo no se encuentra registrado");
        } else {
          $("#messageDanger").text("Este correo es valido!!");
          $("#messageDanger").css("color", "green");
          $("#sendverify").prop("disabled", false);
        }
      })
      .fail(function (validate) {
        alert("Error!!");
      });
  }
});
