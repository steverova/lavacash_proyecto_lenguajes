$(document).ready(() => {
    consultarServicios();
    obtener_hijos(id_servicio);
    const tipo = $("#selectTipo").attr('tipo');
    set_es_basico(tipo == 1);
});

let serviciosData = new Array();
let serviciosMapa = new Array();
let esBasico = 1;
const id_servicio = $('#inputId').val();


const actualizar_tabla = () => {
    let tabla = $("#tableBody > tbody");
    tabla.empty();
    serviciosData.forEach((servicio) => {
        if (serviciosMapa[servicio.id]) {
            let fila = crear_elemento('tr', '');
            fila = configurar_elemento(fila, 'id', servicio.id);
            fila.appendChild(crear_elemento('td', servicio.nombre));
            fila.appendChild(crear_elemento('td', servicio.descripcion));
            let dato = crear_elemento('td', '');
            let btn = crear_elemento('i', '');
            btn = configurar_elemento(btn, 'class', 'bi bi-trash-fill p-3');
            btn = configurar_elemento(btn, 'onclick', 'eliminarMapeo(' + servicio.id + ')');
            dato.appendChild(btn);
            fila.appendChild(dato);
            tabla.append(fila);
        }
    });
};

function agregarServicios() {

    $(".iterable").each((i, element) => {
        if (element.checked) {
            serviciosMapa[element.attributes["value"].value] = 1;
        } else {
            serviciosMapa[element.attributes["value"].value] = 0;
        }
    });
    $('#modalEscogerServicios').modal('hide');
    calcular_precio();
    actualizar_tabla();
}

/*
 * llamar cada vez que se agregan servicios
 */
const calcular_precio = () => {
    let precio = 0;
    let tiempo = 0;
    serviciosData.forEach((servicio) => {
        if (serviciosMapa[servicio.id] === 1) {
            precio += servicio.precio;
            tiempo += servicio.tiempo;
        }
    });
    $("#inputPrecio").val(precio);
    $("#inputDuracion").val(tiempo);
};

function cargarServiciosDisponibles() {
    $("#tableModal > tbody").empty();
    serviciosData.forEach((servicio) => {
        if (serviciosMapa[servicio.id] !== 0) {
            //cargo los datos asociados
            $("#tableModal > tbody").append("<tr>" +
                    "<td>" + servicio.id + "</td>" +
                    "<td>" + servicio.nombre + "</td>" +
                    "<td>" + servicio.descripcion + "</td>" +
                    "<td><input type='checkbox' "
                    + "class='iterable' "
                    + "value='" +
                    servicio.id + "'"
                    + "checked='' /></td>" +
                    "</tr>");
        } else {
            $("#tableModal > tbody").append("<tr>" +
                    "<td>" + servicio.id + "</td>" +
                    "<td>" + servicio.nombre + "</td>" +
                    "<td>" + servicio.descripcion + "</td>" +
                    "<td><input type='checkbox' class='iterable' value='" +
                    servicio.id + "' /></td>" +
                    "</tr>");
        }
    });
}

/*
 * Toma un elemento y le agrega propiedades
 */
const configurar_elemento = (elemento, atributo, valor) => {
    elemento.setAttribute(atributo, valor);
    return elemento;
};

/**
 * Se encarga de traer datos del servidor
 */
function consultarServicios() {
    $.ajax({
        url: './../api/basico',
        data: null,
        processData: false,
        contentType: 'application/json',
        async: false,
        cache: false,
        type: 'GET',
        success: (datos) => {
            datos.forEach((item) => {
                serviciosData.push(item);
                serviciosMapa[item.id] = 0;
            });
        },
        error: (error) => {
            console.log(error);
            window.alert("ERROR: no hubo respuesta del servidor.");
        }
    });
}

/*
 * Crea un elemento td para insertar en una fila
 */
const crear_elemento = (elemento, inner) => {
    const td = document.createElement(elemento);
    td.innerHTML = inner;
    return td;
};

function eliminarMapeo(id) {
    serviciosMapa[id] = 0;
    calcular_precio();
    actualizar_tabla();
}


/**
 * Se encarga de consultar servicios de la api y levantar el modal
 */
function escogerServicios() {
    cargarServiciosDisponibles();
    $('#modalEscogerServicios').modal('show');
}


function guardarServicio() {
    event.preventDefault();
    const data = {
        id: $("#inputId").val(),
        tipo: $("#selectTipo").attr('tipo'),
        nombre: $("#inputNombre").val(),
        descripcion: $("#inputDescripcion").val(),
        precio: $("#inputPrecio").val(),
        tiempo: $("#inputDuracion").val()
    };

    alerta_confirmacion('¿Seguro que desea continuar?', 'Esta acción es irreversible', () => {
        $.ajax({
            url: '../api/',
            dataType: 'text',
            type: 'put',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: (resp) => {
                alerta_auto('Guardando servicios');
                guardar_servicios_hijos(id_servicio);
            },
            error: (error) => {
                alerta_incorrecto('Error al ejecutar la acción', 'Por favor intentarlo denuevo.');
                console.log(error);
            }
        });

    }, '');


}

/*
 * envio servicios hijos al servidor
 */
const guardar_servicios_hijos = (padre) => {
    let mhijos = [];
    serviciosData.forEach((servicio) => {
        if (serviciosMapa[servicio.id] === 1) {
            mhijos.push({
                id: servicio.id,
                nombre: servicio.nombre,
                descripcion: servicio.descripcion
            });
        }
    });
    const data = {
        id: padre,
        hijos: mhijos
    };
    $.ajax({
        url: './../api/hijos/',
        dataType: 'text',
        type: 'post',
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: (resp) => {
            alerta_auto('Servicio Guardado');
            window.location.href = "./../";
        },
        error: (error) => {
            alerta_incorrecto('Error al ejecutar la acción', 'Por favor intentarlo denuevo.');
            console.log(error);
        }
    });
};

const obtener_hijos = (id) => {
    $.ajax({
        url: './../api/hijos/' + id,
        data: null,
        processData: false,
        contentType: false,
        async: false,
        cache: false,
        type: 'GET',
        success: (datos) => {
            datos.hijos.forEach((hijo, index) => {
                serviciosMapa[hijo.id] = 1;
            });
            agregarServicios();
        },
        error: (error) => {
            window.alert("ERROR AL COMUNICARSE CON EL SERVIDOR");
        }
    });
};

const set_es_basico = (estado) => {
    esBasico = estado;
    if (estado) {
        $("#btnAgregarServicios").prop("disabled", "true");
        $("#inputPrecio").removeAttr('readonly');
        $("#inputPrecio").val(0);
        $("#inputDuracion").val(0);
        $("#inputDuracion").removeAttr('readonly');
    } else {
        $("#btnAgregarServicios").removeAttr("disabled");
        $("#inputPrecio").prop('readonly', 'true');
        $("#inputDuracion").prop('readonly', 'true');
    }
};