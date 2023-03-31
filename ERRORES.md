Principio de responsabilidad única:

El código original contaba con una sola interfaz que contenía todos los métodos.
Este hecho obligaba a las clases que implementaban esta interfaz a implementar
todos los metodos, provocando situaciones en las que una clase se ve obligada
a implementar métodos que no le corresponden. En consecuencia las clases contaban
con métodos que excedian su responsabilidad, incumpliendo este principio. 

Como solución a este problema he creado una nueva interfaz para la clase Directory y un grupo de interfaces 
para la clase File. Para esta última clase he divido la interfaz original en varios archivos, ya 
que puede darse la situación de que una clase que la implemente necesite solo leer archivos,
solo escribir o que solo necesite métodos adicionales como el que permite consultar la extension
de un archivo.

La clase file, contaba con dos métodos que permitían convertir archivos de audio. Sin
embargo esta clase parece más orientada a la lectura y escritura de archivos, por tanto 
estas funcionalidades exceden su resposanbilidad. 

Para solucionar este problema he creado una clase abstracta llamada FileConverter, esta clase
proveera de métodos comunes a otras clases que conviertan archivos. De la misma forma he creado
una nueva interfaz Converter Audio, que permitirá implementar métodos relacionados con la 
conversion de archivos de audio a las clases que lo necesiten.
Finalmente he creado una clase destinada a convertir ficheros de audio, que extiende de la clase abstracta e implementa dicha interfaz.

Principio de sustitución de Liskov:

Las clases File y Directory, lanzaban excepciones que la clase ascendente no lanzaba, con lo
que este principio no se cumplia. 

Para que se cumpla este principio tras refactorizar las interfaces, estas clases ya no necesitan
lanzar excepciones no contempladas ya que cuentan con los metodos que les corresponden.

Princio de segregación de interfaces:

Al estar estrechamente relacionado con el principio de responsabilidad única, este principio ya ha sido explicado
en gran medida. Para satisfacerlo, se han refactorizado las interfaces, de manera que las clases solo implementan
los métodos que necesitan.

Princio abierto/cerrado:

He modificado la función calculateSize de la clase FileManager y la he simplificado, anteriormente tenia if anidados que modificaban el comportamiento de la clase y la 
hacían más complicada de mantener.

Principio de inversion de depencias:

Originalmente la única interfaz del proyecto, estaba en el mismo paquete que el resto de clases, lo cual no es una buena
práctica. He creado un nuevo paquete llamado interfaces que agrupa todas las interfaces de proyecto. Sin embargo, no 
he logrado satisfacer el cumplimiento de este principio. En la clase FileSystemItemBase he hecho un casteo de un
objeto de la interfaz FileSystemItem a otro de la interfaz Directory lo cual provoca acoplamiento en el código.

