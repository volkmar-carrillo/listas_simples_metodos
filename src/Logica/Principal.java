/**
 * Métodos de Listas Simples enfocados en la información personal básica de una Persona
 *
 * Manejo de Listas Simples mediante Nodos_Apuntadores haciendo uno de estructuras de datos en poo y excepciones en Java
 *
 * By: Volkmar A Carrillo P
 * e-mail: carrillo.ramklov@gmail.com
 * fecha-publicación: 03/04/2021
 */
package Logica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal {

    public static void main(String[] args) throws IOException {
        int op = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Lista_Simple L1 = new Lista_Simple();

        String show = "";
        show += "\n1. Agregar Nodo a la Lista";
        show += "\n2. Actualizar Nodo de la Lista";
        show += "\n3. Eliminar Nodo de la Lista";
        show += "\n4. Mostrar Lista";
        show += "\n5. Salir";
        show += "\nSeleccione una opción: ";

        do {
            try {
                System.out.print(show);
                op = Integer.parseInt(reader.readLine());
                switch (op) {
                    case 1: {
                        System.out.print("\nIngrese los nombres: ");
                        String nombres = reader.readLine();

                        System.out.print("\nIngrese los apellidos: ");
                        String apellidos = reader.readLine();

                        System.out.print("\nIngrese la Edad: ");
                        int edad = Integer.parseInt(reader.readLine());

                        System.out.print("\nIngrese el número de Cédula: ");
                        int cedula = Integer.parseInt(reader.readLine());

                        System.out.print("\nIngrese la dirección: ");
                        String direccion = reader.readLine();

                        System.out.print("\nIngrese el Correo Electrónico: ");
                        String email = reader.readLine();

                        System.out.print("\nIngrese el número de teléfono: ");
                        long telefono = Long.parseLong(reader.readLine());

                        System.out.println(L1.adicionar(nombres, apellidos, direccion, email, cedula, edad, telefono));

                        System.out.println("\nEl Nodo se ha agredado Exitosamente...\n");
                        break;
                    }
                    case 2: {
                        System.out.println(L1.actualizar());
                        break;
                    }
                    case 3: {
                        System.out.println(L1.listar());
                        System.out.print("\nIngrese la posición del Nodo a Eliminar: ");
                        int pos = Integer.parseInt(reader.readLine());

                        System.out.println(L1.eliminar(pos));
                        break;
                    }
                    case 4: {

                        System.out.println(L1.listar());
                        break;
                    }
                    case 5: {
                        break;
                    }
                    default: {
                        System.out.println("\nOpción Incorrecta...\n");
                    }
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("\nHa ingresado un dato no válido, por favor intente nuevamente...\n");
            }
        } while (op != 5);

    }

}
