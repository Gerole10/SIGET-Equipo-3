package es.uclm.esi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "/tareas")
public class EjemploRestController {

 @GetMapping(value= "/saludo")
public String saludo() {
return "test";
}

}
