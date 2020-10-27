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

    if(ID != 0){
        if(jsonReunionesDia.reuniones == 0){
            document.getElementById("formularioPreview").insertAdjacentHTML('beforeend',"<div><label>NO HAY REUNIONES</label></div>");
        } else {
            for(i = 0; i < jsonReunionesDia.reuniones.length; i++){
                document.getElementById("formularioPreview").insertAdjacentHTML('beforeend',"<div id='reunionYhora'><label id='reunion' onclick='mostrarInfoReunion("+jsonReunionesDia.reuniones[i].id+","+jsonReunionesDia.dia+")'>"+
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

function getDetallesReuniones(numDia){
    return {
    "dia" : numDia,
    "mes" : 10,
    "ano" : 2020,
    "reuniones" : [
        {
            "id": 1,
            "titulo": "Frontend",
            "hora":"11:30",
            "duracion":90,
            "asistentes": ["Jesus Cabanero","Victor Ramirez","German Rolando","Fatima Sanchez","Angel Villaseñor","Edilberto Pozo"],
            "descripcion":"Una reunion para determinar el diseno del frontend"
        },
        {
            "id": 2,
            "titulo": "Daily",
            "hora":"22:00",
            "duracion":15,
            "asistentes": ["Jesus Cabanero","Victor Ramirez","German Rolando","Fatima Sanchez","Angel Villaseñor","Edilberto Pozo"],
            "descripcion":"Reunion daily para comentar el estado del proyecto"
        },
        {
            "id": 3,
            "titulo": "Revision del Sprint",
            "hora":"16:50",
            "duracion":120,
            "asistentes": ["Jesus Cabanero","Victor Ramirez","German Rolando","Fatima Sanchez","Angel Villaseñor","Edilberto Pozo"],
            "descripcion":"Reunion para ver los resultados del sprint"
        }
    ]
}
}

function getReunionesMes(numMes){
    return {
    "mes" : numMes,
    "ano" : 2020,
    "reuniones" : [05,12,17,21,26,27] }
}

function reunionesMesHoy(){ //Recibirá los días en los que hay reunión
	mesActual = hoy.getMonth() + 1;
	var info = {
        type : "PeticionReunionesMes",
		mes : mesActual,
		ano : annohoy
    };
    
    var data = {
        data : JSON.stringify(info),
        url : "peticionReuniones",
        type : "get",
        contentType: 'application/json',
        success : function(event) {
/*			var data = event.data;
			data = JSON.parse(data);
            escribirDiasConReunion(data);
			escribirDiasConReunion(reun);*/
            //Imaginemos que la recepción de los datos se hace correctamente y recibimos el json
        },
        error : function(response) {
            alert("Error en la petición de reuniones");
        }
    };
    $.ajax(data);
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
        url : "peticionDatosReunion",
        type : "get",
        contentType: 'application/json',
        success : function() {
            //Tendríamos la información de las reuniones de ese día
        },
        error : function(response) {
            alert("Error en la petición de reuniones");
        }
    };
    $.ajax(data);
}

function reunionesMes(mesConcreto,anoConcreto){ //Recibirá las reuniones de un mes concreto y las mostrará
	var info = {
        type : "PeticionReunionesMes",
		mes : mesConcreto,
		ano : anoConcreto
    };
    
    var data = {
        data : JSON.stringify(info),
        url : "peticionReuniones",
        type : "get",
        contentType: 'application/json',
        success : function() {
            //Mostraría los días que tienen reuniones
        },
        error : function(response) {
            alert("Error en la petición de reuniones");
        }
    };
    $.ajax(data);
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
        url : "peticionDatosReunion",
        type : "get",
        contentType: 'application/json',
        success : function() {
            // Tendríamos la información de las reuniones de ese día
        },
        error : function(response) {
            alert("Error en la petición de reuniones");
        }
    };
    $.ajax(data);
}

function escribirDiasConReunion(){
	
}