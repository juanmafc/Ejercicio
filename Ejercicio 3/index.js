function validateForm() {
    
    var nombre = document.forms["pedidoForm"]["nombre"].value;
    if (!nombreIsValid(nombre)){ 
        alert("Nombre es obligatorio y no puede superar los 100 caracteres");
        return false;
    }
    
    var monto = document.forms["pedidoForm"]["monto"].value;
    if (!montoIsValid(monto)){ 
        alert("Monto es obligatorio y debe ser un numero");
        return false;
    }

    var descuento = document.forms["pedidoForm"]["descuento"].value;
    if (!descuentoIsValid(descuento)){
        alert("Descuento debe ser un numero o estar vacio");
        return false;
    }
}

function nombreIsValid(nombre) {    
    return nombre !== "" && nombre.length <= 100;
}

function montoIsValid(monto) {    
    return monto !== "" && !isNaN(monto);
}

function descuentoIsValid(descuento) {
    return descuento === "" || !isNaN(descuento);
}