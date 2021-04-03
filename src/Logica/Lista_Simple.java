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

public class Lista_Simple {

    //Atributos
    private Nodo cabecera;
    private final BufferedReader reader;

    //Constructor
    public Lista_Simple() {
        cabecera = null;
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    //Método Adicionar al Final de la Lista
    public String adicionar(String nombres, String apellidos, String direccion, String email, int cedula, int edad, long telefono) {
        Nodo nuevo = new Nodo(nombres, apellidos, direccion, email, cedula, edad, telefono);
        if (isEmpty()) {
            cabecera = nuevo;
        } else {
            Nodo copiaCabecera = cabecera;
            /*
            * Recorre la lista hasta llegar al último Nodo
             */
            while (copiaCabecera.getSig() != null) {
                copiaCabecera = copiaCabecera.getSig();
            }
            /*
            * Agregamos el nuevo Nodo siguiente del último que encontramos
             */
            copiaCabecera.setSig(nuevo);
        }
        return ("\nSe ha agregado el Nodo exitosamente...\n");
    }

    //Método adicionar después de un Nodo por referencia
    public String adicionar(Nodo ref, String nombres, String apellidos, String direccion, String email, int cedula, int edad, long telefono) {
        if (isEmpty()) {
            return ("\nLa Lista debe tener por lo menos un elemento...\n");
        }
        if (buscar(ref)) {
            if (buscar(cedula) == null) {
                Nodo sigRef = ref.getSig();
                Nodo nuevo = new Nodo(nombres, apellidos, direccion, email, cedula, edad, telefono);
                ref.setSig(nuevo);
                nuevo.setSig(sigRef);
                return ("\nSe ha agregado el Nodo exitosamente...\n");
            }
            return ("\nLa persona ya está registrada...\n");
        }
        return ("\nEl nodo por referencia no existe...\n");
    }

    //Método adicionar después de una posición por referencia
    public String adicionar(int pos, String nombres, String apellidos, String direccion, String email, int cedula, int edad, long telefono) {
        if (isEmpty()) {
            return ("\nLa Lista debe tener por lo menos un elemento...\n");
        }
        if (pos > -1 && pos <= getTamanio()) {
            if (buscar(cedula) == null) {
                Nodo nuevo = new Nodo(nombres, apellidos, direccion, email, cedula, edad, telefono);
                Nodo encontrado = buscarP(pos);
                Nodo sigEncontrado = encontrado.getSig();
                encontrado.setSig(nuevo);
                nuevo.setSig(sigEncontrado);
                return ("\nSe ha agregado el Nodo exitosamente...\n");
            }
            return ("\nLa persona ya está registrada...\n");
        }
        return ("\nLa posición es incorrecta...\n");
    }

    //Método Eliminar al final de la lista
    public String eliminar() {
        if (isEmpty()) {
            return ("\nNo hay elementos en la lista...\n");
        }
        Nodo copiaCabecera = cabecera;
        while (copiaCabecera.getSig().getSig() != null) {
            copiaCabecera = copiaCabecera.getSig();
        }
        copiaCabecera.setSig(null);
        return ("\nEl Nodo se ha eliminado exitosamente...\n");
    }

    //Método Eliminar un Nodo por referencia
    public String eliminar(Nodo ref) {
        if (isEmpty()) {
            return ("\nNo hay elementos en la lista...\n");
        }

        if (buscar(ref)) {
            if (ref == cabecera) {
                cabecera = cabecera.getSig();
            } else {
                Nodo copiaCabecera = cabecera;
                while (copiaCabecera.getSig() != ref) {
                    copiaCabecera = copiaCabecera.getSig();
                }
                Nodo sigRef = ref.getSig();
                copiaCabecera.setSig(sigRef);
            }
            return ("\nEl Nodo se ha eliminado exitosamente...\n");
        }
        return ("\nEl Nodo no existe...\n");
    }

    //Método eliminar Nodo dada la posición
    public String eliminar(int pos) {
        if (isEmpty()) {
            return ("\nNo hay elementos en la lista...\n");
        }

        if (pos > -1 && pos <= getTamanio()) {
            Nodo encontrado = buscarP(pos);
            if (encontrado == cabecera) {
                cabecera = cabecera.getSig();
            } else {
                Nodo copiaCabecera = cabecera;
                while (copiaCabecera.getSig() != encontrado) {
                    copiaCabecera = copiaCabecera.getSig();
                }
                Nodo sigRef = encontrado.getSig();
                copiaCabecera.setSig(sigRef);
            }
            return ("\nEl Nodo se ha eliminado exitosamente...\n");
        }
        return ("\nLa posición es incorrecta...\n");
    }

    //Método menuActualizar
    private void menuActualizar(Nodo ref) throws IOException {
        int op = 0;
        String show = "";
        show += "\n1. Modificar Edad";
        show += "\n2. Modificar Nombres";
        show += "\n3. Modificar Apellidos";
        show += "\n4. Modificar Dirección";
        show += "\n5. Modificar Correo Eléctronico";
        show += "\n6. Modificar Teléfono";
        show += "\n7. No Modificar ningún valor";
        show += "\nSeleccione una opción: ";

        do {
            try {
                System.out.print(show);
                op = Integer.parseInt(reader.readLine());
                switch (op) {
                    case 1: {
                        System.out.print("\nIngrese la Edad: ");
                        String edad = reader.readLine();
                        ref.setEdad(Integer.parseInt(edad));
                        System.out.println("\nLa edad se ha actualizado exitosamente...\n");
                        break;
                    }
                    case 2: {
                        System.out.print("\nIngrese los nombres: ");
                        String nombres = reader.readLine();
                        ref.setNombres(nombres);
                        System.out.println("\nLos nombres se han actualizado exitosamente...\n");
                        break;
                    }
                    case 3: {
                        System.out.print("\nIngrese los apellidos: ");
                        String apellidos = reader.readLine();
                        ref.setApellidos(apellidos);
                        System.out.println("\nLos apellidos se han actualizado exitosamente...\n");
                        break;
                    }
                    case 4: {
                        System.out.print("\nIngrese la dirección: ");
                        String direccion = reader.readLine();
                        ref.setDireccion(direccion);
                        System.out.println("\nLa dirección se ha actualizado exitosamente...\n");
                        break;
                    }
                    case 5: {
                        System.out.print("\nIngrese el Correo Electrónico: ");
                        String email = reader.readLine();
                        ref.setEmail(email);
                        System.out.println("\nEl correo electrónico se ha actualizado exitosamente...\n");
                        break;
                    }
                    case 6: {
                        System.out.print("\nIngrese el número de teléfono: ");
                        String telefono = reader.readLine();
                        ref.setTelefono(Long.parseLong(telefono));
                        System.out.println("\nEl número de Teléfono se ha actualizado exitosamente...\n");
                        break;
                    }
                    case 7: {
                        break;
                    }
                    default: {
                        System.out.println("\nOpción Incorrecta...\n");
                    }
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("\nHa ingresado un dato no válido, por favor intente nuevamente...\n");
            }
        } while (op != 7);

    }

    //Método para modificar un Nodo
    public String actualizar() throws IOException {
        System.out.print("Ingrese la cédula del Nodo a actualizar: ");

        String cedula = reader.readLine();
        Nodo encontrado = buscar(Integer.parseInt(cedula));

        if (encontrado != null) {
            System.out.println("\nInformación del Nodo:\n" + listar(encontrado) + "\n");
            menuActualizar(encontrado);
            return ("");
        }
        return ("\nEl Nodo no existe...\n");
    }

    //Método para calcular el total de elementos de la lista
    public int getTamanio() {
        Nodo copiaCabecera = cabecera;
        int cont = 0;

        while (copiaCabecera != null) {
            copiaCabecera = copiaCabecera.getSig();
            cont++;
        }

        return (cont);
    }

    //Método Buscar por Posición
    public Nodo buscarP(int posicion) {
        if (isEmpty()) {
            return (null);
        }
        int i = 0;
        Nodo copiaCabecera = cabecera;

        while (copiaCabecera != null) {
            if (i == posicion) {
                return (copiaCabecera);
            }
            i++;
            copiaCabecera = copiaCabecera.getSig();
        }
        return (null);
    }

    //Método Buscar por Cédula
    public Nodo buscar(int cedula) {
        Nodo copiaCabecera = cabecera;
        if (isEmpty()) {
            return (null);
        }
        while (copiaCabecera != null) {
            if (copiaCabecera.getCedula() == cedula) {
                return (copiaCabecera);
            }
            copiaCabecera = copiaCabecera.getSig();
        }
        return (null);
    }

    //Método Buscar por Nodo
    public boolean buscar(Nodo ref) {
        Nodo copiaCabecera = cabecera;
        if (isEmpty()) {
            return (false);
        }
        while (copiaCabecera != null) {
            if (copiaCabecera == ref) {
                return (true);
            }
            copiaCabecera = copiaCabecera.getSig();
        }
        return (false);
    }

    //Método Vacio
    public boolean isEmpty() {
        if (cabecera == null) {
            return (true);
        }
        return (false);
    }

    //Método Listar
    public String listar() {
        if (cabecera == null) {
            return ("\nNo hay elementos en la lista...\n");
        }
        Nodo copiaCabecera = cabecera;
        String show = "";
        int pos = 0;
        while (copiaCabecera != null) {
            show += "\nPosición del Nodo en la Lista: " + pos;
            show += "\nNombres: " + copiaCabecera.getNombres();
            show += "\nApellidos: " + copiaCabecera.getApellidos();
            show += "\nCédula: " + copiaCabecera.getCedula();
            show += "\nEdad: " + copiaCabecera.getEdad();
            show += "\nDirección: " + copiaCabecera.getDireccion();
            show += "\nE-mail: " + copiaCabecera.getEmail();
            show += "\nTeléfono: " + copiaCabecera.getTelefono();
            show += "\n__________________________________________________\n";
            copiaCabecera = copiaCabecera.getSig();
            pos++;
        }
        return (show);
    }

    //Método Mostrar Nodo
    public String listar(Nodo ref) {
        String show = "";
        show += "\nNombres: " + ref.getNombres();
        show += "\nApellidos: " + ref.getApellidos();
        show += "\nCédula: " + ref.getCedula();
        show += "\nEdad: " + ref.getEdad();
        show += "\nDirección: " + ref.getDireccion();
        show += "\nE-mail: " + ref.getEmail();
        show += "\nTeléfono: " + ref.getTelefono();
        return (show);
    }

    public Nodo getCabecera() {
        return (cabecera);
    }

}
