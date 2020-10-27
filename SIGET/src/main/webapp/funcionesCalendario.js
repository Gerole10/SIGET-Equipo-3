var hoy = new Date();

var reunionesDia = {
    "dia" : 26,
    "mes" : 10,
    "ano" : 2020,
    "reuniones" : {
        "R1" : {
            "id": 1,
            "titulo": "Frontend",
            "hora":"11:30",
            "duracion":90,
            "asistentes": ["Jesus Cabanero","Victor Ramirez","German Rolando","Fatima Sanchez","Angel Villaseñor","Edilberto Pozo"],
            "descripcion":"Una reunion para determinar el diseno del frontend"
        },
        "R2" : {
            "id": 2,
            "titulo": "daily",
            "hora":"22:00",
            "duracion":15,
            "asistentes": ["Jesus Cabanero","Victor Ramirez","German Rolando","Fatima Sanchez","Angel Villaseñor","Edilberto Pozo"],
            "descripcion":"Reunion daily para comentar el estado del proyecto"
        },
        "R3" : {
            "id": 3,
            "titulo": "Revision del Sprint",
            "hora":"16:50",
            "duracion":120,
            "asistentes": ["Jesus Cabanero","Victor Ramirez","German Rolando","Fatima Sanchez","Angel Villaseñor","Edilberto Pozo"],
            "descripcion":"Reunion para ver los resultados del sprint"
        }
    }
};



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