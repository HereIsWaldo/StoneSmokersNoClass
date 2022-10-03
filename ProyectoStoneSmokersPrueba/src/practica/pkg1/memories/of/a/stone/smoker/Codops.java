package practica.pkg1.memories.of.a.stone.smoker;

import java.util.regex.*;

public class Codops {

    public boolean verificarCodop(String cadena) {

        Pattern patronCodop = Pattern.compile("^[a-zA-Z][.a-zA-Z]*\\D$");
        Matcher verificar = patronCodop.matcher(cadena);
        if (verificar.find() == true && puntosDeCodop(cadena) < 2 && cadena.length() < 6) {

            return true;

        } else {
            return false;
        }

    }

    public int puntosDeCodop(String cadenaCodop) {

        char[] arregloDeCadena;
        int contador = 0;
        arregloDeCadena = cadenaCodop.toCharArray();

        for (int j = 0; j < arregloDeCadena.length; j++) {
            if (arregloDeCadena[j] == '.') {
                contador++;
            }
        }
        return contador;
    }

}
