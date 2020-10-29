Feature: Calendario

    
 Scenario: Calendario mes correcto
 		When Consulta calendario  con el token ""
 		And con mes 2 y anio 3
 		Then la respuesta debe ser ""
 		
 Scenario: Calendario dia correcto 
 		When Consulta calendario  con el token ""
 		And con dia 1 mes 2 y anio 3
 		Then la respuesta debe ser ""

 Scenario: Calendario dia vacio
 		When Consulta calendario  con el token ""
 		And con dia 1 mes 2 y anio 3
 		Then la respuesta debe ser ""
 		
 Scenario: Calendario mes vacio 
 		When Consulta calendario  con el token ""
 		And con mes 2 y anio 3
 		Then la respuesta debe ser ""
 		
 Scenario: Calendario dia con token incorrecto
 		When Consulta calendario  con el token "incorrecto"
 		And con dia 1 mes 2 y anio 3
 		Then la respuesta debe ser ""
 		
 		
 Scenario: Calendario mes con token incorrecto
 		When Consulta calendario  con el token "incorrecto"  
 		And con mes 2 y anio 3
 		Then la respuesta debe ser ""
 		
Scenario: Calendario mes con mes vacio
		When Consulta calendario  con el token ""  
		And consulta calendario mes con "mes" vacio
		Then la respuesta debe ser "ERROR"
		
Scenario: Calendario mes con anio vacio
		When Consulta calendario  con el token ""
		And consulta calendario mes con "anio" vacio
		Then la respuesta debe ser "ERROR"		
		
Scenario: Calendario mes con valores vacios
		When Consulta calendario  con el token ""  
		And consulta calendario mes con "todo" vacio
		Then la respuesta debe ser "ERROR"
		
Scenario: Calendario dia con dia vacio
		When Consulta calendario  con el token ""  
		And consulta calendario dia con "dia" vacio
		Then la respuesta debe ser "ERROR"
		
Scenario: Calendario dia con mes vacio
		When Consulta calendario  con el token ""  
		And consulta calendario dia con "mes" vacio
		Then la respuesta debe ser "ERROR"
		
Scenario: Calendario dia con anio vacio
		When Consulta calendario  con el token ""  
		And consulta calendario dia con "anio" vacio
		Then la respuesta debe ser "ERROR"
		
Scenario: Calendario dia con diaYmes vacio
		When Consulta calendario  con el token ""  
		And consulta calendario dia con "diaYmes" vacio
		Then la respuesta debe ser "ERROR"

		
Scenario: Calendario dia con diaYanio vacio
		When Consulta calendario  con el token ""  
		And consulta calendario dia con "diaYanio" vacio
		Then la respuesta debe ser "ERROR"
		
Scenario: Calendario dia con mesYanio vacio
		When Consulta calendario  con el token ""  
		And consulta calendario dia con "mesYanio" vacio
		Then la respuesta debe ser "ERROR"
		
Scenario: Calendario dia con todo vacio
		When Consulta calendario  con el token ""  
		And consulta calendario dia con "todo" vacio
		Then la respuesta debe ser "ERROR"
		

		
		

    