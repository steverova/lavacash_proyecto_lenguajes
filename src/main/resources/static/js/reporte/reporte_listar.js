alerta_cargando('Contactando con el servidor', 'Espere por favor ...');

$(document).ready(function () {

    fetchReportData((data) => {
        $('#tabla_reporte').DataTable({
            dom: 'Bfrtip',
            buttons: [
                'excel', 'pdf', 'print'
            ],
            data: data,
            columns: [
                {title: 'Fecha de Cita'},
                {title: 'Hora de Cita'},
                {title: 'Tipo de Vehículo'},
                {title: 'Placa'},
                {title: 'Usuario'},
                {title: 'Teléfono'},
                {title: 'Tipo de Servicio'},
                {title: 'Nombre del Servicio'},
                {title: 'Precio'},
                {title: 'Duración'}
            ],
            language: {
                "sProcessing": "Procesando...",
                "sLengthMenu": "Mostrar _MENU_ registros",
                "sZeroRecords": "No se encontraron resultados",
                "sEmptyTable": "Ningún dato disponible en esta tabla",
                "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
                "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
                "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
                "sInfoPostFix": "",
                "sSearch": "Buscar:",
                "sUrl": "",
                "sInfoThousands": ",",
                "sLoadingRecords": "Cargando...",
                "oPaginate": {
                    "sFirst": "Primero",
                    "sLast": "Último",
                    "sNext": "Siguiente",
                    "sPrevious": "Anterior"
                },
                "oAria": {
                    "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
                    "sSortDescending": ": Activar para ordenar la columna de manera descendente"
                }
            }
        });
    });

});

function fetchReportData(callback) {
    $.ajax({
        url: './api/',
        data: null,
        processData: false,
        contentType: false,
        async: false,
        cache: false,
        type: 'GET',
        success: (datos) => {
            alerta_auto("Datos recibidos");
            callback(setArray(datos));
        },
        error: (error) => {
            alerta_incorrecto('Problema al conectar con el servidor', 'Intentelo más tarde . . .');
            console.log(error);

        }
    });
}

function setArray(fetched) {
    console.log(fetched);
    var datos = [];
    fetched.map((item) => {
        var nItem = [
            item['fecha'],
            item['hora'],
            item['tipoVehiculo'],
            item['placa'],
            item['nombreUsuario'],
            item['telefono'],
            item['tipoServicio'],
            item['nombreServicio'],
            item['precio'],
            item['tiempo']
        ];
        datos.push(nItem);
    });
    /*
     for (var item in fetched) {
     
     
     }*/
    console.log(datos);
    return datos;
}