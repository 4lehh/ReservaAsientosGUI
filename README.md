# Proyecto Final: Reserva de asientos de Buses.

## Tabla de Contenidos
- [Integrantes del grupo](#integrantes-del-grupo)
- [Requisitos](#requisitos)
- [Funcionamiento](#funcionamiento)
  - [Formulario](#formulario)
  - [Compras](#compras)
  - [Boletos](#boletos)
- [Patrones](#patrones)
- [Diagrama UML](#diagrama-uml)
- [Formulario Comprador](#formulario-comprador)
- [Seleccion de Buses](#seleccion-de-buses)
- [Compra de Asientos](#compra-de-asientos)
- [Boleto de Viaje](#boleto-de-viaje)
- [Decisiones durante el proyecto](#decisiones-durante-el-proyecto)
- [Dificultades durante el proyecto](#dificultades-durante-el-proyecto)


### Integrantes del grupo:
- [Oliver Isaías Peñailillo Sanzana](https://github.com/Zaiik03/ "Oliver Isaías Peñailillo Sanzana")
- [Matias Ignacio Garcia Padilla](https://github.com/Matygp "Matias Ignacio Garcia Padilla")
- [Javier Alejandro Campos Contreras](https://github.com/huebitoo "Javier Alejandro Campos Contreras")


### Requisitos
Antes de empezar a utilizar el programa, se deberá de instalar unas librerias que estan dentro del mismo repositorio. Dichas librerias son 'jcalendar-1.4.jar, jgoodies-common-1.2.0.jar, jgoodies-looks-2.4.1.jar y junit-4.6.jar' para el correcto funcionamiento de la interfaz.
Estas librerias son las encargadas del manejo de las fechas y una forma mas estetica de mostrar un calendario.

[![JCal](https://github.com/huebitoo/ReservaAsientosGUI/blob/main/src/main/resources/ImagenesReadMe/Jcalendar.png "JCal")](https://github.com/huebitoo/ReservaAsientosGUI/blob/main/src/main/resources/ImagenesReadMe/Jcalendar.png "JCal")


### Funcionamiento
**Pasos:**
1. ### Formulario
   Antes de ser parte de un viaje, es importante poder saber quien va a comprar el boleto, cual es su ruta de destino y la fecha en la que desea viajar.
    
3. ### Compras
   Una vez habiendo decidido la ruta de viaje, se le dispondra una cantidad de buses dsiponibles para ese día (Tambien puede comprar un boleto para un bus que viaje el mismo día) donde los buses se diferencian por su tamaño (uno o dos pisos). Una vez seleccionas el bus, puedes escoger que asiento te gusta y gustas usar ademas de que cada asiento tiene su precio adicional.
4. ### Boletos
   Cuando ya te decides en que asiento viajar, al momento de comprar el boleto, se te entregará un boleto con los datos de viaje, el asiento y la fecha de viaje. Además, tu boleto quedará guardado en HistorialBoletos


### Patrones
Los patrones utilizados a los largo del desarrollo fueron elegidos dependiendo la necesidad del proyecto y el que mas se nos acomodara. Utilizamos el patron Factory para la creacion de multiples paneles así tambien como para la creacion de las rutas. La razon por la cual decidimos usar el patron Factory fue por la enorme cantidad de lineas de codigo que se extenderia dentro de unas clases, codigo que es demasiado bruto y visualmente poco legible por lo que este metodo muy ayudo demasiado a entender y mejorar la legibilidad del codigo.


### Diagrama casos de Uso
[![Diag](https://github.com/huebitoo/ReservaAsientosGUI/blob/main/src/main/resources/ImagenesReadMe/DiagramaCasosUso.jpg "UML")](https://github.com/huebitoo/ReservaAsientosGUI/blob/main/src/main/resources/ImagenesReadMe/DiagramaCasosUso.jpg "UML")


### Diagrama UML
[![UML](https://github.com/huebitoo/ReservaAsientosGUI/blob/main/src/main/resources/ImagenesReadMe/UMLProyectoFinal.png "UML")](https://github.com/huebitoo/ReservaAsientosGUI/blob/main/src/main/resources/ImagenesReadMe/UMLProyectoFinal.png "UML")


### Formulario Comprador
[![Form](https://github.com/huebitoo/ReservaAsientosGUI/blob/main/src/main/resources/ImagenesReadMe/formulario.png "Form")](https://github.com/huebitoo/ReservaAsientosGUI/blob/main/src/main/resources/ImagenesReadMe/formulario.png "Form")


### Seleccion de Buses
[![Select](https://github.com/huebitoo/ReservaAsientosGUI/blob/main/src/main/resources/ImagenesReadMe/seleccion.png "Select")](https://github.com/huebitoo/ReservaAsientosGUI/blob/main/src/main/resources/ImagenesReadMe/seleccion.png "Select")


### Compra de Asientos
[![Compra](https://github.com/huebitoo/ReservaAsientosGUI/blob/main/src/main/resources/ImagenesReadMe/compraasiento.png "Compra")](https://github.com/huebitoo/ReservaAsientosGUI/blob/main/src/main/resources/ImagenesReadMe/compraasiento.png "Compra")


### Boleto de Viaje
[![Boleta](https://github.com/huebitoo/ReservaAsientosGUI/blob/main/src/main/resources/ImagenesReadMe/boletodecompra.png "Boleto")](https://github.com/huebitoo/ReservaAsientosGUI/blob/main/src/main/resources/ImagenesReadMe/boletodecompra.png "Boleto")


### Decisiones durante el proyecto
Las principales decisiones que tomamos fueron en base a como manejar todo el proyecto. Primeramente nos reunimos como grupo y realizamos bosquejos sobre la funcionalidad del proyecto, la estetica y describir su comportamiento. Una de las mejores decisiones fue aislar el manejo de logica del proyecto de la parte visual. No queriamos que el apartado de Vistas tuviera codigo relacionado a la logica del proyecto, por lo que decidimos crear la clase ManejoBuses la cual se encarga de entregar todo lo necesario. 


### Dificultades durante el proyecto
Como todo proyecto, siempre hay una variedad de ideas y opiniones que normalmente difieren entre si. Por tanto, una de las dificultades principales fue llegar a un punto de acuerdo para poder aclarar las ideas y poder orientar correctamente el proyecto. Al momento de empezar el proyecto, nos encontramos con muchos problemas al pensar como manejar los datos entre sí, como la distribucion de los paneles al momento de querer lograr el diseño acordado, también podemos agregar que al trabajar en SO distintos (Ubuntu, Windows y Linux Mint) aveces sucedian leves cambios en como se mostraba la interfaz. Además, tuvimos unos cuantos problemas al hacer merge, donde muchas veces teniamos que involucrarnos en codigo que se le designo a otra persona y generando muchos conflicto al hacer el merge. Como autocritica, sentimos que deberiamos haber aprovechado mejor algunas herramientas de trabajo, también ser un poco mas constantes al momento de trabajar y por ultimo nos falto dedicar mas tiempo a hacer refactoring dado que somos conscientes que la gran parte del codigo está hecha con el proposito de "funcionar", no con el proposito de ser escalable. A pesar de esto, hemos dejamos abierta una ventana para posibles mejoras futuras. 

