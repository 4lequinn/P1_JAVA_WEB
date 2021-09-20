/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function confirmDelete(id) {
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
                window.location.href = "../ServletUsuario?codigo=" + id;
            })
        }
    })
}


function agregar() {
    mostrarAlerta("Éxito!","Datos guardados con éxito!", "success");
}


function mostrarAlerta(titulo, descripcion, tipoAleta) {
    swal.fire(
            titulo,
            descripcion,
            tipoAleta
    );
}