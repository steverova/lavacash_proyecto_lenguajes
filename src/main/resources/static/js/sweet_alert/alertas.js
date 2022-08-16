function alerta_simple(mensaje) {
    Swal.fire({
        title: mensaje,
        showClass: {
            popup: 'animate__animated animate__fadeInDown'
        },
        hideClass: {
            popup: 'animate__animated animate__fadeOutUp'
        }
    });
}

function alerta_html(mensaje, content) {
    Swal.fire({
        title: mensaje,
        html: content,
        showClass: {
            popup: 'animate__animated animate__fadeInDown'
        },
        hideClass: {
            popup: 'animate__animated animate__fadeOutUp'
        }
    });
}

function alerta_confirmacion(mensaje, advertencia, callback, param) {
    Swal.fire({
        title: mensaje,
        text: advertencia,
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        cancelButtonText: 'Cancelar',
        confirmButtonText: 'Aceptar'
    })
            .then((result) => {
                if (result.isConfirmed) {
                    callback(param);
                    alerta_simple('LA ACCIÓN SE REALIZO CON ÉXITO');
                }
            });
}

function alerta_auto(mensaje) {
    Swal.fire({
        title: mensaje,
        timer: 1000,
        timerProgressBar: true,
        didOpen: () => {
            Swal.showLoading();
        }
    });
}

const alerta_incorrecto = (title, message) => {
    Swal.fire({
        icon: 'error',
        title: title,
        text: message,
        confirmButtonText: 'OK Si . . .'
    });
}

const alerta_cargando = (title, mensaje) => {
    Swal.fire({
        title: title,
        html: mensaje,
        allowOutsideClick: false,
        allowEscapeKey: false,
        showConfirmButton: false,
        didOpen: () => {
            Swal.showLoading();
        }
    });
};