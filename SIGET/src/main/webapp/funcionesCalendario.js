var hoy = new Date();

function hola(cosa){
    console.log(cosa + " hoy es día " +hoy.getDate())
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