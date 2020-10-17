package es.uclm.esi.model;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class Pruebas {

	public static void main(String[] args) {
		System.out.println(alfanum("por ejemplo")? "Sí que es alfanumérico":"No es alfanumérico");
		
		String s = "some text";
		boolean hasNonAlpha = StringUtils.isAlphanumeric(s); //true if only contains letters or digits, and is non-null wo spaces
	}

	public static boolean alfanum(String contra) {
        if(StringUtils.isAlphanumeric(contra))
        	return true;
		return false;
	}
}
