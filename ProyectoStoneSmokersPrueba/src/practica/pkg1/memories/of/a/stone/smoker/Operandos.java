package practica.pkg1.memories.of.a.stone.smoker;

import java.util.regex.*;

public class Operandos {

    /**
     * 
     * @param caracterDeLineaActual    para comprobar ubicación del determinante del
     *                                 operando.
     * @param posicionDeEtiquetaActual para probar que estamos en la primera
     *                                 posición.
     * @param SistemaNumerico          para determinar el sistema númerico con que
     *                                 se trabaja.
     * @return para validar un operador válido.
     */
    public boolean ValidarPrimerPosDeOperando(String caracterDeLineaActual, int posicionDeEtiquetaActual,
            int SistemaNumerico) {

        if (posicionDeEtiquetaActual == 1) {// Condición de primera posición

            boolean CaracterValidoEncontrado = Pattern.compile("[0-9%$@]").matcher(caracterDeLineaActual).matches();

            if (caracterDeLineaActual == "%" && CaracterValidoEncontrado == true) {// Binario será el sistema número 1
                                                                                   // en nuestro programa.
                SistemaNumerico = 1;
                return true;
            } else if (caracterDeLineaActual == "@" && CaracterValidoEncontrado == true) {// Octal será el sistema
                                                                                          // número 2 en nuestro
                                                                                          // programa.
                SistemaNumerico = 2;
                return true;
            } else if (caracterDeLineaActual == "$" && CaracterValidoEncontrado == true) {// Hexadecimal será el sistema
                                                                                          // número 3 en nuestro
                                                                                          // programa.
                SistemaNumerico = 3;
                return true;
            } else if (CaracterValidoEncontrado == true) {// Decimal será el sistema número 2 en nuestro programa.
                SistemaNumerico = 4;
                return true;
            }

        } // Cierre de condición de posición 1

        return false;// Retorno de false en caso de que el primer carácter no sea un iniciador válido
                     // de un operando.
    }// Cierre del método para validar inicio de operando.

    public boolean ValidarPosDeOperando(String caracterDeLineaActual, int SistemaNumerico) {// Método para validar
                                                                                            // carácteres de operandos

        if (SistemaNumerico == 1) {// Validador de binario
            boolean CaracterValidoEncontrado = Pattern.compile("[0-1]").matcher(caracterDeLineaActual).matches();
            return true;
        } else if (SistemaNumerico == 2) {// Validador de octal
            boolean CaracterValidoEncontrado = Pattern.compile("[0-7]").matcher(caracterDeLineaActual).matches();
            return true;
        } else if (SistemaNumerico == 3) {// Validador de hexadecimal
            boolean CaracterValidoEncontrado = Pattern.compile("[a-zA-Z0-9]").matcher(caracterDeLineaActual).matches();
            return true;
        } else if (SistemaNumerico == 4) {// Validador de decimal
            boolean CaracterValidoEncontrado = Pattern.compile("[0-9]").matcher(caracterDeLineaActual).matches();
            return true;
        }

        return false;// Retorno de falso si el caracter no se encuentra.
    }// Cierre de método para validar carácteres de operandos

}
