package practica.pkg1.memories.of.a.stone.smoker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author waldi
 */
public class Practica1MemoriesOfAStoneSmoker {

    // INSTANCIACION DE CLASES

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */

    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileReader lectorDeArchivo = new FileReader(
                "C:\\Users\\waldi\\Documents\\NetBeansProjects\\New Folder\\Clon Practica1\\New Folder\\practica-1-memories-of-a-stone-smoker\\Practica-1-memories-of-a-stone-smoker\\src\\practica\\pkg1\\memories\\of\\a\\stone\\smoker\\P1ASM.txt");
        FileReader lectorDeArchivoAux = new FileReader(
                "C:\\Users\\waldi\\Documents\\NetBeansProjects\\New Folder\\Clon Practica1\\New Folder\\practica-1-memories-of-a-stone-smoker\\Practica-1-memories-of-a-stone-smoker\\src\\practica\\pkg1\\memories\\of\\a\\stone\\smoker\\P1ASM.txt");

        try {// TRY-CATCH PARA LEER EL ARC HIVO
            String lineaActual;
            BufferedReader lectorDeBuffer = new BufferedReader(lectorDeArchivo);
            BufferedReader lectorDeContador = new BufferedReader(lectorDeArchivoAux);
            String auxContLines;
            int lineasTotales = 0;// Num
            while ((auxContLines = lectorDeContador.readLine()) != null) {
                lineasTotales++;
            }
            lineasTotales++;
            int contadorDeLineas = 1;// Contador que va de 1 en 1 para verificar en que linea estamos
            int numeroDeErrores = 0;// Contador de errores
            int[] errores = new int[lineasTotales];// Arreglo en el que se guarda el numero de linea donde sucedio el
                                                   // error
            boolean bandera = true;

            String aux;// Auxiliar para el tokenizer

            String[][] estructura = new String[3][lineasTotales];// Arreglo donde se guardan las palabras que se
                                                                 // encuentran

            int opc = 0;// variable para realizar case en el switch14
            while ((lineaActual = lectorDeBuffer.readLine()) != null && bandera == true) {// WHILE QUE LEE EL TEXTO
                                                                                          // LINEA POR LINEA

                Comentarios comen = new Comentarios();
                Codops cod = new Codops();
                Etiquetas etique = new Etiquetas();
                Operandos oper = new Operandos();

                if (lineaActual.isBlank()) {
                    lineaActual = "\n";
                }

                StringTokenizer palabra = new StringTokenizer(lineaActual, " ");

                if (comen.validarComentario(lineaActual)) {// SI LA LINEA INICIA CON UN ; EL SWITCH IRA AL CASE 1
                    opc = 1;
                } // fin del if
                if (primeraLetra(lineaActual) == true) {// SI LA LINEA INICIA CON UNA LETRA EL SWITCH IRA AL CASE 2
                    opc = 2;
                } // fin de if
                if (comen.validarComentario(lineaActual) == false && primeraLetra(lineaActual) == false) {// SI LA LINEA
                                                                                                          // INICIA CON
                                                                                                          // UN ESPACIO
                                                                                                          // EN BLANCO
                                                                                                          // EL SWITCH
                                                                                                          // IRA AL CASE
                                                                                                          // 3
                    opc = 3;
                } // fin del if

                switch (opc) {// INICIO DEL SWITCH

                    case 1:
                        if (comen.medirComentario(lineaActual) == true) {
                            estructura[0][contadorDeLineas] = lineaActual;

                        } else {
                            numeroDeErrores++;
                            errores[numeroDeErrores] = contadorDeLineas;
                        }

                        break;
                    case 2:

                        aux = palabra.nextToken();
                        if (etique.verificarEtiqueta(aux) == true) {// Si es una etiqueta la verifica y la pone en el
                                                                    // arreglo
                            estructura[0][contadorDeLineas] = aux;
                            aux = palabra.nextToken();
                            if (cod.verificarCodop(aux) == true) {// verifica el codop
                                estructura[1][contadorDeLineas] = aux;

                                if (palabra.hasMoreTokens()) {// Si encuentra mas palabras despues del codop es un
                                                              // operando
                                    aux = palabra.nextToken();
                                    estructura[2][contadorDeLineas] = aux;
                                }

                            } else {
                                numeroDeErrores++;
                                errores[numeroDeErrores] = contadorDeLineas;
                            } // Fin del segundo if

                        } else {
                            numeroDeErrores++;
                            errores[numeroDeErrores] = contadorDeLineas;
                        } // Fin del primer if

                        break;

                    case 3:

                        aux = palabra.nextToken();
                        if (cod.verificarCodop(aux) == true || lineaActual.isBlank()) {
                            if (lineaActual.isBlank()) {
                                estructura[1][contadorDeLineas] = null;
                            } else {
                                estructura[1][contadorDeLineas] = aux;
                                while (palabra.hasMoreTokens()) {

                                    aux = palabra.nextToken();
                                    estructura[2][contadorDeLineas] = aux;
                                }
                            }
                        } else {
                            numeroDeErrores++;
                            errores[numeroDeErrores] = contadorDeLineas;
                        }

                        break;

                    case 4:

                        estructura[0][contadorDeLineas] = null;
                        estructura[1][contadorDeLineas] = null;
                        estructura[2][contadorDeLineas] = null;

                        break;

                }// FIN DEL SWITCH

                if (lineaActual.contains("End")) {

                    bandera = false;
                }

                contadorDeLineas++;
            } // FIN DEL WHILE

            for (int i = 1; i < contadorDeLineas; i++) {// FOR PARA IMPRIMIR EL CONTENIDO DE LAS LINEAS
                System.out.println("\nLinea: " + i);
                System.out.println("ETIQUETA: " + estructura[0][i]);

                System.out.println("CODOP: " + estructura[1][i]);

                System.out.println("Operando: " + estructura[2][i]);
            }

            if (errores[1] != 0 && contadorDeLineas == lineasTotales) {

                System.out.println("\nTienes errores en las linea/s: ");
                for (int i = 1; i <= numeroDeErrores; i++) {

                    System.out.println(errores[i]);
                }

            }
            if (errores[1] == 0 && contadorDeLineas == lineasTotales) {
                System.out.println("\nNo se encontraron errores");

            }
            lectorDeBuffer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } // FIN DEL TRY-CATCH

    }// FIN DEL MAIN

    /**
     * Metodo para validar si en la primera posicion de la linea hay una letra
     * si el primer caracter de una linea es una letra retorna true
     * 
     * @param cadena
     * @return
     */
    public static boolean primeraLetra(String cadena) {// Inicio de metodo
        Pattern patronCodop = Pattern.compile("^[a-zA-Z]");
        Matcher verificar = patronCodop.matcher(cadena);
        if (verificar.find() == true) {
            return true;
        } else {
            return false;
        } // fin de if else

    }// fin de metodo

}
