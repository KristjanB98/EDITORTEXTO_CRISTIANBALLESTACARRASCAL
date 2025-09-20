/*
 *Elaborado por: Cristian Ballesta Carrascal
 */

import java.util.ArrayList;
import java.util.Scanner;

/*
Implementar la estructura de pila manualmente en Java
Incluir las operaciones fundamentales:
push(), pop(), peek(), isEmpty().
Class Pilas<T>
Lo usamos para crear una pila tipo LIFO usando ArrayList
 */
class Pilas<T> {
    private ArrayList<T> datos = new ArrayList<>();

    // Insertar elementos
    void push(T valor) {
        datos.add(valor);
    }

    // Elimina y devuelve un valor de la pila
    T pop() {
        return datos.isEmpty() ? null : datos.remove(datos.size() - 1);
    }

    // Mostrar el último elemento
    T peek() {
        return datos.isEmpty() ? null : datos.get(datos.size() - 1);
    }

    // Saber si la pila está vacía
    boolean isEmpty() {
        return datos.isEmpty();
    }

    // Depurar la pila
    void clear() {
        datos.clear();
    }
}

/*
Implementar el menú en consola con opciones:
1. Escribir texto
2. Deshacer
3. Rehacer
4. Mostrar texto actual - Elemento en la cima (peek)
5. Salir
 */
class EditorTexto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Crear pilas
        Pilas<String> pila1 = new Pilas<>();
        Pilas<String> pila2 = new Pilas<>();

        int opcion;

        // Bucle menú principal
        do {
            System.out.println("**** Menú ****");
            System.out.println("1. Escribir texto");
            System.out.println("2. Deshacer elemento");
            System.out.println("3. Rehacer elemento");
            System.out.println("4. Mostrar texto actual");
            System.out.println("5. Salir");
            System.out.print("Ingrese la opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    // Opción escribir texto:
                    System.out.print("Texto: ");
                    String t = sc.nextLine();
                    pila1.push(t);
                    pila2.clear(); // al escribir algo nuevo, se limpia la pila de rehacer
                    break;

                case 2:
                    // Opción deshacer → mover de pila1 a pila2
                    String d = pila1.pop();
                    if (d != null) pila2.push(d);
                    else System.out.println("No hay elementos por deshacer");
                    break;

                case 3:
                    // Opción rehacer → mover de pila2 a pila1
                    String r = pila2.pop();
                    if (r != null) pila1.push(r);
                    else System.out.println("Ya no hay elementos para rehacer");
                    break;

                case 4:
                    // Mostrar texto actual
                    String actual = pila1.peek();
                    System.out.println("Texto actual: " + (actual != null ? actual : "(vacío)"));
                    break;
            }
        } while (opcion != 5);

        sc.close();
        System.out.println("Muchas gracias");
    }
}