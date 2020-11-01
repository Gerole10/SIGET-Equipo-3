package es.uclm.esi.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;

@RestController
public class PruebaController {
	
	private static final JSONObject jso = new JSONObject();

	@RequestMapping(value = "/pruebaConexion", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    JSONObject pruebaConexion(JSONObject jsoentrada){
		System.out.println("Pues mira me ha llegao esto: "+jsoentrada);
		jso.put("hey", "hola");
        return jso;
    }
}
