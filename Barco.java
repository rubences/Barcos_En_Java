public class Barco {  
   private String tipo;  
   private int largo;  
   private int latitud;  
   private int longitud;  
   private boolean horizontal;  
   private int partesTocadas = 0;  
  
   private static char simboloTocado = 'x';  
  
   public static final int TOCADO = 1;  
   public static final int HUNDIDO = 2;  
  
   public Barco(String tipo, int largo) {  
       this.tipo = tipo;  
       this.largo = largo;  
   }  
  
   public Barco(String tipo, int largo, int latitud, int  
                                longitud, boolean horizontal) {  
       this(tipo, largo);  
       this.posicionar(latitud, longitud, horizontal);  
   }  
   public int getLargo() {  
       return this.largo;  
   }  
   public String getTipo() {  
       return this.tipo;  
   }  
   public void setTipo(String tipo) {  
       if (tipo.equals(""))  
           System.out.println("El tipo del barco  no puede ser vacío");  
       else  
           this.tipo = tipo;  
   }  
   public void posicionar(int latitud, int longitud, boolean  
                                                     horizontal) {  
       this.latitud = latitud;  
       this.longitud = longitud;  
       this.horizontal = horizontal;  
   }  
  
   public void posicionar(int latIni, int longIni, int latFin, int longFin) {  
       if(latIni == latFin) {  
           if(longFin - longIni +1 == this.largo) {  
               this.horizontal = true;  
               this.latitud = latIni;  
               this.longitud = longIni;  
           } else {  
              System.out.println("Las coordenadas de inicio y de " + "fin del tablero, no son coherentes con el tamaño del barco."); 
           }  
       } else {  
           if(longIni == longFin) {  
               if(latFin - latIni + 1 == this.largo) {  
                   this.horizontal = false;  
                   this.latitud = latIni;  
                   this.longitud = longIni;  
               } else {  
                   System.out.println("Las coordenadas de inicio y " + "de fin del tablero, no son coherentes con el tamaño del barco.");  
               }  
           } else {  
               System.out.println("El barco debe estar posicionado " +  
" vertical u horizontalmente.");  
           }  
       }  
   }  
  
   public boolean utiliza(int latitud, int longitud) {  
       return this.horizontal && this.latitud == latitud &&  
               this.longitud <= longitud && longitud <  
                           this.longitud + this.largo  
               || !this.horizontal && this.longitud == longitud &&  
               this.latitud <= latitud && latitud < this.latitud  
                                                     + this.largo;  
   }  
  
   public int probarDisparo(int latitud, int longitud) {  
       int ret = 0;  
       boolean alcanzado = utiliza(latitud, longitud);  
       if (alcanzado) {  
           this.partesTocadas++;  
           if (this.partesTocadas == this.largo)//getTamaño())  
               ret = Barco.HUNDIDO;  
           else  
               ret = Barco.TOCADO;  
       }  
       return ret;  
   }  
  
   public static void mostrarReglasPosicionamiento() {  
       System.out.println("Los barcos se deben ubicar" + 
"horizontal o verticalmente, pero nunca en diagonal.");  
       System.out.println("Los barcos no se pueden superponer. " +  
" Sin embargo, es posible que se toquen.");  
       System.out.println("Los barcos se deben ubicar " +  
" completamente dentro del tablero del juego de la guerra de barcos.");  
       System.out.println("Una vez posicionados, los barcos no " +  
" se pueden mover.");  
  
   }  
  
   public static char getSimboloTocado() {  
       return Barco.simboloTocado;  
   }  
  
   public static void setSimboloTocado(char simboloTocado) {  
       Barco.simboloTocado = simboloTocado;  
   }  
} 