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

function reunionesMesHoy(){ //Recibirá los días en los que hay reunión
	mesActual = hoy.getMonth() + 1;
	var info = {
        "type" : "PeticionReunionesMes",
		"mes" : mesActual,
		"ano" : hoy.getFullYear()
    };
    $.ajax
        ({
          type: "GET",
          url: "/getCalendarioPersonalMes",
          dataType: 'application/json',
          headers: {
            "Authorization": "Bearer " + localStorage.getItem("jwt")},
          data: JSON.stringify(info),
          success: function (){
            alert('Thanks for your comment!');
            var data = event.data;
            data = JSON.parse(data);
            getReunionesMes(data); 
          },
          error: function(){
            alert("ERROR");
          }
        });
}

function reunionesDiaHoy(){ //Mostrará las reuniones que hay en el día de hoy, por defecto
	mesActual = meshoy+1;
	var info = {
        type : "PeticionDatosReunion",
		dia : diahoy,
		mes : mesActual,
		ano : annohoy
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
			getDetallesReuniones(data);
        },
        error : function(response) {
            alert("Error en la petición de reuniones");
        }
    };
    $.ajax(data);
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