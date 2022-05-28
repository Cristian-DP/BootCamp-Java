### BootCamp Java 2022

- [x] Thread
	- [x] Mostrar numeros
	- [x] Suma de numeros pares
	- [x] Suma de numeros impares
- [X] Streams & Lambdas
	- [X] Clase Alumno
	- [X] Listar Alumnos
	- [X] Ordenar Alumnos
	- [X] Listar Alumnos que inicien con carcacter dado
	- [X] La suma de las edades
	- [X] Mapa [Nota]:[listaDeAlumnos]

## Threads

1) Mostrar los numeros del 1 al 20 con un retardo de 3 segundos entre cada numero
2) Generar un Thread o una Implementacion de Runnable que imprima numeros pares (1 al 10) y calcule la suma.  
Lanzar junto a otro Thread o Runnable que imprima impares (1 al 10) y calcula la suma.  
Cada Thread muestra la suma resultante cuando finaliza.  
Utilizar las pausas necesarias para que se observe el paralelismo.

## Streams & Lambdas

Defina la clase Alumno con los siguientes campos:
int id
string dni
string nombre
string apellido
string curso
double nota
int edad

Cree un Lista y carge un numero considerable de alumnos para que el ejercicio sea viable (15 o mas) con valores a azar.

a) Muestre todos los alumnos de la lista
b) Muestre todos los alumnos ordenados de menor a mayor por edad
c) Muestre aquellos alumnos cuyo nombre empieza con un caracter dado (elegir el caracter en base a la lista de nombre que se utilizo)
d) Sume la edad de todos los alumnos
e) Obtenga un mapa donde la clave sea la nota y el valor sea una lista de alumnos que tienen esa nota
