package practica.pkg1.memories.of.a.stone.smoker;

import java.util.regex.*;

/*
 *
 * @author diego
 */
public class Etiquetas {

    public boolean verificarEtiqueta(String cadena) {

        Pattern patronEtiqueta = Pattern.compile("^[a-zA-Z][a-zA-Z0-9_]*$");
        Matcher verificar = patronEtiqueta.matcher(cadena);
        if (verificar.find() == true && cadena.length() <= 8) {
            return true;
        } else {
            return false;
        }
    }

}// Fin de la clase