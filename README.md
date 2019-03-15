
# Proyecto TP7 de Jose Luis Quintanilla y Andrés Delgado

En este proyecto ampliamos la clase Compra y añadimos persistencia de datos en forma de Base de Datos y archivos de texto plano con formato de Tickets.


# Necesitas.

Para la ejecución del proyecto es necesario la librería *.jar de SQLite. Se incluye en el proyecto GitHub.

## Ejecución

Para la ejecución de este proyecto en un primer momento necesitas compilar los códigos.
Desde el directorio principal escribes:
En Windows:

    javac -cp .;sqlite-jdbc-3.25.2.jar;Codigo/*;Clases/*;. App.java

Una vez completado para ejecutar se escribe:

    java -cp .;sqlite-jdbc-3.25.2.jar;Codigo/*;Clases/*;. App

Esto lanzara el programa y comenzaremos con su uso.

## Usos

El programa permite identificarse como usuario registrado o, si este no fuera el caso, registrarse como nuevo usuario.
Si se trata de un nuevo usuario te pedirá que introduzcas los datos requeridos y los guardará en una Base de Datos.
Si se trata de un usuario previamente registrado te pedirá que te identifiques e introduzcas tu contraseña y comparara los datos introducidos con los guardados en la Base de Datos. Si son correctos procederá a la tienda de productos.
En la tienda muestra una lista de productos almacenados en una Base de Datos, mostrando su nombre y precio. En esta sección el programa ademas de ofrecer el acceso a la sección del carrito o la opción de salir del programa, te permite elegir entre los diferentes productos mediante un identificador numérico. Si eliges un producto muestra el producto elegido y te pide que introduzcas la cantidad.

Al acceder al carrito te permite vaciarlo y volver a empezar, salir del programa o finalizar la compra. Esto último realizará un guardado de los datos de la compra en una Base de Datos además de producir un archivo *.txt con formato de Ticket.

## Casos de Fallo

En la creación de usuario nuevo no está controlado si se introduce un nombre de usuario que ya registrado en la Base de Datos.
