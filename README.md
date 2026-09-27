# Tarea 05 - Detector de Primos

Módulo: Programación de Servicios y Procesos  
Curso: 2026-2027

Se han realizado los cuatro niveles solicitados en la práctica (Niveles 1, 2, 3 y 4).

## Estructura del Código

Main.java  
Contiene el método main para iniciar la aplicación llamando a la clase Interfaz.

Interfaz.java  
Gestiona la entrada por consola del usuario. Pide el nivel a ejecutar (1, 2, 3 o 4) y mantiene un bucle solicitando entradas hasta que se escribe la palabra salir.

Lanzador.java  
Contiene la lógica para ejecutar el comando factor de Linux utilizando ProcessBuilder:

caso1:Crea un proceso con ProcessBuilder para ejecutar factor pasando la entrada recibida. Utiliza redirectErrorStream(true) para unificar la salida estándar y la salida de error en un mismo flujo. Captura e imprime por pantalla el resultado del comando y finalmente espera a que el proceso termine con waitFor() para devolver su código de salida (0 si fue exitoso o 1 si hubo error).

caso2: Lee los flujos de salida y error por separado, mostrando cada línea precedida por [OK] o [ERROR].

caso3: Redirige la salida a factor_output.log y los errores a factor_error.log (creados automáticamente en la raíz del proyecto) y muestra solo el código de salida.

caso4: Muestra la salida del comando y analiza si el número es primo.

## Tabla de Pruebas

Resultados obtenidos al probar las entradas indicadas en las especificaciones:

| Valor | Salida de factor | Código de salida |
|---|---|---|
| 360 | 360: 2 2 2 3 3 5 | 0 |
| 1 | 1: | 0 |
| 17 | 17: 17 | 0 |
| hola | factor: 'hola' is not a valid positive integer | 1 |
| -5 | factor: invalid option -- '5' | 1 |


## Error Encontrado y Solución

Error: Al principio se intentaba validar la entrada en Java usando Integer.parseInt() antes de llamar al comando factor. Esto provocaba que las cadenas no numéricas (como hola o -5) lanzaran una excepción en Java en lugar de permitir que el comando nativo de Linux procesara el argumento y generara la salida de error adecuada en stderr.

Solución: Se eliminó el parseo manual en Java, pasando directamente el argumento introducido a ProcessBuilder("factor", numero). De esta forma, el subproceso Linux gestiona el error y devuelve el código de salida correspondiente (1).


## Archivos de Log (Nivel 3)

Al ejecutar el Nivel 3, se generan o actualizan los siguientes archivos en la raíz del proyecto:

### factor_output.log

360: 2 2 2 3 3 5
1:
17: 17