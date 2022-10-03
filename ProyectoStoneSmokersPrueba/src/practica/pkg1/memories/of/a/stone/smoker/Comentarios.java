package practica.pkg1.memories.of.a.stone.smoker;

/**
 * Clase para validar comentarios
 */

public class Comentarios {
    /**
     * Funcion booleana retorna true cuando la linea actual cargada en el buffer
     * inicia con ;
     * 
     * @param palabraActual
     * @return
     */
    public static boolean validarComentario(String lineaActual) {
        if (lineaActual.startsWith(";")) {
            return true;
        }
        return false;
    }

    /**
     * Funcion que valida que el comentario no exceda la cantidad de caracteres, en
     * caso de que si, muestra mensaje y termina el programa
     * Si el comentario tiene mas de 81 caracteres retorna false
     * 
     * @param textoDeLineaActual
     */
    public static boolean medirComentario(String lineaActual) {
        if (lineaActual.startsWith(";") && lineaActual.length() > 81) {

            return false;
        }
        return true;
    }

}
