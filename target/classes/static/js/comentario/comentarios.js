

var page = 0;
var back = 0;

window.onload = function() {
  loadMoreComments();
};

function loadMoreComments() {

  console.log("###############################")
  console.log("llamar al api");
  console.log("Solicitando pagina: "+page);

  var data = new FormData();
  data.append("page", page);
  $.ajax({
    url: "http://localhost:8080/comentarios/info",
    data: data,
    type: "POST",
    cache: false,
    contentType: false,
    processData: false,
    success: function (comentarios) {

      if (!$.trim(comentarios)) {
        page = page;
        back = page;
        $("#alertComment").show();
        console.log("REspuesta sin datos");
        console.log("dismiss page "+ page);
        console.log("valode back "+ back);
      } else {      
        
        console.log("REspuesta con datos");
        console.log("valor de page "+ page);
        back = 0;
        if (page == 0) {
          console.log("html html");
          $("#comentarios").html(comentarios);
          
        } else {
          if(page != back){
            console.log("Respuesta con datos reenderizar");
            $("#comentarios").append(comentarios); // Donde se va renderizar la data
          }
          
        }
        page++;
        console.log("aumenta a " + page);
      }
     
    },
    error: function (error) {
      alert(error);
    },
  });
}

$(function () {

  $("#btnloadcomments").click(function () {
    loadMoreComments();
  });


});


