
FROM csanchez/maven:3-adoptopenjdk-15-openj9
# Se crea la carpeta para las pruebas
RUN mkdir -p /app/test
# Se crea un nuevo usuario sin contraseña, ni entrada en el /etc/passwd y sin carpeta home
RUN adduser --disabled-password --gecos '' newuser
# Se asignan los permisos en las carpetas necesarias...
#... carpeta donde se va a montar el proyecto
RUN chown newuser /app/test
#... carpeta donde maven registra los logs por defecto
RUN chown newuser -R /root
# Se cambia a la carpeta donde se montará el proyecto
WORKDIR /app/test
# Se copia el archivo necesario "pom.xml"
COPY pom.xml .
# Se usa newuser
USER newuser
# Por último se llama al gestor de tareas para probar el proyecto.
CMD ["mvn","test"]
