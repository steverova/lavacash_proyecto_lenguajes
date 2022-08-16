$(document).ready(() => {
    $("#selectTipo").on("change", () => {
        let value = $("#selectTipo").val();
        if (value == 1) {//aser obj de jquery hacer la comparacion asi
            set_es_basico(1);
            reiniciar_mapa();
            actualizar_tabla();
        } else {
            set_es_basico(0);
        }
    });
    set_es_basico(1);
    setTimeout(consultar_servicios, 100);
});

alerta_cargando('Conectando con el servidor', 'Espere por favor . . .');

let serviciosData = new Array();
let serviciosMapa = new Array();
let esBasico = 1;

/*
 * funcion propia de la vista
 * actualiza la tabla de servicios seleccionados
 */
const actualizar_tabla = () => {
    $("#tableBody > tbody").empty();
    serviciosData.forEach((servicio) => {
        if (serviciosMapa[servicio.id]) {
            const tabla = $("#tableBody > tbody");
            let fila = crear_elemento('tr', '');
            fila = configurar_elemento(fila, 'id', servicio.id);
            fila.appendChild(crear_elemento('td', servicio.nombre));
            fila.appendChild(crear_elemento('td', servicio.descripcion));
            let btn_eliminar = crear_elemento('i', '');
            btn_eliminar = configurar_elemento(btn_eliminar, 'class', 'bi bi-trash-fill p-3');
            btn_eliminar = configurar_elemento(btn_eliminar, 'onclick', 'eliminar_mapeo(' + servicio.id + ')');
            fila.appendChild(btn_eliminar);
            tabla.append(fila);
        }
    });
};


/*
 * funcion propia de la vista
 * recorre los checks
 * se llama desde html
 */
const agregar_servicios = () => {
    //obtengo todos los checks y los valido
    $(".check_agregado").each((i, element) => {
        if (element.checked) {
            serviciosMapa[element.attributes["value"].value] = 1;
        } else {
            serviciosMapa[element.attributes["value"].value] = 0;
        }
    });
    $('#modalEscogerServicios').modal('hide');
    actualizar_tabla();
    calcular_precio();
};

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

/*
 * 
 */
function cargar_servicios_disponibles() {
    let tabla = $("#tableModal > tbody");
    tabla.empty();
    serviciosData.forEach((servicio) => {
        let fila = crear_elemento('tr', '');
        fila.appendChild(crear_elemento('td', servicio.nombre));
        fila.appendChild(crear_elemento('td', servicio.descripcion));
        let dato = crear_elemento('td', '');
        let check = crear_elemento('input', '');
        check = configurar_elemento(check, 'type', 'checkbox');
        check = configurar_elemento(check, 'class', 'check_agregado');
        check = configurar_elemento(check, 'value', servicio.id);
        if (serviciosMapa[servicio.id] !== 0) {
            check = configurar_elemento(check, 'checked', 'true');
        }
        dato.appendChild(check);
        fila.appendChild(dato);
        tabla.append(fila);
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
const consultar_servicios = () => {
    setTimeout(500);
    $.ajax({
        url: './api/basico',
        data: null,
        processData: false,
        contentType: 'application/json',
        async: false,
        cache: false,
        type: 'GET',
        success: (datos) => {
            alerta_auto('Datos recibidos');
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
};

/*
 * Crea un elemento td para insertar en una fila
 */
const crear_elemento = (elemento, inner) => {
    const td = document.createElement(elemento);
    td.innerHTML = inner;
    return td;
};

/*
 * funcion propia de la vista
 * depende de actualizar_tabla
 */
const eliminar_mapeo = (id) => {
    serviciosMapa[id] = 0;
    calcular_precio();
    actualizar_tabla();
};

/**
 * Se encarga de consultar servicios de la api y levantar el modal
 */
function escoger_servicios() {
    cargar_servicios_disponibles();
    $('#modalEscogerServicios').modal('show');
}

/*
 * funcion propia de la vista
 * envia los datos por ajax
 */
const guardarServicio = () => {
    event.preventDefault();
    //extraigo los campos
    const data = {
        tipo: $("#selectTipo").val(),
        nombre: $("#inputNombre").val(),
        descripcion: $("#inputDescripcion").val(),
        precio: $("#inputPrecio").val(),
        tiempo: $("#inputDuracion").val()
    };

    const validacion = validar_servicio();
    if (validacion.length > 0) {
        alerta_html('El servicio es incorrecto', validacion);
    } else {
        $.ajax({
            url: './api/',
            dataType: 'text',
            type: 'post',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: (resp) => {
                if (resp != 0) {
                    alerta_auto('Guardando servicios');
                    guardar_servicios_hijos(resp);
                }
            },
            error: (error) => {
                alerta_incorrecto('Error al ejecutar la acción', 'Por favor intentarlo denuevo.');
                console.log(error);
            }
        });
    }
};

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
        url: './api/hijos/',
        dataType: 'text',
        type: 'post',
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: (resp) => {
            alerta_auto('Servicio Guardado');
            window.location.href = "./";
        },
        error: (error) => {
            alerta_incorrecto('Error al ejecutar la acción', 'Por favor intentarlo denuevo.');
            console.log(error);
        }
    });
};

/*
 * funcion propia de la vista
 * reincia mapa al cambiar a servicio basico
 */
const reiniciar_mapa = () => {
    serviciosData.forEach((servicio) => {
        serviciosMapa[servicio.id] = 0;
    });
};

const set_es_basico = (estado) => {
    esBasico = estado;
    if (estado) {
        $("#btnAgregarServicios").prop("disabled", "true");
        $("#inputPrecio").removeAttr('readonly');
        $("#inputPrecio").val(0);
        $("#inputDuracion").removeAttr('readonly');
        $("#inputDuracion").val(0);
    } else {
        $("#btnAgregarServicios").removeAttr("disabled");
        $("#inputPrecio").prop('readonly', 'true');
        $("#inputDuracion").prop('readonly', 'true');
    }
};

const validar_servicio = () => {
    const tipo = $("#selectTipo").val();
    const nombre = $("#inputNombre").val();
    const descripcion = $("#inputDescripcion").val();
    const precio = $("#inputPrecio").val();
    const tiempo = $("#inputDuracion").val();
    let validaciones = '';
    if (tipo != 1) {
        if (contar_servicios_asociados() == 0) {
            validaciones += 'Un servicio compuesto debe tener servicios asociados <br>';
        }
    } else {
        if (precio == 0) {
            validaciones += 'Ingresar el <b>precio</b> <br>';
        }
        else if(precio < 0) {
            validaciones += '<b>Precio</b> no puede ser negativo <br>';
        }
        if (tiempo == 0) {
            validaciones += 'Ingresar el <b>tiempo</b> <br>';
        }
        else if(tiempo < 0) {
            validaciones += '<b>Tiempo</b> no puede ser negativo <br>';
        }
    }
    if (nombre === '') {
        validaciones += 'Ingresar el <b>nombre</b> <br>';
    }
    if (descripcion === '') {
        validaciones += 'Ingresar la <b>descripción</b> <br>';
    }
    return validaciones;
};

const contar_servicios_asociados = () => {
    let contador = 0;
    serviciosData.forEach((servicio) => {
        if (serviciosMapa[servicio.id] === 1) {
            contador++;
        }
    });
    return contador;
};