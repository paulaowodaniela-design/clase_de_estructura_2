import java.util.Stack;

class Nodo{
    String simbolo;
    int linea;
    int columna;
    Nodo siguiente;

    //constructor
    public Nodo(String simbolo, int linea, int columna){
        this.simbolo = simbolo;
        this.linea = linea;
        this.columna = columna;
        this.siguiente = null;
    }
}
class Pila{
    Nodo cima;

    public boolean isEmpty(){
      return cima == null;
    }

    public void push (String s, int l, int c){
        Nodo nuevo = new Nodo (s, l, c);
        nuevo.siguiente = cima;
        cima = nuevo;
    }
    public Nodo peek(){
        return cima; 
    }
}
