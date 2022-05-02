### BootCamp Java 2022

-  [x] Clase Pila (Collection sin Queue/Deque)
-  [x] Clase Fila (Collection sin Queue/Deque)
-  [x] Clase Pila 
-  [x] Clase Fila 
-  [] Clase Arbol Binario
   -  [] inOrden 
   -  [] preOrden
   -  [] postOrden
-  [] Recursion
   -  [x] Factorial
   -  [] Producto
   -  [x] String invertido
-  [x] Consecutivos menores 

## Clase Nodo
Si bien esta clase no es requisito formal de la consigna, se decidió agregarla como un factor comun a todas las clase que luego se irán creando.

## Clase Pila (Collection sin Queue/Deque) - LIFO
Implementar la clase Pila (Utilizando una Collection que no implemente la interfaz Queue / Deque)

Una pila es una structura que nos permite apilar elementos y recopilarlos en el orden inverso. Esto se conoce como estructuras LIFO.
Una pila suele tener tres operaciones básicas
- push, añade elementos a la lista
- pop, retira elementos de la lista.
- empty, comprueba si la lista está vacia.

Esta pila es declarada como <T>, de forma generica.

## Clase Fila (Collection sin Queue/Deque) - FIFO
Implementar la clase Fila (Utilizando una Collection que no implemente la interfaz Queue / Deque)

## Clase Pila y Fila
Implementar las clases Pila y Fila sin utilizar Collections

## Clase Arbol Binario
Implementar la clase Arbol Binario con los 3 recorridos básicos (inOrden, preOrden y postOrden)

## Recursion Factorial
Recursion: Método factorial recursivo

## CRecursion Producto
Recursion: Calcular el producto de dos enteros sin utilizar multiplicación

## Recursion String invertido
Recursión: Método que recibe un String y lo devuelve invertido.

## Recursion consecutivos menores
NO OBLIGATORIO (Es para pensar): Metodo que devuelva un boolean indicando si esta formado por la suma de numeros consecutivos menores.
    Ej:
       firma --> boolean esSumatoriaDeConsecutivos(int value);

       esSumatoriaDeConsecutivos(3) = TRUE pq 3 = 2 + 1
       esSumatoriaDeConsecutivos(9) = TRUE pq 9 = 4 + 3 + 2

    Se puede implementar recursivo y iterativo.  Deseable contar con metodo que devuelva la lista de numeros que representan la suma.  Comparar performance de ambas implementaciones y sacar conclusiones.


## Referencias

https://docs.oracle.com/javase/tutorial/java/generics/genTypes.html