
function onlyNumberKey(evt) {

    var ASCIICode = (evt.which) ? evt.which : evt.keyCode
    if (ASCIICode > 31 && (ASCIICode < 48 || ASCIICode > 57))
        return false;
    return true;
}

var check = function () {

    var input1 = document.getElementById('password').value;
    var input2 = document.getElementById('confirm_password').value;
    var btn = document.getElementById('btnsubmit');

    if (input1 == input2 && input1 != "" && input2 != "") {
        document.getElementById('message').style.color = 'green';
        document.getElementById('message').innerHTML = 'Las contraseñas coinciden &#9989';
        btn.disabled = false;
    } else if ((input1 == null || input1 == "") || (input2 == null || input2 == "")) {
        document.getElementById('message').style.color = 'blue';
        document.getElementById('message').innerHTML = 'Ingrese una contraseña';
        btn.disabled = true;
    } else if (input1 != input2) {
        document.getElementById('message').style.color = 'red';
        document.getElementById('message').innerHTML = 'Las contraseñas no coinciden &#129313';
        btn.disabled = true;
    }

}

function myFunction() {
    var pass = document.getElementById("password");
    var passConfirm = document.getElementById("confirm_password");

    if (pass.type === "password" && passConfirm.type === "password") {
        pass.type = "text";
        passConfirm.type = "text";
    } else {
        pass.type = "password";
        passConfirm.type = "password";
    }
} 

function myFunctionLogin() {
    var pass = document.getElementById("password");

    if (pass.type === "password") {
        pass.type = "text";
        
    } else {
        pass.type = "password";
    }
} 

function hidemessage(){
    setTimeout(() => {
        const box = document.getElementById('messageDanger');
      
        // 👇️ removes element from DOM
        box.style.display = 'none';
      
        // 👇️ hides element (still takes up space on page)
        // box.style.visibility = 'hidden';
      }, 2000); // 
}

//================= validar codigo de cambio de contrasena

function validateCodeToChangePassword(){

    
    alert($("#session").val());
    // if($('#code').val() === sessionCode ){
    //     alert("validacion Correcta");

    // }

}
