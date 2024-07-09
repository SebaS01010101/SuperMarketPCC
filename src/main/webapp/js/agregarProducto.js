function toggleFields(){
    var tipoProducto = document.getElementById("tipoProducto").value;
    var temperaturaDiv = document.getElementById("temperatura");
    var tipoBebestibleDiv = document.getElementById('tipoBebestible');
    var descripcionDiv = document.getElementById('descripcion');
    var labelTemperatura = document.getElementById('labelTemperatura');
    var labelTipoBebestible = document.getElementById('labelTipoBebestible');
    var labelDescripcion = document.getElementById('labelDescripcion');
    var inputTemperatura = document.getElementById('temperatura');
    var inputTipoBebestible = document.getElementById('tipoBebestible');
    var inputDescripcion = document.getElementById('descripcion');
    var inputCodigoBarras = document.getElementById('codigoBarras');

    temperaturaDiv.style.display = 'none';
    tipoBebestibleDiv.style.display = 'none';
    descripcionDiv.style.display = 'none';
    labelTemperatura.style.display = 'none';
    labelTipoBebestible.style.display = 'none';
    labelDescripcion.style.display = 'none';
    inputTemperatura.required = false;
    inputTipoBebestible.required = false;
    inputDescripcion.required = false;

    if(tipoProducto == '1'){
        temperaturaDiv.style.display = 'block';
        labelTemperatura.style.display = 'block';
        inputTemperatura.required = true;
    }else if(tipoProducto == '3'){
        tipoBebestibleDiv.style.display = 'block';
        labelTipoBebestible.style.display = 'block';
        inputTipoBebestible.required = true;
    }else if(tipoProducto == '5'){
        descripcionDiv.style.display = 'block';
        labelDescripcion.style.display = 'block';
        inputDescripcion.required = true;
    }
} 

document.addEventListener('DOMContentLoaded', function(){
    document.getElementById('tipoProducto').addEventListener('change', toggleFields);
    toggleFields();
});

