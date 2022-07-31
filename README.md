# Softka-challenge

Link video explicación: https://youtu.be/MybPODx2iCY

## Resolver problemas al descargar el proyecto

A continuaciön una explicación de como correr el proyecto:

Después de haberse desarcago y descomprimido el archivo, lo abrimos en IntelliJ donde nos generará un problema

![image](https://user-images.githubusercontent.com/96300875/182005416-32e66dc1-2272-4471-8855-0e0dc6e7ade8.png)

1. Nos dirigimos a "Project Structure..." y definimos la estrucutra del proyecto como aparece a continuación, probablemente no nos aparezca la carpeta target pero de igual modo no hay problema 

![image](https://user-images.githubusercontent.com/96300875/182005441-38699100-675d-460a-b2ad-3aaedd0a3c62.png)

2. Indicamos el JDK de Java con el que se creó este proyecto

![image](https://user-images.githubusercontent.com/96300875/182005461-e538f830-087b-40f1-8233-332dbc1ed901.png)

3. Ahora vamos a realizar la configuración para maven de tal modo que resulva las dependencias

3.1 Nos dirigimos a "Settings"

![image](https://user-images.githubusercontent.com/96300875/182005481-cb159fa5-2f44-43e3-bc80-df9217f658dd.png)

3.2 Buscamos Maven y despues selecionaremos el Maven home path de la imagen

![image](https://user-images.githubusercontent.com/96300875/182005499-70685bac-4bf2-4b07-95c2-22461f5118a9.png)

3.3 Verificamos que sea Bundled(Maven 3) para que en el pom podamos resolver las dependencias

![image](https://user-images.githubusercontent.com/96300875/182005522-a5091b40-c044-4a69-9ee4-83e2743d5e6e.png)
 
4 Resolvemos dependencias dirigiendonos al pom.xml

![image](https://user-images.githubusercontent.com/96300875/182005536-6c059663-32ee-473e-af32-2e0b1ebc3f2e.png)

5 la último que tendremos que hacer será resolver dependencias con el botón que nos aparecerá en la esquina superior derecha con la M de maven

![image](https://user-images.githubusercontent.com/96300875/182005558-a27b659f-83ad-42c0-bc18-50e45f196e38.png)


## Creación de la base de datos

Una vez tengamos nuestro proyecto crearemos la base de datos en MySQL 


1. Crear la base de datos con los códigos del siguiente documento enlazado dentro de MySQL Workbench 

https://docs.google.com/document/d/1ZDeHVK55GT9HvBAXxj2LALQ27sGp4rITGz1iHO6p3yc/edit?usp=sharing

## Listo para usar!

Nuestro proyecto estará listo para usarse cuando al correrlo, en la consola nos aparezca que se ejecuta en el puerto 8080, con el path '/api/spacecraft'

Si queremos abrirlo pegamos la siguiente dirección en el naevgador: http://localhost:8080/api/spacecraft/


