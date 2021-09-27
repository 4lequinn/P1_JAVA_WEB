/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function eliminarUsuario(usuario) {
    Swal.fire({
        icon: 'warning',
        title: '¿Estás Seguro?',
        text: '¡No podrás deshacer la acción!',
        showCancelButton: true,
        cancelButtonColor: "#d33",
        cancelButtonText: "Cancelar",
        confirmButtonText: "Si, Eliminar",
    }).then((result) => {
        if (result.value) {
            Swal.fire(
                    '¡Eliminado!',
                    'Usuario Eliminado correctamente',
                    'success'
                    ).then(function () {
                window.location.href = "ControladorUsuario?usuario=" + (usuario);
            })
        }
    })
}


function eliminarLiga(liga) {
    console.log('ID ' + liga);
    Swal.fire({
        icon: 'warning',
        title: '¿Estás Seguro?',
        text: '¡No podrás deshacer la acción!',
        showCancelButton: true,
        cancelButtonColor: "#d33",
        cancelButtonText: "Cancelar",
        confirmButtonText: "Si, Eliminar",
    }).then((result) => {
        if (result.value) {
            Swal.fire(
                    '¡Eliminado!',
                    'Usuario Eliminado correctamente',
                    'success'
                    ).then(function () {
                window.location.href = "ControladorAdminLiga?liga=" + (liga);
            })
        }
    })
}

function mostrarAlerta(titulo, descripcion, tipoAleta) {
    swal.fire(
            titulo,
            descripcion,
            tipoAleta
    );
}