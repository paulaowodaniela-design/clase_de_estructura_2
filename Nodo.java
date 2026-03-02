

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
    public Nodo pop(){
        //si la pila esta vacia lanzara el if ya que el throw new crea una exception
        if (isEmpty()){
            throw new RuntimeException("Error! La pila está vacía ");
        }
        Nodo auxNodo = cima;
        cima = cima.siguiente;
        return auxNodo;

    }
    public class verificador{
        public static void main(String[] args){
            String codigo = "([])";
            for(int  i = 0; i < codigo.length(); i++){
                //esta linea ayuda al verificador a guardar el caracter y el char sirve
                // para buscar el simbolo en la pocicion i
            char simbolo = codigo.charAt(i);
             System.out.println("El detective ve en la posicion " + i + " un: " + simbolo);
            
             else if (simbolo == ')' || simbolo == ']' || simbolo == '}'){
                String pila;
                if (pila.isEmpty()){
                    System.out.println("error se encontro este simbolo " + simbolo + "pero no se a abierto");
                    return;
                }
             }
            }
        }
    }
}
