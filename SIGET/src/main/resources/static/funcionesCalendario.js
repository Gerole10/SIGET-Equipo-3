var hoy = new Date();

function clickInfoReuniones(ID){ //TODO cambiar metodo de obtención de los días que tienen o no reunión

    var jsonReunionesDia = getDetallesReuniones(ID);

    for(j = 0; j < 31; j++){
        document.getElementById(j).style.border = "2px double #fffafa";
    }

    if(ID != 0){
        var celda = document.getElementById(ID);
        celda.style.border = "2px double coral";
    }

    formEnBlanco();
    detallesEnBlanco();

    if(ID != 0){
        if(jsonReunionesDia.reuniones == 0){
            document.getElementById("formularioPreview").insertAdjacentHTML('beforeend',"<div><label>NO HAY REUNIONES</label></div>");
        } else {
            for(i = 0; i < jsonReunionesDia.reuniones.length; i++){
                document.getElementById("formularioPreview").insertAdjacentHTML('beforeend',"<div id='reunionYhora'><label id='reunion' "+
                	"onclick='mostrarInfoReunion("+jsonReunionesDia.reuniones[i].id+","+jsonReunionesDia.dia+")'>"+
                    jsonReunionesDia.reuniones[i].titulo+"</label>"+
                    "<label id='horasreunion'>"+jsonReunionesDia.reuniones[i].hora+"</label><br></div>");
            }
        }
    }
}

function formEnBlanco(){
var borrador = document.getElementById("formularioPreview");
    while (borrador.firstChild){
        borrador.removeChild(borrador.firstChild);
    }
}

function detallesEnBlanco(){
	//Vacía la caja de la derecha cada vez que cambia el día seleccionado
	var tituloB = document.getElementById("titureunion");
    tituloB.setAttribute("value"," ");

    var horaB = document.getElementById("horareunion");
    horaB.setAttribute("value"," ");

    var descripcionB = document.getElementById("descripcion");
    descripcionB.setAttribute("placeholder"," ");

    var asistentesB = document.getElementById("asistentes");
    asistentesB.setAttribute("placeholder"," ");

}

function mostrarInfoReunion(idReunion,diaReunion){
    var jsonMostrar = getDetallesReuniones(diaReunion);

    var titulo = document.getElementById("titureunion");
    titulo.setAttribute("value",jsonMostrar.reuniones[idReunion-1].titulo);

    var hora = document.getElementById("horareunion");
    hora.setAttribute("value",jsonMostrar.reuniones[idReunion-1].hora);

    var descripcion = document.getElementById("descripcion");
    descripcion.setAttribute("placeholder",jsonMostrar.reuniones[idReunion-1].descripcion);

    for(i = 0; i < jsonMostrar.reuniones[idReunion-1].asistentes.length; i++){
        var asistentes = document.getElementById("asistentes");
        asistentes.setAttribute("placeholder",jsonMostrar.reuniones[idReunion-1].asistentes);   
    }
}

function getDetallesReuniones(data){
    return data;
}

function getReunionesMes(data){
    return data;
}

function pruebaConexion(){
    var info = {
        "id" : 123,
        "ejemplo" : "Pues esto mismo"
    };
    $.ajax({
    // la URL para la petición
    url : '/pruebaConexion',

    // la información a enviar
    data : JSON.stringify(info),

    // especifica si será una petición POST o GET
    type : 'GET',

    // el tipo de información que se espera de respuesta
    dataType: 'json',
    contentType: 'application/json',

    // código a ejecutar si la petición es satisfactoria;
    // la respuesta es pasada como argumento a la función
    success : function(json) {
        console.log("La respuesta llegó");
        console.log("La respuesta es: "+json);
    },

    // código a ejecutar si la petición falla;
    // son pasados como argumentos a la función
    // el objeto de la petición en crudo y código de estatus de la petición
    error : function(response) {
        alert('Disculpe, existió un problema');
        console.log(response);
    },

    // código a ejecutar sin importar si la petición falló o no
    complete : function() {
        alert('Petición realizada');
        console.log("Estoy enviando: "+data);
    }
});
}

function handleData(jsonRespuesta){
    console.log(jsonRespuesta);
}

function reunionesMesHoy(){ //Recibirá los días en los que hay reunión
	mesActual = hoy.getMonth() + 1;
    anoActual = hoy.getFullYear();
	var info = {
        "type" : "PeticionReunionesMes",
		"mes" : mesActual,
		"ano" : anoActual
    };
    var infoAjax = {type: "GET",
        url: "/getCalendarioPersonalMes",
        dataType: 'application/json',
        headers: {"Authorization": "Bearer " + localStorage.getItem("jwt")},
        data: JSON.stringify(info),
        success: function (event){
            console.log(event);
            var data = event.data;
            data = JSON.parse(data);
            getReunionesMes(data); 
        },
        error: function(response){
            console.log(response);
            alert("ERROR en reunionesMesHoy()"+response);
        }};
    $.ajax(infoAjax);
}

function reunionesDiaHoy(){ //Mostrará las reuniones que hay en el día de hoy, por defecto
	mesActual = meshoy+1;
	var info = {
        "type" : "PeticionDatosReunion",
		"dia" : hoy.getDay(),
		"mes" : mesActual,
		"ano" : hoy.getFullYear()
    };

    var infoAjax = {
        type: "GET",
        url: "/getDetallesReunion",
        dataType: 'application/json',
        headers: {"Authorization": "Bearer " + localStorage.getItem("jwt")},
        data: JSON.stringify(info),
        success: function (event){
            var data = event.data;
            data = JSON.parse(data);
            getReunionesMes(data); 
        },
        error: function(){
           alert("ERROR");
        }};
    $.ajax(infoAjax);
}

function getReunionesMesC(data){
	return data;
}

function reunionesMes(mesConcreto,anoConcreto){ //Recibirá las reuniones de un mes concreto y las mostrará
	var info = {
        type : "PeticionReunionesMes",
		mes : mesConcreto,
		ano : anoConcreto
    };
    
    var data = {
        data : JSON.stringify(info),
        url : "/getCalendarioPersonalMes",
        type : "get",
        contentType: 'application/json',
        headers:{'Authorization':'Bearer '+localStorage.getItem('jwt')},
        success : function(event) {
        	var data = event.data;
			data = JSON.parse(data);

        },
        error : function(response) {
            alert("Error en la petición de reuniones");
        }
    };
    $.ajax(data);
}

function getDetallesReunionDiaC(data){
	return data;
}

function reunionesDia(diaConcreto,mesConcreto,anoConcreto){ //Mostrará las reuniones de un día concreto
	mesActual = meshoy+1;
	var info = {
        type : "PeticionDatosReunion",
		dia : diaConcreto,
		mes : mesConcreto,
		ano : anaConcretoConcreto
    };
    
    var data = {
        data : JSON.stringify(info),
        url : "/getDetallesReunion",
        type : "get",
        contentType: 'application/json',
        headers:{'Authorization':'Bearer '+localStorage.getItem('jwt')},
        success : function(event) {
            var data = event.data;
			data = JSON.parse(data);
			getDetallesReunionDiaC(data);
        },
        error : function(response) {
            alert("Error en la petición de reuniones");
        }
    };
    $.ajax(data);
}

/*
Cuando juntemos:
	- Cambiamos el parámetro de getDetallesReunion() para pasarle el data que te llega de reunionesDiaHoy() para que haga un return de esos datos.
	- Cambiamos el parámetro de getReunionesMes() para pasarle el data que te llega de reunionesMesHoy() para que haga un return de esos datos.
	- Hacer función get de los datos que recibe reunionesDia(diaC,mesC,anoC) (get) (getDetallesReunionDiaC())
	- Hacer función get de los datos que recibe reunionesMes(mesC,anoC) (getReunionesMesC())
*/