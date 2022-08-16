var tipoMap = Array();

const cargar_tipo_map = () => {
    tipoMap[1] = "Regular";
    tipoMap[2] = "Promoción";
    tipoMap[3] = "Tiempo Limitado";
    tipoMap[4] = "Temporada";
    tipoMap[5] = "A la Medida";
};

const obtener_servicios = (callback) => {
    $.ajax({
        url: './api/',
        processData: false,
        contentType: false,
        async: false,
        cache: false,
        type: 'GET',
        success: (datos) => {
            alerta_auto('Datos recibidos');
            callback(datos);
        },
        error: (error) => {
            alerta_incorrecto('Error al ejecutar la acción', 'Por favor intentarlo denuevo.');
            console.log(error);
        }
    });
};

const cargar_servicios = (servicios) => {
    $("#tableBody > tbody").empty();
    servicios.forEach((servicio) => {
        const tabla = $("#tableBody > tbody");
        let fila = crear_elemento('tr', '');
        fila.appendChild(crear_elemento('td', tipoMap[servicio.tipo]));
        fila.appendChild(crear_elemento('td', servicio.nombre));
        fila.appendChild(crear_elemento('td', servicio.descripcion));
        fila.appendChild(crear_elemento('td', formato_moneda(servicio.precio)));
        fila.appendChild(crear_elemento('td', servicio.tiempo + ' minutos'));
        let dato = crear_elemento('td', '');
        dato = configurar_elemento(dato, 'style', 'display: flex');
        let btn1 = crear_elemento('i', '');
        btn1 = configurar_elemento(btn1, 'class', 'bi bi-pencil-square p-3');
        btn1 = configurar_elemento(btn1, 'onclick', 'redireccionar("./editar/' + servicio.id + '")');
        let btn2 = crear_elemento('i', '');
        btn2 = configurar_elemento(btn2, 'class', 'bi bi-trash-fill p-3');
        btn2 = configurar_elemento(btn2, 'onclick', 'eliminar_servicio( ' + servicio.id + ')');
        if (servicio.tipo != 1) {
            let btn3 = crear_elemento('i', '');
            btn3 = configurar_elemento(btn3, 'class', 'bi bi-card-list p-3');
            btn3 = configurar_elemento(btn3, 'onclick', 'ver_detalles(' + servicio.id + ',"' + servicio.nombre + '")');
            dato.appendChild(btn3);
        }
        dato.appendChild(btn1);
        dato.appendChild(btn2);

        fila.appendChild(dato);
        tabla.append(fila);
    });
};

const redireccionar = (ref) => {
    window.location.href = ref;
};

const ver_detalles = (id, nombre) => {
    $.ajax({
        url: './api/hijos/' + id,
        data: null,
        processData: false,
        contentType: false,
        async: false,
        cache: false,
        type: 'GET',
        success: (datos) => {
            $('#titulo_modal_detalle').html('El servicio <b>' + nombre + '</b> incluye:');
            let tabla = $('#tabla_modal_detalle > tbody');
            tabla.empty();
            datos.hijos.forEach((hijo, index) => {
                let fila = crear_elemento('tr', '');
                fila.appendChild(crear_elemento('td', hijo.nombre));
                fila.appendChild(crear_elemento('td', hijo.descripcion));
                tabla.append(fila);
            });
        },
        error: (error) => {
            window.alert("ERROR AL COMUNICARSE CON EL SERVIDOR");
        }
    });
    $('#modal_detalles').modal('show');
};

const eliminar_servicio = (id) => {
    const mensaje = "¿Seguro que desea eliminar el servicio?";
    const alerta = "Esta accion es irreversible, los datos eliminados no se podran recuperar.";
    alerta_confirmacion(mensaje, alerta, ejecutar_eliminado, id);
};

const ejecutar_eliminado = (id) => {
    alerta_cargando('Realizando petición', 'Espere por favor');
    setTimeout(() => {
        
        $.ajax({
            url: './api/' + id,
            data: null,
            processData: false,
            contentType: false,
            async: false,
            cache: false,
            type: 'DELETE',
            success: (datos) => {
                alerta_simple("Servicio eliminado exitosamente");
                obtener_servicios(cargar_servicios);
            },
            error: (error) => {
                window.alert("ERROR AL COMUNICARSE CON EL SERVIDOR");
            }
        });
    }, 100);

};

const formato_moneda = (monto) => {
    const f = new Intl.NumberFormat('es-CR', {
        style: 'currency',
        currency: 'CRC',
        minimumFractionDigits: 2
    });
    return f.format(monto);
};

$(document).ready(() => {
    alerta_cargando('Obteniendo datos del servidor', 'Espere por favor');
    setTimeout(() => {
        cargar_tipo_map();
        obtener_servicios(cargar_servicios);
    }, 100);
});

//Otras funciones de ayuda

/*
 * Crea un elemento td para insertar en una fila
 */
const crear_elemento = (elemento, inner) => {
    const td = document.createElement(elemento);
    td.innerHTML = inner;
    return td;
};

/*
 * Toma un elemento y le agrega propiedades
 */
const configurar_elemento = (elemento, atributo, valor) => {
    elemento.setAttribute(atributo, valor);
    return elemento;
};