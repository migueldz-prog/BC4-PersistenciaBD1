--EJERCICIO 1--
Este ejercicio hace la prueba sobre si java se puede conectarse a oracle.
Usando DriverManager.getConnection, si se conecta muestra un mensaje y si no el catch maneja la exvepcion y da otro mensaje.
Este paso en fundamental y estara presente en todos los ejercicios a partir de ahora, para poder trabajar con sentencias sql.

--EJERCICIO 2--
Este ejercicio crea la tabla empleado, que usaremos mas tarde en otros ejercicios. Usamos createStatement y ejecutamos
el create table como si estuvieramos en sql, si todo ha ido bien sacara un mensaje confirmandolo y si no es asi el catch 
manejara la excepcion.

--EJERCICIO 3--
Este ejercicio imprime todos los datos que haya en la tabla empleado, por ello en la select usamos *, despues guardamos estos
resultados en variables con ResultSet pero en el while para que salgan todos los empleados y si algo sale mal el catch manejara la excepcion.

--EJERCICIO 4--
Este ejercicio nos pide insertar un nuevo empleado en la tabla, por lo que ejecutamos una sentencia insert, usamos PreparedStatement
y damos valores a las ? que hay en la sentecia, en el orden en el que estan los nombres de las columnas. Si todo ha ido bien se 
imprimira un mensaje confirmandolo y si no el catch manejara el excepcion.

--EJERCICIO 5--
Este ejercicio nos pide actualizar el salario de un empleado de la tabla empleado, por lo que usaremos un sentencia de update. Y rellenamos 
las ? de la select con el nuevo salario y el id .Para ver si realmente lo hemos cambiado se imprime el numero de filas actulizadas.
Si algo no ha ido bien el catch manejara al excepcion.

--EJERCICIO 6--
Este ejercicio pide eliminar una fila de la tabla empleado identificandola por el id, en este caso del empleado. Se usa una sentencia
delete y al final para ver si lo hemos hecho bien se imprime un mensaje con el numero de filas que hemos actualizado. Si algo no ha 
ido bien el catch manejara la excepcion.

--EJERCICIO 7--
Este ejercicio nos pide elaborar un menu CRUD, por lo que primero importamos el scanner para poder leer la opcion elegida por el 
usuario y esta opcion se declara como una variable de tipo int. Con el switch se elegira que setencia sql se ejecutara. 
Con la primera se inciara un bucle que mostrara toda la informacion de los empleados de la tabla, con la segunda se insertara un empleado como hemos
hecho antes en ele ejercicio 4, en la opcion 3 reutulizamos el codigo del ejercicio 5 ya que nos pide exactamente lo mismo y por ultimo
sucede los mismo con la opcion 4 y el ejercicio 6, eliminando un empleado por el id. 
Por ultimo si se introduce un 0 se sale del programa. Todos los case al terminar imprimen el numero de filas actualizadas/insertadas y tiene un break
para salir. Si algo no sale bien el catch controlara la excepcion.

--EJERCICIO 8--
Este ejercicio pide imprimi rlos nombres que contengan una letra en concreto, para ello se usa el LIKE en el select. Y despues
cuando rellenamos la ? de la sentencia sql ponemos % para que funcione en el formato de oracle. Esta select sacara los nombres y
con el while (rs.next()) imprimiremos todos. Si algo no fuera bien el catch controlaria la excepcion.

--EJERCICIO 9--
Este ejercicio nos pide hallar y mostrar la media de los salario de la tabla empleado, para esto usamos en al select 
AGV(salario), despues este numero lo introducimos en una variable y imprimos esta con un print. Si algo ha fallado el catch manejara la excepcion

--EJERCICIO 10--
Este ejercicio nos pide que insertemos varios empleado a la vez en la tabla y si falla alguno realicemos un rollback. Para ello en primer lugar
hay que desactivar el autocommit, que por default esta activado, para poder hacer el rollback. Entonces con una select de insert en la tabla rellenamos 
las ? de la select con los datos de los nuevos empleados y si algo falla se hace un rollback y si todo va bien se hace un commit.

--EJERCICIO 11--
Este ejercicio nos pide mostrar los empleado en orden descendente en cuanto a su salario, por lo que con las sentecia sql y un  
order by salario desc, les tendremos. Despues les meteremos en las variables y con un bucle while imprimiremos todos. Si algo sale mal
el catch manejara el excepcion.

--EJERCICIO 13--
Este ejercicio nos pide la creacion de dos tablas, una de ellas  ya existia por lo que habria que borrarla primero para evitar errores, la de empleado. 
Usaremos sentencias sql de create table con los campos indicados y poniendo la primary key.
Cuando se hayan creado se imprimira un mensaje indicandolo y si no el catch controlara la excepcion generada.

--EJERCICIO 14--
Este ejercicio pide rellenar de datos las tablas generadas en el anterior. Primero insertamos departamentos ya que los empleados de 
despues deberan pertenecer a alguno, con las consultas de insert into y damos valores a las ? puestas. Si todo ha ido bien se imprimira el 
mensaje confirmandolo, si no el catch manejara la excepcion.

--EJERCICIO 15--
Este ejrecicio nos pide sacar en pantalla el nombre del empleado con el nombre de su departamento, por lo que en la select donde sacamos los dos nombres 
cruzamos las tablas departamento y empleado con el id. Y para sacar los resultados de la select en el print primero les metemos en variables, sacaremos todos gracias al bucle.

--EJERCICIO 16--
Este ejercicio nos pide el nombre de los empleado de x departamento, relleno la ? de la select con el id del departamento y creamos la variable nombre para poder sacar los nombre en el print. 
Y si algo no funciona como deberia el catch controlara esa excepcion.

