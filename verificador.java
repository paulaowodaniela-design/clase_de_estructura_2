// Aquí definimos qué datos guarda cada "ficha" de nuestra pila
// No solo guardamos el símbolo, sino también su ubicación (línea y columna)
// para poder avisarle al usuario exactamente dónde se equivoco
class Nodo {
    String simbolo;
    int linea;
    int columna;
    Nodo siguiente;

    // constructor
    public Nodo(String simbolo, int linea, int columna) {
        this.simbolo = simbolo;
        this.linea = linea;
        this.columna = columna;
        this.siguiente = null;
    }
}

// Esta clase gestiona cómo se apilan y se sacan los nodos.
// Es una estructura LIFO (Last In, First Out): el último en entrar es el primero en salir
class Pila {
    // creamos este nodo para ver la cima de la pila
    Nodo cima;
    //esta linea para saber si la pila esta vacia
    public boolean isEmpty() {
        return cima == null;
    }
    //Ponemos un nodo nuevo encima y lo conectamos con el anterior
    public void push(String s, int l, int c) {
        Nodo nuevo = new Nodo(s, l, c);
        nuevo.siguiente = cima;
        cima = nuevo;
    }

    public Nodo peek() {
        if (isEmpty()) {
            throw new RuntimeException("No puedo hacer peek, la pila está vacía");
        }
        return cima;
    }
    //Quitamos el de arriba y movemos la 'cima' al de abajo
    public Nodo pop() {
        // si la pila esta vacia lanzara el if ya que el throw new crea una exception
        if (isEmpty()) {
            throw new RuntimeException("Error! La pila está vacía ");
        }
        Nodo auxNodo = cima;
        cima = cima.siguiente;
        return auxNodo;

    }
}

public class verificador {
    // Solo devuelve 'true' si el símbolo de apertura coincide con el de cierre
    public static boolean Pareja(String open, String close) {
        //Parentesis
        if (open.equals("(") && close.equals(")")) {
            return true;
        }
        //Corchetes
        if (open.equals("[") && close.equals("]")) {
            return true;
        }
        //Llaves
        if (open.equals("{") && close.equals("}")) {
            return true;
        }

        // Si no entró a ninguno de los anteriores, NO son pareja
        return false;
    }

    public static void main(String[] args) {
        String codigo = "([])";

        Pila miPila = new Pila();// Creamos la pila para ir guardando las aperturas

        for (int i = 0; i < codigo.length(); i++) {
            // esta linea ayuda al verificador a guardar el caracter y el char sirve
            // para buscar el simbolo en la pocicion i
            char simbolo = codigo.charAt(i);
            System.out.println("se ingreso un simbolo " + simbolo + " en la posicion " + i);

            // aqui vamos a guardar el simbolo de apertura
            if (simbolo == '(' || simbolo == '[' || simbolo == '{') {
                // aqui en pila guaradamos el simbolo pero tambien lo comvertimos en un texto ya
                // que esta tipo char
                // y se vuelve en string, tambien notifica en que linea esta y en que posicion
                // par que no diga 0 si no 1
                miPila.push(String.valueOf(simbolo), 1, i + 1);
                System.out.println("Guardado en la pila: " + simbolo);
            }

            // si es cierre validamos
            else if (simbolo == ')' || simbolo == ']' || simbolo == '}') {
                // revisa si la pila esta vacia
                if (miPila.isEmpty()) {
                    System.out.println("error se encontro este simbolo " + simbolo + "pero no se a abierto");
                    return;// y se detiene porque ya encontro un error
                }

                // si la pila no esta vacia sacara el de arriba para comparar
                Nodo ultimo = miPila.pop();
                // aqui lo que hacemos es comparar si el simbolo con el que se abre es igual con
                // el que se cierra
                if (!Pareja(ultimo.simbolo, String.valueOf(simbolo))) {
                    System.out.println(
                            "errror el cierre " + simbolo + " no es el mismo que con que se abrio " + ultimo.simbolo);
                    return;
                }
            }
        }
    }
}
