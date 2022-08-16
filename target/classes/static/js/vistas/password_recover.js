$(function () {
  $("#sendverify").click(function () {
    $("#messageDanger").text("Enviando codigo...");
    sendCode();
  });

  function sendCode() {
    var formdata = new FormData();
    formdata.append("email", $("#email").val());
    $.ajax({
      type: "POST",
      url: "http://localhost:8080/hola/requestPassword",
      dataType: "JSON",
      processData: false,
      contentType: false,
      async: false,
      cache: false,
      data: formdata,
    })
      .done(function () {
        $("#sendmail").hide();
        $("#codeverify").show();
        // alert( 'Success!!' );
      })
      .fail(function () {
        alert("Error!!");
      });
  }
});
