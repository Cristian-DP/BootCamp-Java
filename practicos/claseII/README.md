### BootCamp Java 2022

- [X] Entero capicua
- [X] Factorial
- [X] Decimal a Binario
- [] Binario a Decimal

## Entero Capicua
*Construir un metodo que reciba un entero como parametro y devuelva boolean indicando si es capicua o no dicho numero.*

Recordemos que **capicúa** se refiere a cualquier numero que se lee igual de izquierda a derecha que de derecha a izquierda. Ejemplos: 1221, 52125

Para su resolución se procedió como sigue

1. Se recibe una variable int
2. La variable int es convertida a un array de string
3. Se lee el array tanto de izquiera a derecha como de derecha a izquierda
	3.1. Mientras que las lecturas sean iguales, sigo.
	3.2. Si la lecturas son distintas, retorno **false**.
4. Cuando los indices coinciden y se cumplieron todas las igualdades, retorno **true**. 

## Factorial
*Construir un Metodo que recibe un entero y devuelve el factorial del mismo.*

El factorial de un entero positivo "n" se define en principio como el producti de todos los números enteris positivos desde 1 hasta "n".

## Decimal a Binario
*Construir un Metodo que recibe un entero en formato decimal y devuelve un double en formato binarios.*

Para su resolucion, se usó el metodo de devidir por 2 el numero entero e ir guardando el resto. Este resto es el valor que formará parte del binario final.
**No contempla numeros negativos**
## Binario a Decimal
Construir un Metodo que recibe un double en formato binario y devuelve un int en formato decimal.
