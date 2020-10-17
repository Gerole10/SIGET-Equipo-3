package es.uclm.esi.model;

/**
 * La clase contiene distintas comprobaciones para la contrasena. Se ha programado de tal manera que se puedan ir llamando
 * a los métodos de uno en uno, devolviendo true en caso de que cumplan los requisitos y false en caso de que no para así
 * poder informar del fallo concreto de la contrasena al usuario.
 * @author German
 *
 */

public class PoliticaContraSegura {
	
	/**
	 * Metodo para comprobar que la contrasena tiene más de 8 caracteres
	 * @author German
	 * @param String
	 * @return boolean
	 */
	
	public static boolean caracteres(String contra) {
		if(contra.length() > 8)
			return true;
		return false;
	}
	
	/**
	 * Metodo para comprobar que la contrasena tiene, al menos, un número
	 * @author German
	 * @param String
	 * @return boolean
	 */
	
	public static boolean numero(String contra) {
		for(int i = 0; i < contra.length(); i++) {
			if(esNumerico(String.valueOf(contra.charAt(i))))
				return true;
		}
		return false;
	}
	
	/**
	 * Metodo para comprobar si es numerico
	 * @param String
	 * @return boolean
	 */
	
	public static boolean esNumerico(String str) {
	    try {
	        Double.parseDouble(str);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	/**
	 * Metodo para comprobar que tiene, al menos, una mayuscula
	 * @author German
	 * @param String
	 * @return boolean
	 */
	
	public static boolean mayuscula(String contra) {
		for(int i = 0; i < contra.length(); i++)
			if(Character.isUpperCase(contra.charAt(i))) 
				return true;
		return false;
	}
	
}
